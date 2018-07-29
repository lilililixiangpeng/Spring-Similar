package com.spring.SpringInfo;


import org.dom4j.Document;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by lixiangpeng on 2018/7/29.
 */
public class ConfigManager {
    static Document document =null;
    static Map<String, Object> map = new HashMap<String, Object>();
    public static Map<String, Object> getConfig(String path){
        String xpath = "//bean";
        try {
            InputStream inputStream = ConfigManager.class.getResourceAsStream(path);
            SAXReader reader = new SAXReader();
            document = reader.read(inputStream);
            List<Element> list =  document.selectNodes(xpath);
            for(Element element : list){
                Bean bean = new Bean();
                String name = element.attributeValue("id");
                bean.setName(name);
                bean.setClassName(element.attributeValue("class"));
                List<Property> Properties =new ArrayList<Property>();
                List<Element> children = element.elements("property");
                for(Element element2 : children){
                    Property property = new Property();
                    property.setName(element2.attributeValue("name"));
                    property.setValue(element2.attributeValue("value"));
                    property.setRef(element2.attributeValue("ref"));
                    Properties.add(property);
                }
                bean.setProperties(Properties);

                map.put(name, bean);
            }
            return map;
        } catch (Exception e1) {
            e1.printStackTrace();
            return null;
        }

    }

}
