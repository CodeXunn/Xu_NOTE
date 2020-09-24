package com.xyj.pro.dto;

import java.math.BigDecimal;
import java.util.Objects;

public class Employee {
    private int age;
    private String name;
    private BigDecimal salaly;

    public Employee(int age, String name, BigDecimal salaly) {
        this.age = age;
        this.name = name;
        this.salaly = salaly;
    }
    public Employee(){}
    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public BigDecimal getSalaly() {
        return salaly;
    }

    public void setSalaly(BigDecimal salaly) {
        this.salaly = salaly;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Employee employee = (Employee) o;
        return age == employee.age &&
                Objects.equals(name, employee.name) &&
                Objects.equals(salaly, employee.salaly);
    }

    @Override
    public int hashCode() {
        return Objects.hash(age, name, salaly);
    }
}
