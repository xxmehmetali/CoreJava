package com.optionals.optionalsource1;

import com.optionals.optionalsource1.domain.Customer;

import java.util.List;
import java.util.Optional;
import java.util.Random;

import static com.optionals.optionalsource1.fakedb.FakeDb.getCustomers;

public class Sample1 {

    private static final String NAME_PETER = "peter";

    public static void main(String[] args) throws Exception {
        System.out.println(getCustomerByEmailId("john@gmail.com"));
        checkBeforeUsing();
        findCustomerWithRandomOptional();
    }

    public static Customer getCustomerByEmailId(String email) throws Exception {
        List<Customer> customers = getCustomers();
        Optional<Customer> optionalCustomer = customers.stream()
                .filter(c -> c.getEmail().orElse("").equals(email))
                .findAny();

        String errMessage = "no customer found with this email : " + email;

        return optionalCustomer
                .orElseThrow(() -> new RuntimeException(errMessage));
    }

    public static void checkBeforeUsing() {
        List<Customer> customers = getCustomers();
        Optional<Customer> firstCust = customers.stream().findFirst();
        if (firstCust.isPresent()) {
            Customer customer = firstCust.get();
            System.out.println("First customer is here : " + customer);
        } else
            System.out.println("No customer found");
    }

    public static void findCustomerWithRandomOptional() {
        List<Customer> customers = getCustomers();

        Random random = new Random();
        int randomIndex = random.nextInt(0, 100);

        Customer customer = null;
        if (randomIndex < customers.size())
            customer = customers.get(randomIndex);

        Optional<Customer> customerOptional = Optional.ofNullable(customer);
        String customerName = customerOptional.map(Customer::getName)
                .orElseThrow( () -> new RuntimeException("No customer found"));
        System.out.println("You are lucky. Customer found with random index : " + randomIndex + " and name : " + customerName);

    }

    public static void waysOfCreatingOptional() {
        //empty optional
        Optional o1 = Optional.empty();
        //throws NPE if value is null
        Optional o2 = Optional.of("val");
        //can be put null into. If value is null, returns Optional.empty().
        Optional o3 = Optional.ofNullable("val");
    }
}
