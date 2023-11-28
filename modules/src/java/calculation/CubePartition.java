package java.calculation;

import java.util.List;

public class CubePartition {

    public enum CubeType {
        //center of a cube side
        CENTER,
        //a cube at the border of 2 sides
        BORDER,
        //a cube at the corner of 3 sides
        CORNER;
    }

    Color frontColor = null;

    Color borderColor = null;

    Color cornerColor = null;

    CubeType type = null;

    public CubePartition(CubeType type, List<Color> colors) {
        this.type = type;
        frontColor = colors.get(0);
        switch (type) {
            case BORDER -> {
                borderColor = colors.get(1);
            }
            case CORNER -> {
                borderColor = colors.get(1);
                cornerColor = colors.get(2);
            }
        }
    }
}
