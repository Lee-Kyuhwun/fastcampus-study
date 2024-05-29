package dev.be.demo5;

public class start {
    public static void main(String[] args) {
        int size =5;
        int floor =1;

        while(isFloor(floor, size)){
            for(int i=0; i<size-floor; i++){
                System.out.print("*");
            }
            System.out.println();
            floor++;
        }
    }

    private static boolean isFloor(int floor, int size) {
        return floor <= size;
    }
}
