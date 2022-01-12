package com.example.cositas.Dimensions;

public class DimensionVolume extends Dimension {
    public DimensionVolume() {
        this.name = "Volumen";

        this.count = 24;

        this.units = new String[this.count];
        this.units[0] = "litros (l)";
        this.units[1] = "decilitros (dl)";
        this.units[2] = "centilitros (cl)";
        this.units[3] = "milílitros (ml)";
        this.units[4] = "centímetro cúbico (cm³)";
        this.units[5] = "dectímetro cúbico (dm³)";
        this.units[6] = "metro cúbico (m³)";
        this.units[7] = "onza líquida, Americano (fl oz)";
        this.units[8] = "onza líquida, Británico (fl oz)";
        this.units[9] = "pulgada cúbica (cu in)";
        this.units[10] = "galón, liquido (Americano, gal)";
        this.units[11] = "galón, liquido (Británico, gal)";
        this.units[12] = "pie cúbico (cu ft)";
        this.units[13] = "Barril (bbl)";
        this.units[14] = "copa (EE.UU. 'legal')";
        this.units[15] = "copa (EE.UU.'habitual')";
        this.units[16] = "copa (británico)";
        this.units[17] = "copa (japonés)";
        this.units[18] = "copa (métrica)";
        this.units[19] = "Pinta, Americano (pt)";
        this.units[20] = "Pinta, Britannica (pt)";
        this.units[21] = "Medida de áridos (bsh)";
        this.units[22] = "合 gō";
        this.units[23] = "升 shō";

        this.conversions = new double[this.count];
        this.conversions[0] = 1.0;
        this.conversions[1] = 0.1;
        this.conversions[2] = 0.01;
        this.conversions[3] = 0.001;
        this.conversions[4] = 0.001;
        this.conversions[5] = 1.0;
        this.conversions[6] = 1000.0;
        this.conversions[7] = 0.0295735295625;
        this.conversions[8] = 0.0284130625;
        this.conversions[9] = 0.016387064;
        this.conversions[10] = 3.785411784;
        this.conversions[11] = 4.54609;
        this.conversions[12] = 28.316846;
        this.conversions[13] = 158.987294928;
        this.conversions[14] = 0.24;
        this.conversions[15] = 0.2365882365;
        this.conversions[16] = 0.284;
        this.conversions[17] = 0.2;
        this.conversions[18] = 0.25;
        this.conversions[19] = 0.473176473;
        this.conversions[20] = 0.56826125;
        this.conversions[21] = 35.23907017;
        this.conversions[22] = 0.1804;
        this.conversions[23] = 1.804;
    }
}
