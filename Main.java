package bullscows;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    private static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        CowsAndBulls cnb = new CowsAndBulls();
        System.out.println("Okay, let's start a game!");
        while (true){
            CnB c1;
            if (cnb.isEndGame()) {
                System.out.println("Congratulations! You guessed the secret code.");
                break;
            }
            else {
                System.out.println("Turn " + CowsAndBulls.getTurn() + ":");
                String inp = sc.nextLine();
                cnb.checkGuess(inp);
            }
        }


    }



}
