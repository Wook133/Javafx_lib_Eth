package sample;

import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

import java.io.File;
import java.io.FileInputStream;
import java.io.ObjectInputStream;
import java.util.ArrayList;

public class Controller {
    String smartcontractaddress1 = "0x409780d204b5df57a021652da76e77dfb8342746";
    String smartcontractaddress2 = "0x2979e5ad0dd719f9689300e54687059398e0d336";
    public PasswordField pwField;
    public Button btnLoad;
    public Button btnLogin;

    public File selectedFile;




    // the image onto which this controller will paint
    private Canvas canvas = null;
    // remember the stage - need it to link to open/save chooser
    private Stage stage = null;

    public void linkToUI(Stage stage, Scene scene)
    {
        this.stage = stage;
        canvas = (Canvas) scene.lookup("#canvas");
        Button btnLoad = (Button) scene.lookup("#load");
        TextField txtPassword;


        btnLoad.setOnAction(event -> btnClickLoad());

    }

    private void btnClickLoad()
    {
        // create a file chooser that opens *.shapes files

        FileChooser fileChooser = new FileChooser();
        fileChooser.setTitle("Open Shapes File");
        fileChooser.getExtensionFilters().addAll(
                new FileChooser.ExtensionFilter("keystore", "*."));

        // display the chooser and return the file selected
        selectedFile = fileChooser.showOpenDialog(stage);

    }


}
