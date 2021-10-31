package lab3;


public class MoonShorty extends Shorty {
    public MoonShorty(String name, int age, int money) {
        super(name, age, Place.MOON, money);
    }

    public void payForSomething(Tongue tongue) {
        if (this.getMoney() >= tongue.getCost()) {
            tongue.putMoney(this);
            this.setMoney(this.getMoney() - tongue.getCost());
            System.out.println("У коротышки " + this.getName() + " осталось " + this.getMoney() + " сантик(ов).");
        } else {
            System.out.println("У коротышки " + this.getName() + " не достаточно денег для оплаты объекта: " + tongue.getThing().getName() + ".");
        }
    }
}
