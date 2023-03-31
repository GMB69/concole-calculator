package de.qcademy.calculator;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Pattern plusOppattern = Pattern.compile("\\s*(\\d+)\\s*\\+\\s*(\\d+)|\\s*\\+\\s*(\\d+)|\\s*(\\d+)");
        Pattern quitPattern = Pattern.compile("^\\s*:q\\s*$");


        boolean calculatorStopped = false;
        while (! calculatorStopped) {
            System.out.print("Ausdruck eingeben: ");
            String input = scanner.nextLine();
            Matcher plusOpmatcher = plusOppattern.matcher(input);
            Matcher quitMatcher = quitPattern.matcher(input);
            if (plusOpmatcher.matches()) {
                if (plusOpmatcher.group(4) != null) {
                    double result = Double.parseDouble(plusOpmatcher.group(4));
                    System.out.println(input + " = " + result);
                } else if (plusOpmatcher.group(3) != null) {
                        double result = Double.parseDouble(plusOpmatcher.group(3));
                        System.out.println(input + " = " + result);
                    } else {
                        double firstOperand = Double.parseDouble(plusOpmatcher.group(1));
                        double secondOperand = Double.parseDouble(plusOpmatcher.group(2));
                        double result = firstOperand + secondOperand;
                        System.out.println(input + " = " + result);
                    }
                } else if (quitMatcher.matches()) {
                    System.out.println("Taschenrechner wird gestoppt.");
                    calculatorStopped = true;
                } else {
                    System.err.println("Operation " + input + " nicht erkannt!");
                }
    }
}
}
