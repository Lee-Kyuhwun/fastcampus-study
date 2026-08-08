package chapter4;

import java.util.function.Supplier;

public class Chater4Section1 {

    public static void main(String[] args) {

        Supplier<String> myStringSupplier = () -> "hello world";

        Supplier<Double> myRandomDoubleSupplier = () -> Math.random();

        
    }
}
