public class Main {
  public static void main(String[] args) {
        CowsAndBulls cnb = new CowsAndBulls();
        Scanner sc = new Scanner(System.in);
        String inp;
        while (true) {
            inp = sc.nextLine();
            if (cnb.validateString(inp)) break;
            else System.out.println("Invalid input. try again");
        }
        cnb.checkGuess(inp);

    }
}