package util;

import java.util.Scanner;

public class InputUtil {

    public static String input(String info) {
        try (Scanner scanner = new Scanner(System.in)) {
            System.out.print(info + " : ");
            return scanner.nextLine();
        }
    }
}
