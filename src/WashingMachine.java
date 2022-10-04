public class WashingMachine {
    private String color;
    private int dataOfCreate;
    private String creator;
    private int price;
    private int id;

    /**
     * @param color        of machine (user's inputs);
     * @param dataOfCreate of machine (user's inputs);
     * @param creator      of machine (user's inputs);
     * @param price        of machine (user's inputs);
     * @param id           begins with 1 index.
     */
    public WashingMachine(int id, String creator, int dataOfCreate, int price, String color) {
        this.color = color;
        this.dataOfCreate = dataOfCreate;
        this.creator = creator;
        this.price = price;
        this.id = id;
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

    public int getId() {
        return id;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public void setDataOfCreate(int dataOfCreate) {
        this.dataOfCreate = dataOfCreate;
    }

    public void setCreator(String creator) {
        this.creator = creator;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public void setId(int id) {
        this.id = id;
    }
}
