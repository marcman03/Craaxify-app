package com.example.craxxify.Car;

public class Cotxe {
    private int id;
    private String car;

    public Cotxe(int id) {
        this.id = id;
    }

    public Cotxe(String car) {
        this.car = car;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCar() {
        return car;
    }

    public void setCar(String car) {
        this.car = car;
    }
}
