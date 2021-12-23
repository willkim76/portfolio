package serviceableItems;

import types.GarmentType;
import types.Material;
import types.Serviceable;

public class Garment implements Serviceable {
    private GarmentType theType;
    private Material theMaterial;
    private boolean isServiced;

    @Override
    public void service() { this.isServiced = true; }

    @Override
    public boolean isServiced() {
        return this.isServiced;
    }
}
