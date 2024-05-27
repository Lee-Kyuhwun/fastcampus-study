package org.example.caculate;

import java.util.List;

public class Calculator {


//    private static final List<NewArithmethicOperator> arithmethicOperators = List.of(new AdditionOperator(), new MinusOperator(), new MultiplicationOperator(), new DivisionOperator());

    public static int calculate(int operand1,String operator, int operand2){



       return ArithmethicOperator.arithemeticCalculate(operand1,operator,operand2);
    }
}
