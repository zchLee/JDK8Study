package me.lea.java.filterApple.filter;

import me.lea.java.filterApple.Apple;
import me.lea.java.filterApple.ApplePredicate;

/**
 * 筛选大于150的 重的苹果
 * @author lzc
 */
public class AppleHeavyWeightPredicate implements ApplePredicate {
    @Override
    public boolean test(Apple apple) {
        return apple.getWeight() > 150;
    }
}
