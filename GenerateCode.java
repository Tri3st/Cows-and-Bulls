package bullscows;
import java.util.Random;

public class GenerateCode {
  private int codeLength;
  private int possCodes;
  private static char[] initChars = fillArray();
  private String secret;
  
  public GenerateCode(int codeLength, int possCodes) {
    this.codeLength = codeLength;
    this.possCodes = possCodes;
    this.secret = generateCode(codeLength, possCodes);
  }

  protected String getCode() {
    return this.secret;
  }
  
  private static char[] fillArray() {
    char[] alph = new char[36];
    for (int i = 0; i < 36; i++) {
      if (i < 10) alph[i] = (char)(i + 48);
      else {
        alph[i] = (char)(i + 87);
      }
    }
    return alph;
  }
  
  private static String generateCode(int l, int p) {
    String sec = "";
    int[] nums = new int[l];
    Random r = new Random();
    for(int i = 0; i < l; i++) {
      while (true){
        boolean exist = false;
        int x = r.nextInt(p);
        for(int j = 0; j < l; j++){
          if (x == nums[j]) exist = true;
        }
        if (!exist) {
          nums[i] = x;
          break;
        }
      }
    }
    for (int k = 0; k < l; k++) sec += initChars[nums[k]];
    return sec;
  }
  
  public String printCode(){
    
    String tmp = String.format("code : %s%n", this.secret);
    return tmp;
  }
  
  
}