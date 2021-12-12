package lab3;

import java.util.ArrayList;

public abstract class Film {
    private ArrayList<String> actions = new ArrayList<>();

    abstract void createFilm();

    public void setActions(ArrayList<String> actions) {
        this.actions = actions;
    }

    public ArrayList<String> getActions() {
        return actions;
    }
}
