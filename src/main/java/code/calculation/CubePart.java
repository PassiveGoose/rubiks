package code.calculation;

import java.util.List;

public class CubePart {

    public enum CubeType {
        //center of a cube side
        CENTER,
        //a cube at the border of 2 sides
        BORDER,
        //a cube at the corner of 3 sides
        CORNER
    }

    public Color frontColor;

    public Color borderColor = null;

    public Color cornerColor = null;

    CubeType type;

    public CubePart(CubeType type, List<Color> colors) {
        this.type = type;
        frontColor = colors.get(0);
        switch (type) {
            case BORDER -> borderColor = colors.get(1);
            case CORNER -> {
                borderColor = colors.get(1);
                cornerColor = colors.get(2);
            }
        }
    }
}
