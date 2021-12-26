package serviceableItems;

import types.GarmentType;
import types.Material;
import types.Serviceable;

public class Garment implements Serviceable {
    private GarmentType garmentType;
    private Material material;
    private boolean isServiced;

    private Garment(Builder builder) {
        this.garmentType = builder.garmentType;
        this.material = builder.material;
    }

    @Override
    public boolean isServiced() {
        return this.isServiced;
    }

    public static class Builder {
        private GarmentType garmentType;
        private Material material;

        public Builder withGarmentType(GarmentType garmentType) {
            this.garmentType = garmentType;
            return this;
        }

        public Builder withMaterial(Material material) {
            this.material = material;
            return this;
        }

        public Garment build() {
          return new Garment(this);
        }
    }
}
