package com.xyj.pro.dto;

import java.math.BigDecimal;
import java.util.Objects;

public class Manager extends Employee{
    private BigDecimal bonus;

    public Manager(int age, String name, BigDecimal salaly, BigDecimal bonus) {
        super(age, name, salaly);
        this.bonus = bonus;
    }

    public BigDecimal getBonus() {
        return bonus;
    }

    public void setBonus(BigDecimal bonus) {
        this.bonus = bonus;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Manager manager = (Manager) o;
        return Objects.equals(bonus, manager.bonus);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), bonus);
    }
}
