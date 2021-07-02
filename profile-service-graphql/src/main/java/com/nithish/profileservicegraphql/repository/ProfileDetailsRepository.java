package com.nithish.profileservicegraphql.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.nithish.profileservicegraphql.entity.User;


@Repository
public interface ProfileDetailsRepository extends MongoRepository<User,String> {

	User getByUserId(String userId);


	
}
