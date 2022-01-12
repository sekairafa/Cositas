package com.example.cositas.Dimensions;

public class DimensionMomentum extends Dimension {
    public DimensionMomentum() {
        this.name = "Momento de fuerza";

        this.count = 8;

        this.units = new String[this.count];
        this.units[0] = "Newton metros (Nm)";
        this.units[1] = "Kilonewton metros (kNm)";
        this.units[2] = "newton centimetros (Ncm)";
        this.units[3] = "Kilopond metros";
        this.units[4] = "Libra-fuerza pulgadas";
        this.units[5] = "Pie-libra (ft lb)";
        this.units[6] = "onza-fuerza pulgadas";
        this.units[7] = "onza-fuerza pies";

        this.conversions = new double[this.count];
        this.conversions[0] = 1.0;
        this.conversions[1] = 1000.0;
        this.conversions[2] = 0.01;
        this.conversions[3] = 1.0/0.101971621;
        this.conversions[4] = 1.0/8.85075;
        this.conversions[5] = 1.0/0.737562149277266;
        this.conversions[6] = 1.0/141.611646;
        this.conversions[7] = 1.0/11.8009705;
    }
}
