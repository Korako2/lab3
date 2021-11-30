package lab3;

public class FilmAboutPolice extends Film {
    public FilmAboutPolice() {
        createFilm();
    }

    void createFilm() {
    }

    public class PoliceSquad {
        private int count;
        private String name;
        private PoliceSquad(int count, String name) {
            this.count = count;
        }
        private void startCapturing(String nameOfBandit) {
            System.out.println(name + " начали захват " + nameOfBandit);
        }
        private void throwingBombs(String description, Gang gang){
            System.out.println(name + " забрасывали объект " + gang.name + " бомбами " + description);
        }
        private void callForHelp(ArmoredCarSquad armoredCarSquad) {
            System.out.println(name + " вызвали на подмогу " + armoredCarSquad.name);
        }
        private void joiSquadOfCars(ArmoredCarSquad armoredCarSquad) {
            System.out.println(name + " присоединились к объекту " + armoredCarSquad.name);
        }
    }

    public class Gang {
        private int count;
        private String nameOfLeader;
        private String name;
        private Gang(int count, String nameOfLeader, String name) {
            this.count = count;
            this.nameOfLeader = nameOfLeader;
            this.name = name;
        }
        private void rushToRescue(String name){
            System.out.println(this.name + " бролись выручать бандита по имени: " + name);
        }
    }
    private class ArmoredCarSquad {
        private int count;
        private String name;
        private ArmoredCarSquad(int count, String name){
            this.count = count;
            this.name = name;
        }
        private void startChase(Gang gang){
            System.out.println(name + " пустился в погоню за объектом " + gang.name);
        }
        private void breakDuringTheRoad(String description) {
            System.out.println(name + " крушил и ломал " + description);
        }
    }
}
