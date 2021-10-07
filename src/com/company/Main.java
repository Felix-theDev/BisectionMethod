package com.company;

/** Thisprogram gives an approximation method for finding the roots of a given equation
 * This program takes an input the values of the equation and the initial solution
 * @author Felix Ogbonnaya
 * @since 2020-02-17
 */
import java.util.Scanner;
public class Main {
    private static int a;
    private static int b;
    private static int c;
    private static int k;
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("The equation is of the form ax^3 + bx^2 + cx + k");
        System.out.println("Input values for a, b, c, k");
        a = input.nextInt();
        b = input.nextInt();
        c = input.nextInt();
        k = input.nextInt();
        System.out.println("The given equation is " + getEquation(a ,b, c, k));
        System.out.println("Enter values for the initial solutions (A & B)");
        double A = input.nextInt();
        double B = input.nextInt();
        System.out.print("Enter the maximum number of iterations to be performed: ");
        int max = input.nextInt();
        double x;
        double functionA = FunctionOfX(A);
        double functionB = FunctionOfX(B);
        x = (A + B) / 2;
        double arr[] = new double[max +1];
        arr[0] = x;
        double functionX = FunctionOfX(x);
        int count =1;
        do {
            if(functionX == 0) {
                System.out.println("The equation is " + x);
                break;
            }
            double y = functionA * functionX;
            if (y < 0) {
                B = x;
            }
            if (y > 0) {
                A = x;
            }
            x = (A + B) / 2;
            arr[count] = x;
            functionA = FunctionOfX(A);
            functionX = FunctionOfX(x);
            y = functionA * functionX;
            if (Math.abs(arr[count] - arr[count -1]) <= 0.005 || functionX ==0 ){
                break;
            }
            count++;
        }
            while(count <= max);
        System.out.println("The solution of the equations is " + x);

    }
    public static double FunctionOfX(double x){
        double y = (a * Math.pow(x, 3)) + (b * Math.pow(c, 2) + (c * x) + k);
        return y;

    }
    public static String getEquation(int a, int b, int c, int k){
        String Equation = a+"x^3+ " + b+"x2+" + c+"x+" + "k";
        return Equation;
    }
}
