package com.example.cositas;

import java.text.DecimalFormat;

public class MyDouble {

    private double val;

    public MyDouble(double val) {
        this.set(val);
    }

    public MyDouble(MyDouble myDouble) {
        this.set(myDouble.get());
    }

    public boolean parse(String str) {
        try {
            this.set(Double.parseDouble(str));
        }
        catch (Exception e) {
            this.set(0.0);
            return true;
        }
        return false;
    }

    public double get() {
        return this.val;
    }

    public MyDouble set(double val)
    {
        this.val = val;
        return this;
    }

    public MyDouble set(MyDouble myDouble)
    {
        return this.set(myDouble.get());
    }

    public MyDouble plus(double val) {
        return this.set(this.get() + val);
    }

    public MyDouble plus(MyDouble myDouble) {
        return this.plus(myDouble.get());
    }

    public MyDouble minus(double val) {
        return this.set(this.get() - val);
    }

    public MyDouble minus(MyDouble myDouble) {
        return this.minus(myDouble.get());
    }

    public MyDouble multiply(double val) {
        return this.set(this.get() * val);
    }

    public MyDouble multiply(MyDouble myDouble) {
        return this.multiply(myDouble.get());
    }

    public MyDouble divide(double val) {
        if (val != 0.0) {
            return this.set(this.get() / val);
        }
        return null;
    }

    public MyDouble divide(MyDouble myDouble) {
        return this.divide(myDouble.get());
    }

    @Override
    public String toString()
    {
        DecimalFormat formatter = new DecimalFormat("#.########");
        return formatter.format((Math.abs(this.get()) < 0.00000001)? 0.0 : this.get());
    }
}
