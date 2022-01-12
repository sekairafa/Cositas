package com.example.cositas;

import java.text.DecimalFormat;

public class MyComplex implements Comparable<MyComplex> {

    private double real;
    private double imag;
    private boolean isComplexFlag;

    MyComplex(double real, double imag, boolean flag) {
        this.set(real, imag, flag);
    }

    MyComplex(MyComplex complex) {
        this.set(complex.getReal(), complex.getImag(), complex.isComplex());
    }

    public double getReal() {
        return real;
    }

    public double getImag() {
        return imag;
    }

    public boolean isComplex() {
        return isComplexFlag;
    }

    public MyComplex set(double real, double imag, boolean flag) {
        return this.setReal(real).setImag(imag).setComplex(flag);
    }

    public MyComplex setReal(double real) {
        this.real = real;
        return this;
    }

    public MyComplex setImag(double imag) {
        this.imag = imag;
        return this;
    }

    public MyComplex setComplex(boolean flag) {
        this.isComplexFlag = flag;
        return this;
    }

    public MyComplex add(double real) {
        return this.setReal(this.getReal() + real);
    }

    public MyComplex add(MyComplex complex) {
        return this.setReal(this.getReal() + complex.getReal()).setImag(this.getImag() + complex.getImag()).setComplex(this.getImag() != 0.0);
    }

    public MyComplex minus(double real) {
        return this.setReal(this.getReal() - real);
    }

    public MyComplex minus(MyComplex complex) {
        return this.setReal(this.getReal() - complex.getReal()).setImag(this.getImag() - complex.getImag()).setComplex(this.getImag() != 0.0);
    }

    public MyComplex multiply(double real) {
        return this.setReal(this.getReal() * real).setImag(this.getImag() * real);
    }

    public MyComplex multiply(MyComplex complex) {
        double a = this.getReal();
        double b = this.getImag();
        double c = complex.getReal();
        double d = complex.getImag();

        return this.setReal(a * c - b * d).setImag(a * d + b * c).setComplex(this.getImag() != 0.0);
    }

    public MyComplex divide(MyComplex complex) {
        MyComplex complex_ = new MyComplex(complex).conjuge();

        return this.multiply(complex_).multiply(1 / (Math.pow(complex.getReal(), 2.0) + Math.pow(complex.getImag(), 2.0)));
    }

    public MyComplex conjuge() {
        return this.setImag(-this.getImag());
    }

    public MyComplex[] nRoot(int radical) {
        if (radical < 2) {
            return null;
        }

        MyComplex[] sqrts = new MyComplex[radical];

        int i;

        double module = Math.pow(Math.sqrt(Math.pow(this.getReal(), 2.0) + Math.pow(this.getImag(), 2.0)), 1.0 / (double) radical);
        double angle = Math.atan2(this.getImag(), this.getReal()) / radical;

        double[] ang = new double[radical];

        for (i = 0; i < radical; i++) {
            ang[i] = angle + 2 * Math.PI * i / radical;
            sqrts[i] = new MyComplex(module * Math.cos(ang[i]),module * Math.sin(ang[i]), !(ang[i] == 0));
        }

        return sqrts;
    }

    @Override
    public String toString()
    {
        DecimalFormat formatter = new DecimalFormat("#.########");

        double temp_r = (Math.abs(this.getReal()) < 0.00000001)? 0.0 : this.getReal();
        double temp_i = (Math.abs(this.getImag()) < 0.00000001)? 0.0 : this.getImag();

        boolean temp_f = (temp_i != 0.0);

        String str = "";

        if(temp_r == 0.0 && !temp_f) {
            str += "0";
        }
        else if (temp_r != 0.0) {
            str += formatter.format(temp_r);
        }

        if(temp_f) {
            if(temp_r != 0.0) {
                str += " ";
            }

            str += ((temp_i < 0.0)? "" : "+") + formatter.format(temp_i) + "i";
        }

        return str;
    }

    @Override
    public int compareTo(MyComplex complex) {
        String str_this = this.toString();
        String str_complex = complex.toString();

        return str_this.compareTo(str_complex);
    }
}
