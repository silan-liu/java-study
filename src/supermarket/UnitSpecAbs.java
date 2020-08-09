package supermarket;

public abstract class UnitSpecAbs {
    String spec;

    UnitSpecAbs(String spec) {
        this.spec = spec;
    }

    abstract String getSpec();
}
