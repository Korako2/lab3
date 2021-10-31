package lab3;

public class Lamp extends Entity implements ThingsWithCost {
    private int count;
    private Room room;
    private String info;

    public Lamp() {
        super("лампочка");
        this.count = 0;
        info = "горит";
    }

    public void setLocation(Room room) {
        room.addThing(this);
        this.room = room;
    }

    public boolean use(Shorty shorty) {
        if (count != 0) {
            System.out.println(shorty.getName() + " может все разгядеть в " + room.getName());
            return true;
        }
        System.out.println(shorty.getName() + " может с трудом что-то разгядеть в " + room.getName());
        return false;
    }

    public void setCount(int count) {
        if (count == 0) {
            System.out.println("Свет погас" + ".");
            info = "не горит";
            room.setLighting(Lighting.DARKNESS);
        }
        this.count = count;
    }

    public int getCount() {
        return count;
    }

    public String getDescription() {
        return getName() + ", которая " + info;
    }
}
