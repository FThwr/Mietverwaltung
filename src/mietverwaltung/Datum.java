package mietverwaltung;

import java.util.Calendar;
import java.util.GregorianCalendar;

public class Datum implements Comparable<Datum> {

    private int tag;
    private int monat;
    private int jahr;

    GregorianCalendar cal = new GregorianCalendar();

    public Datum(final int tag, final int monat, final int jahr) {
        this.tag = tag;
        this.monat = monat;
        this.jahr = jahr;
    }

    public int getTag() {
        return this.tag;
    }

    public void setTag(final int tag) {
        this.tag = tag;
    }

    public int getMonat() {
        return this.monat;
    }

    public void setMonat(final int monat) {
        this.monat = monat;
    }

    public int getJahr() {
        return this.jahr;
    }

    public void setJahr(final int jahr) {
        this.jahr = jahr;
    }

    public Datum() {
        this.tag = this.cal.get(Calendar.DATE);
        this.monat = 1 + this.cal.get(Calendar.MONTH);
        this.jahr = this.cal.get(Calendar.YEAR);

    }

    public void print() {
        System.out.println(this.tag + "." + this.monat + "." + this.jahr);
    }

    @Override
    public String toString() {
        return (this.tag + "." + this.monat + "." + this.jahr);
    }

    @Override
    public int compareTo(final Datum arg0) {
        if (this.jahr > arg0.jahr) {
            return 1;
        } else if (this.jahr < arg0.jahr) {
            return -1;
        } else {
            if (this.monat > arg0.monat) {
                return 1;
            } else if (this.monat < arg0.monat) {
                return -1;
            } else {
                if (this.tag > arg0.tag) {
                    return 1;
                } else if (this.tag < arg0.tag) {
                    return -1;
                } else {
                    return 0;
                }
            }
        }
    }
}
