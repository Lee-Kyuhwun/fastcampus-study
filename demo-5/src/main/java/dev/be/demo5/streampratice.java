package dev.be.demo5;

import java.util.Arrays;

public class streampratice {
    public static void main(String[] args) {

        String[] array =  {"a", "b", "c", "d", "e"};

        Arrays.stream(array)
                .filter(name -> !name.equals("b"))
                .map(name -> "Hi, "+ name)
                .forEach(System.out:: println);
    }
}
