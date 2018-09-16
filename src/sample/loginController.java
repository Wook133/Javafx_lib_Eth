package sample;

import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import org.web3j.crypto.Credentials;
import org.web3j.crypto.WalletUtils;
import org.web3j.protocol.Web3j;
import org.web3j.protocol.http.HttpService;

import java.io.File;
import java.io.FileInputStream;
import java.io.ObjectInputStream;
import java.util.ArrayList;

public class loginController {
    private Canvas canvas = null;
    private Stage stage = null;
    String smartcontractaddress1 = "0x409780d204b5df57a021652da76e77dfb8342746";
    String smartcontractaddress2 = "0x2979e5ad0dd719f9689300e54687059398e0d336";
    public PasswordField txtPass;
    public Button btnLoad;
    public Button btnLogin;

    public File selectedFile;
    public String sPath;
    public String sPassword;
    public void linkToUI(Stage stage, Scene scene) throws Exception {
        // remember the stage
        this.stage = stage;
        // obtain controls
        canvas = (Canvas) scene.lookup("#canvas");
        Button btnLoad = (Button) scene.lookup("#load");
        Button btnLogin = (Button) scene.lookup("#login");
        TextField txtPassword = (TextField) scene.lookup("#password");
        btnLoad.setOnAction(event -> load());
        btnLogin.setOnAction(event -> login(txtPassword));
    }
    private void load()
    {
        try {
        // create a file chooser that opens *.shapes files
        FileChooser fileChooser = new FileChooser();
        fileChooser.setTitle("Open Keystore File");
        fileChooser.getExtensionFilters().addAll(
                new FileChooser.ExtensionFilter("Keystore", "*.*"));
        // display the chooser and return the file selected
        selectedFile = fileChooser.showOpenDialog(stage);
        System.out.println(selectedFile.getAbsolutePath());
        sPath = selectedFile.getAbsolutePath().replaceAll("[/\\\\]", "//");
        System.out.println(sPath);
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
    }

    private void login(TextField txtPassword)
    {
        try {
            sPassword = txtPassword.getText();
            System.out.println("Password: " + sPassword);
            Web3j web3j = Web3j.build(new HttpService());
            System.out.println("Connected to Ethereum client version: " + web3j.web3ClientVersion().send().getWeb3ClientVersion().toString());
            Credentials credentials = WalletUtils.loadCredentials(sPassword, sPath);
            System.out.println("Credentials loaded: " + credentials.getAddress());
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
    }


}
