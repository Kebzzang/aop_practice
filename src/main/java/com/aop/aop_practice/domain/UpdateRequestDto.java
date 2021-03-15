package com.aop.aop_practice.domain;

import lombok.Data;

import javax.validation.constraints.NotBlank;
@Data
public class UpdateRequestDto {

    private String phone;
    @NotBlank(message="바꿀 비번 입력 필수")
    private String password;
}
