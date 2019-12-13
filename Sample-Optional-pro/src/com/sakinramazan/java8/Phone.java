package com.sakinramazan.java8;

import java.util.Optional;

public class Phone {
    private long id;
    private String name;
    private String brand;
    private Optional<Monitor> monitor;

    public Phone(long id, String name, String brand, Optional<Monitor> monitor) {
        this.id = id;
        this.name = name;
        this.brand = brand;
        this.monitor = monitor;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public Optional<Monitor> getMonitor() {
        return monitor;
    }

    public void setMonitor(Optional<Monitor> monitor) {
        this.monitor = monitor;
    }
}
