package com.example.cositas.Dimensions;

public class DimensionTemperature extends Dimension {
    public DimensionTemperature() {
        this.name = "Temperatura";

        this.count = 5;

        this.units = new String[this.count];
        this.units[0] = "Celsius (°C)";
        this.units[1] = "Fahrenheit (°F)";
        this.units[2] = "Kelvin (K)";
        this.units[3] = "Rankine (°R)";
        this.units[4] = "Reaumur (°Re)";

        this.conversions = new double[this.count];
        this.conversions[0] = 1.0;
        this.conversions[1] = 1.0;
        this.conversions[2] = 1.0;
        this.conversions[3] = 1.0;
        this.conversions[4] = 1.0;
    }

    @Override
    public double convert(double val, int index_orgn, int index_dest) {
        if (index_orgn == index_dest) {
            return val;
        }

        double temp = val;

        switch (index_orgn) {
            case 0: // °C
                if (index_dest == 4) { // Re
                    temp *= 1.25;
                }
                else { // K - R - F
                    temp += 273.15; // K
                    if (index_dest == 2) {
                        break;
                    }

                    temp *= 1.8; // R
                    if (index_dest == 3) {
                        break;
                    }

                    temp -= 459.67; // F
                }
                break;
            case 1: // °F
                temp += 459.67; // R
                if (index_dest == 3) {
                    break;
                }

                temp /= 1.8; // K
                if (index_dest == 2) {
                    break;
                }

                temp -= 273.15; // C
                if (index_dest == 0) {
                    break;
                }

                temp *= 1.25; // Re
                break;
            case 2: // K
                if(index_dest % 2 == 0) { // C - Re
                    temp -= 273.15; // C
                    if (index_dest == 0) {
                        break;
                    }

                    temp *= 1.25; // Re
                }
                else { // F - R
                    temp *= 1.8; // R
                    if (index_dest == 3) {
                        break;
                    }

                    temp -= 459.67; // F
                }
                break;
            case 3: // °R
                if (index_dest == 1) { // F
                    temp -= 459.67;
                }
                else { // K - C - Re
                    temp /= 1.8; // K
                    if (index_dest == 2) {
                        break;
                    }

                    temp -= 273.15; // C
                    if (index_dest == 0) {
                        break;
                    }

                    temp *= 1.25; // Re
                }
                break;
            case 4: // °Re
                temp /= 1.25; // C
                if (index_dest == 0) {
                    break;
                }

                temp += 273.15; // K
                if (index_dest == 2) {
                    break;
                }

                temp *= 1.8; // R
                if (index_dest == 3) {
                    break;
                }

                temp -= 459.67; // F
                break;
        }

        return temp;
    }
}
