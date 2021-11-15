package lab3;

public class EarthShorty extends Shorty {
    private int earthAge;
    public EarthShorty(String name, int earthAge) {
        super(name, Place.EARTH, 0);
        this.earthAge = earthAge;
    }

    public int getAge() {
        return earthAge;
    }

    public String getInfoAboutAge() {
        return earthAge + " в земных годах";
    }

    public String getInfo() {
        return getName() + ". Возраст: " + getInfoAboutAge() + ". Планета рождения: " + getPlaceOfBorn();
    }

}
