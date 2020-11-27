package com.weshare.model;

import java.time.LocalDateTime;
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
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.validator.constraints.Length;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "user_id")
    private int id;
    
    @Column(name = "user_name")
    @Length(min = 4, message = "*Username must have atleast 4 characters.")
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
    private LocalDateTime joinedOn;
    
    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "user_role", 
    			joinColumns = @JoinColumn(name = "user_id"), 
    			inverseJoinColumns = @JoinColumn(name = "role_id"))
    private Set<Role> roles;

}
