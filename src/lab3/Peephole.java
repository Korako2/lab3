package lab3;

public class Peephole extends Entity implements Placeable {
    private boolean blinking; //If true -> мигает. False -> не мигает.
    private Color color;
    private String dopInfo;

    public Peephole(Payable thing, Color color) {
        super("глазок", "над язычком для объекта " + thing.toString());
        blinking = true;
        dopInfo = "настойчиво мигает цветом: " + color.getColor();
        this.color = color;
    }

    public boolean isBlinking() {
        return blinking;
    }

    public void changeState(boolean flag) {
        if (!flag) stopBlink();
        else blink();
    }

    private void blink() {
        blinking = true;
        dopInfo = " настойчиво мигает цветом: " + color.getColor();
        System.out.println("Теперь " + this.getName() + " " + getInfo() + " " + dopInfo + ".");
    }

    private void stopBlink() {
        dopInfo = "не мигает";
        System.out.println("Теперь " + this.getName() + " " + getInfo() + " " + dopInfo + ".");
        blinking = false;
    }

    public void setLocation(Room room) {
        room.addThing(this);
    }

    public String toString() {
        return getName() + ", который " + getInfo() + " " + dopInfo;
    }
}
