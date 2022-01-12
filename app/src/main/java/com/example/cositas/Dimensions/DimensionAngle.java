package com.example.cositas.Dimensions;

public class DimensionAngle extends Dimension {
    public DimensionAngle() {
        this.name = "Ángulo";

        this.count = 16;

        this.units = new String[this.count];
        this.units[0] = "Grado sexagesimal";
        this.units[1] = "Grado centesimal - gradián - gon";
        this.units[2] = "milesimal (OTAN)";
        this.units[3] = "milesimal (Suecia)";
        this.units[4] = "milesimal (Unión Soviética)";
        this.units[5] = "radián";
        this.units[6] = "miliradián";
        this.units[7] = "Punto (π/16 rad)";
        this.units[8] = "segundo de arco";
        this.units[9] = "minuto de arco";
        this.units[10] = "Ángulo horario";
        this.units[11] = "1/8 rotación (45° or π/4 rad)";
        this.units[12] = "1/6 rotación (60° or π/3 rad)";
        this.units[13] = "Ángulo recto (90° or π/2 rad)";
        this.units[14] = "Ángulo llano (180° or π rad)";
        this.units[15] = "Ángulo completo (360°)";

        this.conversions = new double[this.count];
        this.conversions[0] = 1.0;
        this.conversions[1] = 0.9;
        this.conversions[2] = 0.05625;
        this.conversions[3] = 1/17.5;
        this.conversions[4] = 0.06;
        this.conversions[5] = 180.0/Math.PI;
        this.conversions[6] = 0.18/Math.PI;
        this.conversions[7] = 11.25;
        this.conversions[8] = 1.0/3600.0;
        this.conversions[9] = 1.0/60.0;
        this.conversions[10] = 15.0;
        this.conversions[11] = 45.0;
        this.conversions[12] = 60.0;
        this.conversions[13] = 90.0;
        this.conversions[14] = 180.0;
        this.conversions[15] = 360.0;
    }
}
