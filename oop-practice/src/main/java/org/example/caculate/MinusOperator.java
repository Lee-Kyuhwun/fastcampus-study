package org.example.caculate;

public class MinusOperator implements NewArithmethicOperator{
    @Override
    public boolean support(String operator) {
        return false;
    }

    @Override
    public int calculate(int operand1, int operand2) {
        return 0;
    }
}
