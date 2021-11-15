package lab3;

public class Water extends Entity {
    int volume;

    public Water(String name) {
        super(name, "используется для умывания");
        volume = 0;
    }

    public void setVolume(int volume) {
        this.volume = volume;
    }

    public boolean use() {
        if (volume > 0) {
            volume--;
            return true; // получиться умыться.
        }
        return false;
    }

    public int getVolume() {
        return volume;
    }

    public String toString() {
        return getName() + " объемом " + volume;
    }
}
