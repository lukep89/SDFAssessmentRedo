import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        // System.out.println("hey friend");

        System.out.println("Welcome.");

        Scanner sc = new Scanner(System.in);
        Boolean stop = true;

        Double last = 0d;

        while (true) {

            System.out.print("> ");
            // user input
            String input = sc.nextLine();

            // if input "exit" end operation
            if (input.equalsIgnoreCase("exit")) {
                System.out.println("Bye bye");
                stop = false;
                break;
            }

            String[] lineSplit = input.split(" ");

            // condition if lineSpliter[1] & [2] equals to last
            Double num1 = lineSplit[0].equals("$last") ? last : Double.parseDouble(lineSplit[0]);
            String operator = lineSplit[1];
            Double num2 = lineSplit[2].equals("$last") ? last : Double.parseDouble(lineSplit[2]);

            switch (operator) {
                case "+":
                    last = num1 + num2;
                    System.out.println(last);
                    break;

                case "-":
                    last = num1 - num2;
                    System.out.println(last);
                    break;

                case "/":
                    last = num1 / num2;
                    System.out.println(last);
                    break;

                case "*":
                    last = num1 * num2;
                    System.out.println(last);
                    break;

                default:
                    System.out.println("operation not valid.");
                    break;

            } // switch

        } // while

    } // main
} // class
