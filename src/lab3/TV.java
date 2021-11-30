package lab3;

public class TV extends Entity implements Payable{
    private int time;
    private int count;
    private int lastAction;
    private Film filmInDVD;
    public TV(String name, int count){
        super(name, "какая то информация");
        this.count = count;
    }
    public void TVOff() {
        System.out.println(getName() + " выключился.");
    }

    public void putFilmInDVD(Film film) {
        filmInDVD = film;
    }

    public boolean use(Shorty shorty) {
        class Screen {
            final String name = "экран";
            public void showFragment(Film film) {

            }
            public void flash(){
                System.out.println(name + " замелькал.");
            }
        }
        Screen screen = new Screen();
        screen.flash();
        screen.showFragment(filmInDVD);
        TVOff();
        return true;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public int getCount() {
        return count;
    }

    public String toString() {
        return null;
    }
}
