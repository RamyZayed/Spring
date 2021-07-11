package com.example.test2.entity;


import com.example.test2.validator.Company;
import com.example.test2.validator.PhoneType;
import lombok.Value;
import org.springframework.stereotype.Component;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;


public class Person {

    @NotNull(message = "this id value can't be null")
    private  Integer id;
    @NotNull(message = "DONT ---------------------------------------------------\n")
    private  String name;
    @Min(value = 10, message = "Age should be greater than 10")
    @Max(value = 20, message = "Age should be less than 20")
    private  int age;
    @PhoneType(Company.JAWAL)
    private String PhoneNumber;
    private  int depId;

    public Person(){

    }
    public Person(PersonBuilder builder){
        this.id = builder.getID();
        this.name= builder.getName();
        this.age =builder.getAge();
        this.depId = builder.getDepId();
        this.PhoneNumber= builder.getPhoneNumber();
    }

    public int getId() {
        return id;
    }

    public int getDepId() {
        return depId;
    }

    public String getName() {
        return name;
    }
    public int getAge() {
        return age;
    }

    public String getPhoneNumber(){return PhoneNumber;}


    public void setId(int id) {
        this.id = id;
    }
    public void setPhoneNumber(String Phonenum){
        this.PhoneNumber = Phonenum;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setDepId(int depId){
        this.depId=depId;
    }

    public  static class PersonBuilder {
        private  int id;
        private String PhoneNumber;
        private String name;
        private int age;
        private int depId;

        public PersonBuilder setname(String name){
            this.name=name;
            return this;
        }

        public PersonBuilder setage(int age){
            this.age=age;
            return this;
        }
        public PersonBuilder setid(int id){
            this.id=id;
            return this;
           }
        public PersonBuilder setdepId(int depId){
            this.depId=depId;
            return this;
        }
        public PersonBuilder setPhoneNumber(String PhoneNumber) {
            this.PhoneNumber = PhoneNumber;
            return this;
        }

        public Person build(){
            return new Person(this);
        }

        public String getName() {
            return name;
        }
        public int getDepId(){
            return depId;
        }

        public int getAge() {
            return age;
        }

        public int getID(){
            return id;
        }

        public String getPhoneNumber() {return PhoneNumber; }


    }

}

