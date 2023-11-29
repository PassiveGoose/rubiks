package code.calculation;

import org.junit.Assert;
import org.junit.Test;

public class CubeControllingTest {

    CubesModel model = new CubesModel();

    CubeController controller = model.getController();

    @Test
    public void test() {
        Color[][] predictableTopSide = new Color[][] {{Color.WHITE, Color.WHITE, Color.WHITE},
                                                      {Color.WHITE, Color.WHITE, Color.WHITE},
                                                      {Color.WHITE, Color.WHITE, Color.WHITE}};
        controller.negativeD();
        Color[][] topSide = model.getTopSide();
        for (int i = 0; i < topSide.length; i++) {
            Assert.assertArrayEquals(predictableTopSide[i], topSide[i]);
        }
    }

}
