package com.example.cositas.Dimensions;

public class DimensionAceleration extends Dimension {
    public DimensionAceleration() {
        this.name = "Aceleración";

        this.count = 4;

        this.units = new String[this.count];
        this.units[0] = "m / s²";
        this.units[1] = "cm / s² (Gal)";
        this.units[2] = "ft / s²";
        this.units[3] = "gravedad (g)";

        this.conversions = new double[this.count];
        this.conversions[0] = 1.0;
        this.conversions[1] = 0.01;
        this.conversions[2] = 0.3048;
        this.conversions[3] = 9.80665;
    }
}
