package main.java.entity;

import java.io.Serializable;

/**
 * @Author NINE. LIU
 * @Date 2020/10/20 15:04
 * @Version 1.0
 */
public class Admin implements Serializable {

    private int id;
    private String name;
    private String password;

    public Admin(){}

    public Admin(String name, String password)
    {
        this.id = id;
        this.name=name;
        this.password=password;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
