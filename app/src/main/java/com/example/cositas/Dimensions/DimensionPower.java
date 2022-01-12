package com.example.cositas.Dimensions;

public class DimensionPower extends Dimension {
    public DimensionPower() {
        this.name = "Potencia";

        this.count = 8;

        this.units = new String[this.count];
        this.units[0] = "Kilovatio (kW)";
        this.units[1] = "Megavatio (MW)";
        this.units[2] = "Vatio (W)";
        this.units[3] = "Joule por segundo (J/s)";
        this.units[4] = "Caballo de vapor (hp)";
        this.units[5] = "Caballo de vapor métrico (CV)";
        this.units[6] = "lb·ft/min";
        this.units[7] = "lb·ft/s";

        this.conversions = new double[this.count];
        this.conversions[0] = 1.0;
        this.conversions[1] = 1000.0;
        this.conversions[2] = 0.001;
        this.conversions[3] = 0.001;
        this.conversions[4] = 0.74569987158227022;
        this.conversions[5] = 0.73549875;
        this.conversions[6] = 0.0000225969658;
        this.conversions[7] = 0.0013558179483;
    }
}
