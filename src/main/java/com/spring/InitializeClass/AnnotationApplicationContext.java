package com.spring.InitializeClass;

import com.spring.ClassPathUtils.AnnotationScanUtils;
import com.spring.assignment.SpringAnnotationUtils;
import org.apache.log4j.Logger;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;

/**
 * Created by lixiangpeng on 2018/7/29.
 */
public class AnnotationApplicationContext {

    private static ConcurrentHashMap<String,Object> applicActionContext = new ConcurrentHashMap<String,Object>(); //类似于 spring 的上下文存储bean对象
    private static Logger logger = Logger.getLogger(AnnotationApplicationContext.class);
    private static List<String> classPaths = new ArrayList<String>();

    public AnnotationApplicationContext() throws ClassNotFoundException, IllegalAccessException, NoSuchMethodException, InstantiationException {
        classPaths = AnnotationScanUtils.searchClass();
        SpringAnnotationUtils.AnnoSetBean(classPaths,applicActionContext);
    }

    public Object getObject(String objectname){
        if (applicActionContext.containsKey(objectname)){
            logger.info("已经找到类！");
            return applicActionContext.get(objectname);
        }else {
            try {
                throw new ClassNotFoundException("未找到类！");
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }
        }
        return null;
    }
}
