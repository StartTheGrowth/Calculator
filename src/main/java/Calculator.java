import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.Scanner;

public class Calculator {
    public Calculator() {
        calc();
    }

    Logger log = LogManager.getLogger(Calculator.class.getName());
    double firstNumber;
    double secondNumber;
    Scanner scanner = new Scanner(System.in);
    boolean check = scanner.hasNext();

    void calc() {
        while (check) {
            if (scanner.hasNextDouble()) {
                firstNumber = scanner.nextDouble();
            } else {
                String line = scanner.nextLine();
                if (line.equals("c")){
                    check = false;
                } else {
                    System.out.println("Неверный ввод");
                    calc();
                }
            }
            switch (action()) {
                case "*":
                    secondNumber = scanner.nextDouble();
                    System.out.println(secondNumber * firstNumber);
                    log.info("*");
                    break;
                case "+":
                    secondNumber = scanner.nextDouble();
                    System.out.println(secondNumber + firstNumber);
                    log.info("+");
                    break;
                case "/":
                    secondNumber = scanner.nextDouble();
                    if (secondNumber == 0) {
                        System.out.println("на ноль делить нельзя");
                        log.info("/");
                    } else {
                        System.out.println(firstNumber / secondNumber);
                    }
                    break;
                case "-":
                    secondNumber = scanner.nextDouble();
                    System.out.println(firstNumber - secondNumber);
                    break;
            }
        }
    }

    String action() {
        String sym;
        System.out.println("Выберите операцию");
        sym = new Scanner(System.in).nextLine();
        boolean checkInputOperation = (sym.equals("+") || sym.equals("-") ||
                sym.equals("/") || sym.equals("*") || sym.equals("c"));
        if (!checkInputOperation) {
            System.out.println("Некорректный ввод");
            action();
        } else if (sym.equals("c")) {
            check = false;
        }
        return sym;
    }
}
