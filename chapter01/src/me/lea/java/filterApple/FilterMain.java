package me.lea.java.filterApple;

import java.util.ArrayList;
import java.util.List;

/**
 * @author lzc
 */
public class FilterMain {

    public static void main(String[] args) {
        int p = 123;
        Runnable r = () -> System.out.println(p);
//        p = 123;
        System.out.println("213");
    }

    /**
     * 根据策略模式筛选出不同的苹果
     * @param inventory
     * @param p               不同筛选策略【行为参数化：让方法接受多种行为（或战略）作为参数，并在内部使用，来完成不同的行为。】
     * @return
     */
    public static List<Apple> filterApples(List<Apple> inventory, ApplePredicate p) {
        ArrayList<Apple> result = new ArrayList<>();
        for (Apple apple : inventory) {
            if (p.test(apple))
                result.add(apple);
        }
        return  result;
    }

    /**
     * 使用匿名内部类
     * @param inventory
     * @return
     */
    public static List<Apple> anonymous(List<Apple> inventory) {
        return filterApples(inventory, new ApplePredicate() {
            @Override
            public boolean test(Apple apple) {
                return "red".equals(apple.getColor());
            }
        });
    }

    /**
     * 使用lambda
     * @param inventory
     * @return
     */
    public static List<Apple> lambda(List<Apple> inventory) {
        return filterApples(inventory, a -> "red".equals(a.getColor()));
    }

    public static List<Apple> sort(List<Apple> inventory) {
        inventory.sort((a, b) -> a.compareTo(b));
        return inventory;
    }
}
