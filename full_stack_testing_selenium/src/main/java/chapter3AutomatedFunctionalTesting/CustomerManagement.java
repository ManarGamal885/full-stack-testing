package chapter3AutomatedFunctionalTesting;

import java.util.ArrayList;
import java.util.List;

public class CustomerManagement {
    private String firstName;
    private String lastName;
    private String age;

    private List<List<String>> customers = new ArrayList<List<String>>();

    public List<List<String>> getCustomers(){
        return customers;
    }

    // if the customer name is empty, throw an exception; else add the customer
    public void addCustomers(List<String> customerDetails){
        if (customerDetails.get(0).isEmpty())
            throw new IllegalArgumentException();
        customers.add(customerDetails);
    }

}
