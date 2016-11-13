package test.batis;

import java.io.Serializable;

/**
 * Created by search on 2016/11/12.
 */
public class RedisTestBean implements Serializable{
    private  String name;
    private Short seliry;
    private String[] manbers;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Short getSeliry() {
        return seliry;
    }

    public void setSeliry(Short setSeliry) {
        this.seliry = setSeliry;
    }

    public String[] getManbers() {
        return manbers;
    }

    public void setManbers(String[] manbers) {
        this.manbers = manbers;
    }
}
