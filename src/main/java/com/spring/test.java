package com.spring;

/**
 * Created by lixiangpeng on 2018/7/29.
 */

import com.spring.ClassPathUtils.AnnotationScanUtils;
import com.spring.InitializeClass.XmlApplicationContext;

import com.spring.model.Person;
import com.spring.model.teset;

import java.lang.reflect.Field;
import java.util.List;

public class test {


    public static void main(String[] args) throws Exception {

        XmlApplicationContext context = new XmlApplicationContext("/spring-test.xml");

        Person person = (Person) context.getObject("person");



    }


}
