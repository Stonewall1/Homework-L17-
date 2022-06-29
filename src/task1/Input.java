package task1;

import java.util.Scanner;

public class Input {

    private static String input(){
        Scanner scanner = new Scanner(System.in);
        return scanner.nextLine();
    }

    public static String getInput(){
        return input();
    }
}
