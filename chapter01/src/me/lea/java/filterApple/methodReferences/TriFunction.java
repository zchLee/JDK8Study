package me.lea.java.filterApple.methodReferences;

/**
 * @author lzc
 * 三个参数 构造一个实例
 */
@FunctionalInterface
public interface TriFunction<A, B, C, D> {

    D apply(A a, B b, C c);
}
