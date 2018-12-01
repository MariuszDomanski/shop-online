import java.util.ArrayList;
import java.util.List;

public class Customer {

    private String name;
    private String surname;
    private List<Order> orders;



    public Customer(String name, String surname) {
        this.name = name;
        this.surname = surname;
        orders = new ArrayList<>();
    }

    public void addNewOrder(Order order) {
        orders.add(order);
    }

    public String getName() {

        return name;
    }

    public String setName(String name) {
        this.name = name;

        return name;
    }

    public String getSurname() {
        return surname;
    }

    public String setSurname(String surname) {
        this.surname = surname;

        return surname;
    }

    public void placeAnOrder() {

        System.out.println(" The order has been placed");
    }

    public void receiveOrder() {

        System.out.println("The order has been received");
    }

    public List<Order> getOrders() {
        return orders;
    }

    @Override

    public String toString (){

        return  "Customer{" +
                "name='" + name + " surname='" + surname +
                '}';
    }

}
