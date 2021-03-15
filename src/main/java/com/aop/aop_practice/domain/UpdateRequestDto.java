package com.aop.aop_practice.domain;

import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Data
public class UpdateRequestDto {
    @NotNull(message="널값은 안댑니당")
    @NotBlank(message="유저네임을 입력해야 합니다.")
    @Size(max=20, message="유저네임 길이를 초과했습니다.")
    private String username;

    @NotBlank(message="블랭크는 안됩니다.")
    @Size(max=20, message="패스워드 길이를 초과했습니다. ")
    private String password;

    private String phone;
}
