package dev.be.demo5;

public class startmiddle {
    public static void main(String[] args) {
        int size =5;
        int floor =1;

        for(int i=floor; i<=size; i++){

            // space 회색박스
            for(int j=1; j<=size-i; j++){
                System.out.print(" ");
            }
            // 별박스
            for(int j=1; j<=2*i-1; j++){
                System.out.print("*");
            }
            System.out.println();

        }


    }

    private static boolean isFloor(int floor, int size) {
        return floor <= size;
    }
}
