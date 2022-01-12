package com.example.cositas.Dimensions;

public class DimensionSurface extends Dimension {
    public DimensionSurface() {
        this.name = "Superficie";

        this.count = 14;

        this.units = new String[this.count];
        this.units[0] = "metro cuadrado (m²)";
        this.units[1] = "kilómetro cuadrado (km²)";
        this.units[2] = "decimetro cuadrado (cm²)";
        this.units[3] = "centímetro cuadrado (cm²)";
        this.units[4] = "milímetro cuadrado (mm²)";
        this.units[5] = "acre";
        this.units[6] = "área";
        this.units[7] = "hectárea";
        this.units[8] = "pulgada cuadrada (sq in)";
        this.units[9] = "pie cuadrado (ft²)";
        this.units[10] = "yarda cuadrada (yd²)";
        this.units[11] = "milla cuadrada";
        this.units[12] = "畳 jō";
        this.units[13] = "坪 tsubo - 歩 bu";

        this.conversions = new double[this.count];
        this.conversions[0] = 1.0;
        this.conversions[1] = 1000000.0;
        this.conversions[2] = 0.01;
        this.conversions[3] = 0.0001;
        this.conversions[4] = 0.000001;
        this.conversions[5] = 4046.8564224;
        this.conversions[6] = 100.0;
        this.conversions[7] = 10000.0;
        this.conversions[8] = 0.00064516;
        this.conversions[9] = 0.09290304;
        this.conversions[10] = 0.83612736;
        this.conversions[11] = 2589988.110336;
        this.conversions[12] = 1.653;
        this.conversions[13] = 3.306;
    }
}
