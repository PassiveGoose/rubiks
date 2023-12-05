package code.calculation;

import java.util.ArrayList;

public class CubeController {

    private final ArrayList<CubePartition> movableCubes;

    private final CubePartition topCenter;
    private final CubePartition rightCenter;
    private final CubePartition leftCenter;
    private final CubePartition frontCenter;
    private final CubePartition backCenter;
    private final CubePartition bottomCenter;

    public CubeController(ArrayList<CubePartition> movableCubes, CubePartition topCenter, CubePartition rightCenter,
                                                                 CubePartition leftCenter, CubePartition frontCenter,
                                                                 CubePartition backCenter, CubePartition bottomCenter) {
        this.movableCubes = movableCubes;
        this.topCenter = topCenter;
        this.rightCenter = rightCenter;
        this.leftCenter = leftCenter;
        this.frontCenter = frontCenter;
        this.backCenter = backCenter;
        this.bottomCenter = bottomCenter;
    }

    public void positiveR() {
        //rotate corners
        CubePartition tmpCorner = movableCubes.get(CubesModel.CubeNumber.TOP_CORNER_RIGHT_FRONT.number);
        movableCubes.set(CubesModel.CubeNumber.TOP_CORNER_RIGHT_FRONT.number,
                movableCubes.get(CubesModel.CubeNumber.BOTTOM_CORNER_RIGHT_FRONT.number));

        movableCubes.set(CubesModel.CubeNumber.BOTTOM_CORNER_RIGHT_FRONT.number,
                movableCubes.get(CubesModel.CubeNumber.BOTTOM_CORNER_BACK_RIGHT.number));

        movableCubes.set(CubesModel.CubeNumber.BOTTOM_CORNER_BACK_RIGHT.number,
                movableCubes.get(CubesModel.CubeNumber.TOP_CORNER_BACK_RIGHT.number));

        movableCubes.set(CubesModel.CubeNumber.TOP_CORNER_BACK_RIGHT.number, tmpCorner);

        rotateCornerColorsR();

        //rotate borders
        CubePartition tmpBorder = movableCubes.get(CubesModel.CubeNumber.TOP_BORDER_RIGHT.number);
        movableCubes.set(CubesModel.CubeNumber.TOP_BORDER_RIGHT.number,
                movableCubes.get(CubesModel.CubeNumber.MID_BORDER_RIGHT_FRONT.number));

        movableCubes.set(CubesModel.CubeNumber.MID_BORDER_RIGHT_FRONT.number,
                movableCubes.get(CubesModel.CubeNumber.BOTTOM_BORDER_RIGHT.number));

        movableCubes.set(CubesModel.CubeNumber.BOTTOM_BORDER_RIGHT.number,
                movableCubes.get(CubesModel.CubeNumber.MID_BORDER_BACK_RIGHT.number));

        movableCubes.set(CubesModel.CubeNumber.MID_BORDER_BACK_RIGHT.number, tmpBorder);
    }

    public void negativeR() {
        //rotate corners
        CubePartition tmpCorner = movableCubes.get(CubesModel.CubeNumber.TOP_CORNER_RIGHT_FRONT.number);
        movableCubes.set(CubesModel.CubeNumber.TOP_CORNER_RIGHT_FRONT.number,
                movableCubes.get(CubesModel.CubeNumber.TOP_CORNER_BACK_RIGHT.number));

        movableCubes.set(CubesModel.CubeNumber.TOP_CORNER_BACK_RIGHT.number,
                movableCubes.get(CubesModel.CubeNumber.BOTTOM_CORNER_BACK_RIGHT.number));

        movableCubes.set(CubesModel.CubeNumber.BOTTOM_CORNER_BACK_RIGHT.number,
                movableCubes.get(CubesModel.CubeNumber.BOTTOM_CORNER_RIGHT_FRONT.number));

        movableCubes.set(CubesModel.CubeNumber.BOTTOM_CORNER_RIGHT_FRONT.number, tmpCorner);

        rotateCornerColorsR();

        //rotate borders
        CubePartition tmpBorder = movableCubes.get(CubesModel.CubeNumber.TOP_BORDER_RIGHT.number);
        movableCubes.set(CubesModel.CubeNumber.TOP_BORDER_RIGHT.number,
                movableCubes.get(CubesModel.CubeNumber.MID_BORDER_BACK_RIGHT.number));

        movableCubes.set(CubesModel.CubeNumber.MID_BORDER_BACK_RIGHT.number,
                movableCubes.get(CubesModel.CubeNumber.BOTTOM_BORDER_RIGHT.number));

        movableCubes.set(CubesModel.CubeNumber.BOTTOM_BORDER_RIGHT.number,
                movableCubes.get(CubesModel.CubeNumber.MID_BORDER_RIGHT_FRONT.number));

        movableCubes.set(CubesModel.CubeNumber.MID_BORDER_RIGHT_FRONT.number, tmpBorder);
    }

    private void rotateCornerColorsR() {
        Color tmpColor = movableCubes.get(CubesModel.CubeNumber.TOP_CORNER_RIGHT_FRONT.number).frontColor;
        movableCubes.get(CubesModel.CubeNumber.TOP_CORNER_RIGHT_FRONT.number).frontColor =
                movableCubes.get(CubesModel.CubeNumber.TOP_CORNER_RIGHT_FRONT.number).borderColor;
        movableCubes.get(CubesModel.CubeNumber.TOP_CORNER_RIGHT_FRONT.number).borderColor = tmpColor;
        tmpColor = movableCubes.get(CubesModel.CubeNumber.BOTTOM_CORNER_RIGHT_FRONT.number).frontColor;
        movableCubes.get(CubesModel.CubeNumber.BOTTOM_CORNER_RIGHT_FRONT.number).frontColor =
                movableCubes.get(CubesModel.CubeNumber.BOTTOM_CORNER_RIGHT_FRONT.number).borderColor;
        movableCubes.get(CubesModel.CubeNumber.BOTTOM_CORNER_RIGHT_FRONT.number).borderColor = tmpColor;
        tmpColor = movableCubes.get(CubesModel.CubeNumber.BOTTOM_CORNER_BACK_RIGHT.number).frontColor;
        movableCubes.get(CubesModel.CubeNumber.BOTTOM_CORNER_BACK_RIGHT.number).frontColor =
                movableCubes.get(CubesModel.CubeNumber.BOTTOM_CORNER_BACK_RIGHT.number).borderColor;
        movableCubes.get(CubesModel.CubeNumber.BOTTOM_CORNER_BACK_RIGHT.number).borderColor = tmpColor;
        tmpColor = movableCubes.get(CubesModel.CubeNumber.TOP_CORNER_BACK_RIGHT.number).frontColor;
        movableCubes.get(CubesModel.CubeNumber.TOP_CORNER_BACK_RIGHT.number).frontColor =
                movableCubes.get(CubesModel.CubeNumber.TOP_CORNER_BACK_RIGHT.number).borderColor;
        movableCubes.get(CubesModel.CubeNumber.TOP_CORNER_BACK_RIGHT.number).borderColor = tmpColor;
    }

    public void negativeL() {
        //rotate corners
        CubePartition tmpCorner = movableCubes.get(CubesModel.CubeNumber.TOP_CORNER_FRONT_LEFT.number);
        movableCubes.set(CubesModel.CubeNumber.TOP_CORNER_FRONT_LEFT.number,
                movableCubes.get(CubesModel.CubeNumber.BOTTOM_CORNER_FRONT_LEFT.number));

        movableCubes.set(CubesModel.CubeNumber.BOTTOM_CORNER_FRONT_LEFT.number,
                movableCubes.get(CubesModel.CubeNumber.BOTTOM_CORNER_LEFT_BACK.number));

        movableCubes.set(CubesModel.CubeNumber.BOTTOM_CORNER_LEFT_BACK.number,
                movableCubes.get(CubesModel.CubeNumber.TOP_CORNER_LEFT_BACK.number));

        movableCubes.set(CubesModel.CubeNumber.TOP_CORNER_LEFT_BACK.number, tmpCorner);

        rotateCornerColorsL();

        //rotate borders
        CubePartition tmpBorder = movableCubes.get(CubesModel.CubeNumber.TOP_BORDER_LEFT.number);
        movableCubes.set(CubesModel.CubeNumber.TOP_BORDER_LEFT.number,
                movableCubes.get(CubesModel.CubeNumber.MID_BORDER_FRONT_LEFT.number));

        movableCubes.set(CubesModel.CubeNumber.MID_BORDER_FRONT_LEFT.number,
                movableCubes.get(CubesModel.CubeNumber.BOTTOM_BORDER_LEFT.number));

        movableCubes.set(CubesModel.CubeNumber.BOTTOM_BORDER_LEFT.number,
                movableCubes.get(CubesModel.CubeNumber.MID_BORDER_LEFT_BACK.number));

        movableCubes.set(CubesModel.CubeNumber.MID_BORDER_LEFT_BACK.number, tmpBorder);
    }

    public void positiveL() {
        //rotate corners
        CubePartition tmpCorner = movableCubes.get(CubesModel.CubeNumber.TOP_CORNER_FRONT_LEFT.number);
        movableCubes.set(CubesModel.CubeNumber.TOP_CORNER_FRONT_LEFT.number,
                movableCubes.get(CubesModel.CubeNumber.TOP_CORNER_LEFT_BACK.number));

        movableCubes.set(CubesModel.CubeNumber.TOP_CORNER_LEFT_BACK.number,
                movableCubes.get(CubesModel.CubeNumber.BOTTOM_CORNER_LEFT_BACK.number));

        movableCubes.set(CubesModel.CubeNumber.BOTTOM_CORNER_LEFT_BACK.number,
                movableCubes.get(CubesModel.CubeNumber.BOTTOM_CORNER_FRONT_LEFT.number));

        movableCubes.set(CubesModel.CubeNumber.BOTTOM_CORNER_FRONT_LEFT.number, tmpCorner);

        rotateCornerColorsL();

        //rotate borders
        CubePartition tmpBorder = movableCubes.get(CubesModel.CubeNumber.TOP_BORDER_LEFT.number);
        movableCubes.set(CubesModel.CubeNumber.TOP_BORDER_LEFT.number,
                movableCubes.get(CubesModel.CubeNumber.MID_BORDER_LEFT_BACK.number));

        movableCubes.set(CubesModel.CubeNumber.MID_BORDER_LEFT_BACK.number,
                movableCubes.get(CubesModel.CubeNumber.BOTTOM_BORDER_LEFT.number));

        movableCubes.set(CubesModel.CubeNumber.BOTTOM_BORDER_LEFT.number,
                movableCubes.get(CubesModel.CubeNumber.MID_BORDER_FRONT_LEFT.number));

        movableCubes.set(CubesModel.CubeNumber.MID_BORDER_FRONT_LEFT.number, tmpBorder);
    }

    private void rotateCornerColorsL() {
        Color tmpColor = movableCubes.get(CubesModel.CubeNumber.TOP_CORNER_FRONT_LEFT.number).frontColor;
        movableCubes.get(CubesModel.CubeNumber.TOP_CORNER_FRONT_LEFT.number).frontColor =
                movableCubes.get(CubesModel.CubeNumber.TOP_CORNER_FRONT_LEFT.number).borderColor;
        movableCubes.get(CubesModel.CubeNumber.TOP_CORNER_FRONT_LEFT.number).borderColor = tmpColor;
        tmpColor = movableCubes.get(CubesModel.CubeNumber.BOTTOM_CORNER_FRONT_LEFT.number).frontColor;
        movableCubes.get(CubesModel.CubeNumber.BOTTOM_CORNER_FRONT_LEFT.number).frontColor =
                movableCubes.get(CubesModel.CubeNumber.BOTTOM_CORNER_FRONT_LEFT.number).borderColor;
        movableCubes.get(CubesModel.CubeNumber.BOTTOM_CORNER_FRONT_LEFT.number).borderColor = tmpColor;
        tmpColor = movableCubes.get(CubesModel.CubeNumber.BOTTOM_CORNER_LEFT_BACK.number).frontColor;
        movableCubes.get(CubesModel.CubeNumber.BOTTOM_CORNER_LEFT_BACK.number).frontColor =
                movableCubes.get(CubesModel.CubeNumber.BOTTOM_CORNER_LEFT_BACK.number).borderColor;
        movableCubes.get(CubesModel.CubeNumber.BOTTOM_CORNER_LEFT_BACK.number).borderColor = tmpColor;
        tmpColor = movableCubes.get(CubesModel.CubeNumber.TOP_CORNER_LEFT_BACK.number).frontColor;
        movableCubes.get(CubesModel.CubeNumber.TOP_CORNER_LEFT_BACK.number).frontColor =
                movableCubes.get(CubesModel.CubeNumber.TOP_CORNER_LEFT_BACK.number).borderColor;
        movableCubes.get(CubesModel.CubeNumber.TOP_CORNER_LEFT_BACK.number).borderColor = tmpColor;
    }

    public void positiveF() {
        //rotate corners
        CubePartition tmpCorner = movableCubes.get(CubesModel.CubeNumber.TOP_CORNER_FRONT_LEFT.number);
        movableCubes.set(CubesModel.CubeNumber.TOP_CORNER_FRONT_LEFT.number,
                movableCubes.get(CubesModel.CubeNumber.BOTTOM_CORNER_FRONT_LEFT.number));

        movableCubes.set(CubesModel.CubeNumber.BOTTOM_CORNER_FRONT_LEFT.number,
                movableCubes.get(CubesModel.CubeNumber.BOTTOM_CORNER_RIGHT_FRONT.number));

        movableCubes.set(CubesModel.CubeNumber.BOTTOM_CORNER_RIGHT_FRONT.number,
                movableCubes.get(CubesModel.CubeNumber.TOP_CORNER_RIGHT_FRONT.number));

        movableCubes.set(CubesModel.CubeNumber.TOP_CORNER_RIGHT_FRONT.number, tmpCorner);

        rotateCornerColorsF();

        //rotate borders
        CubePartition tmpBorder = movableCubes.get(CubesModel.CubeNumber.TOP_BORDER_FRONT.number);
        movableCubes.set(CubesModel.CubeNumber.TOP_BORDER_FRONT.number,
                movableCubes.get(CubesModel.CubeNumber.MID_BORDER_FRONT_LEFT.number));

        movableCubes.set(CubesModel.CubeNumber.MID_BORDER_FRONT_LEFT.number,
                movableCubes.get(CubesModel.CubeNumber.BOTTOM_BORDER_FRONT.number));

        movableCubes.set(CubesModel.CubeNumber.BOTTOM_BORDER_FRONT.number,
                movableCubes.get(CubesModel.CubeNumber.MID_BORDER_RIGHT_FRONT.number));

        movableCubes.set(CubesModel.CubeNumber.MID_BORDER_RIGHT_FRONT.number, tmpBorder);
    }

    public void negativeF() {
        //rotate corners
        CubePartition tmpCorner = movableCubes.get(CubesModel.CubeNumber.TOP_CORNER_FRONT_LEFT.number);
        movableCubes.set(CubesModel.CubeNumber.TOP_CORNER_FRONT_LEFT.number,
                movableCubes.get(CubesModel.CubeNumber.TOP_CORNER_RIGHT_FRONT.number));

        movableCubes.set(CubesModel.CubeNumber.TOP_CORNER_RIGHT_FRONT.number,
                movableCubes.get(CubesModel.CubeNumber.BOTTOM_CORNER_RIGHT_FRONT.number));

        movableCubes.set(CubesModel.CubeNumber.BOTTOM_CORNER_RIGHT_FRONT.number,
                movableCubes.get(CubesModel.CubeNumber.BOTTOM_CORNER_FRONT_LEFT.number));

        movableCubes.set(CubesModel.CubeNumber.BOTTOM_CORNER_FRONT_LEFT.number, tmpCorner);

        rotateCornerColorsF();

        //rotate borders
        CubePartition tmpBorder = movableCubes.get(CubesModel.CubeNumber.TOP_BORDER_FRONT.number);
        movableCubes.set(CubesModel.CubeNumber.TOP_BORDER_FRONT.number,
                movableCubes.get(CubesModel.CubeNumber.MID_BORDER_RIGHT_FRONT.number));

        movableCubes.set(CubesModel.CubeNumber.MID_BORDER_RIGHT_FRONT.number,
                movableCubes.get(CubesModel.CubeNumber.BOTTOM_BORDER_FRONT.number));

        movableCubes.set(CubesModel.CubeNumber.BOTTOM_BORDER_FRONT.number,
                movableCubes.get(CubesModel.CubeNumber.MID_BORDER_FRONT_LEFT.number));

        movableCubes.set(CubesModel.CubeNumber.MID_BORDER_FRONT_LEFT.number, tmpBorder);
    }

    private void rotateCornerColorsF() {
        Color tmpColor = movableCubes.get(CubesModel.CubeNumber.TOP_CORNER_FRONT_LEFT.number).frontColor;
        movableCubes.get(CubesModel.CubeNumber.TOP_CORNER_FRONT_LEFT.number).frontColor =
                movableCubes.get(CubesModel.CubeNumber.TOP_CORNER_FRONT_LEFT.number).cornerColor;
        movableCubes.get(CubesModel.CubeNumber.TOP_CORNER_FRONT_LEFT.number).cornerColor = tmpColor;
        tmpColor = movableCubes.get(CubesModel.CubeNumber.TOP_CORNER_RIGHT_FRONT.number).frontColor;
        movableCubes.get(CubesModel.CubeNumber.TOP_CORNER_RIGHT_FRONT.number).frontColor =
                movableCubes.get(CubesModel.CubeNumber.TOP_CORNER_RIGHT_FRONT.number).cornerColor;
        movableCubes.get(CubesModel.CubeNumber.TOP_CORNER_RIGHT_FRONT.number).cornerColor = tmpColor;
        tmpColor = movableCubes.get(CubesModel.CubeNumber.BOTTOM_CORNER_RIGHT_FRONT.number).frontColor;
        movableCubes.get(CubesModel.CubeNumber.BOTTOM_CORNER_RIGHT_FRONT.number).frontColor =
                movableCubes.get(CubesModel.CubeNumber.BOTTOM_CORNER_RIGHT_FRONT.number).cornerColor;
        movableCubes.get(CubesModel.CubeNumber.BOTTOM_CORNER_RIGHT_FRONT.number).cornerColor = tmpColor;
        tmpColor = movableCubes.get(CubesModel.CubeNumber.BOTTOM_CORNER_FRONT_LEFT.number).frontColor;
        movableCubes.get(CubesModel.CubeNumber.BOTTOM_CORNER_FRONT_LEFT.number).frontColor =
                movableCubes.get(CubesModel.CubeNumber.BOTTOM_CORNER_FRONT_LEFT.number).cornerColor;
        movableCubes.get(CubesModel.CubeNumber.BOTTOM_CORNER_FRONT_LEFT.number).cornerColor = tmpColor;

        tmpColor = movableCubes.get(CubesModel.CubeNumber.TOP_BORDER_FRONT.number).frontColor;
        movableCubes.get(CubesModel.CubeNumber.TOP_BORDER_FRONT.number).frontColor =
                movableCubes.get(CubesModel.CubeNumber.TOP_BORDER_FRONT.number).borderColor;
        movableCubes.get(CubesModel.CubeNumber.TOP_BORDER_FRONT.number).borderColor = tmpColor;
        tmpColor = movableCubes.get(CubesModel.CubeNumber.MID_BORDER_RIGHT_FRONT.number).frontColor;
        movableCubes.get(CubesModel.CubeNumber.MID_BORDER_RIGHT_FRONT.number).frontColor =
                movableCubes.get(CubesModel.CubeNumber.MID_BORDER_RIGHT_FRONT.number).borderColor;
        movableCubes.get(CubesModel.CubeNumber.MID_BORDER_RIGHT_FRONT.number).borderColor = tmpColor;
        tmpColor = movableCubes.get(CubesModel.CubeNumber.BOTTOM_BORDER_FRONT.number).frontColor;
        movableCubes.get(CubesModel.CubeNumber.BOTTOM_BORDER_FRONT.number).frontColor =
                movableCubes.get(CubesModel.CubeNumber.BOTTOM_BORDER_FRONT.number).borderColor;
        movableCubes.get(CubesModel.CubeNumber.BOTTOM_BORDER_FRONT.number).borderColor = tmpColor;
        tmpColor = movableCubes.get(CubesModel.CubeNumber.MID_BORDER_FRONT_LEFT.number).frontColor;
        movableCubes.get(CubesModel.CubeNumber.MID_BORDER_FRONT_LEFT.number).frontColor =
                movableCubes.get(CubesModel.CubeNumber.MID_BORDER_FRONT_LEFT.number).borderColor;
        movableCubes.get(CubesModel.CubeNumber.MID_BORDER_FRONT_LEFT.number).borderColor = tmpColor;
    }

    public void positiveT() {
        //rotate corners
        CubePartition tmpCorner = movableCubes.get(CubesModel.CubeNumber.TOP_CORNER_FRONT_LEFT.number);
        movableCubes.set(CubesModel.CubeNumber.TOP_CORNER_FRONT_LEFT.number,
                movableCubes.get(CubesModel.CubeNumber.TOP_CORNER_RIGHT_FRONT.number));

        movableCubes.set(CubesModel.CubeNumber.TOP_CORNER_RIGHT_FRONT.number,
                movableCubes.get(CubesModel.CubeNumber.TOP_CORNER_BACK_RIGHT.number));

        movableCubes.set(CubesModel.CubeNumber.TOP_CORNER_BACK_RIGHT.number,
                movableCubes.get(CubesModel.CubeNumber.TOP_CORNER_LEFT_BACK.number));

        movableCubes.set(CubesModel.CubeNumber.TOP_CORNER_LEFT_BACK.number, tmpCorner);

        rotateCornerColorsT();

        //rotate borders
        CubePartition tmpBorder = movableCubes.get(CubesModel.CubeNumber.TOP_BORDER_FRONT.number);
        movableCubes.set(CubesModel.CubeNumber.TOP_BORDER_FRONT.number,
                movableCubes.get(CubesModel.CubeNumber.TOP_BORDER_RIGHT.number));

        movableCubes.set(CubesModel.CubeNumber.TOP_BORDER_RIGHT.number,
                movableCubes.get(CubesModel.CubeNumber.TOP_BORDER_BACK.number));

        movableCubes.set(CubesModel.CubeNumber.TOP_BORDER_BACK.number,
                movableCubes.get(CubesModel.CubeNumber.TOP_BORDER_LEFT.number));

        movableCubes.set(CubesModel.CubeNumber.TOP_BORDER_LEFT.number, tmpBorder);
    }

    public void negativeT() {
        //rotate corners
        CubePartition tmpCorner = movableCubes.get(CubesModel.CubeNumber.TOP_CORNER_FRONT_LEFT.number);
        movableCubes.set(CubesModel.CubeNumber.TOP_CORNER_FRONT_LEFT.number,
                movableCubes.get(CubesModel.CubeNumber.TOP_CORNER_LEFT_BACK.number));

        movableCubes.set(CubesModel.CubeNumber.TOP_CORNER_LEFT_BACK.number,
                movableCubes.get(CubesModel.CubeNumber.TOP_CORNER_BACK_RIGHT.number));

        movableCubes.set(CubesModel.CubeNumber.TOP_CORNER_BACK_RIGHT.number,
                movableCubes.get(CubesModel.CubeNumber.TOP_CORNER_RIGHT_FRONT.number));

        movableCubes.set(CubesModel.CubeNumber.TOP_CORNER_RIGHT_FRONT.number, tmpCorner);

        rotateCornerColorsT();

        //rotate borders
        CubePartition tmpBorder = movableCubes.get(CubesModel.CubeNumber.TOP_BORDER_FRONT.number);
        movableCubes.set(CubesModel.CubeNumber.TOP_BORDER_FRONT.number,
                movableCubes.get(CubesModel.CubeNumber.TOP_BORDER_LEFT.number));

        movableCubes.set(CubesModel.CubeNumber.TOP_BORDER_LEFT.number,
                movableCubes.get(CubesModel.CubeNumber.TOP_BORDER_BACK.number));

        movableCubes.set(CubesModel.CubeNumber.TOP_BORDER_BACK.number,
                movableCubes.get(CubesModel.CubeNumber.TOP_BORDER_RIGHT.number));

        movableCubes.set(CubesModel.CubeNumber.TOP_BORDER_RIGHT.number, tmpBorder);
    }

    private void rotateCornerColorsT() {
        Color tmpColor = movableCubes.get(CubesModel.CubeNumber.TOP_CORNER_FRONT_LEFT.number).borderColor;
        movableCubes.get(CubesModel.CubeNumber.TOP_CORNER_FRONT_LEFT.number).borderColor =
                movableCubes.get(CubesModel.CubeNumber.TOP_CORNER_FRONT_LEFT.number).cornerColor;
        movableCubes.get(CubesModel.CubeNumber.TOP_CORNER_FRONT_LEFT.number).cornerColor = tmpColor;
        tmpColor = movableCubes.get(CubesModel.CubeNumber.TOP_CORNER_RIGHT_FRONT.number).borderColor;
        movableCubes.get(CubesModel.CubeNumber.TOP_CORNER_RIGHT_FRONT.number).borderColor =
                movableCubes.get(CubesModel.CubeNumber.TOP_CORNER_RIGHT_FRONT.number).cornerColor;
        movableCubes.get(CubesModel.CubeNumber.TOP_CORNER_RIGHT_FRONT.number).cornerColor = tmpColor;
        tmpColor = movableCubes.get(CubesModel.CubeNumber.TOP_CORNER_LEFT_BACK.number).borderColor;
        movableCubes.get(CubesModel.CubeNumber.TOP_CORNER_LEFT_BACK.number).borderColor =
                movableCubes.get(CubesModel.CubeNumber.TOP_CORNER_LEFT_BACK.number).cornerColor;
        movableCubes.get(CubesModel.CubeNumber.TOP_CORNER_LEFT_BACK.number).cornerColor = tmpColor;
        tmpColor = movableCubes.get(CubesModel.CubeNumber.TOP_CORNER_BACK_RIGHT.number).borderColor;
        movableCubes.get(CubesModel.CubeNumber.TOP_CORNER_BACK_RIGHT.number).borderColor =
                movableCubes.get(CubesModel.CubeNumber.TOP_CORNER_BACK_RIGHT.number).cornerColor;
        movableCubes.get(CubesModel.CubeNumber.TOP_CORNER_BACK_RIGHT.number).cornerColor = tmpColor;
    }

    public void positiveB() {
        //rotate corners
        CubePartition tmpCorner = movableCubes.get(CubesModel.CubeNumber.TOP_CORNER_BACK_RIGHT.number);
        movableCubes.set(CubesModel.CubeNumber.TOP_CORNER_BACK_RIGHT.number,
                movableCubes.get(CubesModel.CubeNumber.BOTTOM_CORNER_BACK_RIGHT.number));

        movableCubes.set(CubesModel.CubeNumber.BOTTOM_CORNER_BACK_RIGHT.number,
                movableCubes.get(CubesModel.CubeNumber.BOTTOM_CORNER_LEFT_BACK.number));

        movableCubes.set(CubesModel.CubeNumber.BOTTOM_CORNER_LEFT_BACK.number,
                movableCubes.get(CubesModel.CubeNumber.TOP_CORNER_LEFT_BACK.number));

        movableCubes.set(CubesModel.CubeNumber.TOP_CORNER_LEFT_BACK.number, tmpCorner);

        rotateCornerColorsB();

        //rotate borders
        CubePartition tmpBorder = movableCubes.get(CubesModel.CubeNumber.TOP_BORDER_BACK.number);
        movableCubes.set(CubesModel.CubeNumber.TOP_BORDER_BACK.number,
                movableCubes.get(CubesModel.CubeNumber.MID_BORDER_BACK_RIGHT.number));

        movableCubes.set(CubesModel.CubeNumber.MID_BORDER_BACK_RIGHT.number,
                movableCubes.get(CubesModel.CubeNumber.BOTTOM_BORDER_BACK.number));

        movableCubes.set(CubesModel.CubeNumber.BOTTOM_BORDER_BACK.number,
                movableCubes.get(CubesModel.CubeNumber.MID_BORDER_LEFT_BACK.number));

        movableCubes.set(CubesModel.CubeNumber.MID_BORDER_LEFT_BACK.number, tmpBorder);
    }

    public void negativeB() {
        //rotate corners
        CubePartition tmpCorner = movableCubes.get(CubesModel.CubeNumber.TOP_CORNER_BACK_RIGHT.number);
        movableCubes.set(CubesModel.CubeNumber.TOP_CORNER_BACK_RIGHT.number,
                movableCubes.get(CubesModel.CubeNumber.TOP_CORNER_LEFT_BACK.number));

        movableCubes.set(CubesModel.CubeNumber.TOP_CORNER_LEFT_BACK.number,
                movableCubes.get(CubesModel.CubeNumber.BOTTOM_CORNER_LEFT_BACK.number));

        movableCubes.set(CubesModel.CubeNumber.BOTTOM_CORNER_LEFT_BACK.number,
                movableCubes.get(CubesModel.CubeNumber.BOTTOM_CORNER_BACK_RIGHT.number));

        movableCubes.set(CubesModel.CubeNumber.BOTTOM_CORNER_BACK_RIGHT.number, tmpCorner);

        rotateCornerColorsB();

        //rotate borders
        CubePartition tmpBorder = movableCubes.get(CubesModel.CubeNumber.TOP_BORDER_BACK.number);
        movableCubes.set(CubesModel.CubeNumber.TOP_BORDER_BACK.number,
                movableCubes.get(CubesModel.CubeNumber.MID_BORDER_LEFT_BACK.number));

        movableCubes.set(CubesModel.CubeNumber.MID_BORDER_LEFT_BACK.number,
                movableCubes.get(CubesModel.CubeNumber.BOTTOM_BORDER_BACK.number));

        movableCubes.set(CubesModel.CubeNumber.BOTTOM_BORDER_BACK.number,
                movableCubes.get(CubesModel.CubeNumber.MID_BORDER_BACK_RIGHT.number));

        movableCubes.set(CubesModel.CubeNumber.MID_BORDER_BACK_RIGHT.number, tmpBorder);
    }

    private void rotateCornerColorsB() {
        Color tmpColor = movableCubes.get(CubesModel.CubeNumber.TOP_CORNER_BACK_RIGHT.number).frontColor;
        movableCubes.get(CubesModel.CubeNumber.TOP_CORNER_BACK_RIGHT.number).frontColor =
                movableCubes.get(CubesModel.CubeNumber.TOP_CORNER_BACK_RIGHT.number).cornerColor;
        movableCubes.get(CubesModel.CubeNumber.TOP_CORNER_BACK_RIGHT.number).cornerColor = tmpColor;
        tmpColor = movableCubes.get(CubesModel.CubeNumber.BOTTOM_CORNER_BACK_RIGHT.number).frontColor;
        movableCubes.get(CubesModel.CubeNumber.BOTTOM_CORNER_BACK_RIGHT.number).frontColor =
                movableCubes.get(CubesModel.CubeNumber.BOTTOM_CORNER_BACK_RIGHT.number).cornerColor;
        movableCubes.get(CubesModel.CubeNumber.BOTTOM_CORNER_BACK_RIGHT.number).cornerColor = tmpColor;
        tmpColor = movableCubes.get(CubesModel.CubeNumber.BOTTOM_CORNER_LEFT_BACK.number).frontColor;
        movableCubes.get(CubesModel.CubeNumber.BOTTOM_CORNER_LEFT_BACK.number).frontColor =
                movableCubes.get(CubesModel.CubeNumber.BOTTOM_CORNER_LEFT_BACK.number).cornerColor;
        movableCubes.get(CubesModel.CubeNumber.BOTTOM_CORNER_LEFT_BACK.number).cornerColor = tmpColor;
        tmpColor = movableCubes.get(CubesModel.CubeNumber.TOP_CORNER_LEFT_BACK.number).frontColor;
        movableCubes.get(CubesModel.CubeNumber.TOP_CORNER_LEFT_BACK.number).frontColor =
                movableCubes.get(CubesModel.CubeNumber.TOP_CORNER_LEFT_BACK.number).cornerColor;
        movableCubes.get(CubesModel.CubeNumber.TOP_CORNER_LEFT_BACK.number).cornerColor = tmpColor;

        tmpColor = movableCubes.get(CubesModel.CubeNumber.TOP_BORDER_BACK.number).frontColor;
        movableCubes.get(CubesModel.CubeNumber.TOP_BORDER_BACK.number).frontColor =
                movableCubes.get(CubesModel.CubeNumber.TOP_BORDER_BACK.number).borderColor;
        movableCubes.get(CubesModel.CubeNumber.TOP_BORDER_BACK.number).borderColor = tmpColor;
        tmpColor = movableCubes.get(CubesModel.CubeNumber.MID_BORDER_BACK_RIGHT.number).frontColor;
        movableCubes.get(CubesModel.CubeNumber.MID_BORDER_BACK_RIGHT.number).frontColor =
                movableCubes.get(CubesModel.CubeNumber.MID_BORDER_BACK_RIGHT.number).borderColor;
        movableCubes.get(CubesModel.CubeNumber.MID_BORDER_BACK_RIGHT.number).borderColor = tmpColor;
        tmpColor = movableCubes.get(CubesModel.CubeNumber.BOTTOM_BORDER_BACK.number).frontColor;
        movableCubes.get(CubesModel.CubeNumber.BOTTOM_BORDER_BACK.number).frontColor =
                movableCubes.get(CubesModel.CubeNumber.BOTTOM_BORDER_BACK.number).borderColor;
        movableCubes.get(CubesModel.CubeNumber.BOTTOM_BORDER_BACK.number).borderColor = tmpColor;
        tmpColor = movableCubes.get(CubesModel.CubeNumber.MID_BORDER_LEFT_BACK.number).frontColor;
        movableCubes.get(CubesModel.CubeNumber.MID_BORDER_LEFT_BACK.number).frontColor =
                movableCubes.get(CubesModel.CubeNumber.MID_BORDER_LEFT_BACK.number).borderColor;
        movableCubes.get(CubesModel.CubeNumber.MID_BORDER_LEFT_BACK.number).borderColor = tmpColor;
    }

    public void positiveD() {
        //rotate corners
        CubePartition tmpCorner = movableCubes.get(CubesModel.CubeNumber.BOTTOM_CORNER_FRONT_LEFT.number);
        movableCubes.set(CubesModel.CubeNumber.BOTTOM_CORNER_FRONT_LEFT.number,
                movableCubes.get(CubesModel.CubeNumber.BOTTOM_CORNER_LEFT_BACK.number));

        movableCubes.set(CubesModel.CubeNumber.BOTTOM_CORNER_LEFT_BACK.number,
                movableCubes.get(CubesModel.CubeNumber.BOTTOM_CORNER_BACK_RIGHT.number));

        movableCubes.set(CubesModel.CubeNumber.BOTTOM_CORNER_BACK_RIGHT.number,
                movableCubes.get(CubesModel.CubeNumber.BOTTOM_CORNER_RIGHT_FRONT.number));

        movableCubes.set(CubesModel.CubeNumber.BOTTOM_CORNER_RIGHT_FRONT.number, tmpCorner);

        rotateCornerColorsD();

        //rotate borders
        CubePartition tmpBorder = movableCubes.get(CubesModel.CubeNumber.BOTTOM_BORDER_FRONT.number);
        movableCubes.set(CubesModel.CubeNumber.BOTTOM_BORDER_FRONT.number,
                movableCubes.get(CubesModel.CubeNumber.BOTTOM_BORDER_LEFT.number));

        movableCubes.set(CubesModel.CubeNumber.BOTTOM_BORDER_LEFT.number,
                movableCubes.get(CubesModel.CubeNumber.BOTTOM_BORDER_BACK.number));

        movableCubes.set(CubesModel.CubeNumber.BOTTOM_BORDER_BACK.number,
                movableCubes.get(CubesModel.CubeNumber.BOTTOM_BORDER_RIGHT.number));

        movableCubes.set(CubesModel.CubeNumber.BOTTOM_BORDER_RIGHT.number, tmpBorder);
    }

    public void negativeD() {
        //rotate corners
        CubePartition tmpCorner = movableCubes.get(CubesModel.CubeNumber.BOTTOM_CORNER_FRONT_LEFT.number);
        movableCubes.set(CubesModel.CubeNumber.BOTTOM_CORNER_FRONT_LEFT.number,
                movableCubes.get(CubesModel.CubeNumber.BOTTOM_CORNER_RIGHT_FRONT.number));

        movableCubes.set(CubesModel.CubeNumber.BOTTOM_CORNER_RIGHT_FRONT.number,
                movableCubes.get(CubesModel.CubeNumber.BOTTOM_CORNER_BACK_RIGHT.number));

        movableCubes.set(CubesModel.CubeNumber.BOTTOM_CORNER_BACK_RIGHT.number,
                movableCubes.get(CubesModel.CubeNumber.BOTTOM_CORNER_LEFT_BACK.number));

        movableCubes.set(CubesModel.CubeNumber.BOTTOM_CORNER_LEFT_BACK.number, tmpCorner);

        rotateCornerColorsD();

        //rotate borders
        CubePartition tmpBorder = movableCubes.get(CubesModel.CubeNumber.BOTTOM_BORDER_FRONT.number);
        movableCubes.set(CubesModel.CubeNumber.BOTTOM_BORDER_FRONT.number,
                movableCubes.get(CubesModel.CubeNumber.BOTTOM_BORDER_RIGHT.number));

        movableCubes.set(CubesModel.CubeNumber.BOTTOM_BORDER_RIGHT.number,
                movableCubes.get(CubesModel.CubeNumber.BOTTOM_BORDER_BACK.number));

        movableCubes.set(CubesModel.CubeNumber.BOTTOM_BORDER_BACK.number,
                movableCubes.get(CubesModel.CubeNumber.BOTTOM_BORDER_LEFT.number));

        movableCubes.set(CubesModel.CubeNumber.BOTTOM_BORDER_LEFT.number, tmpBorder);
    }

    private void rotateCornerColorsD() {
        Color tmpColor = movableCubes.get(CubesModel.CubeNumber.BOTTOM_CORNER_FRONT_LEFT.number).borderColor;
        movableCubes.get(CubesModel.CubeNumber.BOTTOM_CORNER_FRONT_LEFT.number).borderColor =
                movableCubes.get(CubesModel.CubeNumber.BOTTOM_CORNER_FRONT_LEFT.number).cornerColor;
        movableCubes.get(CubesModel.CubeNumber.BOTTOM_CORNER_FRONT_LEFT.number).cornerColor = tmpColor;
        tmpColor = movableCubes.get(CubesModel.CubeNumber.BOTTOM_CORNER_LEFT_BACK.number).borderColor;
        movableCubes.get(CubesModel.CubeNumber.BOTTOM_CORNER_LEFT_BACK.number).borderColor =
                movableCubes.get(CubesModel.CubeNumber.BOTTOM_CORNER_LEFT_BACK.number).cornerColor;
        movableCubes.get(CubesModel.CubeNumber.BOTTOM_CORNER_LEFT_BACK.number).cornerColor = tmpColor;
        tmpColor = movableCubes.get(CubesModel.CubeNumber.BOTTOM_CORNER_BACK_RIGHT.number).borderColor;
        movableCubes.get(CubesModel.CubeNumber.BOTTOM_CORNER_BACK_RIGHT.number).borderColor =
                movableCubes.get(CubesModel.CubeNumber.BOTTOM_CORNER_BACK_RIGHT.number).cornerColor;
        movableCubes.get(CubesModel.CubeNumber.BOTTOM_CORNER_BACK_RIGHT.number).cornerColor = tmpColor;
        tmpColor = movableCubes.get(CubesModel.CubeNumber.BOTTOM_CORNER_RIGHT_FRONT.number).borderColor;
        movableCubes.get(CubesModel.CubeNumber.BOTTOM_CORNER_RIGHT_FRONT.number).borderColor =
                movableCubes.get(CubesModel.CubeNumber.BOTTOM_CORNER_RIGHT_FRONT.number).cornerColor;
        movableCubes.get(CubesModel.CubeNumber.BOTTOM_CORNER_RIGHT_FRONT.number).cornerColor = tmpColor;
    }

    public void rotateLeftToFront() {
        rotateRightToFront();
        rotateRightToFront();
        rotateRightToFront();
    }

    public void rotateRightToFront() {
        positiveT();
        negativeD();
        moveCentresRightToFront();
        CubePartition tmpBorder = movableCubes.get(CubesModel.CubeNumber.MID_BORDER_RIGHT_FRONT.number);
        movableCubes.set(CubesModel.CubeNumber.MID_BORDER_RIGHT_FRONT.number,
                movableCubes.get(CubesModel.CubeNumber.MID_BORDER_BACK_RIGHT.number));
        movableCubes.set(CubesModel.CubeNumber.MID_BORDER_BACK_RIGHT.number,
                movableCubes.get(CubesModel.CubeNumber.MID_BORDER_LEFT_BACK.number));
        movableCubes.set(CubesModel.CubeNumber.MID_BORDER_LEFT_BACK.number,
                movableCubes.get(CubesModel.CubeNumber.MID_BORDER_FRONT_LEFT.number));
        movableCubes.set(CubesModel.CubeNumber.MID_BORDER_FRONT_LEFT.number, tmpBorder);
        rotateMidBorderColors();
    }

    private void moveCentresRightToFront() {
        Color tmpColor = frontCenter.frontColor;
        frontCenter.frontColor = rightCenter.frontColor;
        rightCenter.frontColor = backCenter.frontColor;
        backCenter.frontColor = leftCenter.frontColor;
        leftCenter.frontColor = tmpColor;
    }

    private void rotateMidBorderColors() {
        Color tmpColor = movableCubes.get(CubesModel.CubeNumber.MID_BORDER_BACK_RIGHT.number).frontColor;
        movableCubes.get(CubesModel.CubeNumber.MID_BORDER_BACK_RIGHT.number).frontColor =
                movableCubes.get(CubesModel.CubeNumber.MID_BORDER_BACK_RIGHT.number).borderColor;
        movableCubes.get(CubesModel.CubeNumber.MID_BORDER_BACK_RIGHT.number).borderColor = tmpColor;
        tmpColor = movableCubes.get(CubesModel.CubeNumber.MID_BORDER_RIGHT_FRONT.number).frontColor;
        movableCubes.get(CubesModel.CubeNumber.MID_BORDER_RIGHT_FRONT.number).frontColor =
                movableCubes.get(CubesModel.CubeNumber.MID_BORDER_RIGHT_FRONT.number).borderColor;
        movableCubes.get(CubesModel.CubeNumber.MID_BORDER_RIGHT_FRONT.number).borderColor = tmpColor;
        tmpColor = movableCubes.get(CubesModel.CubeNumber.MID_BORDER_LEFT_BACK.number).frontColor;
        movableCubes.get(CubesModel.CubeNumber.MID_BORDER_LEFT_BACK.number).frontColor =
                movableCubes.get(CubesModel.CubeNumber.MID_BORDER_LEFT_BACK.number).borderColor;
        movableCubes.get(CubesModel.CubeNumber.MID_BORDER_LEFT_BACK.number).borderColor = tmpColor;
        tmpColor = movableCubes.get(CubesModel.CubeNumber.MID_BORDER_FRONT_LEFT.number).frontColor;
        movableCubes.get(CubesModel.CubeNumber.MID_BORDER_FRONT_LEFT.number).frontColor =
                movableCubes.get(CubesModel.CubeNumber.MID_BORDER_FRONT_LEFT.number).borderColor;
        movableCubes.get(CubesModel.CubeNumber.MID_BORDER_FRONT_LEFT.number).borderColor = tmpColor;
    }

    public void rotateDownToFront() {
        rotateUpToFront();
        rotateUpToFront();
        rotateUpToFront();
    }

    public void rotateUpToFront() {
        negativeR();
        negativeL();
        moveCentresUpToFront();
        CubePartition tmpBorder = movableCubes.get(CubesModel.CubeNumber.TOP_BORDER_FRONT.number);
        movableCubes.set(CubesModel.CubeNumber.TOP_BORDER_FRONT.number,
                movableCubes.get(CubesModel.CubeNumber.TOP_BORDER_BACK.number));
        movableCubes.set(CubesModel.CubeNumber.TOP_BORDER_BACK.number,
                movableCubes.get(CubesModel.CubeNumber.BOTTOM_BORDER_BACK.number));
        movableCubes.set(CubesModel.CubeNumber.BOTTOM_BORDER_BACK.number,
                movableCubes.get(CubesModel.CubeNumber.BOTTOM_BORDER_FRONT.number));
        movableCubes.set(CubesModel.CubeNumber.BOTTOM_BORDER_FRONT.number, tmpBorder);
        rotateTopAndBotBorderColors();
    }

    private void moveCentresUpToFront() {
        Color tmpColor = frontCenter.frontColor;
        frontCenter.frontColor = topCenter.frontColor;
        topCenter.frontColor = backCenter.frontColor;
        backCenter.frontColor = bottomCenter.frontColor;
        bottomCenter.frontColor = tmpColor;
    }

    private void rotateTopAndBotBorderColors() {
        Color tmpColor = movableCubes.get(CubesModel.CubeNumber.TOP_BORDER_FRONT.number).frontColor;
        movableCubes.get(CubesModel.CubeNumber.TOP_BORDER_FRONT.number).frontColor =
                movableCubes.get(CubesModel.CubeNumber.TOP_BORDER_FRONT.number).borderColor;
        movableCubes.get(CubesModel.CubeNumber.TOP_BORDER_FRONT.number).borderColor = tmpColor;
        tmpColor = movableCubes.get(CubesModel.CubeNumber.TOP_BORDER_BACK.number).frontColor;
        movableCubes.get(CubesModel.CubeNumber.TOP_BORDER_BACK.number).frontColor =
                movableCubes.get(CubesModel.CubeNumber.TOP_BORDER_BACK.number).borderColor;
        movableCubes.get(CubesModel.CubeNumber.TOP_BORDER_BACK.number).borderColor = tmpColor;
        tmpColor = movableCubes.get(CubesModel.CubeNumber.BOTTOM_BORDER_BACK.number).frontColor;
        movableCubes.get(CubesModel.CubeNumber.BOTTOM_BORDER_BACK.number).frontColor =
                movableCubes.get(CubesModel.CubeNumber.BOTTOM_BORDER_BACK.number).borderColor;
        movableCubes.get(CubesModel.CubeNumber.BOTTOM_BORDER_BACK.number).borderColor = tmpColor;
        tmpColor = movableCubes.get(CubesModel.CubeNumber.BOTTOM_BORDER_FRONT.number).frontColor;
        movableCubes.get(CubesModel.CubeNumber.BOTTOM_BORDER_FRONT.number).frontColor =
                movableCubes.get(CubesModel.CubeNumber.BOTTOM_BORDER_FRONT.number).borderColor;
        movableCubes.get(CubesModel.CubeNumber.BOTTOM_BORDER_FRONT.number).borderColor = tmpColor;
    }

}
