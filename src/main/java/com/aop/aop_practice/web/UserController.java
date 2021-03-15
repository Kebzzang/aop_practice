package com.aop.aop_practice.web;


import com.aop.aop_practice.domain.*;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RequiredArgsConstructor //요구되는 변수들에 컨스트럭터를 만들어줘라.
@RestController
public class UserController {

  /*  private UserRepository userRepository;


    //DI 의존성 주입: 유저레파지토리 타입으로 메모리 뒤져서 찾아냄
    public UserController(UserRepository userRepository) {
        this.userRepository = userRepository;
    }*/

    //컴파일 시점에 초기화가 되어 있어야 한다. null이 안된다. 리콰이어드 어노테이션 덕분에
    private final UserRepository userRepository;
    //옛날방식!!@Autowired -> private UserRepository userRepository;

    @GetMapping("/user")
    public CommonDto<List<User>> findAll() {
        return new CommonDto<>(HttpStatus.OK.value(), userRepository.findAll()); //MsgConverter 가 작동 -> JavaObejct-> Json String 으로 변환환    }
    }
    @GetMapping("/user/{id}")
    public CommonDto<User> findById(@PathVariable int id){
        System.out.println("id는 : "+id);
        return new CommonDto<>(HttpStatus.OK.value(), userRepository.findById(id));
    }
    //1. x-www-form-urlencoded 로 들어오게됨 (request.getParameter())
  /*  @PostMapping("/user")
    public void save(String username,String password ,String phone ){
        System.out.println("username: "+username+ " password: "+password+" phone: "+phone);
    }*/
    //2. text/plain -> @RequestBody 어노테이션 활용하면 받을 수 있음
   /* @PostMapping("/user")
    public void save(@RequestBody String data){
        System.out.println("data : "+data);
    }*/
    //3. application/json -> @RequestBody 어노테이션에 오브젝트로 받으면 됨
    @PostMapping("/user")
    public CommonDto<?> save(@Valid @RequestBody JoinRequestDto dto,  BindingResult bindingResult){

        System.out.println("user : "+dto);
        userRepository.save(dto);

        return new CommonDto<>(HttpStatus.CREATED.value(), "OK"); //성공시 200 리턴됨.
    }
    @DeleteMapping("/user/{id}")
    public CommonDto<String> delete(@PathVariable int id){
    userRepository.delete(id);
    return new CommonDto<>(HttpStatus.OK.value(), null);
    }
    @PutMapping("/user/{id}")
    public CommonDto<?> update(@PathVariable int id,@Valid @RequestBody UpdateRequestDto dto,  BindingResult bindingResult){

        System.out.println("update function user: "+dto);
        userRepository.update(dto, id); //update 호출!!!와 신기해~~
        return new CommonDto<>(HttpStatus.OK.value(), null);
    }
}
