package com.fastcampus.jpa.bookmanager.repository;

import com.fastcampus.jpa.bookmanager.domain.User;
import org.assertj.core.util.Lists;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Sort;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class UserRepositoryTest {
    @Autowired
    private UserRepository userRepository;

    @Test
    @Transactional
    void crud(){
//        List<User> users = userRepository.findAll(Sort.by(Sort.Direction.DESC, "name"));

//        List<Long> ids = new ArrayList<>(Lists.newArrayList(1L, 3L, 5L));
//        List<User> users = userRepository.findAllById(ids);
//        users.forEach(System.out::println);

//        User user1 = new User("jack", "jack@fastcampus.com");
//        User user2 = new User("steve", "steve@fastcampus.com");
//        userRepository.saveAll(Lists.newArrayList(user1, user2));
//        userRepository.save(user1);
//        List<User> users = userRepository.findAll();
//        users.forEach(System.out::println);

//        User user = userRepository.getOne(1L);          //lazy patch
//        System.out.println(user);

//        Optional<User> user = userRepository.findById(1L);
//        User user= userRepository.findById(1L).orElse(null);
//        System.out.println(user);

//        userRepository.save(new User("mini kang", "minKang@gamil.com"));
//        userRepository.flush();         //db 저장 시점을 조정할 수 있는데 추후에 동작을 더 확인해보자.
//        userRepository.findAll().forEach(System.out::println);

//        long count = userRepository.count();
//        System.out.println(count);

//        boolean exists = userRepository.existsById(1L);
//        System.out.println(exists);

//        userRepository.delete(userRepository.findById(1L).orElseThrow(RuntimeException::new));
//        userRepository.deleteById(1L);
//        userRepository.deleteAll();
//        userRepository.deleteAll(userRepository.findAllById(Lists.newArrayList(1L, 3L)));        //여기까지는 select 로 확인하고 하나하나 지워가는 과정.
//        userRepository.deleteInBatch(userRepository.findAllById(Lists.newArrayList(1L, 3L)));   //반복해서 delete 하는게 아니라 한번에 삭제(or 로)
        userRepository.deleteAllInBatch();

        userRepository.findAll().forEach(System.out::println);


    }
}