package lab3;

public class AcceptingMoneyMachine extends Entity implements Placeable {
    private Payable thing;
    private Peephole peephole;
    private Tongue tongue;
    private int cost;
    private int count; //Количество использований объекта за одну оплату.
    private String dopInfo;
    private boolean isPayed;

    public AcceptingMoneyMachine(Payable thing, int cost, int count) {
        super("аппарат", "на оплату объекта " + thing.toString());
        this.cost = cost;
        this.count = count;
        this.thing = thing;
        peephole = new Peephole(thing, Color.RED);
        tongue = new Tongue(thing);
        dopInfo = "не оплачен";
    }

    public void setLocation(Room room) {
        room.addThing(this);
        room.addAcceptingMoneyMachine(this);
        peephole.setLocation(room);
        tongue.setLocation(room);
    }

    // Метод, который меняет состояние машины: если передали true и машина до это не была оплачена, то становится оплаченой
    // Иначе ничего не происходит.
    protected void changeState(boolean flag) {
        if (isPayed != flag) {
            isPayed = flag;
            tongue.changeState(!isPayed); // Если оплачено, то передаем false - спрятать в стену. И наоборот.
            peephole.changeState(!isPayed);
        }
        if (!isPayed) {
            dopInfo = "оплачен";
        } else dopInfo = "не оплачен";
    }

    //Если true -> глазок механизма светиться. False - не светиться.
    public boolean isShining() {
        return peephole.isBlinking();
    }

    public int getCost() {
        return cost;
    }

    public Peephole getPeephole() {
        return peephole;
    }

    public void setCount(int count) {
        if (count == 0) changeState(false);
        thing.setCount(count);
    }

    public Tongue getTongue() {
        return tongue;
    }

    public Payable getThing() {
        return thing;
    }

    public String getDopInfo() {
        return dopInfo;
    }

    public boolean isPayed() {
        return isPayed;
    }

    public void setPayed(boolean payed) {
        isPayed = payed;
    }

    public void setDopInfo(String dopInfo) {
        this.dopInfo = dopInfo;
    }

    //Положить деньги в машину.
    public void putMoney(Shorty shorty) {
        System.out.println(shorty.getName() + " положил " + cost + " сантик(ов) в " + this.getName() + ".");
        thing.setCount(count); //Для вещи устанавливаем или обновляем количество использований.
        changeState(true); //Меняем состояние на оплаченное.
    }

    public String toString() {
        return getName() + " " + getInfo() + ", который " + dopInfo + " и состоит из объектов: " + peephole.getName() + ", " + tongue.getName();
    }
}
