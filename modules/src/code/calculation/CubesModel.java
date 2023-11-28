package code.calculation;

import java.util.ArrayList;
import java.util.List;

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

        int number;

        private CubeNumber(int number) {
            this.number = number;
        }
    }

    private ArrayList<CubePartition> movableCubes = new ArrayList<>();

    private CubePartition topCenter;
    private CubePartition rightCenter;
    private CubePartition leftCenter;
    private CubePartition frontCenter;
    private CubePartition backCenter;
    private CubePartition bottomCenter;

    public CubesModel() {
        List<Color> colors = new ArrayList<>();
        colors.add(Color.WHITE);
        colors.add(Color.ORANGE);
        colors.add(Color.GREEN);
        movableCubes.add(CubeNumber.TOP_CORNER_LEFT_BACK.number,
                new CubePartition(CubePartition.CubeType.CORNER, colors));
        colors.clear();
        colors.add(Color.WHITE);
        colors.add(Color.ORANGE);
        movableCubes.add(CubeNumber.TOP_BORDER_BACK.number,
                new CubePartition(CubePartition.CubeType.BORDER, colors));
        colors.clear();
        colors.add(Color.WHITE);
        colors.add(Color.ORANGE);
        colors.add(Color.BLUE);
        movableCubes.add(CubeNumber.TOP_CORNER_BACK_RIGHT.number,
                new CubePartition(CubePartition.CubeType.CORNER, colors));
        colors.clear();
        colors.add(Color.WHITE);
        colors.add(Color.BLUE);
        movableCubes.add(CubeNumber.TOP_BORDER_RIGHT.number,
                new CubePartition(CubePartition.CubeType.BORDER, colors));
        colors.clear();
        colors.add(Color.WHITE);
        colors.add(Color.RED);
        colors.add(Color.BLUE);
        movableCubes.add(CubeNumber.TOP_CORNER_RIGHT_FRONT.number,
                new CubePartition(CubePartition.CubeType.CORNER, colors));
        colors.clear();
        colors.add(Color.WHITE);
        colors.add(Color.RED);
        movableCubes.add(CubeNumber.TOP_BORDER_FRONT.number,
                new CubePartition(CubePartition.CubeType.BORDER, colors));
        colors.clear();
        colors.add(Color.WHITE);
        colors.add(Color.RED);
        colors.add(Color.GREEN);
        movableCubes.add(CubeNumber.TOP_CORNER_FRONT_LEFT.number,
                new CubePartition(CubePartition.CubeType.CORNER, colors));
        colors.clear();
        colors.add(Color.WHITE);
        colors.add(Color.GREEN);
        movableCubes.add(CubeNumber.TOP_BORDER_LEFT.number,
                new CubePartition(CubePartition.CubeType.BORDER, colors));
        colors.clear();
        colors.add(Color.ORANGE);
        colors.add(Color.GREEN);
        movableCubes.add(CubeNumber.MID_BORDER_LEFT_BACK.number,
                new CubePartition(CubePartition.CubeType.BORDER, colors));
        colors.clear();
        colors.add(Color.ORANGE);
        colors.add(Color.BLUE);
        movableCubes.add(CubeNumber.MID_BORDER_BACK_RIGHT.number,
                new CubePartition(CubePartition.CubeType.BORDER, colors));
        colors.clear();
        colors.add(Color.RED);
        colors.add(Color.BLUE);
        movableCubes.add(CubeNumber.MID_BORDER_RIGHT_FRONT.number,
                new CubePartition(CubePartition.CubeType.BORDER, colors));
        colors.clear();
        colors.add(Color.RED);
        colors.add(Color.GREEN);
        movableCubes.add(CubeNumber.MID_BORDER_FRONT_LEFT.number,
                new CubePartition(CubePartition.CubeType.BORDER, colors));
        colors.clear();
        colors.add(Color.YELLOW);
        colors.add(Color.ORANGE);
        colors.add(Color.GREEN);
        movableCubes.add(CubeNumber.BOTTOM_CORNER_LEFT_BACK.number,
                new CubePartition(CubePartition.CubeType.CORNER, colors));
        colors.clear();
        colors.add(Color.YELLOW);
        colors.add(Color.ORANGE);
        movableCubes.add(CubeNumber.BOTTOM_BORDER_BACK.number,
                new CubePartition(CubePartition.CubeType.BORDER, colors));
        colors.clear();
        colors.add(Color.YELLOW);
        colors.add(Color.ORANGE);
        colors.add(Color.BLUE);
        movableCubes.add(CubeNumber.BOTTOM_CORNER_BACK_RIGHT.number,
                new CubePartition(CubePartition.CubeType.CORNER, colors));
        colors.clear();
        colors.add(Color.YELLOW);
        colors.add(Color.BLUE);
        movableCubes.add(CubeNumber.BOTTOM_BORDER_RIGHT.number,
                new CubePartition(CubePartition.CubeType.BORDER, colors));
        colors.clear();
        colors.add(Color.YELLOW);
        colors.add(Color.RED);
        colors.add(Color.BLUE);
        movableCubes.add(CubeNumber.BOTTOM_CORNER_RIGHT_FRONT.number,
                new CubePartition(CubePartition.CubeType.CORNER, colors));
        colors.clear();
        colors.add(Color.YELLOW);
        colors.add(Color.RED);
        movableCubes.add(CubeNumber.BOTTOM_BORDER_FRONT.number,
                new CubePartition(CubePartition.CubeType.BORDER, colors));
        colors.clear();
        colors.add(Color.YELLOW);
        colors.add(Color.RED);
        colors.add(Color.GREEN);
        movableCubes.add(CubeNumber.BOTTOM_CORNER_FRONT_LEFT.number,
                new CubePartition(CubePartition.CubeType.CORNER, colors));
        colors.clear();
        colors.add(Color.YELLOW);
        colors.add(Color.GREEN);
        movableCubes.add(CubeNumber.BOTTOM_BORDER_LEFT.number,
                new CubePartition(CubePartition.CubeType.BORDER, colors));
        colors.clear();
        colors.add(Color.WHITE);
        topCenter = new CubePartition(CubePartition.CubeType.CENTER, colors);
        colors.clear();
        colors.add(Color.BLUE);
        rightCenter = new CubePartition(CubePartition.CubeType.CENTER, colors);
        colors.clear();
        colors.add(Color.RED);
        frontCenter = new CubePartition(CubePartition.CubeType.CENTER, colors);
        colors.clear();
        colors.add(Color.ORANGE);
        backCenter = new CubePartition(CubePartition.CubeType.CENTER, colors);
        colors.clear();
        colors.add(Color.GREEN);
        leftCenter = new CubePartition(CubePartition.CubeType.CENTER, colors);
        colors.clear();
        colors.add(Color.YELLOW);
        bottomCenter = new CubePartition(CubePartition.CubeType.CENTER, colors);

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




    }

}
