package mietverwaltung;

import java.io.Serializable;
import java.util.Calendar;
import java.util.GregorianCalendar;

public class Datum implements Comparable<Datum> , Serializable{

	private int tag;
	private int monat;
	private int jahr;
	
	GregorianCalendar cal = new GregorianCalendar();
	
	public Datum (int tag, int monat, int jahr) {
		this.tag = tag;
		this.monat = monat;
		this.jahr = jahr;
	}
	
	public int getTag() {
		return tag;
	}

	public void setTag(int tag) {
		this.tag = tag;
	}

	public int getMonat() {
		return monat;
	}

	public void setMonat(int monat) {
		this.monat = monat;
	}

	public int getJahr() {
		return jahr;
	}

	public void setJahr(int jahr) {
		this.jahr = jahr;
	}

	public Datum(){
		this.tag = cal.get(Calendar.DATE);
		this.monat = 1 + cal.get(Calendar.MONTH);
		this.jahr = cal.get(Calendar.YEAR);
		
	}
	
	public void print (){
		System.out.println(tag+"."+monat+"."+jahr);
	}
	
	public String toString () {
		return (tag+"."+monat+"."+jahr);
	}

	@Override
	public int compareTo(Datum arg0) {
		if (jahr > arg0.jahr) {
			return 1;
		} else if (jahr < arg0.jahr) {
			return -1;
		} else {
			if (monat > arg0.monat) {
				return 1;
			} else if (monat < arg0.monat) {
				return -1;
			} else {
				if (tag > arg0.tag) {
					return 1;
				} else if (tag < arg0.tag) {
					return -1;
				} else {
					return 0;
				}
			}
		}
	}
}


