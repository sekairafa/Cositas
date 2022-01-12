package com.example.cositas.Dimensions;

public class DimensionStorage extends Dimension {
    public DimensionStorage() {
        this.name = "Almacenamiento";

        this.count = 13;

        this.units = new String[this.count];
        this.units[0] = "bit";
        this.units[1] = "nibble";
        this.units[2] = "octeto (byte)";
        this.units[3] = "Kilobit (Kb)";
        this.units[4] = "Kiloocteto (Ko)";
        this.units[5] = "Megabit (Mb)";
        this.units[6] = "Megaocteto (Mo)";
        this.units[7] = "Gigabit (Gb)";
        this.units[8] = "Gigaocteto (Go)";
        this.units[9] = "Terabit (Tb)";
        this.units[10] = "Teraocteto (To)";
        this.units[11] = "Petabit (Pb)";
        this.units[12] = "Petaocteto (Po)";

        this.conversions = new double[this.count];
        this.conversions[0] = 1.0;
        this.conversions[1] = 4.0;
        this.conversions[2] = 8.0;
        this.conversions[3] = 1024.0;
        this.conversions[4] = 8192.0;
        this.conversions[5] = 1048576.0;
        this.conversions[6] = 8388608.0;
        this.conversions[7] = 1073741824.0;
        this.conversions[8] = 8589934592.0;
        this.conversions[9] = 1099511627776.0;
        this.conversions[10] = 8796093022208.0;
        this.conversions[11] = 1125899906842624.0;
        this.conversions[12] = 9007199254740992.0;
    }
}
