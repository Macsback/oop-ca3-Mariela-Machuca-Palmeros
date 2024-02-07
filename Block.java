public class Block {

    public double price;
    public int quantity;

    public Block( int quantity, double price) {
        this.price = price;
        this.quantity = quantity;
    }

    public Block() {
        this.price = 10;
        this.quantity = 10;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
}
