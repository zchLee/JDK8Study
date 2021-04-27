package me.lea.java.filterApple.methodReferences.sort;

import me.lea.java.filterApple.Apple;

import java.util.Comparator;

/**
 * @author lzc
 */
public class AppleComparator implements Comparator<Apple> {

    @Override
    public int compare(Apple o1, Apple o2) {
        return o1.getWeight() - o2.getWeight();
    }
}
