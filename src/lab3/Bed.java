package lab3;

public class Bed extends Entity implements Placeable{
    private Entity blanket;
    public Bed(String name){
        super(name, "используется для сна");
        blanket = new Entity("одеяло","используется для укрывания") {
            public String toString() {
                //!!!!
                return null;
            }
        };
    }
    public String toString() {
        // !!!
        return null;
    }

    public Entity getBlanket() {
        return blanket;
    }

    public void setLocation(Room room) {
        room.addThing(this);
    }
}
