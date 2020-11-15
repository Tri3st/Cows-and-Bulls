package bullscows;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    private static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        System.out.println("Okay, let's start a game!");
        int codeLength = getCodeLength();
        int possCodes = getNoOfPossCodes(codeLength);
        CowsAndBulls cnb = new CowsAndBulls(codeLength, possCodes);
        System.out.println(printRange(possCodes));
       while (true){
            if (cnb.isEndGame()) {
                System.out.println("Congratulations! You guessed the secret code.");
                break;
            }
            else {
                System.out.println("Turn " + cnb.getTurn() + ":");
                String inp = sc.nextLine();
                cnb.checkGuess(inp);
            }
        }
    }

  private static int getCodeLength(){
    int cl = -1;
    System.out.println("Input the length of the secret code:");
    while (true) {
      cl = sc.nextInt();
      sc.nextLine();
      if (cl > 0 && cl < 37) break;
      else System.out.println("Incorrect input. try again");
    }
    return cl;
  } 
  
  private static int getNoOfPossCodes(int codeLength) {
    int pc = -1;
    System.out.println("Input the number of possible symbols in the code:");
    while (true) {
      pc = sc.nextInt();
      sc.nextLine();
      if (pc >= codeLength &&  pc > 0 && pc < 37) break;
      else System.out.println("Incorrect input. try again.");
    }
    return pc;
  }
  
  private static String printRange(int noOfCodes){
    String tmp = "(0";
    if(noOfCodes > 0) tmp += "-";
    if(noOfCodes < 11) tmp += "" + (noOfCodes-1) + ").";
    else {
      tmp += "9, a";
      if (noOfCodes > 11) tmp += "-"+ (char)(noOfCodes + 86) + ").";
      else tmp += ").";
    }
    return tmp;
  }



}
