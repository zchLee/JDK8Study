package me.lea.java.filterApple;

import java.util.Comparator;

/**
 * @author lzc
 */
public class Apple implements Comparable<Apple> {

    private String color;
    private Integer weight;

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public Integer getWeight() {
        return weight;
    }

    public void setWeight(Integer weight) {
        this.weight = weight;
    }

    @Override
    public int compareTo(Apple o) {
        return this.getWeight().compareTo(o.getWeight());
    }
}
