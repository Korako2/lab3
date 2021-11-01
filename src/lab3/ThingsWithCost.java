package lab3;

public interface ThingsWithCost extends Thing {
    boolean use(Shorty shorty);

    void setCount(int count);

    int getCount();
}
