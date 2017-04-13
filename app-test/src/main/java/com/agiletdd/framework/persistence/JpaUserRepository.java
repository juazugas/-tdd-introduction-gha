package com.agiletdd.framework.persistence;

import org.springframework.data.jpa.repository.JpaRepository;

import com.agiletdd.application.domain.User;
import com.agiletdd.application.domain.UserRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface JpaUserRepository extends UserRepository , JpaRepository<User, String>  {

}
