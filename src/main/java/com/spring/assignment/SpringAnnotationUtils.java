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

    public static void AnnoSetBean(List<String> classpaths, ConcurrentHashMap<String, Object> applicActionContext) throws ClassNotFoundException, IllegalAccessException, InstantiationException, NoSuchMethodException {
        for (int i = 0;i < classpaths.size();i++){
            Class<?> clazz = Class.forName(classpaths.get(i));
            if (clazz.isAnnotationPresent(Bean.class)){
                Object object = clazz.newInstance();
                Bean classBean = clazz.getAnnotation(Bean.class);
                String beanName = clazz.getSimpleName();
                if (classBean.name() != ""){
                    beanName = classBean.name();
                }
                Field[] fields = clazz.getDeclaredFields();
                for (Field field:fields) {
                    if (field.isAnnotationPresent(Autowired.class)){
                        String typename = field.getType().getCanonicalName();
                        Class<?> fieldclass = Class.forName(typename);
                        field.setAccessible(true);
                        field.set(object,fieldclass.newInstance());
                    }
                }
                applicActionContext.put(beanName,object);
            }
        }
    }
}
