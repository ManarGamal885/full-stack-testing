package chapter3AutomatedFunctionalTesting;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;
import org.testng.Assert;
import java.util.ArrayList;
import java.util.List;

// Unit Testing Exercise
public class CustomerManagementTests {

    private CustomerManagement customer;

    @BeforeClass
    public void setup() {
        customer = new CustomerManagement();
    }

    @Test(description = "should return empty when there are no customers")
    public void shouldReturnEmptyWhenThereAreNoCustomers() {
        List<List<String>> customers = customer.getCustomers();
        Assert.assertTrue(customers.isEmpty(), "Error: Customers exist");
    }

    @Test(description = "should throw exception when customer name is invalid", expectedExceptions = IllegalArgumentException.class)
    public void shouldThrowExceptionForInvalidInput() {
        List<String> newCustomer = new ArrayList<>();
        newCustomer.add("");
        newCustomer.add("Jackson");
        newCustomer.add("20");
        customer.addCustomers(newCustomer);
    }
}

