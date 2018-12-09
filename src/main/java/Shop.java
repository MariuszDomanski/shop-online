import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
//TODO 1.zmien tytul ramki odpowiadajacy naszemu programowi i przetestuj
//TODO 2.zmien tytul w buttonie
//TODO 3.pobaw sie tym co mamy w chwili obecnej
//TODO 4.stworz odpowiedna ilosc obiektow TexField, nastepnie pobierz odpowiednia ilosc danych(imie itd.) i w
//TODO momencie na klikniecie przycisku stworz nowego Customera
//TODO 5. Stworz przycisk po nacisnieciu doda uzytkownika do List = ArrayList()
//TODO 6. Stworz przycisk "Czysc" po jego nacisnieciu usunie wszystkich Customer z listy,
//TODO 7.Stworz mechanizm ktory umozliwi uzytkownikowi przejscie do nastepnego okna z przyciskiem " Remove all
//TODO  Customers from the list"
//TODO 8.Pobawic sie z Refactor - rename


public class Shop extends Application {


    @Override
    public void start(Stage primaryStage) throws Exception {
        primaryStage.setTitle("Shop");


        TextField textField = new TextField();
        TextField textField1 = new TextField();
        Button addCustomerBtn = new Button("Add new Customer to list");
        Button showCustomersBtn = new Button("Show Customers from the List");
        Button removeCustomerBtn = new Button("Remove Customers from List");
        Button openNewWindowBtn = new Button("Open new window");


        List<Customer> customers = new ArrayList<>();//TODO Tak sie wyswietla tablice!!!

        addCustomerBtn.setOnAction(action -> {

            Customer customer = new Customer(textField.getText(), textField1.getText());
            System.out.println("Customer has been created" + customer);
            customers.add(customer); //TODO  DZISIAJ, Dodawanie Customera do listy!!!!
            File file = new File("ListOfCustomers.txt");
            PrintWriter printWriter = null; //TODO Dlaczego tutaj jest null?
            try {
                printWriter = new PrintWriter(new FileWriter(file, true));
            } catch (IOException e) {
                e.printStackTrace();
            }
            printWriter.println(customer.getName() + " " + customer.getSurname());
            printWriter.close();

        });

        showCustomersBtn.setOnAction(action -> {
            System.out.println("All customers");
            for (int i = 0; i < customers.size(); i++) { //TODO  ZAPAMIETAJ!!!  tablic wyswietlamy za pomoca petli
                System.out.println(customers.get(i));
            }


        });
        removeCustomerBtn.setOnAction(action -> {
            customers.remove(customers); //TODO Usuwanie Customerow z listy
            System.out.println(" Customers have been removed");
            customers.clear(); //TODO czyszczenie listy


        });

        openNewWindowBtn.setOnAction(action -> {
            HBox hbox1 = new HBox(removeCustomerBtn);
            Scene scene1 = new Scene(hbox1, 400, 400);
            primaryStage.setScene(scene1);
            primaryStage.show();

        });

        HBox hbox = new HBox(textField, textField1, addCustomerBtn, showCustomersBtn, openNewWindowBtn);
        Scene scene = new Scene(hbox, 740, 400);
        primaryStage.setScene(scene);
        primaryStage.show();

    }

    public static void main(String[] args) {
        Application.launch(args);
    }
}


