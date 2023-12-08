package code;

import code.calculation.Color;
import code.calculation.CubeController;
import code.calculation.CubePart;
import code.calculation.CubesModel;
import code.visualization.Cube3D;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

public class Solver {

    private final CubeController controller;

    private final CubesModel model;

    private final Cube3D cube;

    public Solver(CubesModel model, Cube3D cube) {
        this.cube = cube;
        this.model = model;
        controller = model.getController();
    }

    public void solveCube() {
        Color[][] topSide = model.getTopSide();
        while (topSide[0][1] != Color.WHITE || topSide[1][0] != Color.WHITE ||
                topSide[1][2] != Color.WHITE || topSide[2][1] != Color.WHITE) {
            makeWhiteCross();
            topSide = model.getTopSide();
        }
        makeRightWhiteCross();
        purifyWhiteCross();
        makeFullWhiteSide();
    }

    private void makeWhiteCross() {
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                Color[][] topSide = model.getTopSide();
                Color[][] frontSide = model.getFrontSide();
                if (frontSide[1][2] == Color.WHITE) {
                    while (topSide[1][2] == Color.WHITE) {
                        cube.addRotation(Cube3D.RotateOperation.POSITIVE_TOP);
                        controller.positiveT();
                        topSide = model.getTopSide();
                    }
                    cube.addRotation(Cube3D.RotateOperation.POSITIVE_RIGHT);
                    controller.positiveR();
                }
                for (int k = 0; k < 4; k++) {
                    if (topSide[2][1] == Color.WHITE) {
                        cube.addRotation(Cube3D.RotateOperation.POSITIVE_TOP);
                        controller.positiveT();
                        topSide = model.getTopSide();
                    }
                }
                if (topSide[2][1] == Color.WHITE) {
                    break;
                }
                cube.addRotation(Cube3D.RotateOperation.POSITIVE_FRONT);
                controller.positiveF();
            }
            cube.addRotation(Cube3D.RotateOperation.POSITIVE_HORIZONTAL);
            controller.rotateRightToFront();
        }

        Color[][] topSide = model.getTopSide();
        if (topSide[0][1] != Color.WHITE || topSide[1][0] != Color.WHITE ||
                topSide[1][2] != Color.WHITE || topSide[2][1] != Color.WHITE) {
            for (int i = 0; i < 4; i++) {
                topSide = model.getTopSide();
                Color[][] downSide = model.getDownSide();
                if (downSide[0][1] == Color.WHITE) {
                    while (topSide[2][1] == Color.WHITE) {
                        cube.addRotation(Cube3D.RotateOperation.POSITIVE_TOP);
                        controller.positiveT();
                        topSide = model.getTopSide();
                    }
                    cube.addRotation(Cube3D.RotateOperation.POSITIVE_FRONT);
                    cube.addRotation(Cube3D.RotateOperation.POSITIVE_FRONT);
                    controller.positiveF();
                    controller.positiveF();
                }

                cube.addRotation(Cube3D.RotateOperation.POSITIVE_DOWN);
                controller.positiveD();
            }

        }

    }

    private void makeRightWhiteCross() {
        for (int i = 0; i < 4; i++) {
            Color[][] frontSide = model.getFrontSide();

            if (frontSide[0][1] != frontSide[1][1]) {
                int rotationCounter = 0;
                cube.addRotation(Cube3D.RotateOperation.POSITIVE_FRONT);
                cube.addRotation(Cube3D.RotateOperation.POSITIVE_FRONT);
                controller.positiveF();
                controller.positiveF();

                frontSide = model.getFrontSide();

                while (frontSide[2][1] != frontSide[1][1]) {
                    cube.addRotation(Cube3D.RotateOperation.POSITIVE_DOWN);
                    controller.positiveD();
                    cube.addRotation(Cube3D.RotateOperation.POSITIVE_HORIZONTAL);
                    controller.rotateRightToFront();
                    frontSide = model.getFrontSide();
                    rotationCounter += 1;
                }

                cube.addRotation(Cube3D.RotateOperation.POSITIVE_FRONT);
                cube.addRotation(Cube3D.RotateOperation.POSITIVE_FRONT);
                controller.positiveF();
                controller.positiveF();

                for (int j = 0; j < rotationCounter; j++) {
                    cube.addRotation(Cube3D.RotateOperation.NEGATIVE_DOWN);
                    controller.negativeD();
                    cube.addRotation(Cube3D.RotateOperation.NEGATIVE_HORIZONTAL);
                    controller.rotateLeftToFront();
                }

                cube.addRotation(Cube3D.RotateOperation.POSITIVE_FRONT);
                cube.addRotation(Cube3D.RotateOperation.POSITIVE_FRONT);
                controller.positiveF();
                controller.positiveF();
            }

            cube.addRotation(Cube3D.RotateOperation.POSITIVE_HORIZONTAL);
            controller.rotateRightToFront();
        }
    }

    private void purifyWhiteCross() {
        for (int i = 0; i < 4; i++) {
            CubePart cubePart = model.getMovableCubes().get(CubesModel.CubeNumber.TOP_CORNER_RIGHT_FRONT.number);

            if (cubePart.frontColor == Color.WHITE) {
                CubePart bottomCube = model.getMovableCubes().get(CubesModel.CubeNumber.BOTTOM_CORNER_RIGHT_FRONT.number);
                while (bottomCube.cornerColor == Color.WHITE || bottomCube.borderColor == Color.WHITE) {
                    cube.addRotation(Cube3D.RotateOperation.NEGATIVE_DOWN);
                    controller.negativeD();
                    bottomCube = model.getMovableCubes().get(CubesModel.CubeNumber.BOTTOM_CORNER_RIGHT_FRONT.number);
                }
                cube.addRotation(Cube3D.RotateOperation.NEGATIVE_RIGHT);
                cube.addRotation(Cube3D.RotateOperation.NEGATIVE_DOWN);
                cube.addRotation(Cube3D.RotateOperation.POSITIVE_RIGHT);
                controller.negativeR();
                controller.negativeD();
                controller.positiveR();
            }

            cube.addRotation(Cube3D.RotateOperation.POSITIVE_HORIZONTAL);
            controller.rotateRightToFront();
        }

        cube.addRotation(Cube3D.RotateOperation.POSITIVE_VERTICAL);
        cube.addRotation(Cube3D.RotateOperation.POSITIVE_VERTICAL);
        controller.rotateUpToFront();
        controller.rotateUpToFront();

        for (int i = 0; i < 4; i++) {
            CubePart cubePart = model.getMovableCubes().get(CubesModel.CubeNumber.BOTTOM_CORNER_RIGHT_FRONT.number);

            if (cubePart.borderColor == Color.WHITE || cubePart.cornerColor == Color.WHITE) {
                CubePart topCubePart = model.getMovableCubes().get(CubesModel.CubeNumber.TOP_CORNER_RIGHT_FRONT.number);
                while (topCubePart.cornerColor == Color.WHITE || topCubePart.borderColor == Color.WHITE ||
                        topCubePart.frontColor == Color.WHITE) {
                    cube.addRotation(Cube3D.RotateOperation.POSITIVE_TOP);
                    controller.positiveT();
                    topCubePart = model.getMovableCubes().get(CubesModel.CubeNumber.TOP_CORNER_RIGHT_FRONT.number);
                }
                cube.addRotation(Cube3D.RotateOperation.POSITIVE_RIGHT);
                cube.addRotation(Cube3D.RotateOperation.POSITIVE_TOP);
                cube.addRotation(Cube3D.RotateOperation.NEGATIVE_RIGHT);
                controller.positiveR();
                controller.positiveT();
                controller.negativeR();
            }

            cube.addRotation(Cube3D.RotateOperation.POSITIVE_HORIZONTAL);
            controller.rotateRightToFront();
        }

        cube.addRotation(Cube3D.RotateOperation.POSITIVE_VERTICAL);
        cube.addRotation(Cube3D.RotateOperation.POSITIVE_VERTICAL);
        controller.rotateUpToFront();
        controller.rotateUpToFront();
    }

    private void makeFullWhiteSide() {
        ArrayList<CubePart> movableCubes = model.getMovableCubes();

        cube.addRotation(Cube3D.RotateOperation.POSITIVE_VERTICAL);
        cube.addRotation(Cube3D.RotateOperation.POSITIVE_VERTICAL);
        controller.rotateUpToFront();
        controller.rotateUpToFront();

        for (int i = 0; i < 4; i++) {
            Color frontColor = model.getFrontCenter().frontColor;
            Color rightColor = model.getRightCenter().frontColor;

            Set<Color> sideColors = new HashSet<>();
            sideColors.add(frontColor);
            sideColors.add(rightColor);

            CubePart topCube = movableCubes.get(CubesModel.CubeNumber.TOP_CORNER_RIGHT_FRONT.number);
            Set<Color> topCubeColors = new HashSet<>();
            makeCornerColorSet(topCube, topCubeColors);
            while (!topCubeColors.equals(sideColors)) {
                cube.addRotation(Cube3D.RotateOperation.POSITIVE_TOP);
                controller.positiveT();
                topCube = movableCubes.get(CubesModel.CubeNumber.TOP_CORNER_RIGHT_FRONT.number);
                topCubeColors = new HashSet<>();
                makeCornerColorSet(topCube, topCubeColors);
            }

            CubePart bottomCube = movableCubes.get(CubesModel.CubeNumber.BOTTOM_CORNER_RIGHT_FRONT.number);
            while (bottomCube.frontColor != Color.WHITE) {
                rightAlgorithm();
                bottomCube = movableCubes.get(CubesModel.CubeNumber.BOTTOM_CORNER_RIGHT_FRONT.number);
            }

            cube.addRotation(Cube3D.RotateOperation.POSITIVE_HORIZONTAL);
            controller.rotateRightToFront();
        }
    }

    public void makeFullTwoLayers() {
        boolean isThereCubesOnTopSide = true;

        while (isThereCubesOnTopSide) {
            isThereCubesOnTopSide = checkCubesOnTopSide();
            if (!isThereCubesOnTopSide) {
                if (!checkSecondLayer()) {
                    isThereCubesOnTopSide = true;
                }
            }
            for (int i = 0; i < 4; i++) {
                CubePart topCube = model.getMovableCubes().get(CubesModel.CubeNumber.TOP_BORDER_FRONT.number);
                for (int j = 0; j < 4; j++) {
                    if (topCube.borderColor == model.getFrontCenter().frontColor &&
                            topCube.frontColor != Color.YELLOW) {
                        break;
                    }
                    cube.addRotation(Cube3D.RotateOperation.POSITIVE_TOP);
                    controller.positiveT();
                    topCube = model.getMovableCubes().get(CubesModel.CubeNumber.TOP_BORDER_FRONT.number);
                }
                if (topCube.borderColor == model.getFrontCenter().frontColor &&
                        topCube.frontColor != Color.YELLOW) {
                    if (topCube.frontColor == model.getRightCenter().frontColor) {
                        insertToRight();
                    } else {
                        insertToLeft();
                    }
                }
                cube.addRotation(Cube3D.RotateOperation.POSITIVE_HORIZONTAL);
                controller.rotateRightToFront();
            }
        }

    }

    private boolean checkCubesOnTopSide() {
        CubePart topCube = model.getMovableCubes().get(CubesModel.CubeNumber.TOP_BORDER_FRONT.number);
        for (int i = 0; i < 4; i++) {
            if (topCube.borderColor != Color.YELLOW &&
                    topCube.frontColor != Color.YELLOW) {
                break;
            }
            cube.addRotation(Cube3D.RotateOperation.POSITIVE_TOP);
            controller.positiveT();
            topCube = model.getMovableCubes().get(CubesModel.CubeNumber.TOP_BORDER_FRONT.number);
        }

        return (topCube.borderColor != Color.YELLOW &&
                topCube.frontColor != Color.YELLOW);
    }

    private boolean checkSecondLayer() {
        for (int i = 0; i < 4; i++) {
            Color[][] frontSide = model.getFrontSide();

            if (frontSide[1][0] != frontSide[1][1]) {
                insertToLeft();
                return false;
            }

            if (frontSide[1][2] != frontSide[1][1]) {
                insertToRight();
                return false;
            }

            cube.addRotation(Cube3D.RotateOperation.POSITIVE_HORIZONTAL);
            controller.rotateRightToFront();
        }

        return true;
    }

    private void insertToRight() {
        cube.addRotation(Cube3D.RotateOperation.POSITIVE_TOP);
        cube.addRotation(Cube3D.RotateOperation.POSITIVE_RIGHT);
        cube.addRotation(Cube3D.RotateOperation.NEGATIVE_TOP);
        cube.addRotation(Cube3D.RotateOperation.NEGATIVE_RIGHT);
        cube.addRotation(Cube3D.RotateOperation.NEGATIVE_TOP);
        cube.addRotation(Cube3D.RotateOperation.NEGATIVE_FRONT);
        cube.addRotation(Cube3D.RotateOperation.POSITIVE_TOP);
        cube.addRotation(Cube3D.RotateOperation.POSITIVE_FRONT);
        controller.positiveT();
        controller.positiveR();
        controller.negativeT();
        controller.negativeR();
        controller.negativeT();
        controller.negativeF();
        controller.positiveT();
        controller.positiveF();
    }

    private void insertToLeft() {
        cube.addRotation(Cube3D.RotateOperation.NEGATIVE_TOP);
        cube.addRotation(Cube3D.RotateOperation.NEGATIVE_LEFT);
        cube.addRotation(Cube3D.RotateOperation.POSITIVE_TOP);
        cube.addRotation(Cube3D.RotateOperation.POSITIVE_LEFT);
        cube.addRotation(Cube3D.RotateOperation.POSITIVE_TOP);
        cube.addRotation(Cube3D.RotateOperation.POSITIVE_FRONT);
        cube.addRotation(Cube3D.RotateOperation.NEGATIVE_TOP);
        cube.addRotation(Cube3D.RotateOperation.NEGATIVE_FRONT);
        controller.negativeT();
        controller.negativeL();
        controller.positiveT();
        controller.positiveL();
        controller.positiveT();
        controller.positiveF();
        controller.negativeT();
        controller.negativeF();
    }

    private void makeCornerColorSet(CubePart topCube, Set<Color> topCubeColors) {
        if (topCube.frontColor != Color.WHITE) {
            topCubeColors.add(topCube.frontColor);
        }
        if (topCube.borderColor != Color.WHITE) {
            topCubeColors.add(topCube.borderColor);
        }
        if (topCube.cornerColor != Color.WHITE) {
            topCubeColors.add(topCube.cornerColor);
        }
    }

    private void rightAlgorithm() {
        cube.addRotation(Cube3D.RotateOperation.POSITIVE_RIGHT);
        cube.addRotation(Cube3D.RotateOperation.POSITIVE_TOP);
        cube.addRotation(Cube3D.RotateOperation.NEGATIVE_RIGHT);
        cube.addRotation(Cube3D.RotateOperation.NEGATIVE_TOP);
        controller.positiveR();
        controller.positiveT();
        controller.negativeR();
        controller.negativeT();
    }
}
