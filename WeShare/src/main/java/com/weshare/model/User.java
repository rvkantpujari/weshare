package com.weshare.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.validator.constraints.Length;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "user_id")
    private int id;
    
    @Column(name = "user_name")
    @NotEmpty(message = "*Username should not be empty.")
    private String userName;
    
    @Column(name = "email")
    @Email(message = "*Please provide a valid Email.")
    @NotEmpty(message = "*Email should not be empty.")
    private String email;
    
    @Column(name = "password")
    @Length(min = 4, message = "*Password must have at least 4 characters.")
    @NotEmpty(message = "*Password should not be empty.")
    private String password;
    

    @Column(name = "first_name")
    @NotEmpty(message = "*First name should not be empty.")
    private String firstName;
    
    
    @Column(name = "last_name")
    @NotEmpty(message = "*Last name should not be empty.")
    private String lastName;
    
    
    @Column(name = "active")
    private Boolean active;
    
    @CreationTimestamp
    private Date joinedOn;
    
    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "user_role", 
    			joinColumns = @JoinColumn(name = "user_id"), 
    			inverseJoinColumns = @JoinColumn(name = "role_id"))
    private Set<Role> roles;
    
    @JsonIgnore
    @OneToMany(mappedBy="user")
    private Set<Community> communities;
    
    @JsonIgnore
    @OneToMany(mappedBy = "user")
    private List<Post> posts;
    
    @JsonIgnore
    @OneToMany(mappedBy="user")
    private List<Comment> comments;
    
    @JsonIgnore
    @OneToMany(mappedBy="user")
    private List<Vote> votes;
    
    @ManyToMany(cascade = CascadeType.MERGE)
    @JoinTable(name="CommunityMembers",
    		joinColumns = @JoinColumn(name="user_id"),
    		inverseJoinColumns = @JoinColumn(name="community_id"))
    private Set<Community> joinedCommunityList= new HashSet<>();
    
    @ManyToMany(cascade = CascadeType.MERGE)
    @JoinTable(name="SavedPosts",
			joinColumns = @JoinColumn(name="user_id"),
			inverseJoinColumns = @JoinColumn(name="post_id"))
    private List<Post> savedPostList=new ArrayList<Post>();
}

