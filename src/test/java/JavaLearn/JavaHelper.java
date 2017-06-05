package JavaLearn;

import javax.swing.*;

public class JavaHelper {
    private int hour;
    private int minute;
    private int second;

    public void setTime(int h, int m, int s) {
        hour = ((h > 0 && h < 24) ? h:0);
        minute = ((m > 0 && m < 60) ? m:0);
        second = ((s > 0 && s < 60) ? s:0);
    }

    public String toMilitary(){
        return  String.format("%02d:%02d:%02d", hour, minute, second);
    }

    public String toNormal(){
        return String.format("%d:%02d:%02d %s", hour==0||hour==12 ? 12:hour%12, minute, second, hour<12 ? "AM":"PM");
    }

    private int year;
    private int month;
    private int day;

    public JavaHelper(){
        this(0, 0, 0);
    }

    public JavaHelper(int y){
        this(y, 0, 0);
    }

    public JavaHelper(int y, int m){
        this(y, m, 0);
    }

    public JavaHelper(int y, int m, int d){
        setDate(y, m, d);
    }

    public void setDate(int y, int m, int d){
        setYear(y);
        setMonth(m);
        setDay(d);
    }

    public void setYear(int y){
        year = (y >= 1900 && y <= 2016 ? y:2016);
    }

    public void setMonth(int m){
        month = (m >= 1 && m <= 12 ? m:1);
    }

    public void setDay(int d){
        day = (d >= 1 && d <= 31 ? d:1);
    }

    public int getYear(){
        return year;
    }

    public int getMonth(){
        return month;
    }

    public int getDay(){
        return day;
    }

    public String toDisplay(){
        return String.format("%04d-%02d-%02d", year, month, day);
    }

    private String name;
    private JavaRock bd;

    public JavaHelper(String n, JavaRock bday){
        name = n;
        bd = bday;
    }

    public String toString(){
        return String.format("My name is %s, I was born in %s!!!", name, bd);
    }

    public void mult(){
        System.out.println("Im method Mult");
    }
}
