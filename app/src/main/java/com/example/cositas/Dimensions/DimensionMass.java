package com.example.cositas.Dimensions;

public class DimensionMass extends Dimension {
    public DimensionMass() {
        this.name = "Masa";

        this.count = 15;

        this.units = new String[this.count];
        this.units[0] = "Kilogramo (kg)";
        this.units[1] = "gramo (g)";
        this.units[2] = "miligramo (mg)";
        this.units[3] = "Tonelada métrica (T)";
        this.units[4] = "Tonelada corta";
        this.units[5] = "Tonelada larga";
        this.units[6] = "Tonelada marítima";
        this.units[7] = "Libra, Americano (lb)";
        this.units[8] = "Onza (oz)";
        this.units[9] = "Onza, Troy (oz tr)";
        this.units[10] = "Quintal largo";
        this.units[11] = "Carat (ct)";
        this.units[12] = "Poods";
        this.units[13] = "Funt";
        this.units[14] = "匁 momme";

        this.conversions = new double[this.count];
        this.conversions[0] = 1.0;
        this.conversions[1] = 0.001;
        this.conversions[2] = 0.000001;
        this.conversions[3] = 1000;
        this.conversions[4] = 907.18474;
        this.conversions[5] = 1016.05;
        this.conversions[6] = 1132.7;
        this.conversions[7] = 0.45359237;
        this.conversions[8] = 0.028349523125;
        this.conversions[9] = 0.0311034768;
        this.conversions[10] = 100.00;
        this.conversions[11] = 0.0002;
        this.conversions[12] = 16.3805;
        this.conversions[13] = 0.4095125;
        this.conversions[14] = 0.00375;
    }
}
