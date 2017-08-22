package mietverwaltung;

import java.util.Calendar;
import java.util.GregorianCalendar;

public class Gregorien {

    private int tag;
    private int monat;
    private int jahr;

    public void init() {

        GregorianCalendar cal = new GregorianCalendar();

        this.tag = cal.get(Calendar.DATE);
        this.monat = cal.get(Calendar.MONTH) + 1; // Von 0…11!
        this.jahr = cal.get(Calendar.YEAR);
    }

    public void display() {

        System.out.println(this.tag + "." + this.monat + "." + this.jahr);

    }

}