package lab3;

import java.util.ArrayList;

public class Room extends Entity {
    private ArrayList<Placeable> things = new ArrayList<>();
    private ArrayList<Wall> wall = new ArrayList<>();
    private Lighting lighting;
    private ArrayList<AcceptingMoneyMachine> acceptingMoneyMachines = new ArrayList<>();
    private final int square;
    private int temperature;
    private Placeable door;

    public Room(String name, int square) {
        super(name, "площадь: " + square);
        lighting = Lighting.LIGHT;
        this.square = square;
        temperature = 20;
        Wall wall_1 = new Wall("первая стена");
        addWall(wall_1);
        Wall wall_2 = new Wall("вторая стена");
        addWall(wall_1);
        Wall wall_3 = new Wall("третья стена");
        addWall(wall_1);
        Wall wall_4 = new Wall("четвертая стена");
        addWall(wall_1);
        addWall(wall_2);
        addWall(wall_3);
        addWall(wall_4);
        door = new Placeable() {
            @Override
            public void setLocation(Room room) {
                room.hangThing(this);
            }

            public String toString() {
                return "дверь";
            }
        };
        door.setLocation(this);
    }

    public void addWall(Wall wall) {
        this.wall.add(wall);
    }

    public void hangThing(Placeable thing) {
        wall.get(0).addHanging(thing);
        addThing(thing);
    }

    public class Wall {
        private String name;
        private ArrayList<Placeable> hanging = new ArrayList<>();

        private Wall(String name) {
            this.name = name;         }

        public void addHanging(Placeable thing) {
            hanging.add(thing);
        }
    }

    public void addThing(Placeable thing) {
        things.add(thing);
    }

    public void addAcceptingMoneyMachine(AcceptingMoneyMachine acceptingMoneyMachine) {
        acceptingMoneyMachines.add(acceptingMoneyMachine);
    }

    public void setLighting(Lighting lighting) {
        this.lighting = lighting;
    }

    //Метод для поиска светащихся объектов.
    private ArrayList<AcceptingMoneyMachine> getLightingObjects() {
        ArrayList<AcceptingMoneyMachine> lightingObjects = new ArrayList<>();
        for (AcceptingMoneyMachine thing : acceptingMoneyMachines) {
            if (thing.isShining()) { // If глазок механизма светиться, то добавляем в ArrayList.
                lightingObjects.add(thing);
            }
        }
        return lightingObjects;
    }

    //Метод для получения списка объектов, которые видно при данном освещении.
    public void getDescriptionAboutRoomLighting() {
        if (lighting.equals(Lighting.LIGHT)) {
            System.out.println("В объекте " + this.getName() + " " + lighting.getLighting() + ", можно все разглядеть.");
        } else {
            ArrayList<AcceptingMoneyMachine> lightingObjects = getLightingObjects();
            System.out.println("В объекте " + this.getName() + " " + lighting.getLighting() + ", можно разглядеть только:");
            for (AcceptingMoneyMachine thing : lightingObjects) {
                System.out.println(thing.getPeephole().toString()); // Получаем описание светящегося глазка.
                System.out.println(thing.getTongue().toString() + " и поблескивает"); // Получаем описание торчащего язычка.
            }
        }
    }

    public void getInformationAboutThingsInTheRoom() {
        System.out.println("В объекте " + this.getName() + " находятся:");
        for (Placeable thing : things) {
            System.out.println(thing.toString() + ".");
        }
    }

    public String toString() {
        return getName() + " площадью " + square;
    }

    public int getTemperature() {
        return temperature;
    }

    public void setTemperature(int temperature) {
        this.temperature = temperature;
    }

    public Placeable getDoor() {
        return door;
    }

    public void getDescriptionAboutTemperature() {
        if (temperature < 15) {
            System.out.println("Холод пронизывает до костей.");
        } else {
            if (temperature >= 15 && temperature <= 25) {
                System.out.println("В комнате комфортная температура.");
            }
            else {
                System.out.println("В комнате очень жарко.");
            }
        }
    }
}
