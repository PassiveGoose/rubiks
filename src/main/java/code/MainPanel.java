package code;

import code.calculation.CubeController;
import code.calculation.CubesModel;
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
                    0, 4, 1, 6, 2, 5, //BACK
                          1, 5, 3, 7, 2, 6,

                          1, 2, 5, 4, 3, 3, //DOWN
                          5, 3, 7, 5, 3, 4,

                          4, 8, 5, 10, 0, 9, //RIGHT
                          5, 9, 1, 11, 0, 10,

                          2, 6, 3, 8, 6, 7, //LEFT
                          3, 7, 7, 9, 6, 8,

                          6, 10, 7, 12, 4, 11, //FRONT
                          7, 11, 5, 13, 4, 12,

                          4, 12, 0, 14, 6, 13, //TOP
                          0, 13, 2, 15, 6, 14

        );

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
