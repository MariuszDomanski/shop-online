import java.util.ArrayList;
import java.util.List;


public class Order {

    private Status status;
    private List<Product> products;//TODO

    public Order() {
        this.status = Status.NEW;  //TODO
        this.products = new ArrayList<>();  //TODO

    }

    public void addProduct(Product product) {
        if (status == Status.CONFIRM) {
            System.out.println(Status.ERROR);

        } else {
            this.status = Status.IN_PROGRESS;
            products.add(product);
        }
    }


    public void checkProducts() {  //TODO
        for (Product p : products) {
            System.out.println(p);
        }
    }

    //TODO metode caculatePrice wywolaj w confirmOrder i podaj informacje rowniez ile trzeba zaplacic za zamowienie
    public void confirmOrder(Customer customer) {
        this.status = Status.CONFIRM;
        System.out.println("Order confirmed");
        Double price = calculatePrice();
        customer.addNewOrder(this);
        System.out.println("Price for order " + price);
    }

    public void sentOrder() {
        this.status = Status.SENT;
        System.out.println("Order sent to the customer");

    }

    private Double calculatePrice() { // metoda oblicza ceny produktow w zamowieniu
        Double price = 0.0;

        for (Product p : products) { // petla pokazuje wszystkie produkty z listy ma sumowac ceny produktow z listy
            price = price + p.getPrice();
        }

        return price;

    }

    public void deleteProducts(Product product) {
        products.remove(product);
    }


    public Status getStatus() {
        return status;
    }

    public List<Product> getProducts() {
        return products;
    }

    @Override
    public String toString() {
        return "Order{" +
                "status=" + status +
                ", products=" + products +
                '}';
    }
}
