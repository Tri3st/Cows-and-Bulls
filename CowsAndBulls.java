package bullscows;

import java.util.Random;
import java.util.ArrayList;

public class CowsAndBulls {
    private static String secret;
    private static int turn = 0;
    private ArrayList<CnB> guesses;

    public CowsAndBulls(){
        guesses = new ArrayList<>();
        initSecret();
    }

    public void checkGuess (String guess){
        CnB gu = new CnB(secret, guess);
        guesses.add(gu);
        System.out.println(gu.toString());
    }

    public void initSecret() {
        String tmp = "";
        Random rnd = new Random();
        for (int i = 0; i < 4; i++) {
            tmp += rnd.nextInt(10);
        }
        this.secret = tmp;
    }

    public boolean validateString(String str){
        boolean succes = false;
        int digit = 0;
        if (str.length() == 4 && str != null) {
            for (int i = 0; i < 4; i++){
                if (Character.isDigit(str.charAt(i))) digit++;
            }
            if (digit == 4) succes = true;
        }
        return succes;
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
