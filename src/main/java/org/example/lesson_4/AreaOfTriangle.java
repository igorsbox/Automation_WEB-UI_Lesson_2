package org.example.lesson_4;

public class AreaOfTriangle {
    public static void main(String[] args) {
        double S;
        int a = 30;
        int b = 40;
        int c = 50;
        if (isTriangleValid(a, b, c)) {
            S = triangleArea(a, b, c);
            System.out.println("Площадь треугольника равна:" + S);
        }
    }

    public static boolean isTriangleValid(int a, int b, int c) {
        if ((a + b) > c && (a + c) > b && (b + c) > a) {
            return true;
        } else {
            System.out.println("Невалидные стороны треугольника");
            return false;
        }
    }

    public static double triangleArea(int a, int b, int c) {
        double k = (((a + b + c) / 2.0) * ((a + b + c) / 2.0 - a) * ((a + b + c) / 2.0 - b) * ((a + b + c) / 2.0 - c));
        return Math.sqrt(k);
    }
}

