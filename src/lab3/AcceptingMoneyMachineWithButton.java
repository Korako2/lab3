package lab3;

public class AcceptingMoneyMachineWithButton extends AcceptingMoneyMachine{
    private Button button;
    public AcceptingMoneyMachineWithButton(Payable thing, int cost, int count, String info) {
        super(thing, cost, count);
        button = new Button(thing, info, cost);
    }
    protected void changeState(boolean flag) {
        if (isPayed() != flag) {
            setPayed(flag);
            getTongue().changeState(!isPayed());
            getPeephole().changeState(!isPayed());
            button.changeState(!isPayed());
        }
        if (!isPayed()) {
            setDopInfo("оплачен");
        } else setDopInfo("не оплачен");
    }
    public String toString() {
        return getName() + " " + getInfo() + ", который " + getDopInfo() + " и состоит из объектов: " +
                getPeephole().getName() + ", " + getTongue().getName() + ", " + button.getName();
    }
    public void setLocation(Room room) {
        super.setLocation(room);
        button.setLocation(room);
    }

    public Button getButton() {
        return button;
    }
}
