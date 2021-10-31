package lab3;

public class Water extends Entity{
    int volume;
    public Water(String name) {
        super(name);
        volume = 0;
    }

    public void setVolume(int volume) {
        this.volume = volume;
    }

    boolean use() {
        if (volume > 0) {
            volume--;
            return true;
        }
        return false;
    }

    public int getVolume() {
        return volume;
    }
}
