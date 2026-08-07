import util.TriFunction;

public class Chapter3Section4 {

    public static void main(String[] args) {
        TriFunction<Integer, Integer, Integer, Integer> addThreeNumbers = (a, b, c) -> a + b + c;


        Integer apply = addThreeNumbers.apply(3, 2, 5);


    }
}
