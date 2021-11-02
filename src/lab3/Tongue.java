package lab3;

public class Tongue extends Entity implements Thing {
    private String material;
    private String dopInfo;
    private boolean pokedOut;

    public Tongue(Thing thing) {
        super("язычок", "на оплату объекта " + thing.getName());
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
        }
        else {
            dopInfo = "находится в стене";
            System.out.println("Теперь " + getName() + " " + getInfo() + " " + dopInfo + ".");
        }
        pokedOut = flag;
    }

    public String getDescription() {
        return material + " " + getName() + " " + getInfo() + ", который  " + dopInfo;
    }
}
