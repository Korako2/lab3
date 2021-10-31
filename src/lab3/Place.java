package lab3;

public enum Place {
    MOON("Луна"),
    EARTH("Земля");
    private String place;
    Place(String place) {
        this.place = place;
    }

    public String getPlace() {
        return place;
    }
}
