package com.github.marlonflorencio.java8.beans;

public class Nota2 implements Comparable<Nota2> {

    private int id;


    public Nota2() {
    }

    public Nota2(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int compareTo(Nota2 o) {
        return  Integer.valueOf(id).compareTo(o.getId());
    }

    @Override
    public String toString() {
        return "Nota2{" +
                "id=" + id +
                '}';
    }
}
