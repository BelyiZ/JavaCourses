package ru.reksoft;

import java.util.ArrayList;

public class B extends A {
    public B() {
        ArrayList<B> e = new ArrayList();
        B b = e.get(0);
        e.add(new B());
        for (B b1: e){

        }
    }
}
