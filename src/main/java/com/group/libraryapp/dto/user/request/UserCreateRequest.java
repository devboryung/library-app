package com.group.libraryapp.dto.user.request;

public class UserCreateRequest {

    private String name;
    private Integer age; //Integer는 null을 가질 수 있음.

    public String getName() {
        return name;
    }

    public Integer getAge() {
        return age;
    }
}
