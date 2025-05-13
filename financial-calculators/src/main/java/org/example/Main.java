package org.example;

import java.util.Scanner;

public class Main {
    static Scanner user_info = new Scanner(System.in);

    public static void main(String[] args) {
        /* application for finance that provides a set of financial calcs, prompting user
        to select which calc they would like to use */

        // Mortgage Calculator
        // user input: principal amount, interest rate, loan length
        // display expected monthly payment and total interest paid

    }

    public static void mortgageCalculator(double principal, double annual_ir, double loan_length_in_years) {
        principal = user_info.nextDouble(); // total amount of loan - user
        annual_ir = user_info.nextDouble(); // annual interest rate - user
        loan_length_in_years = user_info.nextDouble(); // how many years the loan lasts - user
        double monthly_i = (user_info.nextDouble() / 12);
        int nr_of_monthly_payments = (int) (loan_length_in_years * 12); // 12 x y because there are 12 monthly payments/year
        double pow = Math.pow();
        double monthly_payment = principal * ((monthly_i * (1 + monthly_i))
        (((double) nr_of_monthly_payments / (1 + monthly_i
        Math.pow(nr_of_monthly_payments)))-1));
        // compounded interest formula M=P×(i*(1+i)^n / ((1+i)^n)-1)

    }
}