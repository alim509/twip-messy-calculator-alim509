package com.company;
import java.io.*;
import java.sql.SQLOutput;
import java.util.*;

class Test {

    public static void main(String[] args) {

        Scanner kbInput = new Scanner(System.in);
        String operatorWord;
        System.out.println("Welcome to the Limsane Calculator!");
        System.out.println("What would you like to do? Choose + to add, - to subtract, * to multiply, or / to divide.");
        String operatorSymbol = kbInput.next();

        do {
            if (!operatorSymbol.equals("+") && !operatorSymbol.equals("-") && !operatorSymbol.equals("*") && !operatorSymbol.equals("/")) {
                System.out.println("That is not an operator! Pick either +, -, *, or /.");
                operatorSymbol = kbInput.next();
            }
        } while (!operatorSymbol.equals("+") && !operatorSymbol.equals("-") && !operatorSymbol.equals("*") && !operatorSymbol.equals("/"));

        if (operatorSymbol.equals("+")) {
            operatorWord = "add";
        } else if (operatorSymbol.equals("-")) {
            operatorWord = "subtract";
        } else if (operatorSymbol.equals("*")) {
            operatorWord = "multiply";
        } else {
            operatorWord = "divide";
        }

        System.out.println("What would you like to " + operatorWord + " together? Pick a whole number between 1 and 10 and press enter.");
        String firstNum = kbInput.next();
        int firstNumInt = 0;

        do {
            try {
                if (Integer.parseInt(firstNum) > -1) {
                    firstNumInt = Integer.parseInt(firstNum);
                    if (firstNumInt < 1 || firstNumInt > 10) {
                        System.out.println("That is not a whole number between 1 and 10. Pick a whole number between 1 and 10 only.");
                        firstNum = kbInput.next();
                    }
                }
            }catch(Exception e){
                System.out.println("That is not an integer! Pick any whole number to proceed.");
                firstNum = kbInput.next();
            }
        } while (firstNumInt < 1 || firstNumInt > 10);

        System.out.println("Pick another whole number between 1 and 10 and press enter.");
        String secondNum = kbInput.next();
        int secondNumInt = 0;
        do {
            try {
                if (Integer.parseInt(secondNum) > -1) {
                    secondNumInt = Integer.parseInt(secondNum);
                    if (secondNumInt < 1 || secondNumInt > 10) {
                        System.out.println("That is not a whole number between 1 and 10. Pick a whole number between 1 and 10 only.");
                        secondNum = kbInput.next();
                    }
                }
            }catch(Exception e){
                System.out.println("That is not an integer! Pick any whole number to proceed.");
                secondNum = kbInput.next();
            }
        } while (secondNumInt < 1 || secondNumInt > 10);

        int result = 0;
        if (operatorWord.equals("add")) {
            result = firstNumInt + secondNumInt;
        } else if (operatorWord.equals("subtract")){
            result = firstNumInt - secondNumInt;
        } else if (operatorWord.equals("multiply")) {
            result = firstNumInt * secondNumInt;
        } else {
            result = firstNumInt / secondNumInt;
        }

        String equation = firstNum + " " + operatorSymbol + " " + secondNum + " = ";
        double[] possibleResults = {Math.pow(result, 2), Math.sqrt(result)};
        int skeweredResult = new Random().nextInt(possibleResults.length);
        System.out.println(equation + possibleResults[skeweredResult]);
        System.out.println("The result is " + possibleResults[skeweredResult] + ".");

        String correctAnswer;
        String wrongAnswer;
        if (possibleResults[skeweredResult] == (Math.sqrt(result))) {
            correctAnswer = "sqrt";
            wrongAnswer = "pow";
        } else {
            correctAnswer = "pow";
            wrongAnswer = "sqrt";
        }

        System.out.println("Is this the answer? Type yes or no.");
        String response;
        String answer = "";
        String nextAnswer = "";
        do {
            response = kbInput.next();
            if (response.equals("yes")) {
                System.out.println("You are wrong. Try again. Choose yes or no.");
            } else if (response.equals("no")) {
                System.out.println("Correct! Now was the result skewered by the method sqrt (takes square root of number) or by the method pow (squares the number)? Type sqrt or pow to proceed.");
            } else {
                System.out.println("Your response was neither yes nor no. Type yes or no to proceed.");
            }
        } while (!response.equals("no"));

        do {
            answer = kbInput.next();
            if (answer.equals(correctAnswer)) {
                System.out.println("You are right! The correct result should be " + result + ". Congratulations!");
            } else if (answer.equals(wrongAnswer)) {
                System.out.println("You are wrong! Choose either sqrt or pow.");
            } else {
                System.out.println("Your response was neither sqrt nor pow. Type sqrt or pow to proceed.");
            }
        } while (!answer.equals(correctAnswer));

        System.out.println("Try again? Type yes or no.");
        String fate;
        do {
            fate = kbInput.next();
            if (fate.equals("yes")) {
                main(null);
            } else if (fate.equals("no")) {
                System.exit(0);
            } else {
                System.out.println("You chose neither yes nor no. Choose yes or no to proceed.");
            }
        } while ((!fate.equals("yes")) || (!fate.equals("no")));

    }

}