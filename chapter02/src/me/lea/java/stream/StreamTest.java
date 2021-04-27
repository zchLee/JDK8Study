package me.lea.java.stream;

import me.lea.java.data.Dish;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;


/**
 * @author lzc
 * stream 是Java API的新成员
 * 它允许你以声明性方式处理数据集合（通过查询语句来表达，而不是临时编写一个实现）。
 * 从支持数据处理操作的源生成的元素序列
 *
 * 注意：流只能被消费一次
 */
public class StreamTest {

    @Test
    public void stream() {
        List<Integer> list = new ArrayList<>();
        // 同步
        Stream<Integer> stream = list.stream();

        stream.forEach(System.out::println);
        stream.forEach(System.out::println);

        // 多核并行执行这段代码
        list.parallelStream().close();
    }

    @Test
    public void test() {
        Dish.menu.forEach(System.out::println);
        Map<Dish.Type, List<Dish>> collect = Dish.menu.stream().collect(Collectors.groupingBy(Dish::getType));
        collect.forEach((k, v) -> {
            System.out.println(k + "  ");
            System.out.println(v);
        });
    }


    @Test
    public void treeHigh() {
        List<String> threeHighCaloricDishNames = Dish.menu.stream()
                .filter(d -> d.getCalories() > 300)
                .map(Dish::getName)
                .limit(3L)
                .collect(Collectors.toList());
        System.out.println(threeHighCaloricDishNames);
    }
}
