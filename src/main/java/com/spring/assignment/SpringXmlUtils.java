package com.spring.assignment;

import com.spring.SpringInfo.Bean;
import com.spring.SpringInfo.Property;
import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.lang.StringUtils;

import java.lang.reflect.Method;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * Created by lixiangpeng on 2018/7/29.
 */
public class SpringXmlUtils {

    public static void XMLBeanSet(Map<String, Object> map, ConcurrentHashMap<String, Object> applicActionContext) throws Exception{

        for (Map.Entry<String, Object> entry : map.entrySet()) {
            //System.out.println("Key = " + entry.getKey() + ", Value = " + entry.getValue());
            Bean bean = (Bean) entry.getValue();
            Object beanObj = Class.forName(bean.getClassName()).newInstance();
            applicActionContext.put(bean.getName(), beanObj);

            for(Property property : bean.getProperties()){
                String methodName = "set" + property.getName().substring(0, 1).toUpperCase() + property.getName().substring(1);

                //属性注入
                if(property.getValue()!=null){
                    BeanUtils.setProperty(beanObj, property.getName(), property.getValue());
                }

                //依赖注入
                if(StringUtils.isNotBlank(property.getRef())){
                    Bean vbBean =  (Bean) map.get(property.getRef());
                    Object o = null;
                    if(applicActionContext.get(vbBean.getName()) == null){
                        o = Class.forName(vbBean.getClassName()).newInstance();
                        applicActionContext.put(vbBean.getName(),o);
                    }else {
                        o = applicActionContext.get(vbBean.getName());
                    }

                    Method method = beanObj.getClass().getMethod(methodName, o.getClass());
                    method.invoke(beanObj, o);
                }
            }

        }

    }


}
