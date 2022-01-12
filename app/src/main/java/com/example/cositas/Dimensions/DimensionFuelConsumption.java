package com.example.cositas.Dimensions;

public class DimensionFuelConsumption extends Dimension {
    public DimensionFuelConsumption() {
        this.name = "Consumo de combustible";

        this.count = 12;

        this.units = new String[this.count];
        this.units[0] = "Kilómetros por litro";
        this.units[1] = "Kilómetros por galón (Americano)";
        this.units[2] = "Kilómetros por galón (Británico)";
        this.units[3] = "Millas por litro";
        this.units[4] = "Millas por galón (Americano - mpg)";
        this.units[5] = "Millas por galón (Británico - mpg)";
        this.units[6] = "Litros por 100 kilómetros";
        this.units[7] = "Litros por 100 millas";
        this.units[8] = "Galones por 100 km (Americano)";
        this.units[9] = "Galones por 100 km (Británico)";
        this.units[10] = "Galones por 100 millas (Americano)";
        this.units[11] = "Galones por 100 millas (Británico)";

        this.conversions = new double[this.count];
        this.conversions[0] = 1.0;
        this.conversions[1] = 1/3.785411784;
        this.conversions[2] = 1/4.54609;
        this.conversions[3] = 1.609344;
        this.conversions[4] = 1.609344/3.785411784;
        this.conversions[5] = 1.609344/4.54609;
        this.conversions[6] = 100.0;
        this.conversions[7] = 160.9344;
        this.conversions[8] = 100.0/3.785411784;
        this.conversions[9] = 100.0/4.54609;
        this.conversions[10] = 160.9344/3.785411784;
        this.conversions[11] = 160.9344/4.54609;
    }

    @Override
    public double convert(double val, int index_orgn, int index_dest) {
        if (index_orgn == index_dest) {
            return val;
        }

        double temp = ((index_orgn < 6 )? val : 1 / val) * this.conversions[index_orgn] / this.conversions[index_dest];

        return ((index_dest < 6)? temp : 1.0 / temp);
    }
}
