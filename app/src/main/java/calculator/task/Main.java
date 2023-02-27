package calculator.task;

import java.util.Scanner;

public class Main {
    private static final Calculator calculator = Factory.getInstance().create(Calculator.class);

    public static void main(String[] args) throws ValidationException {
        System.out.println(calc(write()));
    }

    private static String calc(String input) throws ValidationException {
        return calculator.calculate(input);
    }

    private static String write() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter your equation:");
        return scanner.nextLine();
    }
}
