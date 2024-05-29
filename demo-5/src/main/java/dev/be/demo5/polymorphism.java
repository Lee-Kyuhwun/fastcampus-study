package dev.be.demo5;

public class polymorphism {

    public static void main(String[] args) {
        // 프로그래머의 타입에 따라 다른 행동 구현

        JavaProgrammer javaProgrammer = new JavaProgrammer();
        CProgrammer cProgrammer = new CProgrammer();
        writeCode(javaProgrammer);
        writeCode(cProgrammer);

    }

    public static void writeCode(Programmer programmer){
        programmer.wirteCode();
    }
}
