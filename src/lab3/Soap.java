package lab3;

public class Soap extends Entity implements ThingsWithCost {
    private int count;

    public Soap(String name) {
        super(name, "используется для умывания");
        count = 0; // количество использований мыла(не уменьшается)
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
        } else return false;
    }

    public void pinchEyes(Shorty shorty, String reason) {
        System.out.println(this.getName() + " невыносимо щиплет глаза объекту " + shorty.getName() + " так как " + reason + ".");
    }

    public String getDescription() {
        return getName();
    }
}
