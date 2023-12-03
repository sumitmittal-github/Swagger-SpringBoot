package com.sumit.domain;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(description = "This is the model class of Person")
public class Person {

    @ApiModelProperty(notes = "The unique id of the Person", required = true)
    private Long id;

    @ApiModelProperty(notes = "The name of the Person")
    private String name;

    @ApiModelProperty(notes = "The age of the Person")
    private byte age;

    @ApiModelProperty(notes = "The Phone Number of the Person")
    private String phoneNo;


    public Person(Long id, String name, byte age, String phoneNo) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.phoneNo = phoneNo;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public byte getAge() {
        return age;
    }

    public void setAge(byte age) {
        this.age = age;
    }

    public String getPhoneNo() {
        return phoneNo;
    }

    public void setPhoneNo(String phoneNo) {
        this.phoneNo = phoneNo;
    }
}
