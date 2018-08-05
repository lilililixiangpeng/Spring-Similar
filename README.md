# IOC-Demo
模仿spring IOC的原理所写的一个demo


## 环境需求
>- JDK 1.8
>- IDEA
>- Maven

## 实现架构
![架构说明](https://github.com/lilililixiangpeng/img-folder/blob/master/Spring.PNG)

## 项目说明
此项目使用的是spring的ioc思想，利用反射来自动注入类并初始化。

## 使用说明
使用此项目，clone到本地，由于未实现接口配置等，所以要把xml文件放到maven项目的resource文件夹下，并且将xml文件取名未spring-test.xml，使用注解的话目前只能使用@Beanm,@Autiwried,@Resource。
