package com.spring.SpringInfo;

/**
 * Created by lixiangpeng on 2018/7/29.
 */
public class Property {
    private String name;
    private Object value;
    private String ref;
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public Object getValue(){
        return value;
    }

    public void setValue(Object value) {
        this.value = value;
    }
    public String getRef() {
        return ref;
    }
    public void setRef(String ref) {
        this.ref = ref;
    }

}
