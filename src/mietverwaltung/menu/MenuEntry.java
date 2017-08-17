package mietverwaltung.menu;

import mietverwaltung.action.Action;

public class MenuEntry {

    private String name;
    private String[] location = null; // Array der Untermenuepunkte
    private Action action = null;

    public String getName() {
        return this.name;
    }

    public void setName(final String name) {
        this.name = name;
    }

    public String[] getLocation() {
        return this.location;
    }

    public void setLocation(final String[] location) {
        this.location = location;
    }

    public Action getAction() {
        return this.action;
    }

    public void setAction(final Action action) {
        this.action = action;
    }

    public MenuEntry(final String name, final String[] location) {
        this.name = name;
        this.location = location; // Untermenuepunkte
    }

    public MenuEntry(final String name, final Action action) {
        this.name = name;
        this.action = action;
    }

}
