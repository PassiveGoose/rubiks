package code;

import code.calculation.CubeController;
import code.calculation.CubesModel;
import code.visualization.Cube3D;
import javafx.application.Application;
import javafx.scene.*;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

import java.io.FileNotFoundException;
import java.util.List;

public final class MainPanel extends Application {

    private double mousePosX;
    private double mousePosY;
    private double mouseOldX;
    private double mouseOldY;

    Cube3D cube3D;

    @Override
    public void start(Stage stage) throws FileNotFoundException{
        //buildCubeModel();

        Group sceneRoot = new Group();
        Scene scene = new Scene(sceneRoot, 800, 800, true, SceneAntialiasing.BALANCED);
        scene.setFill(Color.BLUE);
        PerspectiveCamera camera = new PerspectiveCamera(true);
        camera.setNearClip(0.1);
        camera.setFarClip(1000.0);
        camera.setTranslateZ(-10);
        scene.setCamera(camera);

        cube3D = new Cube3D();
        List<Group> cubes = cube3D.getCube();

        sceneRoot.getChildren().addAll(cubes);
        sceneRoot.getChildren().add(new AmbientLight(Color.WHITE));

        scene.addEventFilter(KeyEvent.KEY_PRESSED, (KeyEvent event) -> {
            if (event.getCode().equals(KeyCode.T)) {
                cube3D.getRotateTop().setAngle(cube3D.getRotateTop().getAngle() + 90);
            }
            if (event.getCode().equals(KeyCode.N)) {
                cube3D.getRotateNext().setAngle(cube3D.getRotateNext().getAngle() + 90);
            }
            event.consume();
        });
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
        });

        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
    private void buildCubeModel (){
        CubesModel model = new CubesModel();
        CubeController controller = model.getController();
        model.printModel();
        controller.rotateLeftToFront();
        controller.rotateUpToFront();
        model.printModel();

        controller.rotateDownToFront();
        controller.rotateRightToFront();
        model.printModel();
    }
}
