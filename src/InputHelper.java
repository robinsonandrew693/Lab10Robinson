import javax.print.DocFlavor;
import java.util.Scanner;

public class InputHelper {
    //All methods should be public and static

    public static String getNonZeroLenString(Scanner scan, String prompt) {
        String s;
        boolean valid = false;
        System.out.println(prompt);
        do {
            s = scan.nextLine();
            if (s.length() > 0) {
                valid = true;
            }
            else {
                System.out.println("Error: Please try again. You entered a String of length 0.");
            }
        } while (!valid);
        return s;
    }

    public static int getInt(Scanner scan, String prompt) {
        int x = 0;
        boolean valid = false;
        System.out.println(prompt);
        do {
            if (scan.hasNextInt()) {
                x = scan.nextInt();
                valid = true;
            }
            else {
                System.out.println("Error: Please try again. You didn't enter an integer.");
            }
            scan.nextLine();
        } while (!valid);
        return x;
    }

    public static double getDouble(Scanner scan, String prompt) {
        double y = 0;
        boolean valid = false;
        System.out.println(prompt);
        do {
            if (scan.hasNextDouble()) {
                y = scan.nextDouble();
                valid = true;
            }
            else {
                System.out.println("Error: Please try again. You didn't enter a double.");
            }
            scan.nextLine();
        } while (!valid);
        return y;
    }

    public static int getRangedInt(Scanner scan, String intPrompt, int minimum, int maximum) {
        int z = 0;
        boolean validInt = false;
        System.out.println(intPrompt);
        do {
            if (scan.hasNextInt()) {
                z = scan.nextInt();
                if (z >= minimum && z <= maximum) {
                    validInt = true;
                }
                else {
                    System.out.println("Error: Please try again. You didn't enter a value in the right range.");
                }
            }
            else {
                System.out.println("Error: Please try again. You didn't enter an integer.");
            }
            scan.nextLine();
        } while (!validInt);
        return z;
    }

    public static double getRangedDouble(Scanner scan, String intPrompt, double minimum, double maximum) {
        double a = 0;
        boolean valid = false;
        System.out.println(intPrompt);
        do {
            if (scan.hasNextDouble()) {
                a = scan.nextDouble();
                if (a >= minimum && a <= maximum) {
                    valid = true;
                }
                else {
                    System.out.println("Error: Please try again. You didn't enter a value in the right range.");
                }
            }
            else {
                System.out.println("Error: Please try again. You didn't enter a double.");
            }
            scan.nextLine();
        } while (!valid);
        return a;
    }

    public static int getPositiveNonZeroInt(Scanner scan, String prompt) {
        int j = 0;
        boolean valid = false;
        System.out.println(prompt);
        do {
            if (scan.hasNextInt()) {
                j = scan.nextInt();
                if (j > 0) {
                    valid = true;
                }
                else {
                    System.out.println("Error: Please try again. You didn't enter a positive, non-zero.");
                }
            }
            else {
                System.out.println("Error: Please try again. You didn't enter an integer.");
            }
            scan.nextLine();
        } while (!valid);
        return j;
    }

    public static String getYNConfirm(Scanner scan, String prompt) {
        String q;
        boolean valid = false;
        System.out.println(prompt);
        do {
            q = scan.nextLine();
            if (q.equalsIgnoreCase("Y") || q.equalsIgnoreCase("N")) {
                valid = true;
            }
            else {
                System.out.println("Error: Please try again. You didn't enter a yes or no answer.");
            }
        } while (!valid);
        return q;
    }

    public static String getRegExString(Scanner scan, String prompt, String pattern) {
        String b;
        boolean valid = false;
        System.out.println(prompt);
        do {
            b = scan.nextLine();
            if (b.matches(pattern)) {
                valid = true;
            }
            else {
                System.out.println("Error: Please try again. You didn't enter a string that matches the pattern.");
            }
        } while (!valid);
        return b;
    }
}
