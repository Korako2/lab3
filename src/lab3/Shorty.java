package lab3;

import java.util.Objects;

public abstract class Shorty {
    private String name;
    private int age;
    private Place placeOfBorn;
    private int money;
    private Room room;

    public Shorty(String name, int age, Place placeOfBorn, int money) {
        this.name = name;
        this.age = age;
        this.placeOfBorn = placeOfBorn;
        this.money = money;
    }

    public void decideToDoSomething(String part, String action) {
        System.out.println("Время суток: " + part + ". " + this.getName() + " решил " + action + ".");
    }

    public void setLocation(Room room) {
        this.room = room;
        System.out.println(this.getName() + " находится в объекте " + room.getName() + ".");
    }

    public void startToDoSomething(String action) {
        System.out.println(this.getName() + " начал " + action + ".");
    }

    public boolean washUp(AcceptingMoneyMachine soap, AcceptingMoneyMachine towel, AcceptingMoneyMachine faucet) {
        if (soap.useThing(this)) {
            if (faucet.useThing(this)) {
                if (towel.useThing(this)) return true; //возвращаем: умывание успешно.
            } else {
                System.out.println(this.getName() + " не смог смыть мыло, так как вода закончилась" + ".");
            }
        } else {
            System.out.println(this.getName() + " не смог умыться" + ".");
        }
        return false; // возвращаем: умывание не успешно
    }

    public void comeToSomething(Thing thing) {
        System.out.println(this.getName() + " подошел к предмету: " + thing.getName() + ".");
    }

    public int getMoney() {
        return money;
    }

    public void setMoney(int money) {
        this.money = money;
    }

    public void analyzeTheSituation(String result) {
        System.out.println(this.getName() + " проанализировал ситуацию и понял: " + result + ".");
    }


    public void runToSomething(Thing thing) {
        System.out.println(this.getName() + " подбежал к объекту: " + thing.getName() + ".");
    }

    public void callForHelp(Shorty shorty) {
        System.out.println(this.getName() + " стал звать на помощь коротышку " + shorty.getName() + ".");
    }

    public boolean turn(Faucet faucet, MethodsOfObjectRotation method, boolean result) {
        System.out.println(this.getName() + " вертел " + faucet.getName() + " " + method.getMethods() + ".");
        if (!result) {
            System.out.println("Это не помогало.");
        } else {
            System.out.println("Это помогло.");
            faucet.setCount(1); // Если верчение крана помогло, то добавляем использование крана
            faucet.use(this); // Продолжаем умываться.
        }
        return result;
    }

    public boolean knock(Faucet faucet, boolean result) {
        System.out.println(this.getName() + " стучал кулаком по объекту: " + faucet.getName() + ".");
        if (!result) {
            System.out.println("И это тоже не помогало.");
        } else {
            System.out.println("Это помогло.");
            faucet.setCount(1);
            faucet.use(this);
        }
        return result;
    }

    public String getInfo() {
        return name + ". Возраст: " + age + ". Планета рождения: " + placeOfBorn;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public String toString() {
        return getInfo() + ". Кол-во денег: " + money;
    }

    public int hashCode() {
        int h = Objects.hashCode(getInfo());
        return h;
    }

    public boolean equals(Object shorty1) {
        if (shorty1 == this) {
            return true;
        }
        if (shorty1 == null || getClass() != shorty1.getClass()) {
            return false;
        }
        Shorty shorty2 = (Shorty) shorty1;

        return getInfo() == shorty2.getInfo();
    }

}
