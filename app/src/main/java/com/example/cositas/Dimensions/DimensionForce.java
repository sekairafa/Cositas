package com.example.cositas.Dimensions;

public class DimensionForce extends Dimension {
    public DimensionForce() {
        this.name = "Fuerza";

        this.count = 9;

        this.units = new String[this.count];
        this.units[0] = "Newton (N)";
        this.units[1] = "Kilonewton (kN)";
        this.units[2] = "Meganewton (MN)";
        this.units[3] = "Dina (dyn)";
        this.units[4] = "Kilogramo fuerza, kilopond (kgf)";
        this.units[5] = "Libra fuerza (lbf)";
        this.units[6] = "Kilo Libra fuerza (Kip)";
        this.units[7] = "Poundal (pdl)";
        this.units[8] = "Sthène (sn)";

        this.conversions = new double[this.count];
        this.conversions[0] = 1.0;
        this.conversions[1] = 1000.0;
        this.conversions[2] = 1000000.0;
        this.conversions[3] = 0.00001;
        this.conversions[4] = 9.80665;
        this.conversions[5] = 4.4482216152605;
        this.conversions[6] = 4448.2216152605;
        this.conversions[7] = 0.138254954376;
        this.conversions[8] = 1000.0;
    }
}
