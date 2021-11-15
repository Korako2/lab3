package lab3;

public class Towel extends Entity implements Payable, Placeable {
    private int count; // количество использований(не уменьшается).

    public Towel(String name) {
        super(name, "используется для вытирания");
        this.count = 0;
    }

    public void setLocation(Room room) {
        room.addThing(this);
    }

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

    public String toString() {
        return getName();
    }
}
