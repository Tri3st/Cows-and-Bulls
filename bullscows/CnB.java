package bullscows;

public class CnB {
    private final String secret;
    private final String guess;
    private int turn;
    private int cows;
    private int bulls;

    public CnB (String secret,String guess, int turn) {
        this.secret = secret;
        this.guess = guess;
        this.turn = turn;
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

    public String toStringLong() {
        String tmp = "";
        tmp += "Turn " + this.turn + " | ";
        tmp += "Guess : \'" + this.guess + "\'" + " | ";
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
        tmp += "\n";
        return tmp;
    }

    public String toString() {
        String tmp = "";
        //tmp += "Turn " + this.turn + " : ";
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
            tmp += "\n";
        return tmp;
    }

}
