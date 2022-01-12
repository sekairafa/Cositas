package com.example.cositas.Dimensions;

public class DimensionPressure extends Dimension {
    public DimensionPressure() {
        this.name = "Presión";

        this.count = 14;

        this.units = new String[this.count];
        this.units[0] = "N/m²";
        this.units[1] = "Pascal (Pa)";
        this.units[2] = "Hectopascal (hPa)";
        this.units[3] = "Kilopascal (kPa)";
        this.units[4] = "Megapascal (MPa)";
        this.units[5] = "Atmósfera física (atm)";
        this.units[6] = "Atmósfera técnica (at)";
        this.units[7] = "bar";
        this.units[8] = "milibar (mbar)";
        this.units[9] = "Libra por pie cuadrado (psf)";
        this.units[10] = "Libra por pulgada cuadrada (psi)";
        this.units[11] = "milímetros de agua (mmH2O)";
        this.units[12] = "milímetros de mercurio (mmHg)";
        this.units[13] = "Torr";

        this.conversions = new double[this.count];
        this.conversions[0] = 1.0;
        this.conversions[1] = 1.0;
        this.conversions[2] = 100.0;
        this.conversions[3] = 1000.0;
        this.conversions[4] = 1000000.0;
        this.conversions[5] = 101325.0;
        this.conversions[6] = 98066.5;
        this.conversions[7] = 100000.0;
        this.conversions[8] = 100.0;
        this.conversions[9] = 47.880268685;
        this.conversions[10] = 6894.757293168361;
        this.conversions[11] = 9.80665;
        this.conversions[12] = 133.322387415;
        this.conversions[13] = 133.32236842105263157894736842105;
    }
}
