package model;

public final class Location {
    private long x;
    private Integer y;
    private Float z;

    public Location(long x, Integer y, Float z) {
        if (y == null) throw new IllegalArgumentException("y null");
        if (z == null) throw new IllegalArgumentException("z null");

        this.x = x;
        this.y = y;
        this.z = z;
    }

    public Location() {}

    public void setX(long x) {
        this.x = x;
    }

    public void setY(Integer y) {
        if (y == null) throw new IllegalArgumentException("y null");
        this.y = y;
    }

    public void setZ(Float z) {
        if (z == null) throw new IllegalArgumentException("z null");
        this.z = z;
    }

    public long getX() {
        return x;
    }

    public Integer getY() {
        return y;
    }

    public Float getZ() {
        return z;
    }

    @Override
    public String toString() {
        return "\n      X = " + x
                + ";\n      Y = " + y
                + ";\n      Z = " + z;
    }
}

