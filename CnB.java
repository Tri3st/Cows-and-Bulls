package bullscows;

public class CnB {
    private String secret;
    private String guess;
    private int cows;
    private int bulls;

    public CnB (String secret,String guess) {
        this.secret = secret;
        this.guess = guess;
        calculateCnB();
    }

    public int getCows(){
        return this.cows;
    }

    public int getBulls() {
        return this.bulls;
    }

    private void calculateCnB() {
        //cows
        int c = 0;
        int b = 0;
        for (int i = 0; i < secret.length(); i++) {
            char x = guess.charAt(i);
            String t = "" + x;
            if (secret.contains(t)) c++;
            if (guess.charAt(i) == secret.charAt(i)) b++;
        }
        c -= b;
        this.cows = c;
        this.bulls = b;
    }

    public String toString() {
        String tmp = "";
        //tmp += "Your guess : " + this.guess + "\n";
        tmp += "Grade: ";
            if (this.bulls != 0) {
                tmp += this.bulls + " bull(s)";
                tmp += (this.cows == 0)?". ":"";
            }
            tmp += (this.bulls != 0 && this.cows != 0)?" and ":"";
            if (this.cows != 0){
                tmp += this.cows + " cow(s). ";
            }
            if (this.cows == 0 && this.bulls == 0) tmp += "None.";
        return tmp;
    }

}
