package bullscows;

import java.util.Random;
import java.util.ArrayList;
import java.util.Scanner;

public class CowsAndBulls {
    private String secret;
    private int secretLength;
    private int possNoOfCodes;
    private boolean endGame;
    private int turns;
    private ArrayList<CnB> guesses;
    private static Scanner sc = new Scanner(System.in);

    public CowsAndBulls(int secretLength, int possNoOfCodes){
        this.secretLength = secretLength;
        this.possNoOfCodes = possNoOfCodes;
        turns = 0;
        guesses = new ArrayList<>();
        //get secretcode length and possible no of possible codes
        GenerateCode gnc = new GenerateCode(secretLength, possNoOfCodes);
        secret = gnc.getCode();
    }

    public ArrayList<CnB> getList(){
        return guesses;
    }

    /*public CnB getLastTurn() {
        return guesses.get(guesses.size()-1);
    }*/
    
    /*public String getSecret() {
      return secret;
    }*/

    public boolean isEndGame(){
        return endGame;
    }

    public void checkGuess (String guess){
        this.turns++;
        CnB gu = new CnB(secret, guess, turns);
        guesses.add(gu);
        System.out.println(gu.toString());
        if (gu.getBulls() == secretLength) endGame = true;

    }

    /*public int getSecretLength() {
        return secretLength;
    }*/

    public int getTurn() {
        return turns;
    }

    
    private boolean validateString(String str){
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
    
    public String printResultGuess(){
        String tmp = "";
        int count = 1;
        tmp += "The secret code was : " + this.secret + "\n";
        for (CnB c: guesses){
            tmp += c.toStringLong();
            count++;
        }
        return tmp;
    }

}
