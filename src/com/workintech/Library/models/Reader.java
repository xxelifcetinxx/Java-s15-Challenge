package com.workintech.Library.models;

public class Reader extends Person {

    public Reader(String name) {
        super(name);
    }

    @Override
    public void whoyouare() {
        System.out.println("Reader Name: " + getName());
    }

    @Override
    public String toString() {
        return "Reader Name: " + getName();
    }
}