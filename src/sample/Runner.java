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
import org.apache.commons.lang3.tuple.Triple;
import org.web3j.crypto.CipherException;
import org.web3j.crypto.Credentials;
import org.web3j.crypto.WalletUtils;
import org.web3j.protocol.Web3j;
import org.web3j.protocol.core.RemoteCall;
import org.web3j.protocol.http.HttpService;
import org.web3j.tuples.generated.Tuple3;
import org.web3j.tx.Contract;
import org.web3j.tx.ManagedTransaction;

import java.io.File;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.concurrent.atomic.AtomicReference;

public class Runner extends Application {
    boolean loggedIn = false;
    String smartcontractaddress1 = "0xef9e839064631c365162877c038d25304d4deb3a";
    String smartcontractaddress2 = "0xfb1203e8db28cf7cd6b9e21d66c4eae8b9977c64";

    ArrayList<String> ownerAddress = new ArrayList<>();
    ArrayList<Triple<String, String, String>> listInfo = new ArrayList<>();

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
        grid.setPrefWidth(400.0);
        grid.setPrefHeight(200.0);
        grid.setVgap(4);
        grid.setPadding(new Insets(5, 5, 5, 5));
        Label lblAddress = new Label("Please enter Address");
        TextField txtAddress = new TextField();
        Button btnAddOwner = new Button("Add Owner");
        btnAddOwner.setOnAction(event ->
        {
            try {
                Web3j web3j = Web3j.build(new HttpService());
                System.out.println("Connected to Ethereum client version: " + web3j.web3ClientVersion().send().getWeb3ClientVersion().toString());
                Credentials credentials = WalletUtils.loadCredentials(sPassword, sPath);
                test.P3AbsoluteBasic_sol_lifeInformation contract = test.P3AbsoluteBasic_sol_lifeInformation.load(smartcontractaddress2, web3j, credentials, ManagedTransaction.GAS_PRICE, Contract.GAS_LIMIT);
                contract.addOwners(txtAddress.getText()).send();
                System.out.println("Owner added with approval for " + txtAddress.getText());
            } catch (Exception e)
            {
                e.printStackTrace();
                System.out.println("Failure");
            }
        });
        Button btnAddApproval = new Button("Approve");
        btnAddApproval.setOnAction(event ->
        {
            try {
                Web3j web3j = Web3j.build(new HttpService());
                System.out.println("Connected to Ethereum client version: " + web3j.web3ClientVersion().send().getWeb3ClientVersion().toString());
                Credentials credentials = WalletUtils.loadCredentials(sPassword, sPath);
                test.P3AbsoluteBasic_sol_lifeInformation contract = test.P3AbsoluteBasic_sol_lifeInformation.load(smartcontractaddress2, web3j, credentials, ManagedTransaction.GAS_PRICE, Contract.GAS_LIMIT);
                contract.addApproval(txtAddress.getText()).send();
                System.out.println("Approval for " + txtAddress.getText());
            } catch (Exception e)
            {
                e.printStackTrace();
                System.out.println("Failure");
            }
        });

        Button btnRemoveApproval = new Button("Disapprove");
        btnRemoveApproval.setOnAction(event ->
        {
            try {
                Web3j web3j = Web3j.build(new HttpService());
                System.out.println("Connected to Ethereum client version: " + web3j.web3ClientVersion().send().getWeb3ClientVersion().toString());
                Credentials credentials = WalletUtils.loadCredentials(sPassword, sPath);
                test.P3AbsoluteBasic_sol_lifeInformation contract = test.P3AbsoluteBasic_sol_lifeInformation.load(smartcontractaddress2, web3j, credentials, ManagedTransaction.GAS_PRICE, Contract.GAS_LIMIT);
                contract.removeApproval(txtAddress.getText()).send();
                System.out.println("Removed approval for " + txtAddress.getText());
            } catch (Exception e)
            {
                e.printStackTrace();
                System.out.println("Failure");
            }
        });

        Button btnMenu = new Button("Menu");
        btnMenu.setOnAction(event ->
        {
            stage.setScene(createMenu(stage));
        });
        grid.add(lblAddress, 0, 0);
        grid.add(txtAddress, 1, 0);
        grid.add(btnAddApproval, 0, 1);
        grid.add(btnAddOwner, 1, 1);
        grid.add(btnRemoveApproval, 2, 1);
        grid.add(btnMenu, 0,2,2,1);
        scApproval = new Scene(grid);
        return scApproval;
    }

    public Scene createAddInformation(Stage stage)
    {
        GridPane grid = new GridPane();
        grid.setPrefWidth(400.0);
        grid.setPrefHeight(200.0);
        grid.setVgap(4);
        grid.setPadding(new Insets(5, 5, 5, 5));
        Label lblAddress = new Label("Please enter Address");
        TextField txtAddress = new TextField();
        Button btnAddOwner = new Button("Add Owner");
        return scAddInformation;
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
        btnClose.setOnAction(event -> stage.close());

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
            test.P3AbsoluteBasic_sol_lifeInformation contract = test.P3AbsoluteBasic_sol_lifeInformation.load(smartcontractaddress2, web3j, credentials, ManagedTransaction.GAS_PRICE, Contract.GAS_LIMIT);
            RemoteCall<BigInteger> counter = contract.getCountOwners();
            System.out.println(counter.send());
            for (int i =0; i <= Integer.valueOf(counter.send().toString()); i++)
            {
                String s = contract.getOwner(BigInteger.valueOf(i)).send();
                ownerAddress.add(s);
                System.out.println(s);
            }
            RemoteCall<BigInteger> counterInfo = contract.getCountCows();
            for (int i =0; i <= Integer.valueOf(counterInfo.send().toString()); i++)
            {
                Tuple3<String, String, String> s = contract.getPos(BigInteger.valueOf(i)).send();
                Triple<String, String, String> stemp = Triple.of(s.getValue1().toString(), s.getValue2().toString(), s.getValue3().toString());
                listInfo.add(stemp);
                System.out.println(s);
            }
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

class sortByCow implements Comparator<Triple<String, String, String>>
{
    @Override
    public int compare(Triple<String, String, String> a, Triple<String, String, String> b)
    {
        int d =0;
        try {
            d = a.getLeft().compareTo(b.getLeft());
        }
        catch (Exception e)
        {
            return 0;
        }
        return d;
    }
}
class sortByOwner implements Comparator<Triple<String, String, String>>
{
    @Override
    public int compare(Triple<String, String, String> a, Triple<String, String, String> b)
    {
        int d =0;
        try {
            d = a.getMiddle().compareTo(b.getMiddle());
        }
        catch (Exception e)
        {
            return 0;
        }
        return d;
    }
}
class sortByInformation implements Comparator<Triple<String, String, String>>
{
    @Override
    public int compare(Triple<String, String, String> a, Triple<String, String, String> b)
    {
        int d =0;
        try {
            d = a.getRight().compareTo(b.getRight());
        }
        catch (Exception e)
        {
            return 0;
        }
        return d;
    }
}