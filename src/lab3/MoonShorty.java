package lab3;


public class MoonShorty extends Shorty {
    private int moonAge;
    public MoonShorty(String name, int money, int moonAge) {
        super(name, Place.MOON, money);
        this.moonAge = moonAge;
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
    public int getAge() {
        return moonAge;
    }

    public String getInfoAboutAge() {
        return moonAge + " в лунных годах";
    }

    public String getInfo() {
        return getName() + ". Возраст: " + getInfoAboutAge() + ". Планета рождения: " + getPlaceOfBorn();
    }
    public boolean getMoneyFromPocket(int money) {
        if (getMoney() >= money) {
            System.out.println(this.getName() + " достал " + money + " сантик(ов) из кармана.");
            return true;
        }
        else {
            System.out.println(this.getName() + " не смог достать " + money + " сантик(ов) из кармана, т.к. недостаточно денег.");
            return false;
        }
    }
    public int countTheMoney() {
        System.out.println(this.getName() + " подсчитал оставшиеся монеты. Осталось: " + this.getMoney() + " сантиков.");
        return this.getMoney();
    }
}
