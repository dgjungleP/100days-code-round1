package com.jungle.challenge.spi.v2;

import com.jungle.challenge.spi.interfaces.People;

public class Girl implements People {
    @Override
    public void name() {
        System.out.println("I`m girl");
    }
}
