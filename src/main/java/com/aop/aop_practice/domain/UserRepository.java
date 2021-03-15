package com.aop.aop_practice.domain;

import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class UserRepository {
    public List<User> findAll(){
        List<User> users=new ArrayList <>();
        users.add(new User(1, "keb", "1234", "00000000"));
        users.add(new User(2, "love", "1234", "000020000"));
        users.add(new User(3, "kebzzang", "1234", "000030000"));


            return users;

    }

    public User findById(int id){
        return new User(4, "kebb", "3333", "00000");
    }
    public void save(JoinRequestDto dto){
        System.out.println("DB insertion");

    }
    public void update(UpdateRequestDto dto, int id){
        throw new IllegalArgumentException("잘못된 아규먼트!!"){
        };

    }
    public void delete(int id){
        System.out.println("DB deletion");
    }
}
