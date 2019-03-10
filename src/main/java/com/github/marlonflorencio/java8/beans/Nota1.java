package com.github.marlonflorencio.java8.beans;

public class Nota1 {

    private int id;

    public Nota1() {
    }

    public Nota1(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public boolean equals(Object o) {

        if (this == o) return true;

        if (o == null || getClass() != o.getClass()) return false;

        Nota1 that = (Nota1) o;

        return id == that.id;
    }

    @Override
    public int hashCode() {
        return id;
    }

    @Override
    public String toString() {
        return "Nota1{" +
                "id=" + id +
                '}';
    }
}
