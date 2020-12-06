package com.weshare.model;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import lombok.Data;

@Entity
@Data
public class Vote {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int voteId;
	
	@ManyToOne
	@JoinColumn(name="user_id")
	private User user;
	
	@ManyToOne(cascade = CascadeType.MERGE)
	@JoinColumn(name="post_id")
	private Post post;
	
	private int vote;
	
	public Vote(User user, Post post, int vote) {
	    this.user = user;
	    this.post = post;
	    this.vote = vote;
	  }
	public Vote() {
	  }
}
