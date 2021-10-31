package lab3;

public class Tongue extends Entity implements Thing {
    private String material;
    private ThingsWithCost thing;
    private Peephole peephole;
    private int cost;
    private int count;
    private boolean pokedOut;
    private String info;

    public Tongue(ThingsWithCost thing, int cost, int count) {
        super("язычок на оплату объекта " + thing.getName());
        material = "металлический";
        this.cost = cost;
        this.count = count;
        info = "торчит из стены";
        this.thing = thing;
        pokedOut = true;
        peephole = new Peephole(thing, Color.RED);
    }

    public void setLocation(Room room) {
        room.addThing(this);
        room.addTongue(this);
        peephole.setLocation(room);
    }

    private void changeState(boolean flag){
        if (pokedOut == flag) {
            pokedOut = !pokedOut;
            peephole.changeState(pokedOut);
        }
        if (!pokedOut) {
            info = "находится в стене";
        } else info = "торчит из стены";
    }

    public boolean isShining() {
        return peephole.isBlinking();
    }

    public int getCost() {
        return cost;
    }

    public Peephole getPeephole(){
        return peephole;
    }

    public void setCount(int count){
        if (count == 0) changeState(false);
        thing.setCount(count);
    }

    public Thing getThing() {
        return thing;
    }

    public void disabledLight(){
        if (pokedOut) peephole.changeState(false);
    }

    public boolean useThing(Shorty shorty) {
        if (!pokedOut) {
            boolean flag = thing.use(shorty);
            changeState(flag);
            return flag;
        } else return false;
    }

    public void putMoney(Shorty shorty) {
        System.out.println(this.getName() + " положил " + cost + " сантик(ов) в " + this.getName() + ".");
        thing.setCount(count);
        changeState(true);
        System.out.println("Теперь " + this.getName() + " " + info);
    }

    public String getDescription() {
        return material + " " + getName() + ", который " + info;
    }
}
