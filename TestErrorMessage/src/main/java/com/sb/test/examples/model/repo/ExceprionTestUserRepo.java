package com.sb.test.examples.model.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.sb.test.examples.model.dao.User;

@Repository
public interface ExceprionTestUserRepo extends JpaRepository<User, String>{

}
