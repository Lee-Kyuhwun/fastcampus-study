package org.example.caculate;

public class MultiplicationOperator implements NewArithmethicOperator{
    @Override
    public boolean support(String operator) {
        return operator.equals("*");
    }

    @Override
    public int calculate(int operand1, int operand2) {
        return operand1 * operand2;
    }
}
