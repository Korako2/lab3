package lab3;

public class Main {
    public static void main(String[] args) {
        Room room = new Room("комната", 16);
        Sink sink = new Sink(new Faucet("кран"), "рукомойник");
        Lamp lamp = new Lamp("лампочка");
        Soap soap = new Soap("мыло");
        Towel towel = new Towel("полотенце");
        AcceptingMoneyMachine acceptingMoneyMachineForSoap = new AcceptingMoneyMachine(soap, 1, -1);
        AcceptingMoneyMachine acceptingMoneyMachineForTowel = new AcceptingMoneyMachine(towel, 1, -1);
        AcceptingMoneyMachine acceptingMoneyMachineForFaucet = new AcceptingMoneyMachine(sink.getFaucet(), 1, 1);
        AcceptingMoneyMachine acceptingMoneyMachineForLamp = new AcceptingMoneyMachine(lamp, 1, 5);
        sink.setLocation(room);
        lamp.setLocation(room);
        acceptingMoneyMachineForSoap.setLocation(room);
        acceptingMoneyMachineForTowel.setLocation(room);
        acceptingMoneyMachineForFaucet.setLocation(room);
        acceptingMoneyMachineForLamp.setLocation(room);
        //room.getInformationAboutThingsInTheRoom();

        MoonShorty kozlic = new MoonShorty("Козлик", 20, 4);
        EarthShorty neznaika = new EarthShorty("Незнайка", 16);
        kozlic.setLocation(room);
        neznaika.setLocation(room);
        kozlic.decideToDoSomething("ночь", "умыться");
        kozlic.comeToSomething(sink);
        boolean flag2 = false;
        boolean flag3 = false;
        boolean flag1 = kozlic.payForSomething(acceptingMoneyMachineForSoap);
        if (flag1) flag2 = kozlic.payForSomething(acceptingMoneyMachineForTowel);
        if (flag2) flag3 = kozlic.payForSomething(acceptingMoneyMachineForFaucet);
        if (flag1 && flag2 && flag3) {
            if (kozlic.washUp(acceptingMoneyMachineForSoap, acceptingMoneyMachineForTowel, acceptingMoneyMachineForFaucet)) {
                neznaika.startToDoSomething("умываться");
                if (!neznaika.washUp(acceptingMoneyMachineForSoap, acceptingMoneyMachineForTowel, acceptingMoneyMachineForFaucet)) {
                    if (!neznaika.turn(sink.getFaucet(), MethodsOfObjectRotation.BACKANDFORTH, false)) {
                        if (!neznaika.knock(sink.getFaucet(), true)) {
                            soap.pinchEyes(neznaika, "нет воды");
                            neznaika.callForHelp(kozlic);
                            kozlic.analyzeTheSituation("что-то неладное");
                            kozlic.runToSomething(sink.getFaucet());
                        }
                    }
                }
            }
            acceptingMoneyMachineForFaucet.disabledLight();
        }
        acceptingMoneyMachineForLamp.setCount(0);
        room.getDescriptionAboutRoomLighting();
    }
}
