package lab3;

public class Tongue extends Entity implements Placeable {
    private String material;
    private String dopInfo;
    private boolean pokedOut;

    public Tongue(Payable thing) {
        super("язычок", "на оплату объекта " + thing.toString());
        material = "металлический";
        pokedOut = true; // true - выдвинут из стены. false - спрятан.
        dopInfo = "торчит из стены"; // Если pokedOut = true -> торчит из стены. Если false - находится в стене.
    }

    public void setLocation(Room room) {
        room.addThing(this);
    }

    public void changeState(boolean flag) {
        if (flag) {
            dopInfo = "торчит из стены";
            System.out.println("Теперь " + getName() + " " + getInfo() + " " + dopInfo + ".");
        } else {
            dopInfo = "находится в стене";
            System.out.println("Теперь " + getName() + " " + getInfo() + " " + dopInfo + ".");
        }
        pokedOut = flag;
    }

    public String toString() {
        return material + " " + getName() + " " + getInfo() + ", который " + dopInfo;
    }
}
