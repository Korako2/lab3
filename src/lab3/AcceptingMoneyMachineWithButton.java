package lab3;

public class AcceptingMoneyMachineWithButton extends AcceptingMoneyMachine{
    private Button button;
    public AcceptingMoneyMachineWithButton(Payable thing, int cost, int count) {
        super(thing, cost, count);
        button = new Button(thing, "???");
    }
    protected void changeState(boolean flag) {} //!!
}
