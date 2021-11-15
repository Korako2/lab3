package lab3;

public class Faucet extends Entity implements Payable, Placeable {
    private boolean state; // Состояние: false-закрыт. True - открыт.
    private Water water;
    private Room room;

    public Faucet(String name) {
        super(name, "используется для подачи воды");
        water = new Water("вода");
    }

    public void setLocation(Room room) {
        this.room = room;
    }

    public void off() {
        click(); //Кран щелкает при выключении
        state = false;
        System.out.println(water.getName() + " перестала течь.");
    }

    public void on() {
        state = true;
        System.out.println(water.getName() + " потекла.");
    }

    public void click() {
        System.out.println(this.getName() + " щелкнул.");
    }
    //Передаем воде объем через кран.
    public void setCount(int count) {
        water.setVolume(count);
        on();
    }

    public int getCount() {
        return water.getVolume();
    }

    public boolean use(Shorty shorty) {
        if (water.use()) {
            return true;
        } else {
            off();
            return false;
        }
    }

    public String toString() {
        return getName();
    }
}
