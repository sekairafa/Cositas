package com.example.cositas;

public class MyInteger {

    private int val;

    public MyInteger(int integer) {
        this.set(integer);
    }

    public MyInteger(MyInteger myInteger) {
        this.set(myInteger.get());
    }

    public boolean parse(String str) {
        try {
            this.set(Integer.parseInt(str));
        }
        catch (Exception e) {
            this.set(0);
            return true;
        }
        return false;
    }

    public int get() {
        return this.val;
    }

    public MyInteger set(int integer)
    {
        this.val = integer;
        return this;
    }

    public MyInteger set(MyInteger myInteger)
    {
        return this.set(myInteger.get());
    }

    public MyInteger plus(int integer) {
        return this.set(this.get() + integer);
    }

    public MyInteger plus(MyInteger myInteger) {
        return this.plus(myInteger.get());
    }

    public MyInteger minus(int integer) {
        return this.set(this.get() - integer);
    }

    public MyInteger minus(MyInteger myInteger) {
        return this.minus(myInteger.get());
    }

    public MyInteger multiply(int integer) {
        return this.set(this.get() * integer);
    }

    public MyInteger multiply(MyInteger myInteger) {
        return this.multiply(myInteger.get());
    }

    public MyInteger divide(int integer) {
        if (integer != 0) {
            return this.set(this.get() / integer);
        }
        return null;
    }

    public MyInteger divide(MyInteger myInteger) {
        return this.divide(myInteger.get());
    }

    @Override
    public String toString()
    {
        return String.valueOf(this.get());
    }
}
