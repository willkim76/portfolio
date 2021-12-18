package ServiceableItems;

import types.GarmentType;
import types.Serviceable;

public class Garment implements Serviceable {
    private GarmentType theType;


    @Override
    public boolean isServiced() {
        return false;
    }
}
