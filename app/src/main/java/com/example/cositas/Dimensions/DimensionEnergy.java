package com.example.cositas.Dimensions;

public class DimensionEnergy extends Dimension {
    public DimensionEnergy() {
        this.name = "Energía";

        this.count = 9;

        this.units = new String[this.count];
        this.units[0] = "Newton metro - Joule (Nm - J)";
        this.units[1] = "Kilojoule (kJ)";
        this.units[2] = "Megajoule (MJ)";
        this.units[3] = "Kilovatio hora (kWh)";
        this.units[4] = "Megavatio hora (MWh)";
        this.units[5] = "Calorías (cal)";
        this.units[6] = "Kilocalorías (kcal)";
        this.units[7] = "Pie-libra (ft lb)";
        this.units[8] = "Unidad térmica inglesa (Btu)";

        this.conversions = new double[this.count];
        this.conversions[0] = 1.0;
        this.conversions[1] = 1000.0;
        this.conversions[2] = 1000000.0;
        this.conversions[3] = 3600000.0;
        this.conversions[4] = 3600000000.0;
        this.conversions[5] = 4.1868;
        this.conversions[6] = 4186.8;
        this.conversions[7] = 1.3558179483314004;
        this.conversions[8] = 1055.05585262;
    }
}
