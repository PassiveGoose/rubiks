package java.calculation;

import java.util.ArrayList;
import java.util.List;

public class Side {

    public enum CubeNumber {
        TOP_LEFT(0),
        TOP_CENTER(1),
        TOP_RIGHT(2),
        MID_RIGHT(3),
        BOTTOM_RIGHT(4),
        BOTTOM_CENTER(5),
        BOTTOM_LEFT(6),
        MID_LEFT(7);

        int number;

        private CubeNumber(int number) {
            this.number = number;
        }
    }

    CubePartition center;

    List<CubePartition> movableParts = new ArrayList<>();

    public Side(ColorLinks centerColorLinks) {
        List<Color> colors = new ArrayList<>();
        colors.add(centerColorLinks.center);

    }
}
