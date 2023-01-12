import exceptions.EmptyCollectionException;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws EmptyCollectionException {
        Scanner scanner = new Scanner(System.in);

        System.out.println("enter a calculation in postfix: ");
        String calculationPostfix = scanner.nextLine();

        String[] calculationArray = calculationPostfix.split("\\s+");

        System.out.println("result: "+calculator(calculationArray));
    }

    private static double calculator(String[] calculationArray) throws EmptyCollectionException {

        ArrayStack<Double> operands = new ArrayStack<Double>();

        for(String calculation: calculationArray){
            if(calculation.trim().equals("")){

                continue;
            }

            switch (calculation){

                case "+":
                case "-":
                case "*":
                case "/":
                    double right = operands.pop();
                    double left = operands.pop();
                    double value = 0;

                    switch (calculation){
                        case "+":
                            value = left + right;
                            break;

                        case "-":
                            value = left - right;
                            break;

                        case "*":
                            value = left * right;
                            break;

                        case "/":
                            value = left / right;
                            break;

                        default:
                            break;
                    }

                    operands.push(value);
                    break;

                default:
                    operands.push(Double.parseDouble(calculation));
                    break;
            }
        }

        return operands.pop();
    }
}