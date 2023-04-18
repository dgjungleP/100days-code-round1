package com.jungle.challenge.spi.core;

import com.jungle.challenge.spi.interfaces.People;

import java.util.ServiceLoader;

public class PeopleFactory {
    public void invoker() {
        ServiceLoader<People> loader = ServiceLoader.load(People.class);

        boolean notFound = true;
        for (People people : loader) {
            notFound = false;
            people.name();
        }
        if (notFound) {
            throw new RuntimeException("Not found any People instant");
        }
    }
}
