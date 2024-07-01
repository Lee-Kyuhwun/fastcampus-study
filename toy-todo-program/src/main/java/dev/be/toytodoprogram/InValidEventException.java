package dev.be.toytodoprogram;

public class InValidEventException extends RuntimeException{

    public InValidEventException(String s) {
        super("Invalid Event");
    }
}
