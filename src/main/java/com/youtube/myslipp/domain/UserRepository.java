package com.youtube.myslipp.domain;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface UserRepository extends JpaRepository<User, Long> {
    User findByUserId(String userId);

    List<User> findTop10By();

    List<User> findNameBy();

}
