package lab3;

public class Service extends Entity implements Payable{

    private int count;

    public Service(String name) {
        super(name, "предоставляются отелем за плату");
        count = 0;
    }

    public String toString() {
        return getName();
    }

    public boolean use(Shorty shorty) {
        if (count > 0) {
            System.out.println(shorty.getName() + " использует " + getName());
            return true;
        } else {
            System.out.println(shorty.getName() + " не можут использовать " + getName());
            return false;
        }
    }

    public void setCount(int count) {
        this.count = count;
    }

    public int getCount() {
        return count;
    }
}
