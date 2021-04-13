package me.lea.java.filterApple.filter;

import me.lea.java.filterApple.Apple;
import me.lea.java.filterApple.ApplePredicate;

/**
 * 筛选绿色的苹果
 * @author lzc
 */
public class AppleGreenColorPredicate implements ApplePredicate {
    @Override
    public boolean test(Apple apple) {
        return "green".equals(apple.getColor());
    }
}
