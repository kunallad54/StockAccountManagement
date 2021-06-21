package StockModel;

public class StockAccount {
    int numberOfShares;
    String name;
    int price;

    public StockAccount() {
    }

    public StockAccount(int numberOfShares, String name, int price) {
        this.numberOfShares = numberOfShares;
        this.name = name;
        this.price = price;
    }

    public int getNumberOfShares() {
        return numberOfShares;
    }

    public void setNumberOfShares(int numberOfShares) {
        this.numberOfShares = numberOfShares;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }
}
