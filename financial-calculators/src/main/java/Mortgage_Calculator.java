import java.util.Scanner;

public class Mortgage_Calculator {
    public static Scanner scanner = new Scanner(System.in);
    public static double interestRate = 0;
    public static double principal = 0;
    public static int loanLengthYears = 0;
    public static double monthlyPayment = 0;
    public static double totalInterestPaid = 0;

    public static void main(String[] args) {
        getUserDetails();
        calculateMortgageDetails();
        calculateTotalInterestPaid();
        displayMortgageResults();
        scanner.close();
    }

    // Get the user's details
    public static void getUserDetails() {
        System.out.println("Welcome to the mortgage calculator!");
        System.out.println("Please enter your details. What is the principal");
        principal = scanner.nextDouble();
        System.out.println("And what is the interest rate?");
        interestRate = scanner.nextDouble();
        System.out.println("What is the loan length in years?);");
        loanLengthYears = scanner.nextInt();
    }

    public static void calculateMortgageDetails() {
        // M=P×(i*(1+i)^n / ((1+i)^n)-1)
        double monthlyInterestRate = interestRate / 12 / 100; //i
        double loanLengthMonths = 12 * loanLengthYears; // n
        monthlyPayment = principal * Math.pow(1+ monthlyInterestRate, loanLengthMonths);
        calculateTotalInterestPaid();
    }

    public static void calculateTotalInterestPaid() {
        totalInterestPaid = monthlyPayment * loanLengthYears * 12 - principal;
    }
    public static void displayMortgageResults () {
        System.out.println("Results are in");
        System.out.println("Monthly Payment " + monthlyPayment);
    }
}

