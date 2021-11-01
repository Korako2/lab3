package lab3;

public class Main {
    public static void main(String[] args) {
        Room room = new Room("комната", 16);
        Sink sink = new Sink(new Faucet("кран"), "рукомойник");
        Lamp lamp = new Lamp("лампочка");
        Soap soap = new Soap("мыло");
        Towel towel = new Towel("полотенце");
        AcceptingMoneyMachine tongueForSoap = new AcceptingMoneyMachine(soap, 1, -1);
        AcceptingMoneyMachine tongueForTowel = new AcceptingMoneyMachine(towel, 1, -1);
        AcceptingMoneyMachine tongueForFaucet = new AcceptingMoneyMachine(sink.getFaucet(), 1, 1);
        AcceptingMoneyMachine tongueForLamp = new AcceptingMoneyMachine(lamp, 1, 5);
        sink.setLocation(room);
        lamp.setLocation(room);
        tongueForSoap.setLocation(room);
        tongueForTowel.setLocation(room);
        tongueForFaucet.setLocation(room);
        tongueForLamp.setLocation(room);
        room.getInformationAboutThingsInTheRoom();

        MoonShorty kozlic = new MoonShorty("Козлик", 20, 4);
        EarthShorty neznaika = new EarthShorty("Незнайка", 16, 0);
        kozlic.setLocation(room);
        neznaika.setLocation(room);
        kozlic.decideToDoSomething("ночь", "умыться");
        kozlic.comeToSomething(sink);
        kozlic.payForSomething(tongueForSoap);
        kozlic.payForSomething(tongueForTowel);
        kozlic.payForSomething(tongueForFaucet);
        if (kozlic.washUp(tongueForSoap, tongueForTowel, tongueForFaucet)) {
            neznaika.startToDoSomething("умываться");
            if (!neznaika.washUp(tongueForSoap, tongueForTowel, tongueForFaucet)) {
                if (!neznaika.turn(sink.getFaucet(), MethodsOfObjectRotation.BACKANDFORTH, false)) {
                    if (!neznaika.knock(sink.getFaucet(), false)) {
                        soap.pinchEyes(neznaika, "нет воды");
                        neznaika.callForHelp(kozlic);
                        kozlic.analyzeTheSituation("что-то неладное");
                        kozlic.runToSomething(sink.getFaucet());
                    } else {

                    }
                } else {

                }
            }

        }
        tongueForLamp.setCount(0);
        tongueForFaucet.disabledLight();
        room.getDescriptionAboutRoomLighting();
    }
}
