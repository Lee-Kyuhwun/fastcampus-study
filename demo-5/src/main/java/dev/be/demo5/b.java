package dev.be.demo5;

import java.util.Arrays;
import java.util.stream.Stream;

public class b {
    public static void main(String[] args) {
        String[] array =  {"a", "b", "c", "d", "e"};
        for(String name : array){
            System.out.println("name = " + name);
        }

        Stream<String> stream = Arrays.stream(array);

        long count = stream.count();

        // stream은 한번 사용하면 닫힌다. 따라서 다시 사용하려면 다시 생성해야 한다.
        // stream.cout(); // 에러


    }


}