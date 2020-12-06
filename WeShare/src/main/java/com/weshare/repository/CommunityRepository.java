package com.weshare.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.weshare.model.Category;
import com.weshare.model.Community;

@Repository
public interface CommunityRepository extends JpaRepository<Community,Integer> {

	List<Community> findByCategory(Category c);

	Community findByCommunityName(String cname);
//	List<Community> findByCategory(int cid);

	
}
