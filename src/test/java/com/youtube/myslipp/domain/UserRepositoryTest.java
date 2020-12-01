package com.youtube.myslipp.domain;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

/**
 * @author yj
 * @version 0.1.0
 * @since 2020/12/01
 */
@SpringBootTest
class UserRepositoryTest {

    @Autowired
    UserRepository userRepository;

    @Test
    public void test() {

        // from user limit 10;
        System.out.println(userRepository.findTop10By());

        // * from user;
        System.out.println(userRepository.findNameBy());

    }
}