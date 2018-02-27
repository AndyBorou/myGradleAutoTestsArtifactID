package com.software.model;


import lombok.Builder;
//@Builder(builderMethodName = "of", buildMethodName = "create") - позднее создание обекта
//of - crfeate for creating object
@Builder(builderMethodName = "of", buildMethodName = "create")
public class UserCreatedByBuilder {

    private  String userName;
    private  String password;

}
