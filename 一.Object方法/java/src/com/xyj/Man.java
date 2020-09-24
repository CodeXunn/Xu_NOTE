package com.xyj;

import java.util.Objects;

public class Man extends People {
    private String power;
    Man(String name,int age){
        super(name,age,"man");
    }

    @Override
    public boolean equals(Object other) {
        if (!super.equals(other)) return false;
        Man man = (Man)other;
        return Objects.equals(power,man.power);
    }
}
