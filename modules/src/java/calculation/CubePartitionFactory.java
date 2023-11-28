package java.calculation;

import java.util.List;

public class CubePartitionFactory {

    public enum Color {
        WHITE,
        RED,
        BLUE,
        GREEN,
        ORANGE,
        YELLOW
    }

    public enum CubesType {
        //center of a cube side
        CENTER,
        //a cube at the border of 2 sides
        BORDER,
        //a cube at the corner of 3 sides
        CORNER
    }

    public CubePartitionFactory(CubesType type, Color sideColor) {

    }
}
