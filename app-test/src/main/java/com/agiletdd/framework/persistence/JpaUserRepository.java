package com.agiletdd.framework.persistence;

import com.agiletdd.application.domain.User;
import com.agiletdd.application.domain.UserRepository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface JpaUserRepository extends UserRepository, JpaRepository<User, String> {

}
