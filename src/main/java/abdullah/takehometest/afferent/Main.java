package abdullah.takehometest.afferent;

import java.util.Scanner;

public class Main {
    public static void main( String[] args )
    {
        Calculator calc = new Calculator();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            String input = scanner.nextLine();

            if (input.equals("close") || input.equals("exit")) break;

            Double val = calc.parse(input);
            if (val == null) {
                System.out.println("Invalid input");
            } else {
                System.out.println("-> " + val);
            }
        }

        scanner.close();
    }
}
