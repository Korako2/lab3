package lab3;

public class Sink extends Entity implements Thing{
    private Faucet faucet;

    public Sink(Faucet faucet) {
        super("рукомойник");
        this.faucet = faucet;
    }
    public void setLocation(Room room) {
        room.addThing(this);
    }

    public Faucet getFaucet() {
        return faucet;
    }

    public String getDescription() {
        return getName() + ", у которого есть " + faucet.getName();
    }
}
















