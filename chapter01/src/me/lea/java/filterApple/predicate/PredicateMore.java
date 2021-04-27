package me.lea.java.filterApple.predicate;

import me.lea.java.filterApple.Apple;
import org.junit.jupiter.api.Test;

import java.awt.*;
import java.awt.desktop.AppForegroundListener;
import java.util.function.Function;
import java.util.function.Predicate;

/**
 * @author lzc
 */
public class PredicateMore {

    /**
     * 函数符合
     */
    @Test
    public void testFunction() {
        Function<Integer, Integer> f = x -> {
            return x + 1;
        };
        Function<Integer, Integer> g = x -> {
            return x * 2;
        };
        // f(g(x))
//        Function<Integer, Integer> h = f.andThen(g);
//        Integer res = h.apply(1);
//        System.out.println("andThen: f(g(x)):" + res);

        Function<Integer, Integer> compose = f.compose(g);
        System.out.println("compose:g(f(x)) =：" + compose.apply(1));
    }

    /**
     * 谓词符合 的使用
     */
    @Test
    public void testPredicate() {
        Apple apple = new Apple();
        apple.setColor("red");
        apple.setWeight(300);
        Predicate<Apple> redApple = p -> "red".equals(apple.getColor());

//        System.out.println(redApple);
        System.out.println("Apple 是否是红色的：" + redApple.test(apple));

        // 产生现有Predicate 对象redApple的非
        Predicate<Apple> negate = redApple.negate();
//        System.out.println(negate);
        System.out.println("颜色监测的反义词：" + negate.test(apple));

        // and 两个条件都符合  苹果要既是红色的又是超过200克的
        Predicate<Apple> and = redApple.and(a -> a.getWeight() > 200);
        System.out.println("苹果是否是又大又红：" + and.test(apple));
    }
}
