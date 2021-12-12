package lab3;

public class Button extends Entity implements Placeable{
    private boolean push = false;
    private boolean light = true;
    private String lightDescription = "мигает";
    private String text;
    private int cost;
    public Button(Payable thing, String text, int cost) {
        super("кнопка", "для объекта " + thing.toString() );
        this.text = text;
        this.cost = cost;
    }

    public void setLocation(Room room) {
        room.addThing(this);
    }

    public String toString() {
        return getName() + " " + getInfo() + ", на которой " + lightDescription + " надпись " + text;
    }

    public void push(){
        push = true;
        if (light) {
            System.out.println("Требуется оплата " + cost + " сантик(ов)!");
        } else System.out.println("Аппарат оплачен");
    }

    public void lightUp(){
        System.out.println("На кнопке " + getInfo() + " мигает надпись: " + text);
        push = false;
        light = true;
        lightDescription = "мигает";
    }
    public void lightOff(){
        System.out.println("На кнопке " + getInfo() + " перестала мигать надпись: " + text);
        push = true;
        light = false;
        lightDescription = "не мигает";
    }
    public void changeState(boolean flag) {
        if (!flag) lightOff();
        else lightUp();
    }
}
