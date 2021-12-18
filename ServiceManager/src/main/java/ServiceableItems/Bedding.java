package ServiceableItems;

import types.BeddingType;
import types.Serviceable;
import types.Sizeable;

public class Bedding implements Serviceable, Sizeable {
    private BeddingType theType;
    private String theSize;


    private boolean isServiced;

    @Override
    public boolean isServiced() {
        return isServiced;
    }

    @Override
    public String getSize() {
        return "";
    }
}
