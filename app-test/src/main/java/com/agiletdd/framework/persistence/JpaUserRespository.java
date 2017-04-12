package com.agiletdd.framework.persistence;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;

import com.agiletdd.application.domain.User;
import com.agiletdd.application.domain.UserRepository;

@Component
public interface JpaUserRespository extends UserRepository , JpaRepository<User, String>  {

    @Override
    User findByName(String name);
}
