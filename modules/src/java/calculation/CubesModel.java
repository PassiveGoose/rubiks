package java.calculation;

public class CubesModel {

    private enum CubeNumber {

        TOP_CORNER_LEFT_BACK(0),
        TOP_BORDER_BACK(1),
        TOP_CORNER_BACK_RIGHT(2),
        TOP_BORDER_RIGHT(3),
        TOP_CORNER_RIGHT_FRONT(4),
        TOP_BORDER_FRONT(5),
        TOP_CORNER_FRONT_LEFT(6),
        TOP_BORDER_LEFT(7),
        MID_CORNER_LEFT_BACK(8),
        MID_CORNER_BACK_RIGHT(9),
        MID_CORNER_RIGHT_FRONT(10),
        MID_CORNER_FRONT_LEFT(11),
        BOTTOM_CORNER_LEFT_BACK(12),
        BOTTOM_BORDER_BACK(13),
        BOTTOM_CORNER_BACK_RIGHT(14),
        BOTTOM_BORDER_RIGHT(15),
        BOTTOM_CORNER_RIGHT_FRONT(16),
        BOTTOM_BORDER_FRONT(17),
        BOTTOM_CORNER_FRONT_LEFT(18),
        BOTTOM_BORDER_LEFT(19);

        int number;

        private CubeNumber(int number) {
            this.number = number;
        }
    }


}
