package com.aop.aop_practice.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CommonDto<T>{
    private int statusCode;
    private T data;

    public CommonDto(int statusCode) {
        this.statusCode = statusCode;
    }

}
