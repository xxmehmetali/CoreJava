package com.optionals.optionalsource1.fakedb;

import com.optionals.optionalsource1.domain.Customer;

import java.util.Arrays;
import java.util.List;

public class FakeDb {
    public static List<Customer> getCustomers() {
        return Arrays.asList(
                new Customer(101, "john", "john@gmail.com", Arrays.asList("397937955", "21654725")),
                new Customer(102, "smith", "smith@gmail.com", Arrays.asList("89563865", "2487238947")),
                new Customer(103, "peter", "peter@gmail.com", Arrays.asList("38946328654", "3286487236")),
                new Customer(104, "kely", "kely@gmail.com", Arrays.asList("389246829364", "948609467"))
        );
    }
}
