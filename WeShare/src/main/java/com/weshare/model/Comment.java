package com.weshare.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import org.hibernate.annotations.CreationTimestamp;

import lombok.Data;

@Entity
@Data
public class Comment {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int commentId;
	
	@Column(length=3000)
	private String content;
	
    @CreationTimestamp
    private Date creationDate;
    
    @ManyToOne
    @JoinColumn(name="post_id")
	private Post post;
    
    @ManyToOne
    @JoinColumn(name="user_id")
	private User user;
	
	
}
