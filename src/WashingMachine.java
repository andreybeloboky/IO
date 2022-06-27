public class WashingMachine {
    String color;
    int dataOfCreate;
    String creator;
    int price;
    int ID;

    /**
     * @param color of machine (user's inputs);
     * @param dataOfCreate of machine (user's inputs);
     * @param creator of machine (user's inputs);
     * @param price of machine (user's inputs);
     * @param ID begins with 1 index.
     */
    public WashingMachine(int ID, String creator, int dataOfCreate, int price, String color) {
        this.color = color;
        this.dataOfCreate = dataOfCreate;
        this.creator = creator;
        this.price = price;
        this.ID = ID;
    }

    public String getColor() {
        return color;
    }

    public int getDataOfCreate() {
        return dataOfCreate;
    }

    public String getCreator() {
        return creator;
    }

    public int getPrice() {
        return price;
    }

    public int getID() {
        return ID;
    }
}
