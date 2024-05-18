package org.example.caculate;


import java.util.Arrays;

public enum ArithmethicOperator {

    ADDITION("+") {
        @Override
        public int calculate(int operand1, int operand2) {
            return operand1+operand2;
        }
    },
    SUBTRACTION("-") {
        @Override
        public int calculate(int operand1, int operand2) {
            return operand1-operand2;

        }
    },
    MULTIPLICATION("*") {
        @Override
        public int calculate(int operand1, int operand2) {
            return operand1*operand2;
        }
    },
    DIVISION("/") {
        @Override
        public int calculate(int operand1, int operand2) {
            return operand1/operand2;

        }
    };
    private final String operator;
    ArithmethicOperator(String operator)
    {
        this.operator = operator;
    }

    public abstract int calculate(final int operand1, final int operand2);
    public  static int arithemeticCalculate(int operand1,String operator,  int operand2) {
        ArithmethicOperator arithmethicOperator1 = Arrays.stream(values())
                .filter(arithmethicOperator -> arithmethicOperator.operator.equals(operator))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("연산자가 잘못되었습니다."));

        return arithmethicOperator1.calculate(operand1,operand2);
    }

}
