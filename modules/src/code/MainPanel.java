package code;

import code.calculation.CubesModel;

public class MainPanel {

    private MainPanel() {
        CubesModel model = new CubesModel();
        model.positiveR();
        model.printModel();
        System.out.println("model is done");

    }

    public static void main(String[] args) {
        final MainPanel panel = new MainPanel();
    }
}
