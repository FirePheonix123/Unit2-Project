import java.util.Scanner;
public class LinearEquationLogic {
    Scanner scan = new Scanner(System.in);
    private LinearEquation equation;
    private Scanner myScan;
    LinearEquation line = new LinearEquation();

    public LinearEquationLogic() {
        equation = null; // will initialize from user input
        myScan = new Scanner(System.in);
    }
    public void start() {
        MainMenu();
    }
    private void MainMenu() {
        Boolean ans = true;
        while (ans) {
            getCoords();

            System.out.println("\n" + line.lineInfo() + "\n");

            System.out.print("Enter a value for x: ");
            int x = scan.nextInt();
            System.out.println("The point on the line is: " + line.coordinateForX(x));


            System.out.println("\nWould you like to enter another pair of coordinates? y/n: ");
            String ans2 = scan.nextLine();
            if(ans2.equals("y")) {
                ans = false;
            }
        }
        System.out.println("Thank you for using the slope calculator, goodbye!");
    }
    private void getCoords() {
        System.out.println("Welcome to the linear equation calculator!");
        System.out.print("Enter coordinate 1: ");
        String cord1 = scan.nextLine();
        System.out.print("Enter coordinate 2: ");
        String cord2 = scan.nextLine();


        String[] result1 = cord1.substring(1, cord1.length() - 1).split(", ");
        String[] result2 = cord2.substring(1, cord1.length() - 1).split(", ");

        line.setCoords(Integer.parseInt(result1[0]), Integer.parseInt(result1[1]), Integer.parseInt(result2[0]), Integer.parseInt(result2[1]));
    }
}
