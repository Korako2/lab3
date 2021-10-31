package lab3;

public enum MethodsOfObjectRotation {
    LEFT("влево"),
    RIGHT("вправо"),
    BACKANDFORTH("то в одну сторону, то в другую сторону");
    private String methods;
    MethodsOfObjectRotation(String methods) {
        this.methods = methods;
    }
    public String getMethods() {
        return methods;
    }
}
