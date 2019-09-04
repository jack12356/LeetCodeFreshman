package leetcode其他题目;

import java.util.Scanner;

public class CountDays{
    private int[] month_day = new int[]{31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};


    private boolean isLeap(int year) {
        return (year % 4 == 0 && year % 100 != 0) || year % 400 == 0;
    }


    private int dayOfYear(int year, int month, int day) {
        int res = 0;
        for (int i = 0; i < month - 1; i++) {
            res += month_day[i];
        }
        res += day;
        if (isLeap(year) && month > 2) res++;
        return res;
    }


    private int distance(int year1, int year2, int month1, int month2, int day1, int day2) {
        if (year2 < year1 || (year2 == year1 && month2 < month1) || (year2 == year1 && month2 == month1 && day2 < day1)) {
            int t = year1;
            year1 = year2;
            year2 = t;

            t = month1;
            month1 = month2;
            month2 = t;

            t = day1;
            day1 = day2;
            day2 = t;
        }
        int dis1 = dayOfYear(year1, month1, day1);
        int dis2 = dayOfYear(year2, month2, day2);
        int res = 0;
        for (int i = year1; i < year2; i++) {
            res += isLeap(i) ? 366 : 365;
        }
        res = res + dis2 - dis1;
        return res;
    }


    public static void main(String[] args) {
        CountDays solve = new CountDays();
        Scanner sc = new Scanner(System.in);
        int year0 = 2012;
        int month0 = 3;
        int day0 = 12;
        int T = sc.nextInt();
        for (int i = 0; i < T; i++) {
            int year = sc.nextInt();
            int month = sc.nextInt();
            int day = sc.nextInt();
            System.out.println(solve.distance(year0,year,month0,month,day0,day));
        }
    }
}