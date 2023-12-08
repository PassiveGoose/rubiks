package code.calculation;

import java.util.ArrayList;
import java.util.List;

public class CubesModel {

    public enum CubeNumber {

        TOP_CORNER_LEFT_BACK(0),
        TOP_BORDER_BACK(1),
        TOP_CORNER_BACK_RIGHT(2),
        TOP_BORDER_RIGHT(3),
        TOP_CORNER_RIGHT_FRONT(4),
        TOP_BORDER_FRONT(5),
        TOP_CORNER_FRONT_LEFT(6),
        TOP_BORDER_LEFT(7),
        MID_BORDER_LEFT_BACK(8),
        MID_BORDER_BACK_RIGHT(9),
        MID_BORDER_RIGHT_FRONT(10),
        MID_BORDER_FRONT_LEFT(11),
        BOTTOM_CORNER_LEFT_BACK(12),
        BOTTOM_BORDER_BACK(13),
        BOTTOM_CORNER_BACK_RIGHT(14),
        BOTTOM_BORDER_RIGHT(15),
        BOTTOM_CORNER_RIGHT_FRONT(16),
        BOTTOM_BORDER_FRONT(17),
        BOTTOM_CORNER_FRONT_LEFT(18),
        BOTTOM_BORDER_LEFT(19);

        public final int number;

        CubeNumber(int number) {
            this.number = number;
        }
    }

    private final ArrayList<CubePart> movableCubes = new ArrayList<>();

    private final CubePart topCenter;
    private final CubePart rightCenter;
    private final CubePart leftCenter;
    private final CubePart frontCenter;
    private final CubePart backCenter;
    private final CubePart bottomCenter;

    private final CubeController controller;

    public CubesModel() {
        List<Color> colors = new ArrayList<>();
        colors.add(Color.WHITE);
        colors.add(Color.ORANGE);
        colors.add(Color.GREEN);
        movableCubes.add(CubeNumber.TOP_CORNER_LEFT_BACK.number,
                new CubePart(CubePart.CubeType.CORNER, colors));
        colors.clear();
        colors.add(Color.WHITE);
        colors.add(Color.ORANGE);
        movableCubes.add(CubeNumber.TOP_BORDER_BACK.number,
                new CubePart(CubePart.CubeType.BORDER, colors));
        colors.clear();
        colors.add(Color.WHITE);
        colors.add(Color.ORANGE);
        colors.add(Color.BLUE);
        movableCubes.add(CubeNumber.TOP_CORNER_BACK_RIGHT.number,
                new CubePart(CubePart.CubeType.CORNER, colors));
        colors.clear();
        colors.add(Color.WHITE);
        colors.add(Color.BLUE);
        movableCubes.add(CubeNumber.TOP_BORDER_RIGHT.number,
                new CubePart(CubePart.CubeType.BORDER, colors));
        colors.clear();
        colors.add(Color.WHITE);
        colors.add(Color.RED);
        colors.add(Color.BLUE);
        movableCubes.add(CubeNumber.TOP_CORNER_RIGHT_FRONT.number,
                new CubePart(CubePart.CubeType.CORNER, colors));
        colors.clear();
        colors.add(Color.WHITE);
        colors.add(Color.RED);
        movableCubes.add(CubeNumber.TOP_BORDER_FRONT.number,
                new CubePart(CubePart.CubeType.BORDER, colors));
        colors.clear();
        colors.add(Color.WHITE);
        colors.add(Color.RED);
        colors.add(Color.GREEN);
        movableCubes.add(CubeNumber.TOP_CORNER_FRONT_LEFT.number,
                new CubePart(CubePart.CubeType.CORNER, colors));
        colors.clear();
        colors.add(Color.WHITE);
        colors.add(Color.GREEN);
        movableCubes.add(CubeNumber.TOP_BORDER_LEFT.number,
                new CubePart(CubePart.CubeType.BORDER, colors));
        colors.clear();
        colors.add(Color.ORANGE);
        colors.add(Color.GREEN);
        movableCubes.add(CubeNumber.MID_BORDER_LEFT_BACK.number,
                new CubePart(CubePart.CubeType.BORDER, colors));
        colors.clear();
        colors.add(Color.ORANGE);
        colors.add(Color.BLUE);
        movableCubes.add(CubeNumber.MID_BORDER_BACK_RIGHT.number,
                new CubePart(CubePart.CubeType.BORDER, colors));
        colors.clear();
        colors.add(Color.RED);
        colors.add(Color.BLUE);
        movableCubes.add(CubeNumber.MID_BORDER_RIGHT_FRONT.number,
                new CubePart(CubePart.CubeType.BORDER, colors));
        colors.clear();
        colors.add(Color.RED);
        colors.add(Color.GREEN);
        movableCubes.add(CubeNumber.MID_BORDER_FRONT_LEFT.number,
                new CubePart(CubePart.CubeType.BORDER, colors));
        colors.clear();
        colors.add(Color.YELLOW);
        colors.add(Color.ORANGE);
        colors.add(Color.GREEN);
        movableCubes.add(CubeNumber.BOTTOM_CORNER_LEFT_BACK.number,
                new CubePart(CubePart.CubeType.CORNER, colors));
        colors.clear();
        colors.add(Color.YELLOW);
        colors.add(Color.ORANGE);
        movableCubes.add(CubeNumber.BOTTOM_BORDER_BACK.number,
                new CubePart(CubePart.CubeType.BORDER, colors));
        colors.clear();
        colors.add(Color.YELLOW);
        colors.add(Color.ORANGE);
        colors.add(Color.BLUE);
        movableCubes.add(CubeNumber.BOTTOM_CORNER_BACK_RIGHT.number,
                new CubePart(CubePart.CubeType.CORNER, colors));
        colors.clear();
        colors.add(Color.YELLOW);
        colors.add(Color.BLUE);
        movableCubes.add(CubeNumber.BOTTOM_BORDER_RIGHT.number,
                new CubePart(CubePart.CubeType.BORDER, colors));
        colors.clear();
        colors.add(Color.YELLOW);
        colors.add(Color.RED);
        colors.add(Color.BLUE);
        movableCubes.add(CubeNumber.BOTTOM_CORNER_RIGHT_FRONT.number,
                new CubePart(CubePart.CubeType.CORNER, colors));
        colors.clear();
        colors.add(Color.YELLOW);
        colors.add(Color.RED);
        movableCubes.add(CubeNumber.BOTTOM_BORDER_FRONT.number,
                new CubePart(CubePart.CubeType.BORDER, colors));
        colors.clear();
        colors.add(Color.YELLOW);
        colors.add(Color.RED);
        colors.add(Color.GREEN);
        movableCubes.add(CubeNumber.BOTTOM_CORNER_FRONT_LEFT.number,
                new CubePart(CubePart.CubeType.CORNER, colors));
        colors.clear();
        colors.add(Color.YELLOW);
        colors.add(Color.GREEN);
        movableCubes.add(CubeNumber.BOTTOM_BORDER_LEFT.number,
                new CubePart(CubePart.CubeType.BORDER, colors));
        colors.clear();
        colors.add(Color.WHITE);
        topCenter = new CubePart(CubePart.CubeType.CENTER, colors);
        colors.clear();
        colors.add(Color.BLUE);
        rightCenter = new CubePart(CubePart.CubeType.CENTER, colors);
        colors.clear();
        colors.add(Color.RED);
        frontCenter = new CubePart(CubePart.CubeType.CENTER, colors);
        colors.clear();
        colors.add(Color.ORANGE);
        backCenter = new CubePart(CubePart.CubeType.CENTER, colors);
        colors.clear();
        colors.add(Color.GREEN);
        leftCenter = new CubePart(CubePart.CubeType.CENTER, colors);
        colors.clear();
        colors.add(Color.YELLOW);
        bottomCenter = new CubePart(CubePart.CubeType.CENTER, colors);

        controller = new CubeController(movableCubes, topCenter, rightCenter, leftCenter,
                                        frontCenter, backCenter, bottomCenter);
    }

    public void printModel() {
        System.out.println("top side:");
        System.out.print(movableCubes.get(CubeNumber.TOP_CORNER_LEFT_BACK.number).frontColor + " ");
        System.out.print(movableCubes.get(CubeNumber.TOP_BORDER_BACK.number).frontColor + " ");
        System.out.println(movableCubes.get(CubeNumber.TOP_CORNER_BACK_RIGHT.number).frontColor);
        System.out.print(movableCubes.get(CubeNumber.TOP_BORDER_LEFT.number).frontColor + " ");
        System.out.print(topCenter.frontColor + " ");
        System.out.println(movableCubes.get(CubeNumber.TOP_BORDER_RIGHT.number).frontColor);
        System.out.print(movableCubes.get(CubeNumber.TOP_CORNER_FRONT_LEFT.number).frontColor + " ");
        System.out.print(movableCubes.get(CubeNumber.TOP_BORDER_FRONT.number).frontColor + " ");
        System.out.println(movableCubes.get(CubeNumber.TOP_CORNER_RIGHT_FRONT.number).frontColor);
        System.out.println();

        System.out.println("right side:");
        System.out.print(movableCubes.get(CubeNumber.TOP_CORNER_RIGHT_FRONT.number).cornerColor + " ");
        System.out.print(movableCubes.get(CubeNumber.TOP_BORDER_RIGHT.number).borderColor + " ");
        System.out.println(movableCubes.get(CubeNumber.TOP_CORNER_BACK_RIGHT.number).cornerColor);
        System.out.print(movableCubes.get(CubeNumber.MID_BORDER_RIGHT_FRONT.number).borderColor + " ");
        System.out.print(rightCenter.frontColor + " ");
        System.out.println(movableCubes.get(CubeNumber.MID_BORDER_BACK_RIGHT.number).borderColor);
        System.out.print(movableCubes.get(CubeNumber.BOTTOM_CORNER_RIGHT_FRONT.number).cornerColor + " ");
        System.out.print(movableCubes.get(CubeNumber.BOTTOM_BORDER_RIGHT.number).borderColor + " ");
        System.out.println(movableCubes.get(CubeNumber.BOTTOM_CORNER_BACK_RIGHT.number).cornerColor);
        System.out.println();

        System.out.println("front side:");
        System.out.print(movableCubes.get(CubeNumber.TOP_CORNER_FRONT_LEFT.number).borderColor + " ");
        System.out.print(movableCubes.get(CubeNumber.TOP_BORDER_FRONT.number).borderColor + " ");
        System.out.println(movableCubes.get(CubeNumber.TOP_CORNER_RIGHT_FRONT.number).borderColor);
        System.out.print(movableCubes.get(CubeNumber.MID_BORDER_FRONT_LEFT.number).frontColor + " ");
        System.out.print(frontCenter.frontColor + " ");
        System.out.println(movableCubes.get(CubeNumber.MID_BORDER_RIGHT_FRONT.number).frontColor);
        System.out.print(movableCubes.get(CubeNumber.BOTTOM_CORNER_FRONT_LEFT.number).borderColor + " ");
        System.out.print(movableCubes.get(CubeNumber.BOTTOM_BORDER_FRONT.number).borderColor + " ");
        System.out.println(movableCubes.get(CubeNumber.BOTTOM_CORNER_RIGHT_FRONT.number).borderColor);
        System.out.println();

        System.out.println("left side:");
        System.out.print(movableCubes.get(CubeNumber.TOP_CORNER_LEFT_BACK.number).cornerColor + " ");
        System.out.print(movableCubes.get(CubeNumber.TOP_BORDER_LEFT.number).borderColor + " ");
        System.out.println(movableCubes.get(CubeNumber.TOP_CORNER_FRONT_LEFT.number).cornerColor);
        System.out.print(movableCubes.get(CubeNumber.MID_BORDER_LEFT_BACK.number).borderColor + " ");
        System.out.print(leftCenter.frontColor + " ");
        System.out.println(movableCubes.get(CubeNumber.MID_BORDER_FRONT_LEFT.number).borderColor);
        System.out.print(movableCubes.get(CubeNumber.BOTTOM_CORNER_LEFT_BACK.number).cornerColor + " ");
        System.out.print(movableCubes.get(CubeNumber.BOTTOM_BORDER_LEFT.number).borderColor + " ");
        System.out.println(movableCubes.get(CubeNumber.BOTTOM_CORNER_FRONT_LEFT.number).cornerColor);
        System.out.println();

        System.out.println("back side:");
        System.out.print(movableCubes.get(CubeNumber.TOP_CORNER_BACK_RIGHT.number).borderColor + " ");
        System.out.print(movableCubes.get(CubeNumber.TOP_BORDER_BACK.number).borderColor + " ");
        System.out.println(movableCubes.get(CubeNumber.TOP_CORNER_LEFT_BACK.number).borderColor);
        System.out.print(movableCubes.get(CubeNumber.MID_BORDER_BACK_RIGHT.number).frontColor + " ");
        System.out.print(backCenter.frontColor + " ");
        System.out.println(movableCubes.get(CubeNumber.MID_BORDER_LEFT_BACK.number).frontColor);
        System.out.print(movableCubes.get(CubeNumber.BOTTOM_CORNER_BACK_RIGHT.number).borderColor + " ");
        System.out.print(movableCubes.get(CubeNumber.BOTTOM_BORDER_BACK.number).borderColor + " ");
        System.out.println(movableCubes.get(CubeNumber.BOTTOM_CORNER_LEFT_BACK.number).borderColor);
        System.out.println();

        System.out.println("bottom side:");
        System.out.print(movableCubes.get(CubeNumber.BOTTOM_CORNER_FRONT_LEFT.number).frontColor + " ");
        System.out.print(movableCubes.get(CubeNumber.BOTTOM_BORDER_FRONT.number).frontColor + " ");
        System.out.println(movableCubes.get(CubeNumber.BOTTOM_CORNER_RIGHT_FRONT.number).frontColor);
        System.out.print(movableCubes.get(CubeNumber.BOTTOM_BORDER_LEFT.number).frontColor + " ");
        System.out.print(bottomCenter.frontColor + " ");
        System.out.println(movableCubes.get(CubeNumber.BOTTOM_BORDER_RIGHT.number).frontColor);
        System.out.print(movableCubes.get(CubeNumber.BOTTOM_CORNER_LEFT_BACK.number).frontColor + " ");
        System.out.print(movableCubes.get(CubeNumber.BOTTOM_BORDER_BACK.number).frontColor + " ");
        System.out.println(movableCubes.get(CubeNumber.BOTTOM_CORNER_BACK_RIGHT.number).frontColor);
        System.out.println();
    }

    public Color[][] getTopSide() {
        Color[][] topSide = new Color[3][3];

        topSide[0][0] = movableCubes.get(CubeNumber.TOP_CORNER_LEFT_BACK.number).frontColor;
        topSide[0][1] = movableCubes.get(CubeNumber.TOP_BORDER_BACK.number).frontColor;
        topSide[0][2] = movableCubes.get(CubeNumber.TOP_CORNER_BACK_RIGHT.number).frontColor;
        topSide[1][0] = movableCubes.get(CubeNumber.TOP_BORDER_LEFT.number).frontColor;
        topSide[1][1] = topCenter.frontColor;
        topSide[1][2] = movableCubes.get(CubeNumber.TOP_BORDER_RIGHT.number).frontColor;
        topSide[2][0] = movableCubes.get(CubeNumber.TOP_CORNER_FRONT_LEFT.number).frontColor;
        topSide[2][1] = movableCubes.get(CubeNumber.TOP_BORDER_FRONT.number).frontColor;
        topSide[2][2] = movableCubes.get(CubeNumber.TOP_CORNER_RIGHT_FRONT.number).frontColor;

        return topSide;
    }

    public Color[][] getFrontSide() {
        Color[][] frontSide = new Color[3][3];

        frontSide[0][0] = movableCubes.get(CubeNumber.TOP_CORNER_FRONT_LEFT.number).borderColor;
        frontSide[0][1] = movableCubes.get(CubeNumber.TOP_BORDER_FRONT.number).borderColor;
        frontSide[0][2] = movableCubes.get(CubeNumber.TOP_CORNER_RIGHT_FRONT.number).borderColor;
        frontSide[1][0] = movableCubes.get(CubeNumber.MID_BORDER_FRONT_LEFT.number).frontColor;
        frontSide[1][1] = frontCenter.frontColor;
        frontSide[1][2] = movableCubes.get(CubeNumber.MID_BORDER_RIGHT_FRONT.number).frontColor;
        frontSide[2][0] = movableCubes.get(CubeNumber.BOTTOM_CORNER_FRONT_LEFT.number).borderColor;
        frontSide[2][1] = movableCubes.get(CubeNumber.BOTTOM_BORDER_FRONT.number).borderColor;
        frontSide[2][2] = movableCubes.get(CubeNumber.BOTTOM_CORNER_RIGHT_FRONT.number).borderColor;

        return frontSide;
    }

    public Color[][] getDownSide() {
        Color[][] downSide = new Color[3][3];

        downSide[0][0] = movableCubes.get(CubeNumber.BOTTOM_CORNER_FRONT_LEFT.number).frontColor;
        downSide[0][1] = movableCubes.get(CubeNumber.BOTTOM_BORDER_FRONT.number).frontColor;
        downSide[0][2] = movableCubes.get(CubeNumber.BOTTOM_CORNER_RIGHT_FRONT.number).frontColor;
        downSide[1][0] = movableCubes.get(CubeNumber.BOTTOM_BORDER_LEFT.number).frontColor;
        downSide[1][1] = bottomCenter.frontColor;
        downSide[1][2] = movableCubes.get(CubeNumber.BOTTOM_BORDER_RIGHT.number).frontColor;
        downSide[2][0] = movableCubes.get(CubeNumber.BOTTOM_CORNER_LEFT_BACK.number).frontColor;
        downSide[2][1] = movableCubes.get(CubeNumber.BOTTOM_BORDER_BACK.number).frontColor;
        downSide[2][2] = movableCubes.get(CubeNumber.BOTTOM_CORNER_BACK_RIGHT.number).frontColor;

        return downSide;
    }

    public CubeController getController() {
        return controller;
    }

    public ArrayList<CubePart> getMovableCubes() {
        return movableCubes;
    }

    public CubePart getFrontCenter() {
        return frontCenter;
    }

    public CubePart getRightCenter() {
        return rightCenter;
    }
}
