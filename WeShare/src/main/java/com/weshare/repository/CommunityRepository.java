package com.weshare.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.weshare.model.Community;

public interface CommunityRepository extends JpaRepository<Community,Integer> {

}
