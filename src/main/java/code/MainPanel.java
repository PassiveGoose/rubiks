package code;

import code.calculation.CubeController;
import code.calculation.CubesModel;
import code.visualization.Cube3D;
import code.visualization.Cube3DPart;
import javafx.application.Application;
import javafx.scene.*;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

import java.io.FileNotFoundException;
import java.util.ArrayList;

public final class MainPanel extends Application {

    Cube3D cube3D;

    CubeController controller;

    @Override
    public void start(Stage stage) throws FileNotFoundException{
        CubesModel model = new CubesModel();
        controller = model.getController();

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

        Solver cubeSolver = new Solver(model, cube3D);

        scene.addEventFilter(KeyEvent.KEY_PRESSED, (KeyEvent event) -> {
            if (!cube3D.isRotating()) {
                if (event.getCode().equals(KeyCode.P)) {
                    model.printModel();
                }
                if (event.getCode().equals(KeyCode.M)) {
                    try {
                        messCube();
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                }
                if (event.getCode().equals(KeyCode.S)) {
                    cubeSolver.solveCube();
                }
                if (event.getCode().equals(KeyCode.Q)) {
                    cubeSolver.makeFullTwoLayers();
                }
            }
            if (event.getCode().equals(KeyCode.T)) {
                if (event.isShiftDown()) {
                    Ti();
                } else {
                    T();
                }
            }
            if (event.getCode().equals(KeyCode.R)) {
                if (event.isShiftDown()) {
                    Ri();
                } else {
                    R();
                }
            }
            if (event.getCode().equals(KeyCode.L)) {
                if (event.isShiftDown()) {
                    Li();
                } else {
                    L();
                }
            }
            if (event.getCode().equals(KeyCode.D)) {
                if (event.isShiftDown()) {
                    Di();
                } else {
                    D();
                }
            }
            if (event.getCode().equals(KeyCode.F)) {
                if (event.isShiftDown()) {
                    Fi();
                } else {
                    F();
                }
            }
            if (event.getCode().equals(KeyCode.B)) {
                if (event.isShiftDown()) {
                    Bi();
                } else {
                    B();
                }
            }
            if (event.getCode().equals(KeyCode.RIGHT)) {
                cube3D.addRotation(Cube3D.RotateOperation.POSITIVE_HORIZONTAL);
                controller.rotateRightToFront();
            }
            if (event.getCode().equals(KeyCode.LEFT)) {
                cube3D.addRotation(Cube3D.RotateOperation.NEGATIVE_HORIZONTAL);
                controller.rotateLeftToFront();
            }
            if (event.getCode().equals(KeyCode.DOWN)) {
                cube3D.addRotation(Cube3D.RotateOperation.POSITIVE_VERTICAL);
                controller.rotateUpToFront();
            }
            if (event.getCode().equals(KeyCode.UP)) {
                cube3D.addRotation(Cube3D.RotateOperation.NEGATIVE_VERTICAL);
                controller.rotateDownToFront();
            }
            event.consume();
        });

        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }

    private void messCube() throws InterruptedException {
        R();
        T();
        L();
        F();
        B();
        D();
        Bi();
        L();
        R();
        Ti();
        R();
        T();
        L();
        F();
        B();
        D();
        Bi();
        L();
        R();
        Ti();
        F();
        B();
        D();
        Bi();
        L();
        R();
        Ti();
        R();
        T();
    }

    public void T() {
        cube3D.addRotation(Cube3D.RotateOperation.POSITIVE_TOP);
        controller.positiveT();
    }

    public void Ti() {
        cube3D.addRotation(Cube3D.RotateOperation.NEGATIVE_TOP);
        controller.negativeT();
    }

    public void F() {
        cube3D.addRotation(Cube3D.RotateOperation.POSITIVE_FRONT);
        controller.positiveF();
    }

    public void Fi() {
        cube3D.addRotation(Cube3D.RotateOperation.NEGATIVE_FRONT);
        controller.negativeF();
    }

    public void R() {
        cube3D.addRotation(Cube3D.RotateOperation.POSITIVE_RIGHT);
        controller.positiveR();
    }

    public void Ri() {
        cube3D.addRotation(Cube3D.RotateOperation.NEGATIVE_RIGHT);
        controller.negativeR();
    }

    public void L() {
        cube3D.addRotation(Cube3D.RotateOperation.POSITIVE_LEFT);
        controller.positiveL();
    }

    public void Li() {
        cube3D.addRotation(Cube3D.RotateOperation.NEGATIVE_LEFT);
        controller.negativeL();
    }

    public void B() {
        cube3D.addRotation(Cube3D.RotateOperation.POSITIVE_BACK);
        controller.positiveB();
    }

    public void Bi() {
        cube3D.addRotation(Cube3D.RotateOperation.NEGATIVE_BACK);
        controller.negativeB();
    }

    public void D() {
        cube3D.addRotation(Cube3D.RotateOperation.POSITIVE_DOWN);
        controller.positiveD();
    }

    public void Di() {
        cube3D.addRotation(Cube3D.RotateOperation.NEGATIVE_DOWN);
        controller.negativeD();
    }
}
