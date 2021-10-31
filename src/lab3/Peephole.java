package lab3;

public class Peephole extends Entity implements Thing {
    private boolean blinking;
    private Color color;
    private String info;

    public Peephole(Thing thing, Color color) {
        super("глазок около язычка для " + thing.getName());
        blinking = true;
        this.color = color;
        info = "мигает цветом: " + color.getColor();
    }

    public boolean isBlinking() {
        return blinking;
    }

    protected void changeState(boolean flag) {
        if (!flag) stopBlink();
        else blink();
    }

    private void blink() {
        blinking = true;
        info = "мигает цветом: " + color.getColor();
        System.out.println(this.getName() + " " + info + ".");
    }

    private void stopBlink() {
        info = "не мигает";
        System.out.println(this.getName() + " " + info + ".");
        blinking = false;
    }

    public void setLocation(Room room) {
        room.addThing(this);
    }

    public String getDescription() {
        return getName() + ", который " + info;
    }
}
