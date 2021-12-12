package lab3;

import java.util.ArrayList;

public class EconomicalHotelTV extends Entity implements Payable {
    private int time;
    private static int count = 5;
    private static int diagonal = 16;
    private static String model = "телевизор гостиницы Экономическая";
    private int lastAction;
    private Film filmInDVD;

    public EconomicalHotelTV(String name, int time) {
        super(name, "телевизор с поддержкой DVD-проигрывателя.");
        this.time = time;
    }

    public void TVOff() {
        System.out.println(getName() + " выключился.");
    }

    public void putFilmInDVD(Film film) {
        filmInDVD = film;
        lastAction = 0;
    }
    //что то странное с ретёрн
    public boolean use(Shorty shorty) {
        System.out.println(shorty.getName() + " включил телевизор.");
        showFilm();
        return lastAction == 0;
    }

    private void showFilm() {
        class Screen {
            final String name = "экран";
            public void showFragment() {
                ArrayList<String> actions = filmInDVD.getActions();
                int newLastAction = 0;
                for (int i = lastAction; i < lastAction+time; i++){
                    if (i < actions.size()) {
                        System.out.println(actions.get(i));
                        newLastAction = i;
                    }else {
                        System.out.println("Фильм закончился.");
                        newLastAction = -1;
                        break;
                    }
                }
                lastAction = newLastAction + 1;
            }
            public void flash() {
                System.out.println(name + " замелькал.");
            }
        }
        Screen screen = new Screen();
        screen.flash();
        screen.showFragment();
        TVOff();
    }

    public void setCount(int count) {
        this.count = count;
    }

    public int getCount() {
        return count;
    }

    public String toString() {
        return getName();
    }

    public static class TVPassport {
        public static int getCount() {
            return count;
        }
        public static int getDiagonal() {
            return diagonal;
        }
        public static String getModel() {
            return model;
        }
    }
}
