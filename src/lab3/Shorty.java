package lab3;

import java.util.Objects;

public abstract class Shorty {
    private String name;
    private Place placeOfBorn;
    private int money;
    private Room room;

    public Shorty(String name, Place placeOfBorn, int money) {
        this.name = name;
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

    public boolean washUp(Soap soap, Towel towel, Faucet faucet) {
        soap.use(this);
        if (faucet.use(this)) {
            towel.use(this);
            return true; //возвращаем: умывание успешно.
        }
        System.out.println(this.getName() + " не смог смыть мыло, так как вода закончилась" + ".");
        return false; // возвращаем: умывание не успешно
    }

    public void comeToSomething(Placeable thing) {
        System.out.println(this.getName() + " подошел к предмету: " + thing.toString() + ".");
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


    public void runToSomething(Placeable thing) {
        System.out.println(this.getName() + " подбежал к объекту: " + thing.toString() + ".");
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

    public void understandWhatToDo(Placeable thing, String action) {
        System.out.println(this.getName() + " сообразил, что нужно " + action + " объект " + thing.toString());
    }

    public void seeObjects(Entity ... entities) {
        System.out.println(this.getName() + " увидел объект(ы):");
        for (Entity entity: entities) {
            System.out.println(entity.toString());
        }
    }

    public void washOffSoap(Soap soap) {
        System.out.println(this.getName() + " смог смыть разъедавшее глаза " + soap.getName() + ".");
    }

    public void sigh() {
        System.out.println(this.getName() + " тяжело вздохнул.");
    }

    public void say(String info) {
        System.out.println(this.getName() + " сказал " + info + ".");
    }

    public void undress() {
        System.out.println(this.getName() + " разделся.");
    }

    public void goToBed(Bed bed) {
        System.out.println(this.getName() + " забрался в " + bed.getName() + ".");
    }

    public boolean feelTheCool(Room room) {
        if (room.getTemperature() < 15) {
            System.out.println(this.getName() + " почувствовал, что объекте " + room.getName() + " стало холодно.");
            return true;
        } else {
            System.out.println(this.getName() + " ощутил, что объекте " + room.getName() + " комфортная температура.");
            return false;
        }
    }

    public void wrapUpInBlanket(Bed bed) {
        System.out.println(this.getName() + " закутывался в " + bed.getBlanket().getName() + ".");
    }

    public void jumpFromBed(Bed bed) {
        System.out.println(this.getName() + " вскочил с объекта " + bed.getName() + ".");
    }

    public void pushOnButton(Button button) {
        System.out.println(this.getName() + " нажал на объект " + button.toString());
        button.push();
    }

    public void sleep() {
        System.out.println(this.getName() + " заснул.");
    }

    public Place getPlaceOfBorn() {
        return placeOfBorn;
    }

    public abstract String getInfo();

    public String getName() {
        return name;
    }

    public abstract int getAge();

    public abstract String getInfoAboutAge();

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
