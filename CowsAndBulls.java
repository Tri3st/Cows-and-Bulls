package bullscows;

import java.util.Random;
import java.util.ArrayList;
import java.util.Scanner;

public class CowsAndBulls {
    private static String secret;
    private static int secretLength;
    private static boolean endGame;
    private static int turn = 1;
    public static ArrayList<CnB> guesses;
    private static Scanner sc = new Scanner(System.in);

    public CowsAndBulls(){
        guesses = new ArrayList<>();
        //initSecret2();
        //get secretcode length and possible no of possible codes
        secret = GenerateCode(codeLength, noOfPossCodes);
    }

    public ArrayList<CnB> getList(){
        return guesses;
    }

    public CnB getLastTurn() {
        return guesses.get(guesses.size()-1);
    }
    
    public static String getSecret() {
      return secret;
    }

    public boolean isEndGame(){
        return endGame;
    }

    public void checkGuess (String guess){
        CnB gu = new CnB(secret, guess);
        guesses.add(gu);
        System.out.println(gu.toString());
        if (gu.getBulls() == secretLength) endGame = true;
        CowsAndBulls.turn++;
    }

    public static int getSecretLength() {
        return secretLength;
    }

    public static int getTurn() {
        return turn;
    }

    public void initSecret() {
        StringBuilder secretCode;
        int size = sc.nextInt();
        if (size > 10) {
            System.out.printf("Error: can't generate a secret number with a length of %d " +
                    "because there aren't enough unique digits.", size);
            return;
        }
        do {
            long pseudoRandomNumber = System.nanoTime();
            StringBuilder sbPseudoRnd = new StringBuilder("" + pseudoRandomNumber);
            secretCode = new StringBuilder();
            sbPseudoRnd.reverse();

            // generate secret code for a given length
            for (int i = 0; i < sbPseudoRnd.length(); i++) {
                if (Character.getNumericValue(sbPseudoRnd.charAt(0)) == 0) { // remove the 0s to the start
                    sbPseudoRnd.deleteCharAt(0);
                    i = 0;
                    continue;
                }
                int digit = Character.getNumericValue(sbPseudoRnd.charAt(i));
                if (!secretCode.toString().contains(String.valueOf(digit))) {
                    secretCode.append(digit);
                }
                if (secretCode.length() == size) {
                    break;
                }
            }
        } while (secretCode.length() != size);
        CowsAndBulls.secret = secretCode.toString();
        CowsAndBulls.secretLength = secret.length();
    }

    public boolean validateString(String str){
        boolean succes = false;
        int digit = 0;
        if (str.length() == secretLength) {
            for (int i = 0; i < secretLength; i++){
                if (Character.isDigit(str.charAt(i))) digit++;
            }
            if (digit == secretLength) succes = true;
        }
        return succes;
    }
    
    public void initSecret2() {
        StringBuilder code = new StringBuilder();
        int strsize;
        while(true){
            strsize = sc.nextInt();
            if (strsize < 0 || strsize > 9) {
                System.out.printf("Error: can't generate a secret number with a length of %d \" +\n" +
                        "                    \"because there aren't enough unique digits.", strsize);
            } else break;
        }
        Random random = new Random();
        int t;
        for (int i = 0; i < strsize; i++) {
            while (true) {
                t = random.nextInt(10);
                if (code.indexOf(Integer.toString(t)) == -1) {
                    code.append(Integer.toString(t));
                    break;
                }
            }

        }
        CowsAndBulls.secret = "" + code;
        CowsAndBulls.secretLength = code.length();

    }

    public void printResultGuess(){
        String tmp = "";
        int count = 1;
        tmp += "The secret code was : " + this.secret + "\n";
        for (CnB c: guesses){
            tmp += "Turn " + count + " : \n";
            tmp += c.toString();
        }
    }

}
