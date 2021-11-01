package lab3;

import java.util.Objects;

public abstract class Entity {
    private final String name;
    private final String info;

    public Entity(String name, String info) {
        this.name = name;
        this.info = info;
    }

    public String getName() {
        return name;
    }

    public String getInfo() {
        return info;
    }

    public String toString() {
        return name + " " + info;
    }

    public int hashCode() {
        int h = Objects.hashCode(toString());
        return h;
    }

    public boolean equals(Object entity1) {
        if (entity1 == this) {
            return true;
        }
        if (entity1 == null || getClass() != entity1.getClass()) {
            return false;
        }
        Entity entity2 = (Entity) entity1;

        return toString() == entity2.toString();
    }

}
