package lab3;


public class MoonShorty extends Shorty {
    public MoonShorty(String name, int age, int money) {
        super(name, age, Place.MOON, money);
    }

    public boolean payForSomething(AcceptingMoneyMachine acceptingMoneyMachine) {
        if (this.getMoney() >= acceptingMoneyMachine.getCost()) {
            acceptingMoneyMachine.putMoney(this);
            this.setMoney(this.getMoney() - acceptingMoneyMachine.getCost());
            System.out.println("У коротышки " + this.getName() + " осталось " + this.getMoney() + " сантик(ов).");
            return true;
        } else {
            System.out.println("У коротышки " + this.getName() + " не достаточно денег для оплаты: " + acceptingMoneyMachine.toString() + ".");
            return false;
        }
    }
}
