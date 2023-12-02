package code.calculation;

public enum Color {
    WHITE (12),
    RED (10),
    BLUE (8),
    ORANGE (4),
    GREEN (6),
    YELLOW (2),

    BLACK (0);

    public final int number;

    Color(int number) {
        this.number = number;
    }
}
