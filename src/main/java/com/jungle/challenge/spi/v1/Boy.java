package com.jungle.challenge.spi.v1;

import com.jungle.challenge.spi.interfaces.People;

public class Boy implements People {
    @Override
    public void name() {
        System.out.println("I`m boy");
    }
}
