package code.visualization;

import code.calculation.Color;
import javafx.geometry.Point3D;
import javafx.scene.Group;
import javafx.scene.image.Image;
import javafx.scene.paint.PhongMaterial;
import javafx.scene.shape.MeshView;
import javafx.scene.shape.TriangleMesh;
import javafx.scene.transform.Rotate;
import javafx.scene.transform.Translate;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

public class Cube3D {

    Group cube = new Group();
    Rotate rotateX = new Rotate(30, 0.1, -0.5, 1.5, Rotate.X_AXIS);
    Rotate rotateY = new Rotate(20, 0.1, -0.5, 1.5, Rotate.Y_AXIS);

    public Cube3D() throws FileNotFoundException {
        PhongMaterial material = new PhongMaterial();
        material.setDiffuseMap(new Image(
            new FileInputStream("E:\\project\\rubiksCube\\src\\main\\java\\code\\imageResources\\color_palette.png")));

        AtomicInteger cont = new AtomicInteger();
        cubeFacePatterns.forEach(p -> {
            MeshView meshP = new MeshView();
            meshP.setMesh(createCube(p));
            meshP.setMaterial(material);
            Point3D pt = cubePositions.get(cont.getAndIncrement());
            meshP.getTransforms().addAll(new Translate(pt.getX(), pt.getY(), pt.getZ()));
            cube.getChildren().add(meshP);

        });

        cube.getTransforms().addAll(rotateX, rotateY);
    }

    public Group getCube() {
        return cube;
    }

    public Rotate getRotateX() {
        return rotateX;
    }

    public Rotate getRotateY() {
        return rotateY;
    }

    public TriangleMesh createCube(int[] faces) {
        TriangleMesh mesh = new TriangleMesh();

        mesh.getPoints().addAll(
                0f, 0f, 0f,
                0f, 0.5f, 0f,
                -0.5f, 0f, 0f,
                -0.5f, 0.5f, 0f,
                0f, 0f, -0.5f,
                0f, 0.5f, -0.5f,
                -0.5f, 0f, -0.5f,
                -0.5f, 0.5f, -0.5f
        );
        mesh.getTexCoords().addAll(
                1f, 0f,
                0f, 0f,
                1f, 1f / 7f,
                0f, 1f / 7f,
                1f, 2f / 7f,
                0f, 2f / 7f,
                1f, 3f / 7f,
                0f, 3f / 7f,
                1f, 4f / 7f,
                0f, 4f / 7f,
                1f, 5f / 7f,
                0f, 5f / 7f,
                1f, 6f / 7f,
                0f, 6f / 7f,
                1f, 1f,
                0f, 1f
        );
        mesh.getFaces().addAll(
                4, faces[0], 0, 2 + faces[0], 6, 1 + faces[0], //TOP
                0, 1 + faces[0], 2, 3 + faces[0], 6, 2 + faces[0],

                6, faces[1], 7, 2 + faces[1], 4, 1 + faces[1],       //FRONT
                7, 1 + faces[1], 5, 3 + faces[1], 4, 2 + faces[1],

                4, faces[2], 5, 2 + faces[2], 0, 1 + faces[2],       //RIGHT
                5, 1 + faces[2], 1, 3 + faces[2], 0, 2 + faces[2],

                2, faces[3], 3, 2 + faces[3], 6, 1 + faces[3],       //LEFT
                3, 1 + faces[3], 7, 3 + faces[3], 6, 2 + faces[3],

                0, faces[4], 1, 2 + faces[4], 2, 1 + faces[4],       //BACK
                1, 1 + faces[4], 3, 3 + faces[4], 2, 2 + faces[4],

                1, faces[5], 5, 2 + faces[5], 3, 1 + faces[5],       //DOWN
                5, 1 + faces[5], 7, 3 + faces[5], 3, 2 + faces[5]
        );

        return mesh;
    }

    private static final int[] TOP_CORNER_FRONT_LEFT = new int[] {Color.WHITE.number,
                                                                  Color.RED.number,
                                                                  Color.BLACK.number,
                                                                  Color.GREEN.number,
                                                                  Color.BLACK.number,
                                                                  Color.BLACK.number};
    private static final int[] TOP_BORDER_FRONT = new int[] {code.calculation.Color.WHITE.number,
            Color.RED.number,
            Color.BLACK.number,
            Color.BLACK.number,
            Color.BLACK.number,
            Color.BLACK.number};

    private static final int[] TOP_CORNER_RIGHT_FRONT = new int[] {Color.WHITE.number,
            Color.RED.number,
            Color.BLUE.number,
            Color.BLACK.number,
            Color.BLACK.number,
            Color.BLACK.number};

    private static final int[] TOP_BORDER_RIGHT = new int[] {Color.WHITE.number,
            Color.BLACK.number,
            Color.BLUE.number,
            Color.BLACK.number,
            Color.BLACK.number,
            Color.BLACK.number};

    private static final int[] TOP_CORNER_BACK_RIGHT = new int[] {Color.WHITE.number,
            Color.BLACK.number,
            Color.BLUE.number,
            Color.BLACK.number,
            Color.ORANGE.number,
            Color.BLACK.number};

    private static final int[] TOP_BORDER_BACK = new int[] {Color.WHITE.number,
            Color.BLACK.number,
            Color.BLACK.number,
            Color.BLACK.number,
            Color.ORANGE.number,
            Color.BLACK.number};

    private static final int[] TOP_CORNER_LEFT_BACK = new int[] {Color.WHITE.number,
            Color.BLACK.number,
            Color.BLACK.number,
            Color.GREEN.number,
            Color.ORANGE.number,
            Color.BLACK.number};

    private static final int[] TOP_BORDER_LEFT = new int[] {Color.WHITE.number,
            Color.BLACK.number,
            Color.BLACK.number,
            Color.GREEN.number,
            Color.BLACK.number,
            Color.BLACK.number};

    private static final int[] TOP_CENTER = new int[] {Color.WHITE.number,
            Color.BLACK.number,
            Color.BLACK.number,
            Color.BLACK.number,
            Color.BLACK.number,
            Color.BLACK.number};

    private static final int[] MID_BORDER_FRONT_LEFT = new int[] {Color.BLACK.number,
            Color.RED.number,
            Color.BLACK.number,
            Color.GREEN.number,
            Color.BLACK.number,
            Color.BLACK.number};

    private static final int[] MID_CENTER_FRONT = new int[] {Color.BLACK.number,
            Color.RED.number,
            Color.BLACK.number,
            Color.BLACK.number,
            Color.BLACK.number,
            Color.BLACK.number};

    private static final int[] MID_BORDER_RIGHT_FRONT = new int[] {Color.BLACK.number,
            Color.RED.number,
            Color.BLUE.number,
            Color.BLACK.number,
            Color.BLACK.number,
            Color.BLACK.number};

    private static final int[] MID_CENTER_RIGHT = new int[] {Color.BLACK.number,
            Color.BLACK.number,
            Color.BLUE.number,
            Color.BLACK.number,
            Color.BLACK.number,
            Color.BLACK.number};

    private static final int[] MID_BORDER_BACK_RIGHT = new int[] {Color.BLACK.number,
            Color.BLACK.number,
            Color.BLUE.number,
            Color.BLACK.number,
            Color.ORANGE.number,
            Color.BLACK.number};

    private static final int[] MID_CENTER_BACK = new int[] {Color.BLACK.number,
            Color.BLACK.number,
            Color.BLACK.number,
            Color.BLACK.number,
            Color.ORANGE.number,
            Color.BLACK.number};

    private static final int[] MID_BORDER_LEFT_BACK = new int[] {Color.BLACK.number,
            Color.BLACK.number,
            Color.BLACK.number,
            Color.GREEN.number,
            Color.ORANGE.number,
            Color.BLACK.number};

    private static final int[] MID_CENTER_LEFT = new int[] {Color.BLACK.number,
            Color.BLACK.number,
            Color.BLACK.number,
            Color.GREEN.number,
            Color.BLACK.number,
            Color.BLACK.number};

    private static final int[] BOTTOM_CORNER_FRONT_LEFT = new int[] {Color.BLACK.number,
            Color.RED.number,
            Color.BLACK.number,
            Color.GREEN.number,
            Color.BLACK.number,
            Color.YELLOW.number};

    private static final int[] BOTTOM_BORDER_FRONT = new int[] {Color.BLACK.number,
            Color.RED.number,
            Color.BLACK.number,
            Color.BLACK.number,
            Color.BLACK.number,
            Color.YELLOW.number};

    private static final int[] BOTTOM_CORNER_RIGHT_FRONT = new int[] {Color.BLACK.number,
            Color.RED.number,
            Color.BLUE.number,
            Color.BLACK.number,
            Color.BLACK.number,
            Color.YELLOW.number};

    private static final int[] BOTTOM_BORDER_RIGHT = new int[] {Color.BLACK.number,
            Color.BLACK.number,
            Color.BLUE.number,
            Color.BLACK.number,
            Color.BLACK.number,
            Color.YELLOW.number};

    private static final int[] BOTTOM_CORNER_BACK_RIGHT = new int[] {Color.BLACK.number,
            Color.BLACK.number,
            Color.BLUE.number,
            Color.BLACK.number,
            Color.ORANGE.number,
            Color.YELLOW.number};

    private static final int[] BOTTOM_BORDER_BACK = new int[] {Color.BLACK.number,
            Color.BLACK.number,
            Color.BLACK.number,
            Color.BLACK.number,
            Color.ORANGE.number,
            Color.YELLOW.number};

    private static final int[] BOTTOM_CORNER_LEFT_BACK = new int[] {Color.BLACK.number,
            Color.BLACK.number,
            Color.BLACK.number,
            Color.GREEN.number,
            Color.ORANGE.number,
            Color.YELLOW.number};
    private static final int[] BOTTOM_BORDER_LEFT = new int[] {Color.BLACK.number,
            Color.BLACK.number,
            Color.BLACK.number,
            Color.GREEN.number,
            Color.BLACK.number,
            Color.YELLOW.number};

    private static final int[] BOTTOM_CENTER = new int[] {Color.BLACK.number,
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
