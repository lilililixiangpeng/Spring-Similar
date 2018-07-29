package com.spring.InitializeClass;

import com.spring.SpringInfo.Bean;
import com.spring.SpringInfo.ConfigManager;
import com.spring.SpringInfo.Property;
import com.spring.assignment.SpringUtils;
import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.lang.StringUtils;

import java.lang.reflect.Method;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * Created by lixiangpeng on 2018/7/29.
 */
public class XmlApplicationContext {

    private static ConcurrentHashMap<String,Object> applicActionContext = new ConcurrentHashMap<String,Object>(); //类似于 spring 的上下文存储bean对象
    private Map<String, Object> map = null;
    public XmlApplicationContext(String path){
        map = ConfigManager.getConfig(path);
        try {
            SpringUtils.XMLBeanSet(map, applicActionContext);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public Object getObject(String objectname){
        return applicActionContext.get(objectname);
    }


}
