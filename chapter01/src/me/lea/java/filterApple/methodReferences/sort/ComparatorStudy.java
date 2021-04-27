package me.lea.java.filterApple.methodReferences.sort;

import me.lea.java.filterApple.Apple;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

/**
 * @author lzc
 *
 * 排序的集中方式
 */
public class ComparatorStudy {

    public static void main(String[] args) {
        List<Apple> inventory = new ArrayList<>();
        // 第一种排序方式：自定义抽象类
        inventory.sort(new AppleComparator());
        // 第二種方式：使用匿名类
        inventory.sort(new Comparator<Apple>() {
            @Override
            public int compare(Apple o1, Apple o2) {
                return o1.getWeight() - o2.getWeight();
            }
        });
        // 第三种方式：使用Lambda表达式
        inventory.sort((a1, a2) -> a1.getWeight() - a2.getWeight());
        // 第四种方式：方法引用
        inventory.sort(Comparator.comparingInt(Apple::getWeight));

    }

    // 复合 Lambda 表达式的有用方法
    public void recombination() {
        List<Apple> inventory = new ArrayList<>();
        Comparator<Apple> comparing = Comparator.comparing(Apple::getWeight);
        // 逆序
        inventory.sort(comparing.reversed());

    }

    // 比较器链 (按苹果重量逆序排序，如果体重相同 按颜色排序)

    // 复合 Lambda 表达式的有用方法
    public void recombinationByMore() {
        List<Apple> inventory = new ArrayList<>();
        Comparator<Apple> comparing = Comparator.comparing(Apple::getWeight);
        // 按重量逆序排序，如果重量相同，则按照颜色排序
        inventory.sort(comparing.reversed().thenComparing(Apple::getColor));

    }
}
