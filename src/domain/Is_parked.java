package domain;

public enum Is_parked {
    TRUE(true),
    FALSE(false);

    private boolean b;

    Is_parked(boolean b) {
        this.b = b;
    }

    public boolean getB() {
        return b;
    }
}
