package com.spring.model;

/**
 * Created by lixiangpeng on 2018/7/29.
 */

public class Person implements java.io.Serializable{
    /**
     *
     */
    private static final long serialVersionUID = 1L;
    private String name;
    private int age;
    private String addres;
     teset teset;

    public Person() {}

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public int getAge() {
        return age;
    }
    public void setAge(int age) {
        this.age = age;
    }
    public String getAddres() {
        return addres;
    }
    public void setAddres(String addres) {
        this.addres = addres;
    }

    public void say(){
        System.out.println("est");
    }

    @Override
    public String toString() {
        return "Person [name=" + name + ", age=" + age + ", addres=" + addres + "]";
    }


}

