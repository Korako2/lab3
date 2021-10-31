package lab3;

public class Soap extends Entity implements ThingsWithCost {
    private int count;
    public Soap() {
        super("мыло");
        count = 0;
    }
    public void setLocation(Room room) {
        room.addThing(this);
    }

    public void setCount(int count) {
        this.count = count;
    }
    public int getCount() {
        return count;
    }
    public boolean use(Shorty shorty) {
        if (count != 0) {
            System.out.println(shorty.getName() + " намылил лицо.");
            return true;
        }else return false;
    }

    public void pinchEyes(Shorty shorty){

    }

    public String getDescription() {
        return getName();
    }
}
