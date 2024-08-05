package domain;

public enum Rank {
    FAMILY(1), GOLD(2), VIP(3);
    private int rank;
    private Rank(int rank) {
        this.rank = rank;
    }

    static double getDiscountRatio(Rank rank)    {
        return switch (rank.rank)   {
            case 1 -> 0.1d;
            case 2 -> 0.2d;
            case 3 -> 0.3d;
            default -> 0.d;
        };
    }
}
