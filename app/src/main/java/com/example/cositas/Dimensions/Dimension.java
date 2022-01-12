package com.example.cositas.Dimensions;

import com.example.cositas.MyComplex;

public abstract  class Dimension implements Comparable<Dimension> {
    protected String name;

    protected int count;
    protected String[] units;
    protected double[] conversions;

    public double convert(double val, int index_orgn, int index_dest) {
        return val * ((index_orgn == index_dest)? 1.0 : this.conversions[index_orgn] / this.conversions[index_dest]);
    }

    public final String unit(int index) {
        return this.units[index];
    }

    public final String[] unitArray() {
        return this.units;
    }

    @Override
    public String toString() {
        return name;
    }

    @Override
    public int compareTo(Dimension dimension) {
        return this.toString().compareTo(dimension.toString());
    }
}
