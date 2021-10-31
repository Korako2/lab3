package lab3;

public enum Lighting {
    LIGHT("светло"),
    DARKNESS("темно");
    private String lighting;
    Lighting(String lighting) {
        this.lighting = lighting;
    }

    public String getLighting() {
        return lighting;
    }
}
