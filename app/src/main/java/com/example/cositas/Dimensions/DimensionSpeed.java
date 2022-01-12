package com.example.cositas.Dimensions;

public class DimensionSpeed extends Dimension {
    public DimensionSpeed() {
        this.name = "Velocidad";

        this.count = 10;

        this.units = new String[this.count];
        this.units[0] = "Kilometros por hora (km/h)";
        this.units[1] = "Kilometros por segundo (km/s)";
        this.units[2] = "metros por segundo (m/s)";
        this.units[3] = "centímetros por segundo (cm/s)";
        this.units[4] = "milla por hora (mph)";
        this.units[5] = "pies por segundo (ft/s)";
        this.units[6] = "pulgadas por segundo (ips)";
        this.units[7] = "Nudo";
        this.units[8] = "~Mach 1";
        this.units[9] = "Velocidad de la luz (c)";

        this.conversions = new double[this.count];
        this.conversions[0] = 1.0;
        this.conversions[1] = 3600.0;
        this.conversions[2] = 3.6;
        this.conversions[3] = 0.036;
        this.conversions[4] = 1.609344;
        this.conversions[5] = 1.09728;
        this.conversions[6] = 0.09144;
        this.conversions[7] = 1.852;
        this.conversions[8] = 1225.08;
        this.conversions[9] = 1079252848.8;
    }
}
