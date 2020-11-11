import java.util.Random;
import java.util.ArrayList;

public class CowsAndBulls {
  private static String secret;
  private static int turn = 0;
  private ArrayList<CnB> guesses;
  
  public CowsAndBulls(){
    guesses = new ArrayList<>();
    initSecret();
    System.out.println("code is : " + this.secret);
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
  
  public void printResultGuess(){
    //eerst tostring in CnB maken
  }
  
}