package code;

import code.calculation.CubeController;
import code.calculation.CubesModel;
import javafx.application.Application;
import javafx.scene.paint.Color;
import javafx.scene.paint.PhongMaterial;
import javafx.scene.shape.Box;
import javafx.stage.Stage;

public final class MainPanel extends Application {

    @Override
    public void start(Stage stage) {
        buildCubeModel();

        Box box = new Box(5, 5, 5);
        PhongMaterial material = new PhongMaterial(Color.RED);
        box.setMaterial(material);
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
