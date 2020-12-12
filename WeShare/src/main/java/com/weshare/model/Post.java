package com.weshare.model;

import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Transient;

import org.hibernate.annotations.CreationTimestamp;
import org.springframework.web.multipart.MultipartFile;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Data;

@Entity
@Data
public class Post {
	
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int postId;
    
    @Column(nullable = false)
    private String title;
    
    @Column(columnDefinition="text")
    private String content;
    
    @CreationTimestamp
    private Date creationDate;
    
    private String link;
    private String imageUrl;
    private String videoUrl;
    private String videoThumbnail;
    private int score;
    private int commentsNum;
    
    @Transient
	private MultipartFile postImage;
    
    @ManyToOne
    @JoinColumn(name="community_id")
	private Community community;
    
    @ManyToOne
    @JoinColumn(name="user_id")
	private User user;
    
    @JsonIgnore
	@OneToMany(mappedBy="post",cascade = CascadeType.MERGE)
    private List<Comment> comments;

    @JsonIgnore
 	@OneToMany(mappedBy="post")
    private List<Vote> votes;
    

	public boolean hasUserVoted(User user)
	{
		for(Vote vote: this.votes)
			if(vote.getUser() == user)
				return true;
		return false;
	}
}
