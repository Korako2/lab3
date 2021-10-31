package lab3;

public class Main {
    public static void main(String[] args) {
        Room room = new Room();
        Sink sink = new Sink(new Faucet());
        Lamp lamp = new Lamp();
        Tongue tongueForSoap = new Tongue(new Soap(), 1, -1);
        Tongue tongueForTowel = new Tongue(new Towel(), 1, -1);
        Tongue tongueForFaucet = new Tongue(sink.getFaucet(), 1, 1);
        Tongue tongueForLamp = new Tongue(lamp, 1, 5);
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
            if (!neznaika.washUp(tongueForSoap, tongueForTowel, tongueForFaucet)){
                if (!neznaika.turn(sink.getFaucet(), MethodsOfObjectRotation.BACKANDFORTH, false)){
                    if (!neznaika.knock(sink.getFaucet(), false)) {
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
