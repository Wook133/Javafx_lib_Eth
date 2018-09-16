package sample;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.*;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import org.web3j.crypto.CipherException;
import org.web3j.crypto.Credentials;
import org.web3j.crypto.WalletUtils;
import org.web3j.protocol.Web3j;
import org.web3j.protocol.http.HttpService;

import java.io.File;
import java.util.concurrent.atomic.AtomicReference;

public class Runner extends Application {
    boolean loggedIn = false;
    String smartcontractaddress1 = "0x409780d204b5df57a021652da76e77dfb8342746";
    String smartcontractaddress2 = "0x2979e5ad0dd719f9689300e54687059398e0d336";

    public File selectedFile;
    public String sPath;

    Scene scLogin;
    Scene scMenu;
    Scene scApproval;
    Scene scAddInformation;
    Scene scGetInformation;

    public String sPassword;

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        primaryStage.setTitle("deVill Wagyu");

        scLogin = createLoginScene(primaryStage);
        primaryStage.setScene(scLogin);


        primaryStage.show();


    }

    public Scene createApproval(Stage stage)
    {
        GridPane grid = new GridPane();
        grid.setPrefWidth(300.0);
        grid.setPrefHeight(300.0);
        grid.setVgap(4);
        grid.setPadding(new Insets(5, 5, 5, 5));
        Label lblAddress = new Label("Please enter Address");
        TextField txtAddress = new TextField();
        Button btnAddApproval = new Button("Approve");
        Button btnRemoveApproval = new Button("Disapprove");
        Button btnMenu = new Button("Menu");
        grid.add(lblAddress, 0, 0);
        grid.add(txtAddress, 1, 0);
        grid.add(btnAddApproval, 0, 1);
        grid.add(btnRemoveApproval, 1, 1);
        grid.add(btnMenu, 0,2,2,1);
        scApproval = new Scene(grid);
        return scApproval;
    }



    public Scene createMenu(Stage stage)
    {
        GridPane grid = new GridPane();
        grid.setPrefWidth(300.0);
        grid.setPrefHeight(300.0);
        grid.setVgap(4);
        grid.setPadding(new Insets(5, 5, 5, 5));

        Button btnApproval = new Button("Approval");
        btnApproval.setOnAction(event -> stage.setScene(createApproval(stage)));

        Button btnAddInformaion = new Button("Add Information");

        Button btnGetInformation = new Button("Get Information");
        Button btnGetAllCows = new Button("All Wagyu Cattle");
        Button btnGetAllOwners = new Button("All Owners");
        Button btnClose = new Button("Close");
        grid.add(btnApproval, 0, 0);
        grid.add(btnAddInformaion, 1, 0);
        grid.add(btnGetInformation, 0, 1);
        grid.add(btnGetAllCows, 1, 1);
        grid.add(btnGetAllOwners, 0, 2);
        grid.add(btnClose, 1, 2);
        scMenu = new Scene((grid));
        return scMenu;
    }

    public Scene createLoginScene(Stage stage) {

        BorderPane borderPane = new BorderPane();
        borderPane.setPrefWidth(300.0);
        FlowPane flowPane = new FlowPane();
        Label lbl = new Label("Select your Keystore: ");
        Button btnLoad = new Button("Load");
        btnLoad.setId("load");

        Button btnLogin = new Button("Login");
        btnLogin.setId("login");

        TextField txtPassword = new TextField("");
        txtPassword.setId("password");
        Label lbl2 = new Label("Enter your password: ");

        Region p = new Region();
        p.setPrefSize(200.0, 0.0);
        Region p2 = new Region();
        p2.setPrefSize(100.0, 0.0);
        flowPane.getChildren().addAll(lbl, btnLoad, p,
                lbl2, txtPassword, p2,
                btnLogin
        );
        Canvas canvas = new Canvas(200, 200);
        canvas.setId("canvas");
        borderPane.setTop(flowPane);
        borderPane.setCenter(canvas);
        btnLoad.setOnAction(event -> loadKeystore(stage));
        AtomicReference<Scene> scTemp = new AtomicReference<>(new Scene((borderPane)));
        btnLogin.setOnAction(event ->
        {
            login(txtPassword, stage);
            if (loggedIn)
            {
                scTemp.set(createMenu(stage));
                stage.setScene(scTemp.get());
            }
        });
        return scTemp.get();
    }
    private void loadKeystore(Stage stage)
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
    private void login(TextField txtPassword, Stage stage)
    {

        try {
            sPassword = txtPassword.getText();
            System.out.println("Password: " + sPassword);
            Web3j web3j = Web3j.build(new HttpService());
            System.out.println("Connected to Ethereum client version: " + web3j.web3ClientVersion().send().getWeb3ClientVersion().toString());
            Credentials credentials = WalletUtils.loadCredentials(sPassword, sPath);
            System.out.println("Credentials loaded: " + credentials.getAddress());
            loggedIn = true;
            System.out.println("Correct Password and keystore combo");
           // stage.setScene(new Scene(new Pane()));

        }
        catch (CipherException ce)
        {
            loggedIn = false;
            System.out.println("Wrong Password and keystore combo");
        }
        catch (Exception e)
        {
            loggedIn = false;
            e.printStackTrace();
        }
    }


}
