package com.example.cositas.Dimensions;

public class DimensionLength extends Dimension {
    public DimensionLength() {
        this.name = "Longitud";

        this.count = 15;

        this.units = new String[this.count];
        this.units[0] = "metro (m)";
        this.units[1] = "Kilómetro (km)";
        this.units[2] = "decímetro (dm)";
        this.units[3] = "centímetro (cm)";
        this.units[4] = "milímetro (mm)";
        this.units[5] = "pulgada (in)";
        this.units[6] = "pie (ft)";
        this.units[7] = "Yarda (yd)";
        this.units[8] = "Milla (mi)";
        this.units[9] = "Milla náutica (nmi)";
        this.units[10] = "Cable";
        this.units[11] = "Sazhen";
        this.units[12] = "Versta";
        this.units[13] = "寸 sun";
        this.units[14] = "尺 shaku";

        this.conversions = new double[this.count];
        this.conversions[0] = 1.0;
        this.conversions[1] = 1000.0;
        this.conversions[2] = 0.1;
        this.conversions[3] = 0.01;
        this.conversions[4] = 0.001;
        this.conversions[5] = 0.0254;
        this.conversions[6] = 0.3048;
        this.conversions[7] = 0.9144;
        this.conversions[8] = 1609.344;
        this.conversions[9] = 1852;
        this.conversions[10] = 185.2;
        this.conversions[11] = 2.1336;
        this.conversions[12] = 1066.8;
        this.conversions[13] = 0.0303;
        this.conversions[14] = 0.3030;
    }
}
