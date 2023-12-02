package code;

import code.calculation.CubeController;
import code.calculation.CubesModel;
import code.visualization.Cube3D;
import javafx.application.Application;
import javafx.scene.*;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

import java.io.FileNotFoundException;

public final class MainPanel extends Application {

    private double mousePosX;
    private double mousePosY;
    private double mouseOldX;
    private double mouseOldY;

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

        Cube3D cube3D = new Cube3D();
        Group cube = cube3D.getCube();

        sceneRoot.getChildren().addAll(cube, new AmbientLight(Color.WHITE));


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
