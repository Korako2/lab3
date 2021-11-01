package lab3;

public class Lamp extends Entity implements ThingsWithCost {
    private int count;
    private Room room;
    private String dopInfo;

    public Lamp(String name) {
        super(name, "используется для освещения");
        this.count = 0;
        dopInfo = "горит";
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
            dopInfo = "не горит";
            room.setLighting(Lighting.DARKNESS);
        }
        this.count = count;
    }

    public int getCount() {
        return count;
    }

    public String getDescription() {
        return getName() + ", которая " + dopInfo;
    }
}
