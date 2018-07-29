package com.spring;

/**
 * Created by lixiangpeng on 2018/7/29.
 */

import com.spring.InitializeClass.XmlApplicationContext;

import com.spring.model.Person;

public class test {


    public static void main(String[] args) throws Exception {

        XmlApplicationContext context = new XmlApplicationContext("/spring-test.xml");

        Person person = (Person) context.getObject("person");

        System.out.println(person.getName());
    }


}
