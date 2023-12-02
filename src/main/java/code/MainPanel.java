package code;

import code.calculation.CubeController;
import code.calculation.CubesModel;
import code.visualization.Cube3D;
import javafx.application.Application;
import javafx.scene.*;
import javafx.scene.image.Image;
import javafx.scene.paint.Color;
import javafx.scene.paint.PhongMaterial;
import javafx.scene.shape.MeshView;
import javafx.scene.shape.TriangleMesh;
import javafx.scene.transform.Rotate;
import javafx.stage.Stage;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

public final class MainPanel extends Application {

    private double mousePosX;
    private double mousePosY;
    private double mouseOldX;
    private double mouseOldY;

    @Override
    public void start(Stage stage) throws FileNotFoundException {
        //buildCubeModel();

        Group sceneRoot = new Group();
        Scene scene = new Scene(sceneRoot, 800, 800, true, SceneAntialiasing.BALANCED);
        scene.setFill(Color.BLUE);
        PerspectiveCamera camera = new PerspectiveCamera(true);
        camera.setNearClip(0.1);
        camera.setFarClip(1000.0);
        camera.setTranslateZ(-10);
        scene.setCamera(camera);

        PhongMaterial material = new PhongMaterial();
        material.setDiffuseMap(new Image(
            new FileInputStream("E:\\project\\rubiksCube\\src\\main\\java\\code\\imageResources\\color_palette.png")));

        Cube3D cube3D = new Cube3D();

        TriangleMesh mesh = cube3D.createCube(new int[] {code.calculation.Color.WHITE.number,
                                                         code.calculation.Color.RED.number,
                                                         code.calculation.Color.BLUE.number,
                                                         code.calculation.Color.BLACK.number,
                                                         code.calculation.Color.BLACK.number,
                                                         code.calculation.Color.BLACK.number});

        Group meshGroup = new Group();
        MeshView meshView = new MeshView();
        meshView.setMesh(mesh);
        meshView.setMaterial(material);
        meshGroup.getChildren().add(meshView);

        Rotate rotateX = new Rotate(30, 0, 0, 0, Rotate.X_AXIS);
        Rotate rotateY = new Rotate(20, 0, 0, 0, Rotate.Y_AXIS);
        meshGroup.getTransforms().addAll(rotateX, rotateY);

        sceneRoot.getChildren().addAll(meshGroup, new AmbientLight(Color.WHITE));

        scene.setOnMousePressed(me -> {
            mouseOldX = me.getSceneX();
            mouseOldY = me.getSceneY();
        });
        scene.setOnMouseDragged(me -> {
            mousePosX = me.getSceneX();
            mousePosY = me.getSceneY();
            rotateX.setAngle(rotateX.getAngle()-(mouseOldY - mousePosY));
            rotateY.setAngle(rotateY.getAngle()+(mouseOldX - mousePosX));
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
