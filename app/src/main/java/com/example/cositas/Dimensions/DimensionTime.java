package com.example.cositas.Dimensions;

public class DimensionTime extends Dimension {
    public DimensionTime() {
        this.name = "Tiempo";

        this.count = 16;

        this.units = new String[this.count];
        this.units[0] = "segundos (s)";
        this.units[1] = "milisegundos (ms)";
        this.units[2] = "minutos";
        this.units[3] = "horas";
        this.units[4] = "Días";
        this.units[5] = "Semanas";
        this.units[6] = "Meses";
        this.units[7] = "Trimestre";
        this.units[8] = "Semestre";
        this.units[9] = "Años";
        this.units[10] = "Año anomalístico";
        this.units[11] = "Año bisiesto";
        this.units[12] = "Año sidéreo";
        this.units[13] = "Año solar gregoriano";
        this.units[14] = "Año solar juliano";
        this.units[15] = "Año tropical";

        this.conversions = new double[this.count];
        this.conversions[0] = 1.0;
        this.conversions[1] = 0.001;
        this.conversions[2] = 60.0;
        this.conversions[3] = 3600.0;
        this.conversions[4] = 86400.0;
        this.conversions[5] = 604800.0;
        this.conversions[6] = 2628000.0;
        this.conversions[7] = 7884000;
        this.conversions[8] = 15768000.0;
        this.conversions[9] = 31536000.0;
        this.conversions[10] = 31558432.1;
        this.conversions[11] = 31622400.0;
        this.conversions[12] = 31558149.54;
        this.conversions[13] = 31556952.0;
        this.conversions[14] = 31557600.0;
        this.conversions[15] = 31556926.0;
    }
}
