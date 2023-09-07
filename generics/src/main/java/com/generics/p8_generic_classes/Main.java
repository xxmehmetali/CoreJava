package com.generics.p8_generic_classes;

import com.generics.p8_generic_classes.domains.FirstDomain;
import com.generics.p8_generic_classes.domains.SecondDomain;
import com.generics.p8_generic_classes.services.SomeService;

public class Main {
    public static void main(String[] args) {

        SomeService someService1 = new SomeService();
        someService1.setT1(1);
        someService1.setT2("q");
        someService1.summarize();

        SomeService<FirstDomain> someService2 = new SomeService<FirstDomain>();
        someService2.setT1(new FirstDomain("FirstDomainString-1"));
        someService2.setT2(new FirstDomain("FirstDomainString-2"));
        someService2.summarize();

        SomeService<SecondDomain> someService3 = new SomeService<SecondDomain>();
        someService3.setT1(new SecondDomain(1));
        someService3.setT2(new SecondDomain(2));
        someService3.summarize();

        //will get exception because type parameter. It has to be suitable with parameterized types. There is no place for SecondDomain in someService4.
        SomeService<FirstDomain> someService4 = new SomeService<>();
        someService4.setT1(new FirstDomain("FirstDomainString-4"));
        /**someService4.setT2(new SecondDomain(3));*/
        someService4.summarize();

    }
}
