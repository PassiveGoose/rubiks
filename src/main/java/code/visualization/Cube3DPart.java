package code.visualization;

import javafx.geometry.Point3D;
import javafx.scene.Group;
import javafx.scene.image.Image;
import javafx.scene.paint.PhongMaterial;
import javafx.scene.shape.MeshView;
import javafx.scene.shape.TriangleMesh;
import javafx.scene.transform.Affine;
import javafx.scene.transform.Translate;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

public class Cube3DPart extends Group{

    Affine affine = new Affine();

    Cube3DPart (int[] pattern, Point3D position) throws FileNotFoundException {
        PhongMaterial material = new PhongMaterial();
        material.setDiffuseMap(new Image(
                new FileInputStream("E:\\project\\rubiksCube\\src\\main\\java\\code\\imageResources\\color_palette.png")));

        MeshView meshP = new MeshView();
        meshP.setMesh(createCube(pattern));
        meshP.setMaterial(material);
        meshP.getTransforms().add(new Translate(position.getX(), position.getY(), position.getZ()));
        this.getChildren().addAll(meshP);
    }

    public Affine getAffine() {
        return affine;
    }

    public TriangleMesh createCube(int[] faces) {
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
                4, faces[0], 0, 2 + faces[0], 6, 1 + faces[0], //TOP
                0, 1 + faces[0], 2, 3 + faces[0], 6, 2 + faces[0],

                6, faces[1], 7, 2 + faces[1], 4, 1 + faces[1],       //FRONT
                7, 1 + faces[1], 5, 3 + faces[1], 4, 2 + faces[1],

                4, faces[2], 5, 2 + faces[2], 0, 1 + faces[2],       //RIGHT
                5, 1 + faces[2], 1, 3 + faces[2], 0, 2 + faces[2],

                2, faces[3], 3, 2 + faces[3], 6, 1 + faces[3],       //LEFT
                3, 1 + faces[3], 7, 3 + faces[3], 6, 2 + faces[3],

                0, faces[4], 1, 2 + faces[4], 2, 1 + faces[4],       //BACK
                1, 1 + faces[4], 3, 3 + faces[4], 2, 2 + faces[4],

                1, faces[5], 5, 2 + faces[5], 3, 1 + faces[5],       //DOWN
                5, 1 + faces[5], 7, 3 + faces[5], 3, 2 + faces[5]
        );

        return mesh;
    }
}
