package code;

import code.calculation.CubeController;
import code.calculation.CubesModel;

public final class MainPanel {

    public MainPanel() {
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

    public static void main(String[] args) {
        final MainPanel panel = new MainPanel();
    }
}
