package com.nithish.profileservicegraphql.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.coxautodev.graphql.tools.GraphQLMutationResolver;
import com.coxautodev.graphql.tools.GraphQLQueryResolver;
import com.nithish.profileservicegraphql.entity.User;
import com.nithish.profileservicegraphql.repository.ProfileDetailsRepository;

@Service
public class ProfileService implements GraphQLQueryResolver, GraphQLMutationResolver {

	@Autowired
	ProfileDetailsRepository profileRepository;

	public List<User> getAllUsers() {
		return profileRepository.findAll();
	}

	public Optional<User> getUserById(String userId) {

		return profileRepository.findById(userId);
	}

	public User updateProfile(String userId, String emailId, Long mobileNo) {
		User user = profileRepository.getByUserId(userId);
		user.setEmailId(emailId);
		user.setMobileNo(mobileNo);
		profileRepository.save(user);

		return user;
	}

	public String deleteUserById(String userId) {

		profileRepository.deleteById(userId);
		return "User Deleted with an Id: " + userId;
	}
	
	public User addProfile(User user) {
		
		profileRepository.save(user);
		return user;
		
	}

}
