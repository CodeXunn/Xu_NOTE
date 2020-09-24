package com.xyj;

import java.util.Objects;

public class People {
    private String name;
    private int age;
    private String sex;
    People(String name,int age,String sex){
        this.name = name;
        this.age = age;
        this.sex = sex;
    }
    People(){};
    @Override
    public boolean equals(Object other){
        if (this == other) return true;

        if (other == null) return false;

        if (getClass() == other.getClass()) return true;

        People p = (People)other;
        return Objects.equals(this.name,p.name) && (age == p.age)
                && Objects.equals(sex,p.sex);
    }
}
