package com.example.cositas.Dimensions;

public class DimensionDensity extends Dimension {
    public DimensionDensity() {
        this.name = "Densidad";

        this.count = 5;

        this.units = new String[this.count];
        this.units[0] = "kg/m³";
        this.units[1] = "g/cm³";
        this.units[2] = "libra / pie cúbico (lb/ft³)";
        this.units[3] = "libra / pulgada cúb. (lb/inch³)";
        this.units[4] = "onza / pulgada cúb. (oz/inch³)";

        this.conversions = new double[this.count];
        this.conversions[0] = 1.0;
        this.conversions[1] = 1000.0;
        this.conversions[2] = 16.018463373;
        this.conversions[3] = 27679.9047;
        this.conversions[4] = 1729.99404;
    }
}
