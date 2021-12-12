package lab3;

import java.util.ArrayList;

public class FilmAboutPolice extends Film {
    public FilmAboutPolice() {
        createFilm();
    }

    void createFilm() {
        ArrayList<String> actions = new ArrayList<>();
        actions.add("Картина между тем становилась все напряженнее и стремительнее");
        FilmAction chases = new FilmAction("погони", "головокружительные");
        FilmAction fights = new FilmAction("драки", "массовые");
        FilmAction fire = new FilmAction("перестрелки", "оглушительные");
        actions.add("Возникали " + chases.info + " " + chases.name + ", " + fights.info + " " +
                fights.name + ", " + fire.info + " " + fire.name + ".");
        PoliceSquad policeSquad = new PoliceSquad(5, "отряд полицейских");
        Gang gang = new Gang(10, "главарь шайки по кличке Меткий", "банда");
        actions.add("Началось самое интересное место фильма: " + policeSquad.startCapturing(gang));
        actions.add(gang.rushToRescue(gang.nameOfLeader));
        ArmoredCarSquad armoredCarSquad = new ArmoredCarSquad(3, "отряд бронированных машин");
        actions.add(policeSquad.throwingBombs("со слезоточивым газом", gang) + "\n" + "Затем " +
                policeSquad.callForHelp(armoredCarSquad) + "\n" + policeSquad.joinSquadOfCars(armoredCarSquad));
        actions.add( armoredCarSquad.startChase(gang) + "\n" + armoredCarSquad.breakDuringTheRoad("все на своем пути"));
        actions.add("Началось самое интересное место фильма: " + policeSquad.startCapturing(gang));
        setActions(actions);
    }

    private class PoliceSquad {
        private int count;
        private String name;

        private PoliceSquad(int count, String name) {
            this.count = count;
            this.name = name;
        }

        private String startCapturing(Gang gang) {
            return (name + " в количестве " + count + " человек" + " начал захват человека: " + gang.nameOfLeader + ".");
        }

        private String throwingBombs(String description, Gang gang) {
            return (name + " забрасывали объект " + gang.name + " бомбами " + description);
        }

        private String callForHelp(ArmoredCarSquad armoredCarSquad) {
            return (name + " вызвали на подмогу " + armoredCarSquad.name + " в составе из " + armoredCarSquad.count + "машин.");
        }

        private String joinSquadOfCars(ArmoredCarSquad armoredCarSquad) {
            return (name + " присоединились к объекту " + armoredCarSquad.name);
        }
    }

    private class Gang {
        private int count;
        private String nameOfLeader;
        private String name;

        private Gang(int count, String nameOfLeader, String name) {
            this.count = count;
            this.nameOfLeader = nameOfLeader;
            this.name = name;
        }

        private String rushToRescue(String name) {
            return (this.name + " бросились выручать бандита: " + name);
        }
    }

    private class FilmAction {
        private String name;
        private String info;

        public FilmAction(String name, String info) {
            this.name = name;
            this.info = info;
        }

        public void startAction(FilmAboutPolice.Gang gang, FilmAboutPolice.PoliceSquad policeSquad) {

        }
    }


    private class ArmoredCarSquad {
        private int count;
        private String name;

        private ArmoredCarSquad(int count, String name) {
            this.count = count;
            this.name = name;
        }

        private String startChase(Gang gang) {
            return (name + " пустился в погоню за объектом " + gang.name + ".");
        }

        private String breakDuringTheRoad(String description) {
            return (name + " крушил и ломал " + description + ".");
        }
    }
}
