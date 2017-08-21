package mietverwaltung;

import java.io.Serializable;
import java.util.Calendar;
import java.util.GregorianCalendar;

public class Datum implements Comparable<Datum>, Serializable {

    private static final long serialVersionUID = 7907478171840216174L;

    private int tag;
    private int monat;
    private int jahr;

    private static final GregorianCalendar cal = new GregorianCalendar();

    public Datum() {
        this(Datum.cal.get(Calendar.DATE), 1 + Datum.cal.get(Calendar.MONTH), Datum.cal.get(Calendar.YEAR));
    }

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
        }

        if (this.monat > arg0.monat) {
            return 1;
        } else if (this.monat < arg0.monat) {
            return -1;
        }

        if (this.tag > arg0.tag) {
            return 1;
        } else if (this.tag < arg0.tag) {
            return -1;
        }

        return 0;
    }
}
