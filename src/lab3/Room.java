package lab3;

import java.util.ArrayList;

public class Room extends Entity {
    private ArrayList<Placeable> things = new ArrayList<>();
    private ArrayList<Wall> wall = new ArrayList<>();
    private Lighting lighting;
    private ArrayList<AcceptingMoneyMachine> acceptingMoneyMachines = new ArrayList<>();
    private final int square;
    private int temperature;
    private Entity door;

    public Room(String name, int square) {
        super(name, "площадь: " + square);
        lighting = Lighting.LIGHT;
        this.square = square;
        Wall wall_1 = new Wall("первая стена");
        addWall(wall_1);
        //3 стены
        door = new Entity("дверь", "?") {
            public String toString() {
                //?
                return null;
            }
        };
        wall.get(1).addHanging(door);//?
    }

    public void addWall(Wall wall) {
        this.wall.add(wall);
    }

    public void hangThing(Entity entity) {
        wall.get(1).addHanging(entity);
        //??
    }

    public class Wall {
        private String name;
        private ArrayList<Entity> hanging = new ArrayList<>();

        private Wall(String name) {
            this.name = name;
        }

        public void addHanging(Entity entity) {
            hanging.add(entity);
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

    public void getDecriptionAboutTemperature() {
        //!!!
    }
}
