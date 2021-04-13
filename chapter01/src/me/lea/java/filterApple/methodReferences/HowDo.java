package me.lea.java.filterApple.methodReferences;

import java.util.*;
import java.util.function.BiFunction;
import java.util.function.BiPredicate;
import java.util.function.Function;
import java.util.function.Supplier;

/**
 * @author lzc
 * 方法引用： 方法引用让你可以重复使用现有的方法定义，并像Lambda一样传递它们。
 * 方法引用主要有三类。
 *      1.指向静态方法的方法引用（例如Integer的parseInt方法，写作Integer::parseInt）。
 *          (args) -> ClassName.staticMethod(args);  ====>   ClassName::staticMethod
 *      2.指 向 任意类型实例方法 的方法引用（例如 String 的 length 方法，写作 String::length）。
 *          (arg0, rest) -> arg0.instanceMethod(rest)   arg0是className类型的
 *          ClassName::instanceMethod
 *      3.指向现有对象的实例方法的方法引用（假设你有一个局部变量expensiveTransaction
 *          用于存放Transaction类型的对象，它支持实例方法getValue，那么你就可以写expensive::Transaction::getValue）。
 *          (args) -> expr.instanceMethod(args);
 *          expr::instanceMethod
 *
 */
public class HowDo {



    public static void main(String[] args) {
        // 给str集合 排序
        List<String> str = Arrays.asList("e", "a", "b", "D");
        str.sort(String::compareToIgnoreCase);
        System.out.println(str);
        // String 转向 Integer
        Function<String, Integer> stringToInteger = (String s) -> Integer.parseInt(s);
        stringToInteger = Integer::parseInt;

        // 判断两个输入参数是是否存在
        BiPredicate<List<String>, String> contains = (list, s) -> list.contains(s);
        contains = List::contains;
    }

    // 构造函数引用
    public void constructor() {
        Supplier<HowDo> supplier = HowDo::new;
        HowDo howDo = supplier.get();
        // 等价于
        Supplier<HowDo> supplier1 = () -> new HowDo();
        HowDo howDo1 = supplier1.get();

//        如果有参数
        Function<String, HowDo> function = HowDo::new;
        HowDo apply = function.apply("123");
        // 等价于
        Function<String, HowDo> function1 = (String str) -> new HowDo(str);

        List<String> strs = Arrays.asList("g","2","dfs");
        map(strs, HowDo::new);

        // 两个参数的构造函数
        BiFunction<String, Integer, HowDo> biFunction = HowDo::new;
        biFunction.apply("abc", 1);
        // 等价于
        biFunction = (String str, Integer integer) -> new HowDo(str, integer);
        biFunction.apply("abd", 2);


        // 三个构造函数的 方法引用
        TriFunction<Integer, String, Double, HowDo> triFunction = HowDo::new;
        HowDo bg = triFunction.apply(1, "bg", 9.0);

    }

    static Map<String, Function<String, Fruit>> map = new HashMap<>();
    static {
        map.put("apple", Apple::new);
        map.put("orange", Orange::new);
    }

    public static Fruit giveMeFruit(String fruit, String color) {
        return map.get(fruit).apply(color);
    }


    public static List<HowDo> map(List<String> list, Function<String, HowDo> function) {
        ArrayList<HowDo> r = new ArrayList<>();
        for (String str : list) {
            r.add(function.apply(str));
        }
        return r;
    }

    public HowDo() {}

    // 一个构造函数 Function函数式接口
    public HowDo(String a) {}
    // 两个构造函数 BiFunction 函数式接口
    public HowDo(String a, Integer b) {}
    // 三个构造函数 自己见一个函数式接口  构造函数引用的签名匹配
    public HowDo(Integer a, String b, Double c) {}
}
