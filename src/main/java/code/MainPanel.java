package code;

import code.calculation.CubeController;
import code.calculation.CubesModel;
import code.visualization.Cube3D;
import code.visualization.Cube3DPart;
import javafx.animation.KeyFrame;
import javafx.animation.KeyValue;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.scene.*;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.paint.Color;
import javafx.scene.transform.Rotate;
import javafx.stage.Stage;
import javafx.util.Duration;

import java.io.FileNotFoundException;
import java.util.ArrayList;

public final class MainPanel extends Application {

    private static final int POSITIVE_ROTATION = 1;

    private static final int NEGATIVE_ROTATION = -1;

    private double mousePosX;
    private double mousePosY;
    private double mouseOldX;
    private double mouseOldY;

    Cube3D cube3D;

    @Override
    public void start(Stage stage) throws FileNotFoundException{
        CubesModel model = new CubesModel();
        CubeController controller = model.getController();

        Group sceneRoot = new Group();
        Scene scene = new Scene(sceneRoot, 800, 800, true, SceneAntialiasing.BALANCED);
        scene.setFill(Color.BLUE);
        PerspectiveCamera camera = new PerspectiveCamera(true);
        camera.setNearClip(0.1);
        camera.setFarClip(1000.0);
        camera.setTranslateZ(-10);
        scene.setCamera(camera);

        cube3D = new Cube3D();
        ArrayList<Cube3DPart> cubes = cube3D.getCube();

        sceneRoot.getChildren().addAll(cubes);
        sceneRoot.getChildren().add(new AmbientLight(Color.WHITE));

        scene.addEventFilter(KeyEvent.KEY_PRESSED, (KeyEvent event) -> {
            if (!cube3D.isRotating()) {
                if (event.getCode().equals(KeyCode.T)) {
                    if (event.isShiftDown()) {
                        cube3D.rotateTop(NEGATIVE_ROTATION);
                        controller.negativeT();
                    } else {
                        cube3D.rotateTop(POSITIVE_ROTATION);
                        controller.positiveT();
                    }
                }
                if (event.getCode().equals(KeyCode.R)) {
                    if (event.isShiftDown()) {
                        cube3D.rotateRight(NEGATIVE_ROTATION);
                        controller.negativeR();
                    } else {
                        cube3D.rotateRight(POSITIVE_ROTATION);
                        controller.positiveR();
                    }
                }
                if (event.getCode().equals(KeyCode.L)) {
                    if (event.isShiftDown()) {
                        cube3D.rotateLeft(NEGATIVE_ROTATION);
                        controller.negativeL();
                    } else {
                        cube3D.rotateLeft(POSITIVE_ROTATION);
                        controller.positiveL();
                    }
                }
                if (event.getCode().equals(KeyCode.D)) {
                    if (event.isShiftDown()) {
                        cube3D.rotateDown(NEGATIVE_ROTATION);
                        controller.negativeD();
                    } else {
                        cube3D.rotateDown(POSITIVE_ROTATION);
                        controller.positiveD();
                    }
                }
                if (event.getCode().equals(KeyCode.F)) {
                    if (event.isShiftDown()) {
                        cube3D.rotateFront(NEGATIVE_ROTATION);
                        controller.negativeF();
                    } else {
                        cube3D.rotateFront(POSITIVE_ROTATION);
                        controller.positiveF();
                    }
                }
                if (event.getCode().equals(KeyCode.B)) {
                    if (event.isShiftDown()) {
                        cube3D.rotateBack(NEGATIVE_ROTATION);
                        controller.negativeB();
                    } else {
                        cube3D.rotateBack(POSITIVE_ROTATION);
                        controller.positiveB();
                    }
                }
                if (event.getCode().equals(KeyCode.RIGHT)) {
                    cube3D.rotateHorizontal(POSITIVE_ROTATION);
                }
                if (event.getCode().equals(KeyCode.LEFT)) {
                    cube3D.rotateHorizontal(NEGATIVE_ROTATION);
                }
                if (event.getCode().equals(KeyCode.DOWN)) {
                    cube3D.rotateVertical(POSITIVE_ROTATION);
                }
                if (event.getCode().equals(KeyCode.UP)) {
                    cube3D.rotateVertical(NEGATIVE_ROTATION);
                }
                if (event.getCode().equals(KeyCode.P)) {
                    model.printModel();
                }
            }
            event.consume();
        });
        /*
        scene.setOnMousePressed(me -> {
            mouseOldX = me.getSceneX();
            mouseOldY = me.getSceneY();
        });
        scene.setOnMouseDragged(me -> {
            mousePosX = me.getSceneX();
            mousePosY = me.getSceneY();
            cube3D.getRotateX().setAngle(cube3D.getRotateX().getAngle()-(mouseOldY - mousePosY));
            cube3D.getRotateY().setAngle(cube3D.getRotateY().getAngle()+(mouseOldX - mousePosX));
            mouseOldX = mousePosX;
            mouseOldY = mousePosY;
        });*/

        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}
