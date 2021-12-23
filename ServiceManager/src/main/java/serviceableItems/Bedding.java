package serviceableItems;

import types.BeddingSize;
import types.BeddingType;
import types.Material;
import types.Serviceable;

/**
 * Defines the characteristics of a bedding article that is serviceable
 */
public class Bedding implements Serviceable {
    private BeddingType beddingType;
    private BeddingSize beddingSize;
    private Material material;
    private boolean isServiced;

    private Bedding() { }

    public BeddingType getBeddingType() { return this.beddingType; }

    public BeddingSize getBeddingSize() { return this.beddingSize; }

    public Material getMaterial() { return this.material; }

    @Override
    public void service() { this.isServiced = true; }

    @Override
    public boolean isServiced() {
        return isServiced;
    }

    @Override
    public String toString() {
        return String.format(
                "{%s, %s, %s, Serviced: %s}",
                beddingType,
                beddingSize,
                material,
                isServiced
        );
    }

    public static class Builder {
        private BeddingType beddingType;
        private BeddingSize beddingSize;
        private Material material;
        private boolean isService;

        public Builder withBeddingType(BeddingType beddingType) {
            this.beddingType = beddingType;
            return this;
        }

        public Builder withBeddingSize(BeddingSize beddingSize) {
            this.beddingSize = beddingSize;
            return this;
        }

        public Builder withMaterial(Material material) {
            this.material = material;
            return this;
        }

        public Bedding build() {
            Bedding bedding = new Bedding();
            bedding.beddingType = beddingType;
            bedding.beddingSize = beddingSize;
            bedding.material = material;

            return bedding;
        }
    }
}
