package lab3;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int randomMoney;
        boolean resultOfObjectRotation;
        boolean resultOfKnock;
        double randomResultOfObjectRotation;
        double randomResultKnock;
        while (true) {
            System.out.println("Если вы хотите увидеть исходную историю введите 1, если хотите увидеть случайную историю введите 0");
            float number = scanner.nextFloat();
            if (number == 0f) {
                int k = 6; // коэффициент для генерации рандомного числа
                randomMoney = (int) Math.round(k * Math.random()); // генерация денег Козлика
                randomResultOfObjectRotation = Math.random();
                randomResultKnock = Math.random();
                if (randomResultOfObjectRotation >= 0.5) {
                    resultOfObjectRotation = true;
                } else {
                    resultOfObjectRotation = false;
                }
                if (randomResultKnock >= 0.5) {
                    resultOfKnock = true;
                } else {
                    resultOfKnock = false;
                }
                break;
            }
            if (number == 1f) {
                randomMoney = 4;
                resultOfKnock = false;
                resultOfObjectRotation = false;
                break;
            } else {
                System.out.println("Вы ввели неверное число, давайте попробуем заново.");
            }
        }
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
        room.getInformationAboutThingsInTheRoom();


        MoonShorty kozlic = new MoonShorty("Козлик", 20, randomMoney);
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
                    if (!neznaika.turn(sink.getFaucet(), MethodsOfObjectRotation.BACKANDFORTH, resultOfObjectRotation)) {
                        if (!neznaika.knock(sink.getFaucet(), resultOfKnock)) {
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
