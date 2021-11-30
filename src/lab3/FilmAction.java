package lab3;

public abstract class FilmAction {
    private String name;
    private String info;
    public FilmAction(String name, String info){
        this.name = name;
    }

    public abstract void startAction(FilmAboutPolice.Gang gang, FilmAboutPolice.PoliceSquad policeSquad);

    static class Chase extends FilmAction{

        public Chase(String name) {
            super(name, "");
        }

        public void startAction(FilmAboutPolice.Gang gang, FilmAboutPolice.PoliceSquad policeSquad) {
            /////////////
        }
    }
    static class Fight extends FilmAction{

        public Fight(String name) {
            super(name, "");
        }

        public void startAction(FilmAboutPolice.Gang gang, FilmAboutPolice.PoliceSquad policeSquad) {
            /////////////
        }
    }
    static class Shootout extends FilmAction{

        public Shootout(String name) {
            super(name, "");
        }

        public void startAction(FilmAboutPolice.Gang gang, FilmAboutPolice.PoliceSquad policeSquad) {
            /////////////
        }
    }
}
