package com.sb.test.examples.model.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.sb.test.examples.model.dao.User;
import com.sb.test.examples.model.repo.ExceprionTestUserRepo;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class ExceptionTestService {

	@Autowired
	private ExceprionTestUserRepo repo;

	@Transactional(readOnly = true)
	public User getUserById(String id) {
		Optional<User> user = null;
		try {
			user = repo.findById(id);
		} catch (Exception e) {

			log.error("error in getting records from database {} in class {} ", e.getMessage(), e.getClass());
		}
		if (user.isPresent()) {
			return user.get();
		}
		log.info("Unable to find the user with given id {}", id);
		return null;
	}

	@Transactional(readOnly = false)
	public User saveUser(User user) {

		User newUser = null;
		try {
			log.info("saving record in database");
			newUser = repo.save(user);
		} catch (Exception e) {
			log.error("error in saving record in database {} in class {} ", e.getMessage(), e.getClass());
		}
		return newUser;
	}

}
