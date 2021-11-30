package lab3;

public class Button extends Entity implements Placeable{
    public boolean push = false;
    private String info;
    public Button(Payable thing, String info) {
        super("глазок",  info);//??
        this.info = info;
    }

    public void setLocation(Room room) {
        room.addThing(this);
    }

    public String toString() {
        return null;
        //?
    }
    public void lightUp(){
        //?
    }
}
