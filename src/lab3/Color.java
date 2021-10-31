package lab3;

public enum Color {
    RED("красный"),
    GREEN("зеленый"),
    BLUE("синий");
    private String color;
    Color(String color) {
        this.color = color;
    }
    public String getColor() {
        return color;
    }
}
