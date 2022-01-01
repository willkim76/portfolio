package serviceableItems;

import types.BeddingSize;
import types.BeddingType;
import types.Material;
import types.Serviceable;

/**
 * Defines the characteristics of a Bedding type that is Serviceable
 */
public class Bedding implements Serviceable {
    private final BeddingType beddingType;
    private final BeddingSize beddingSize;
    private boolean isServiced;
    private final Material material;

    private Bedding(Builder builder) {
        this.beddingType = builder.beddingType;
        this.beddingSize = builder.beddingSize;
        this.isServiced = false;
        this.material = builder.material;
    }

    public BeddingType getBeddingType() { return this.beddingType; }

    public BeddingSize getBeddingSize() { return this.beddingSize; }

    public Material getMaterial() { return this.material; }

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
            return new Bedding(this);
        }
    }
}
