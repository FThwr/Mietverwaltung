package hilfsklassen;

import java.io.Serializable;

public class Bedingung implements Serializable {

    private static final long serialVersionUID = 1861648890010637088L;
    private double wunschwert;
    private int rela;
    private int krit;

    public Bedingung(final int krit, final int rela, final double wunschwert) {

        this.wunschwert = wunschwert;
        this.rela = rela;
        this.krit = krit;
    }

    public double getWunschwert() {
        return this.wunschwert;
    }

    public void setWunschwert(final double wunschwert) {
        this.wunschwert = wunschwert;
    }

    public int getRela() {
        return this.rela;
    }

    public void setRela(final int rela) {
        this.rela = rela;
    }

    public int getKrit() {
        return this.krit;
    }

    public void setKrit(final int krit) {
        this.krit = krit;
    }
}