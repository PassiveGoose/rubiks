package code.calculation;

public enum ColorLinks {

    WHITE(Color.WHITE, Color.BLUE, Color.GREEN, Color.ORANGE, Color.RED),
    RED(Color.RED, Color.BLUE, Color.GREEN, Color.WHITE, Color.YELLOW),
    BLUE(Color.BLUE, Color.ORANGE, Color.RED, Color.WHITE, Color.YELLOW),
    ORANGE(Color.ORANGE, Color.GREEN, Color.BLUE, Color.WHITE, Color.YELLOW),
    GREEN(Color.GREEN, Color.RED, Color.GREEN, Color.WHITE, Color.YELLOW),
    YELLOW(Color.YELLOW, Color.BLUE, Color.GREEN, Color.RED, Color.ORANGE);

    Color center;
    Color right;
    Color left;
    Color top;
    Color bottom;

    ColorLinks(Color center, Color right, Color left, Color top, Color bottom) {
        this.center = center;
        this.right = right;
        this.left = left;
        this.top = top;
        this.bottom = bottom;
    }

}

