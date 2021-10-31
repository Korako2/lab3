package lab3;

public class Towel extends Entity implements ThingsWithCost {
    private int count;
    public Towel() {
        super("полотенце");
        this.count = 0;
    }

    public void setLocation(Room room) {}

    public boolean use(Shorty shorty) {
        if (count != 0) {
            System.out.println(shorty.getName() + " смог вытереться.");
            return true;
        }
        System.out.println(shorty.getName() + " ждал, пока само высохнет.");
        return false;
    }

    public void setCount(int count) {
        this.count = count;
    }
    public int getCount() {
        return count;
    }

    public String getDescription() {
        return getName();
    }
}
