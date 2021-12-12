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
                randomMoney = 20;
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
        EconomicalHotelTV TV = new EconomicalHotelTV("телевизор", 3);
        Bed bed = new Bed("кровать");
        Service maid = new Service("услуги горничной");
        Service waiter = new Service("услуги официанта");
        Service courier = new Service("услуги посыльного");
        Service bellboy = new Service("услуги коридорного");
        AcceptingMoneyMachine acceptingMoneyMachineForSoap = new AcceptingMoneyMachine(soap, 1, -1);
        AcceptingMoneyMachine acceptingMoneyMachineForTowel = new AcceptingMoneyMachine(towel, 1, -1);
        AcceptingMoneyMachine acceptingMoneyMachineForFaucet = new AcceptingMoneyMachine(sink.getFaucet(), 1, 1);
        AcceptingMoneyMachine acceptingMoneyMachineForLamp = new AcceptingMoneyMachine(lamp, 1, 5);
        AcceptingMoneyMachine acceptingMoneyMachineForTV = new AcceptingMoneyMachineWithButton(TV, 5, 1, "5 сантиков");
        AcceptingMoneyMachineWithButton acceptingMoneyMachineForMaid = new AcceptingMoneyMachineWithButton(maid, 1, 1, "горничная");
        AcceptingMoneyMachineWithButton acceptingMoneyMachineForWaiter = new AcceptingMoneyMachineWithButton(waiter, 1, 1, "официант");
        AcceptingMoneyMachineWithButton acceptingMoneyMachineForCourier = new AcceptingMoneyMachineWithButton(courier, 1, 1, "посыльный");
        AcceptingMoneyMachineWithButton acceptingMoneyMachineForBellboy = new AcceptingMoneyMachineWithButton(bellboy, 1, 1, "коридорный");
        sink.setLocation(room);
        lamp.setLocation(room);
        acceptingMoneyMachineForSoap.setLocation(room);
        acceptingMoneyMachineForTowel.setLocation(room);
        acceptingMoneyMachineForFaucet.setLocation(room);
        acceptingMoneyMachineForLamp.setLocation(room);
        acceptingMoneyMachineForTV.setLocation(room);
        room.getInformationAboutThingsInTheRoom();
        FilmAboutPolice filmAboutPolice = new FilmAboutPolice();
        TV.putFilmInDVD(filmAboutPolice);


        MoonShorty kozlic = new MoonShorty("Козлик", randomMoney, 192);
        EarthShorty neznaika = new EarthShorty("Незнайка", 16);
        kozlic.setLocation(room);
        neznaika.setLocation(room);
        if (kozlic.payForSomething(acceptingMoneyMachineForTV)) {
            TV.use(kozlic);
            acceptingMoneyMachineForTV.setCount(0);
            if (kozlic.payForSomething(acceptingMoneyMachineForTV)) {
                boolean flag = TV.use(kozlic);
                acceptingMoneyMachineForTV.setCount(0);
                if (flag)
                    System.out.println(neznaika.getName() + " и " + kozlic.getName() + " досмотрели фильм до конца");
                else
                    System.out.println(neznaika.getName() + " и " + kozlic.getName() + " не досмотрели фильм до конца");
            }
        }
        kozlic.decideToDoSomething("ночь", "умыться");
        kozlic.comeToSomething(sink);
        boolean flag2 = false;
        boolean flag3 = false;
        boolean flag1 = kozlic.payForSomething(acceptingMoneyMachineForSoap);
        if (flag1) flag2 = kozlic.payForSomething(acceptingMoneyMachineForTowel);
        if (flag2) flag3 = kozlic.payForSomething(acceptingMoneyMachineForFaucet);
        if (flag1 && flag2 && flag3) {
            kozlic.washUp(soap, towel, sink.getFaucet());
            neznaika.startToDoSomething("умываться");
            if (!neznaika.washUp(soap, towel, sink.getFaucet())) {
                if (!neznaika.turn(sink.getFaucet(), MethodsOfObjectRotation.BACKANDFORTH, resultOfObjectRotation)) {
                    if (!neznaika.knock(sink.getFaucet(), resultOfKnock)) {
                        soap.pinchEyes(neznaika, "нет воды");
                        neznaika.callForHelp(kozlic);
                        kozlic.analyzeTheSituation("что-то неладное");
                        kozlic.runToSomething(sink.getFaucet());
                    }
                }
            }
        } else {
            kozlic.goToBed(bed);
            neznaika.goToBed(bed);
            kozlic.sleep();
            neznaika.sleep();
            return;
        }
        acceptingMoneyMachineForLamp.setCount(0);
        room.getDescriptionAboutRoomLighting();
        kozlic.understandWhatToDo(lamp, "заплатить за");
        kozlic.runToSomething(acceptingMoneyMachineForLamp.getTongue());
        if (kozlic.getMoneyFromPocket(acceptingMoneyMachineForLamp.getCost())) {
            kozlic.payForSomething(acceptingMoneyMachineForLamp);
            acceptingMoneyMachineForLamp.setCount(5);
            kozlic.runToSomething(sink);
            kozlic.seeObjects(acceptingMoneyMachineForFaucet.getTongue());
            if (kozlic.getMoneyFromPocket(acceptingMoneyMachineForFaucet.getCost())) {
                kozlic.payForSomething(acceptingMoneyMachineForFaucet);
                neznaika.washOffSoap(soap);
                kozlic.sigh();
                kozlic.countTheMoney();
                kozlic.say("надо поскорей укладываться спать, т.к денег осталось мало");
                kozlic.undress();
                neznaika.undress();
                kozlic.goToBed(bed);
                neznaika.goToBed(bed);
                room.setTemperature(10);
                if (kozlic.feelTheCool(room) && neznaika.feelTheCool(room)) {
                    kozlic.wrapUpInBlanket(bed);
                    neznaika.wrapUpInBlanket(bed);
                    room.getDescriptionAboutTemperature();
                    kozlic.jumpFromBed(bed);
                    kozlic.decideToDoSomething("ночь", "потребовать, чтобы их перевели в более теплый номер");
                    kozlic.runToSomething(room.getDoor());
                    kozlic.seeObjects(acceptingMoneyMachineForBellboy.getButton(), acceptingMoneyMachineForMaid.getButton(),
                            acceptingMoneyMachineForCourier.getButton(), acceptingMoneyMachineForWaiter.getButton());
                    kozlic.pushOnButton(acceptingMoneyMachineForBellboy.getButton());
                    kozlic.pushOnButton(acceptingMoneyMachineForMaid.getButton());
                    kozlic.pushOnButton(acceptingMoneyMachineForCourier.getButton());
                    kozlic.pushOnButton(acceptingMoneyMachineForWaiter.getButton());
                } else {
                    room.getDescriptionAboutTemperature();
                    kozlic.sleep();
                    neznaika.sleep();
                }
            }
        } else {
            kozlic.goToBed(bed);
            neznaika.goToBed(bed);
            kozlic.sleep();
            neznaika.sleep();
        }
    }
}
