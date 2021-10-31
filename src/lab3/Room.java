package lab3;

import java.util.ArrayList;

public class Room extends Entity {
    private ArrayList<Thing> things = new ArrayList<>();
    private Lighting lighting;
    private ArrayList<Tongue> tongues = new ArrayList<>();

    public Room() {
        super("комната");
        lighting = Lighting.LIGHT;
    }

    public void addThing(Thing thing) {
        things.add(thing);
    }

    public void addTongue(Tongue tongue) {
        tongues.add(tongue);
    }

    public void setLighting(Lighting lighting) {
        this.lighting = lighting;
    }

    private ArrayList<Tongue> getLightingObjects() {
        ArrayList<Tongue> lightingObjects = new ArrayList<>();
        for (Tongue thing: tongues) {
            if (thing.isShining()) {
                lightingObjects.add(thing);
            }
        }
        return lightingObjects;
    }

    public void getDescriptionAboutRoomLighting(){
        if (lighting.equals(Lighting.LIGHT)){
            System.out.println("В объекте " + this.getName() + " " +  lighting.getLighting() + ", можно все разглядеть.");
        } else {
            ArrayList<Tongue> lightingObjects = getLightingObjects();
            System.out.println("В объекте " + this.getName() + " " +  lighting.getLighting() + ", можно разглядеть только:");
            for (Tongue thing: lightingObjects) {
                System.out.println(thing.getPeephole().getDescription());
                System.out.println(thing.getDescription());
            }
        }
    }

    public void getInformationAboutThingsInTheRoom() {
        System.out.println("В объекте " + this.getName() + " находятся:");
        for (Thing thing : things) {
            System.out.println(thing.getDescription() + ".");
        }
    }
}
