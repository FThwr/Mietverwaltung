package objekte;

public class Mitarbeiter {

    private int mitarbeiterID;
    private String name;
    private String vorname;
    private String benutzername;
    private String passwort;

    public Mitarbeiter(final int mitarbeiterID, final String name, final String vorname, final String passwort) {
        this.mitarbeiterID = mitarbeiterID;
        this.name = name;
        this.passwort = passwort;
        this.benutzername = vorname.trim().substring(0, 1) + "." + name;
    }

    public Mitarbeiter(final int mitarbeiterID, final String name, final String vorname) {
        this(mitarbeiterID, name, vorname, null);
    }

    public String getName() {
        return this.name;
    }

    public void setName(final String name) {
        this.name = name;
    }

    public String getVorname() {
        return this.vorname;
    }

    public void setVorname(final String vorname) {
        this.vorname = vorname;
    }

    public String getBenutzername() {
        return this.benutzername;
    }

    public void setBenutzername(final String benutzername) {
        this.benutzername = benutzername;
    }

    public String getPasswort() {
        return this.passwort;
    }

    public void setPasswort(final String passwort) {
        this.passwort = passwort;
    }

}
