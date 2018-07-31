package com.spring.assignment;

import com.spring.Annotation.Autowired;
import com.spring.Annotation.Bean;

import java.lang.reflect.Field;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;

/**
 * Created by lixiangpeng on 2018/7/30.
 */
public class SpringAnnotationUtils {

    static Object object;

    public static void AnnoSetBean(List<String> classpaths, ConcurrentHashMap<String, Object> applicActionContext) throws ClassNotFoundException, IllegalAccessException, InstantiationException, NoSuchMethodException {
        for (int i = 0;i < classpaths.size();i++){
            Class<?> clazz = Class.forName(classpaths.get(i));
            if (clazz.isAnnotationPresent(Bean.class)){
                Object object = clazz.newInstance();
                Bean classBean = clazz.getAnnotation(Bean.class);
                if (classBean.name() == ""){
                    String beanName = clazz.getSimpleName();
                }
                Field[] fields = clazz.getDeclaredFields();
                for (Field field:fields) {
                    if (field.isAnnotationPresent(Autowired.class)){
                        field.getType().getCanonicalName();
                    }
                }
            }
        }
    }
}
