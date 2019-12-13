package com.sakinramazan.java8;

import java.util.Optional;

public class Main {

    public static void main(String[] args) {
        Screen screen = new Screen(0, 0);
        Monitor monitor = new Monitor("0", java.util.Optional.of(screen)); // Optionalize the param
        Optional<Phone> phone = Optional.of(new Phone(2015001, "MyBrand", "Sample X7", Optional.of(monitor)));
        Service mService = new Service();

        int myPhoneWidth = mService.getMobileScreenWidth(phone);
        System.out.println("My phone screen width = " + myPhoneWidth);
    }
}
