package code.visualization;

import code.calculation.Color;
import javafx.animation.KeyFrame;
import javafx.animation.KeyValue;
import javafx.animation.Timeline;
import javafx.beans.property.DoubleProperty;
import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.geometry.Point3D;
import javafx.scene.transform.Affine;
import javafx.scene.transform.Rotate;
import javafx.util.Duration;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import java.util.concurrent.atomic.AtomicInteger;

public class Cube3D {
    ArrayList<Cube3DPart> cubes = new ArrayList<>();
    Rotate rotateX = new Rotate(30, -0.25, -0.25 ,1.25, Rotate.X_AXIS);
    Rotate rotateY = new Rotate(30, -0.25, -0.25 ,1.25, Rotate.Y_AXIS);

    int[] currentIndexes;
    Point3D currentAxis;
    boolean isRotating;

    ChangeListener<Number> rotationListener = new ChangeListener<>() {
        @Override
        public void changed(ObservableValue<? extends Number> observable, Number oldValue, Number newValue) {
            Arrays.stream(currentIndexes).forEach(index -> {
                Rotate rotate = new Rotate(newValue.doubleValue() - oldValue.doubleValue(),
                        -0.25, -0.25, 1.25, currentAxis);
                Affine affine = cubes.get(index).getAffine();
                affine.prepend(rotate);
            });
        }
    };

    int[] topIndexes = new int[] {0, 1, 2, 3, 4, 5, 6, 7, 8};
    int[] downIndexes = new int[] {23, 22, 21, 20, 19, 18, 17, 24, 25};
    int[] rightIndexes = new int[] {19, 20, 21, 13, 4, 3, 2, 11, 12};
    int[] leftIndexes = new int[] {23, 24, 17, 9, 0, 7, 6, 15, 16};
    int[] frontIndexes = new int[] {17, 18, 19, 11, 2, 1, 0, 9, 10};
    int[] backIndexes = new int[] {21, 22, 23, 15, 6, 5, 4, 13, 14};

    int[] allIndexes = new int[] {0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10,
                                  11, 12, 13, 14, 15, 16, 17, 18, 19,
                                  20, 21, 22, 23, 24, 25};

    Point3D topAxis = Rotate.Y_AXIS;
    Point3D downAxis = Rotate.Y_AXIS;
    Point3D rightAxis = Rotate.X_AXIS;
    Point3D leftAxis = Rotate.X_AXIS;
    Point3D frontAxis = Rotate.Z_AXIS;
    Point3D backAxis = Rotate.Z_AXIS;

    public Cube3D() throws FileNotFoundException {
        AtomicInteger cont = new AtomicInteger();
        for (int[] pattern : cubeFacePatterns) {
            Point3D position = cubePositions.get(cont.getAndIncrement());
            Cube3DPart someCube = new Cube3DPart(pattern, position);
            someCube.getTransforms().addAll(rotateX, rotateY);
            someCube.getTransforms().add(someCube.getAffine());
            cubes.add(someCube);
        }
    }

    public ArrayList<Cube3DPart> getCube() {
        return cubes;
    }

    public boolean isRotating() {
        return isRotating;
    }

    private void rotate(double angle) {
        DoubleProperty rotation=new SimpleDoubleProperty(0d);
        rotation.addListener(rotationListener);
        isRotating = true;
        Timeline timeline = new Timeline(
                new KeyFrame(Duration.millis(300), e -> {
                    rotation.removeListener(rotationListener);
                    isRotating = false;
                } , new KeyValue(rotation, angle)));
        timeline.playFromStart();
    }

    public void rotateHorizontal(int sign) {
        currentIndexes = allIndexes;
        currentAxis = Rotate.Y_AXIS;

        rotate(sign * 90);
        if (sign > 0) {
            moveSides(rightIndexes, leftIndexes, topIndexes, downIndexes);
        } else {
            moveSides(leftIndexes, rightIndexes, downIndexes, topIndexes);
        }
    }

    private void moveSides(int[] firstMovableSide, int[] secondMovableSide,
                           int[] firstNonMovableSide, int[] secondNonMovableSide) {
        int[] tmpIndexes = new int[9];
        System.arraycopy(frontIndexes, 0, tmpIndexes, 0, firstMovableSide.length);
        System.arraycopy(firstMovableSide, 0, frontIndexes, 0, firstMovableSide.length);
        System.arraycopy(backIndexes, 0, firstMovableSide, 0, firstMovableSide.length);
        System.arraycopy(secondMovableSide, 0, backIndexes, 0, firstMovableSide.length);
        System.arraycopy(tmpIndexes, 0, secondMovableSide, 0, firstMovableSide.length);

        moveIndexesForward(firstNonMovableSide);
        moveIndexesReverse(secondNonMovableSide);
    }

    public void rotateVertical(int sign) {
        currentIndexes = allIndexes;
        currentAxis = Rotate.X_AXIS;

        rotate(sign * 90);

        if (sign > 0) {
            moveSides(topIndexes, downIndexes, leftIndexes, rightIndexes);
            reverseSide(topIndexes);
            reverseSide(backIndexes);
        } else {
            moveSides(downIndexes, topIndexes, rightIndexes, leftIndexes);
            reverseSide(downIndexes);
            reverseSide(backIndexes);
        }

    }

    private void reverseSide(int[] side) {
        for (int i = 0; i < 4; i++) {
            int tmp = side[i];
            side[i] = side[i + 4];
            side[i + 4] = tmp;
        }
    }

    public void rotateTop(int sign) {
        currentIndexes = topIndexes;
        currentAxis = topAxis;

        rotate(sign * 90);

        if (sign > 0) {
            moveIndexesForward(topIndexes);
        } else {
            moveIndexesReverse(topIndexes);
        }

        rightIndexes[4] = topIndexes[4];
        rightIndexes[5] = topIndexes[3];
        rightIndexes[6] = topIndexes[2];

        leftIndexes[4] = topIndexes[0];
        leftIndexes[5] = topIndexes[7];
        leftIndexes[6] = topIndexes[6];

        frontIndexes[4] = topIndexes[2];
        frontIndexes[5] = topIndexes[1];
        frontIndexes[6] = topIndexes[0];

        backIndexes[4] = topIndexes[6];
        backIndexes[5] = topIndexes[5];
        backIndexes[6] = topIndexes[4];
    }

    public void rotateRight(int sign) {
        currentIndexes = rightIndexes;
        currentAxis = rightAxis;

        rotate(-sign * 90);
        if (sign > 0) {
            moveIndexesForward(rightIndexes);
        } else {
            moveIndexesReverse(rightIndexes);
        }

        topIndexes[2] = rightIndexes[6];
        topIndexes[3] = rightIndexes[5];
        topIndexes[4] = rightIndexes[4];

        downIndexes[2] = rightIndexes[2];
        downIndexes[3] = rightIndexes[1];
        downIndexes[4] = rightIndexes[0];

        frontIndexes[2] = rightIndexes[0];
        frontIndexes[3] = rightIndexes[7];
        frontIndexes[4] = rightIndexes[6];

        backIndexes[0] = rightIndexes[2];
        backIndexes[7] = rightIndexes[3];
        backIndexes[6] = rightIndexes[4];
    }

    public void rotateLeft(int sign) {
        currentIndexes = leftIndexes;
        currentAxis = leftAxis;

        rotate(sign * 90);

        if (sign > 0) {
            moveIndexesForward(leftIndexes);
        } else {
            moveIndexesReverse(leftIndexes);
        }

        topIndexes[0] = leftIndexes[4];
        topIndexes[7] = leftIndexes[5];
        topIndexes[6] = leftIndexes[6];

        downIndexes[0] = leftIndexes[0];
        downIndexes[7] = leftIndexes[1];
        downIndexes[6] = leftIndexes[2];

        frontIndexes[0] = leftIndexes[2];
        frontIndexes[7] = leftIndexes[3];
        frontIndexes[6] = leftIndexes[4];

        backIndexes[2] = leftIndexes[0];
        backIndexes[3] = leftIndexes[7];
        backIndexes[4] = leftIndexes[6];
    }

    public void rotateDown(int sign) {
        currentIndexes = downIndexes;
        currentAxis = downAxis;

        rotate(-sign * 90);

        if (sign > 0) {
            moveIndexesForward(downIndexes);
        } else {
            moveIndexesReverse(downIndexes);
        }

        rightIndexes[0] = downIndexes[4];
        rightIndexes[1] = downIndexes[3];
        rightIndexes[2] = downIndexes[2];

        leftIndexes[0] = downIndexes[0];
        leftIndexes[1] = downIndexes[7];
        leftIndexes[2] = downIndexes[6];

        frontIndexes[0] = downIndexes[6];
        frontIndexes[1] = downIndexes[5];
        frontIndexes[2] = downIndexes[4];

        backIndexes[0] = downIndexes[2];
        backIndexes[1] = downIndexes[1];
        backIndexes[2] = downIndexes[0];
    }

    public void rotateFront(int sign) {
        currentIndexes = frontIndexes;
        currentAxis = frontAxis;

        rotate(sign * 90);

        if (sign > 0) {
            moveIndexesForward(frontIndexes);
        } else {
            moveIndexesReverse(frontIndexes);
        }

        topIndexes[0] = frontIndexes[6];
        topIndexes[1] = frontIndexes[5];
        topIndexes[2] = frontIndexes[4];

        downIndexes[6] = frontIndexes[0];
        downIndexes[5] = frontIndexes[1];
        downIndexes[4] = frontIndexes[2];

        rightIndexes[0] = frontIndexes[2];
        rightIndexes[7] = frontIndexes[3];
        rightIndexes[6] = frontIndexes[4];

        leftIndexes[2] = frontIndexes[0];
        leftIndexes[3] = frontIndexes[7];
        leftIndexes[4] = frontIndexes[6];
    }

    public void rotateBack(int sign) {
        currentIndexes = backIndexes;
        currentAxis = backAxis;

        rotate(-sign * 90);

        if (sign > 0) {
            moveIndexesForward(backIndexes);
        } else {
            moveIndexesReverse(backIndexes);
        }

        topIndexes[6] = backIndexes[4];
        topIndexes[5] = backIndexes[5];
        topIndexes[4] = backIndexes[6];

        downIndexes[0] = backIndexes[2];
        downIndexes[1] = backIndexes[1];
        downIndexes[2] = backIndexes[0];

        rightIndexes[2] = backIndexes[0];
        rightIndexes[3] = backIndexes[7];
        rightIndexes[4] = backIndexes[6];

        leftIndexes[0] = backIndexes[2];
        leftIndexes[7] = backIndexes[3];
        leftIndexes[6] = backIndexes[4];
    }

    private void moveIndexesForward(int[] side) {
        int tmpFirst = side[0];
        int tmpSecond = side[1];
        for (int i = 0; i < side.length - 3; i++) {
            side[i] = side[i + 2];
        }
        side[6] = tmpFirst;
        side[7] = tmpSecond;
    }

    private void moveIndexesReverse(int[] side) {
        int tmpFirst = side[6];
        int tmpSecond = side[7];
        for (int i = side.length - 2; i >= 2 ; i--) {
            side[i] = side[i-2];
        }
        side[0] = tmpFirst;
        side[1] = tmpSecond;
    }

    private static final int[] TOP_CORNER_FRONT_LEFT = new int[] {
            Color.WHITE.number,
            Color.RED.number,
            Color.BLACK.number,
            Color.GREEN.number,
            Color.BLACK.number,
            Color.BLACK.number};
    private static final int[] TOP_BORDER_FRONT = new int[] {
            Color.WHITE.number,
            Color.RED.number,
            Color.BLACK.number,
            Color.BLACK.number,
            Color.BLACK.number,
            Color.BLACK.number};

    private static final int[] TOP_CORNER_RIGHT_FRONT = new int[] {
            Color.WHITE.number,
            Color.RED.number,
            Color.BLUE.number,
            Color.BLACK.number,
            Color.BLACK.number,
            Color.BLACK.number};

    private static final int[] TOP_BORDER_RIGHT = new int[] {
            Color.WHITE.number,
            Color.BLACK.number,
            Color.BLUE.number,
            Color.BLACK.number,
            Color.BLACK.number,
            Color.BLACK.number};

    private static final int[] TOP_CORNER_BACK_RIGHT = new int[] {
            Color.WHITE.number,
            Color.BLACK.number,
            Color.BLUE.number,
            Color.BLACK.number,
            Color.ORANGE.number,
            Color.BLACK.number};

    private static final int[] TOP_BORDER_BACK = new int[] {
            Color.WHITE.number,
            Color.BLACK.number,
            Color.BLACK.number,
            Color.BLACK.number,
            Color.ORANGE.number,
            Color.BLACK.number};

    private static final int[] TOP_CORNER_LEFT_BACK = new int[] {
            Color.WHITE.number,
            Color.BLACK.number,
            Color.BLACK.number,
            Color.GREEN.number,
            Color.ORANGE.number,
            Color.BLACK.number};

    private static final int[] TOP_BORDER_LEFT = new int[] {
            Color.WHITE.number,
            Color.BLACK.number,
            Color.BLACK.number,
            Color.GREEN.number,
            Color.BLACK.number,
            Color.BLACK.number};

    private static final int[] TOP_CENTER = new int[] {
            Color.WHITE.number,
            Color.BLACK.number,
            Color.BLACK.number,
            Color.BLACK.number,
            Color.BLACK.number,
            Color.BLACK.number};

    private static final int[] MID_BORDER_FRONT_LEFT = new int[] {
            Color.BLACK.number,
            Color.RED.number,
            Color.BLACK.number,
            Color.GREEN.number,
            Color.BLACK.number,
            Color.BLACK.number};

    private static final int[] MID_CENTER_FRONT = new int[] {
            Color.BLACK.number,
            Color.RED.number,
            Color.BLACK.number,
            Color.BLACK.number,
            Color.BLACK.number,
            Color.BLACK.number};

    private static final int[] MID_BORDER_RIGHT_FRONT = new int[] {
            Color.BLACK.number,
            Color.RED.number,
            Color.BLUE.number,
            Color.BLACK.number,
            Color.BLACK.number,
            Color.BLACK.number};

    private static final int[] MID_CENTER_RIGHT = new int[] {
            Color.BLACK.number,
            Color.BLACK.number,
            Color.BLUE.number,
            Color.BLACK.number,
            Color.BLACK.number,
            Color.BLACK.number};

    private static final int[] MID_BORDER_BACK_RIGHT = new int[] {
            Color.BLACK.number,
            Color.BLACK.number,
            Color.BLUE.number,
            Color.BLACK.number,
            Color.ORANGE.number,
            Color.BLACK.number};

    private static final int[] MID_CENTER_BACK = new int[] {
            Color.BLACK.number,
            Color.BLACK.number,
            Color.BLACK.number,
            Color.BLACK.number,
            Color.ORANGE.number,
            Color.BLACK.number};

    private static final int[] MID_BORDER_LEFT_BACK = new int[] {
            Color.BLACK.number,
            Color.BLACK.number,
            Color.BLACK.number,
            Color.GREEN.number,
            Color.ORANGE.number,
            Color.BLACK.number};

    private static final int[] MID_CENTER_LEFT = new int[] {
            Color.BLACK.number,
            Color.BLACK.number,
            Color.BLACK.number,
            Color.GREEN.number,
            Color.BLACK.number,
            Color.BLACK.number};

    private static final int[] BOTTOM_CORNER_FRONT_LEFT = new int[] {
            Color.BLACK.number,
            Color.RED.number,
            Color.BLACK.number,
            Color.GREEN.number,
            Color.BLACK.number,
            Color.YELLOW.number};

    private static final int[] BOTTOM_BORDER_FRONT = new int[] {
            Color.BLACK.number,
            Color.RED.number,
            Color.BLACK.number,
            Color.BLACK.number,
            Color.BLACK.number,
            Color.YELLOW.number};

    private static final int[] BOTTOM_CORNER_RIGHT_FRONT = new int[] {
            Color.BLACK.number,
            Color.RED.number,
            Color.BLUE.number,
            Color.BLACK.number,
            Color.BLACK.number,
            Color.YELLOW.number};

    private static final int[] BOTTOM_BORDER_RIGHT = new int[] {
            Color.BLACK.number,
            Color.BLACK.number,
            Color.BLUE.number,
            Color.BLACK.number,
            Color.BLACK.number,
            Color.YELLOW.number};

    private static final int[] BOTTOM_CORNER_BACK_RIGHT = new int[] {
            Color.BLACK.number,
            Color.BLACK.number,
            Color.BLUE.number,
            Color.BLACK.number,
            Color.ORANGE.number,
            Color.YELLOW.number};

    private static final int[] BOTTOM_BORDER_BACK = new int[] {
            Color.BLACK.number,
            Color.BLACK.number,
            Color.BLACK.number,
            Color.BLACK.number,
            Color.ORANGE.number,
            Color.YELLOW.number};

    private static final int[] BOTTOM_CORNER_LEFT_BACK = new int[] {
            Color.BLACK.number,
            Color.BLACK.number,
            Color.BLACK.number,
            Color.GREEN.number,
            Color.ORANGE.number,
            Color.YELLOW.number};
    private static final int[] BOTTOM_BORDER_LEFT = new int[] {
            Color.BLACK.number,
            Color.BLACK.number,
            Color.BLACK.number,
            Color.GREEN.number,
            Color.BLACK.number,
            Color.YELLOW.number};

    private static final int[] BOTTOM_CENTER = new int[] {
            Color.BLACK.number,
            Color.BLACK.number,
            Color.BLACK.number,
            Color.BLACK.number,
            Color.BLACK.number,
            Color.YELLOW.number};

    private static final List<int[]> cubeFacePatterns = Arrays.asList(
            TOP_CORNER_FRONT_LEFT, TOP_BORDER_FRONT, TOP_CORNER_RIGHT_FRONT, TOP_BORDER_RIGHT, TOP_CORNER_BACK_RIGHT,
            TOP_BORDER_BACK, TOP_CORNER_LEFT_BACK, TOP_BORDER_LEFT, TOP_CENTER,
            MID_BORDER_FRONT_LEFT, MID_CENTER_FRONT, MID_BORDER_RIGHT_FRONT, MID_CENTER_RIGHT,
            MID_BORDER_BACK_RIGHT, MID_CENTER_BACK, MID_BORDER_LEFT_BACK, MID_CENTER_LEFT,
            BOTTOM_CORNER_FRONT_LEFT, BOTTOM_BORDER_FRONT, BOTTOM_CORNER_RIGHT_FRONT, BOTTOM_BORDER_RIGHT,
            BOTTOM_CORNER_BACK_RIGHT, BOTTOM_BORDER_BACK, BOTTOM_CORNER_LEFT_BACK, BOTTOM_BORDER_LEFT, BOTTOM_CENTER
    );

    private static final Point3D TOP_CORNER_FRONT_LEFT_POSITION = new Point3D(-0.5, -1.0, 1.0);
    private static final Point3D TOP_BORDER_FRONT_POSITION = new Point3D(0.0, -1.0, 1.0);
    private static final Point3D TOP_CORNER_RIGHT_FRONT_POSITION = new Point3D(0.5, -1.0, 1.0);
    private static final Point3D TOP_BORDER_RIGHT_POSITION = new Point3D(0.5, -1.0, 1.5);
    private static final Point3D TOP_CORNER_BACK_RIGHT_POSITION = new Point3D(0.5, -1.0, 2.0);
    private static final Point3D TOP_BORDER_BACK_POSITION = new Point3D(0.0, -1.0, 2.0);
    private static final Point3D TOP_CORNER_LEFT_BACK_POSITION = new Point3D(-0.5, -1.0, 2.0);
    private static final Point3D TOP_BORDER_LEFT_POSITION = new Point3D(-0.5, -1.0, 1.5);
    private static final Point3D TOP_CENTER_POSITION = new Point3D(0.0, -1.0, 1.5);

    private static final Point3D BOTTOM_BORDER_FRONT_LEFT_POSITION = new Point3D(-0.5, -0.5, 1.0);
    private static final Point3D BOTTOM_CENTER_FRONT_POSITION = new Point3D(0.0, -0.5, 1.0);
    private static final Point3D BOTTOM_BORDER_RIGHT_FRONT_POSITION = new Point3D(0.5, -0.5, 1.0);
    private static final Point3D BOTTOM_CENTER_RIGHT_POSITION = new Point3D(0.5, -0.5, 1.5);
    private static final Point3D BOTTOM_BORDER_BACK_RIGHT_POSITION = new Point3D(0.5, -0.5, 2.0);
    private static final Point3D BOTTOM_CENTER_BACK_POSITION = new Point3D(0.0, -0.5, 2.0);
    private static final Point3D BOTTOM_BORDER_LEFT_BACK_POSITION = new Point3D(-0.5, -0.5, 2.0);
    private static final Point3D BOTTOM_CENTER_LEFT_POSITION = new Point3D(-0.5, -0.5, 1.5);

    private static final Point3D BOTTOM_CORNER_FRONT_LEFT_POSITION = new Point3D(-0.5, 0.0, 1.0);
    private static final Point3D BOTTOM_BORDER_FRONT_POSITION = new Point3D(0.0, 0.0, 1.0);
    private static final Point3D BOTTOM_CORNER_RIGHT_FRONT_POSITION = new Point3D(0.5, 0.0, 1.0);
    private static final Point3D BOTTOM_BORDER_RIGHT_POSITION = new Point3D(0.5, 0.0, 1.5);
    private static final Point3D BOTTOM_CORNER_BACK_RIGHT_POSITION = new Point3D(0.5, 0.0, 2.0);
    private static final Point3D BOTTOM_BORDER_BACK_POSITION = new Point3D(0.0, 0.0, 2.0);
    private static final Point3D BOTTOM_CORNER_LEFT_BACK_POSITION = new Point3D(-0.5, 0.0, 2.0);
    private static final Point3D BOTTOM_BORDER_LEFT_POSITION = new Point3D(-0.5, 0.0, 1.5);
    private static final Point3D BOTTOM_CENTER_POSITION = new Point3D(0.0, 0.0, 1.5);

    private static final List<Point3D> cubePositions = Arrays.asList(
            TOP_CORNER_FRONT_LEFT_POSITION, TOP_BORDER_FRONT_POSITION, TOP_CORNER_RIGHT_FRONT_POSITION,
            TOP_BORDER_RIGHT_POSITION, TOP_CORNER_BACK_RIGHT_POSITION, TOP_BORDER_BACK_POSITION,
            TOP_CORNER_LEFT_BACK_POSITION, TOP_BORDER_LEFT_POSITION, TOP_CENTER_POSITION,
            BOTTOM_BORDER_FRONT_LEFT_POSITION, BOTTOM_CENTER_FRONT_POSITION, BOTTOM_BORDER_RIGHT_FRONT_POSITION,
            BOTTOM_CENTER_RIGHT_POSITION, BOTTOM_BORDER_BACK_RIGHT_POSITION, BOTTOM_CENTER_BACK_POSITION,
            BOTTOM_BORDER_LEFT_BACK_POSITION, BOTTOM_CENTER_LEFT_POSITION,
            BOTTOM_CORNER_FRONT_LEFT_POSITION, BOTTOM_BORDER_FRONT_POSITION, BOTTOM_CORNER_RIGHT_FRONT_POSITION,
            BOTTOM_BORDER_RIGHT_POSITION, BOTTOM_CORNER_BACK_RIGHT_POSITION, BOTTOM_BORDER_BACK_POSITION,
            BOTTOM_CORNER_LEFT_BACK_POSITION, BOTTOM_BORDER_LEFT_POSITION, BOTTOM_CENTER_POSITION
    );
}
