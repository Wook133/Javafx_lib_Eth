package sample;
//https://medium.com/coinmonks/ethereum-blockchain-hello-world-smart-contract-with-java-9b6ae2961ad1
import com.sun.xml.internal.txw2.TxwException;
import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.*;
import javafx.scene.text.Font;
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
import org.web3j.tx.exceptions.ContractCallException;

import java.io.File;
import java.math.BigInteger;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Date;
import java.util.Observable;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.atomic.AtomicReference;

public class Runner extends Application {
    boolean loggedIn = false;
    String smartcontractaddress1 = "0xc83bebe3fe6f197715d18d9723458802ce068c8f";
    //String smartcontractaddress2 = "0x519ad27415a49596d915ea9eb4687b2d5108b255";

    ArrayList<String> comboboxOptions = new ArrayList<>();

    ArrayList<String> ownerAddress = new ArrayList<>();
    ArrayList<Triple<String, String, String>> listInfo = new ArrayList<>();
    ArrayList<Information> listRealInfo = new ArrayList<>();
    ObservableList<Information> observeInfo = FXCollections.observableArrayList(listRealInfo);

    public File selectedFile;
    public String sPath;

    Scene scLogin;
    Scene scMenu;
    Scene scApproval;
    Scene scAddInformation;
    Scene scGetInformation;

    public String sPassword;

    private void setupInformation()
    {
        observeInfo.clear();
        for (Triple<String, String, String> stemp : listInfo)
        {
            Information cur = new Information(stemp.getLeft(), stemp.getMiddle(), stemp.getRight());
            observeInfo.add(cur);
            System.out.println(cur.toString());
        }
    }

    public static ObservableList<Information> popObservableData(ArrayList<Information> listInfo)
    {
        ObservableList<Information> data = FXCollections.observableArrayList(listInfo);
        return data;
    }

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
                CompleteBasic_sol_lifeInformation contract = CompleteBasic_sol_lifeInformation.load(smartcontractaddress1, web3j, credentials, ManagedTransaction.GAS_PRICE, Contract.GAS_LIMIT);
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
                CompleteBasic_sol_lifeInformation contract = CompleteBasic_sol_lifeInformation.load(smartcontractaddress1, web3j, credentials, ManagedTransaction.GAS_PRICE, Contract.GAS_LIMIT);
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
                CompleteBasic_sol_lifeInformation contract = CompleteBasic_sol_lifeInformation.load(smartcontractaddress1, web3j, credentials, ManagedTransaction.GAS_PRICE, Contract.GAS_LIMIT);
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

    public Scene setAddInformationScene(Stage stage)
    {
        comboboxOptions.add("Medication");
        comboboxOptions.add("Food");
        comboboxOptions.add("Development");
        comboboxOptions.add("Location");
        comboboxOptions.add("Distribution");
        comboboxOptions.add("Slaughter");
        comboboxOptions.add("Packaging");
        comboboxOptions.add("Comment");
        stage.setTitle("Add Information");
        Scene scene = new Scene(new Group(), 760, 350);

        Button button = new Button ("Add Information");
        Button buttonMenu = new Button ("Menu");
        TextArea text = new TextArea ("");
        Label lblAddress = new Label("Please enter Address of cow");
        TextField txtAddress = new TextField();
        txtAddress.setPrefWidth(300);
        text.setPrefWidth(750);

        final ComboBox cmbAddInformation = new ComboBox();
        cmbAddInformation.setPrefWidth(300);
        cmbAddInformation.getItems().addAll(comboboxOptions);
        cmbAddInformation.setOnAction(event ->
                {
                    String stemplate = "";

                    int iselected = comboboxOptions.indexOf(cmbAddInformation.getValue().toString());
                    stemplate = generateTemplate(iselected);
                    System.out.println(iselected);
                    text.insertText(0, cmbAddInformation.getValue().toString()  + ": " + stemplate + System.lineSeparator());
                }
        );

        button.setOnAction(event ->
        {
            try {
                Web3j web3j = Web3j.build(new HttpService());
                System.out.println("Connected to Ethereum client version: " + web3j.web3ClientVersion().send().getWeb3ClientVersion().toString());
                Credentials credentials = WalletUtils.loadCredentials(sPassword, sPath);
                CompleteBasic_sol_lifeInformation contract = CompleteBasic_sol_lifeInformation.load(smartcontractaddress1, web3j, credentials, ManagedTransaction.GAS_PRICE, Contract.GAS_LIMIT);
                contract.addInformation(txtAddress.getText(), text.getText()).send();
                System.out.println("Information added to Ethereum : " + txtAddress.getText() + ", " + credentials.getAddress() +", " + text.getText());
                Triple<String, String, String> cur = Triple.of(txtAddress.getText(), credentials.getAddress(), text.getText());
                listInfo.add(cur);
                listInfo.sort(new sortByCow());
            } catch (Exception e)
            {
                e.printStackTrace();
                System.out.println("Failure");
            }
        });
        buttonMenu.setOnAction(event ->
        {
            stage.setScene(createMenu(stage));
        });


        GridPane grid = new GridPane();
        grid.setVgap(20);
        grid.setHgap(20);
        grid.setPadding(new Insets(5, 5, 5, 5));
        grid.add(new Label("Select Template for Information"), 0, 0);

        grid.add(cmbAddInformation, 1, 0);
        grid.add(lblAddress, 0, 1);
        grid.add(txtAddress, 1, 1);

        grid.add(text, 0, 2, 4, 1);
        grid.add(button, 0, 3);
        grid.add(buttonMenu, 1, 3);
        Group root = (Group)scene.getRoot();
        root.getChildren().add(grid);
        return scene;
    }

    public Scene createAddInformation(Stage stage)
    {
        GridPane grid = new GridPane();
        grid.setPrefWidth(600.0);
        grid.setPrefHeight(400.0);
        grid.setVgap(4);
        grid.setPadding(new Insets(5, 5, 5, 5));
        Label lblAddress = new Label("Please enter Address of cow");
        TextField txtAddress = new TextField();
        Label lblInfo = new Label("Please enter Information you wish to add");
        TextArea txtInfo = new TextArea();
        Button btnAddInformation = new Button("Add Information to Ethereum");
        btnAddInformation.setOnAction(event ->
        {
            try {
                Web3j web3j = Web3j.build(new HttpService());
                System.out.println("Connected to Ethereum client version: " + web3j.web3ClientVersion().send().getWeb3ClientVersion().toString());
                Credentials credentials = WalletUtils.loadCredentials(sPassword, sPath);
                CompleteBasic_sol_lifeInformation contract = CompleteBasic_sol_lifeInformation.load(smartcontractaddress1, web3j, credentials, ManagedTransaction.GAS_PRICE, Contract.GAS_LIMIT);
                contract.addInformation(txtAddress.getText(), txtInfo.getText()).send();
                System.out.println("Information added to Ethereum : " + txtAddress.getText() + ", " + credentials.getAddress() +", " + txtInfo.getText());
                Triple<String, String, String> cur = Triple.of(txtAddress.getText(), credentials.getAddress(), txtInfo.getText());
                listInfo.add(cur);
                listInfo.sort(new sortByCow());
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
        grid.add(lblInfo, 0, 1);
        grid.add(txtInfo, 1, 1, 5, 1);
        grid.add(btnAddInformation, 2, 2);
        grid.add(btnMenu, 0,2);

        scAddInformation = new Scene(grid);

        return scAddInformation;
    }

    public Scene createViewInformation(Stage stage)
    {
        try {
            Web3j web3j = Web3j.build(new HttpService());
            System.out.println("Connected to Ethereum client version: " + web3j.web3ClientVersion().send().getWeb3ClientVersion().toString());
            Credentials credentials = WalletUtils.loadCredentials(sPassword, sPath);
            CompleteBasic_sol_lifeInformation contract1 = CompleteBasic_sol_lifeInformation.load(smartcontractaddress1, web3j, credentials, ManagedTransaction.GAS_PRICE, Contract.GAS_LIMIT);
            BigInteger biCount =  contract1.getCountCows().send();
            Integer counter = Integer.valueOf(biCount.toString());
            System.out.println("Cow Information Counter = " + counter);
            System.out.println("Cow =" + contract1.getCowAddressPos(BigInteger.ZERO).send());
            for (int i = 0; i <= counter - 1; i++)
            {
                String sInfo = contract1.getInformationPos(BigInteger.valueOf(i)).send();
                String sCowAddress = contract1.getCowAddressPos(BigInteger.valueOf(i)).send();
                String sOwnerAddress = contract1.getPublisherPos(BigInteger.valueOf(i)).send();
                listRealInfo.add(new Information(sCowAddress, sOwnerAddress, sInfo));
                System.out.println(sInfo);
            }
        } catch (Exception e)
        {
            e.printStackTrace();
            System.out.println("Failure");
        }

        Scene scene = new Scene(new Group());
        stage.setTitle("All Information");
        stage.setWidth(1100);
        stage.setHeight(520);
        TableView table = new TableView();
        final Label label = new Label("Wagyu Details");
        label.setFont(new Font("Arial", 16));
        table.setEditable(true);
        TableColumn colCowAdd = new TableColumn("Wagyu Address");
        colCowAdd.setCellValueFactory(new PropertyValueFactory<Information, String>("cowAddress"));
        colCowAdd.setPrefWidth(300);
        TableColumn colOwnerAdd = new TableColumn("Owner Address");
        colOwnerAdd.setPrefWidth(300);
        colOwnerAdd.setCellValueFactory(new PropertyValueFactory<Information, String>("ownerAddress"));
        TableColumn colInfo = new TableColumn("Information");
        colInfo.setCellValueFactory(new PropertyValueFactory<Information, String>("info"));
        colInfo.setPrefWidth(400);

        Button btnMenu = new Button("Menu");
        btnMenu.setOnAction(event ->
        {
            stage.setScene(createMenu(stage));
        });
        final ObservableList<Information> data  = popObservableData(listRealInfo);
        table.setItems(data);
        table.getColumns().addAll(colCowAdd, colOwnerAdd, colInfo);
        final VBox vbox = new VBox();
        vbox.setSpacing(5);
        vbox.setPadding(new Insets(10, 0, 0, 10));
        vbox.getChildren().addAll(label, table, btnMenu);
        ((Group) scene.getRoot()).getChildren().addAll(vbox);
        return scene;
    }


    public Scene createMenu(Stage stage)
    {
        GridPane grid = new GridPane();
        grid.setPrefWidth(300.0);
        grid.setPrefHeight(150.0);
        grid.setVgap(4);
        grid.setPadding(new Insets(5, 5, 5, 5));

        Button btnApproval = new Button("Approval");
        btnApproval.setOnAction(event -> stage.setScene(createApproval(stage)));

        Button btnAddInformaion = new Button("Add Information");
        btnAddInformaion.setOnAction(event -> stage.setScene(setAddInformationScene(stage)));

        Button btnGetInformation = new Button("Get Information");
        btnGetInformation.setOnAction(event -> stage.setScene(createViewInformation(stage)));

        /*Button btnGetAllCows = new Button("All Wagyu Cattle");
        Button btnGetAllOwners = new Button("All Owners");*/

        Button btnClose = new Button("Close");
        btnClose.setOnAction(event -> stage.close());

        grid.add(btnApproval, 0, 0);
        grid.add(btnAddInformaion, 1, 0);
        grid.add(btnGetInformation, 0, 1);
       /* grid.add(btnGetAllCows, 1, 1);
        grid.add(btnGetAllOwners, 0, 2);*/
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
            CompleteBasic_sol_lifeInformation contract = CompleteBasic_sol_lifeInformation.load(smartcontractaddress1, web3j, credentials, ManagedTransaction.GAS_PRICE, Contract.GAS_LIMIT);
            RemoteCall<BigInteger> counter = contract.getCountOwners();
            System.out.println("OWNERS: " + counter.send());
            for (int i = 0; i <= Integer.valueOf(counter.send().toString()) - 1; i++) {
                String s = contract.getOwner(BigInteger.valueOf(i)).send();
                ownerAddress.add(s);
                System.out.println(s);
            }
            RemoteCall<BigInteger> counterInfo = contract.getCountCows();
            System.out.println("COWS: " + counterInfo.send());
            listInfo.sort(new sortByCow());
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

    public String generateTemplate(int ipos)
    {
        String s ="";
        Long l = System.currentTimeMillis();
        Date date = new Date(l);
        SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
        String d = formatter.format(date);
        switch(ipos)
        {
            case 0 :
            {
                s = "Medication name; Medication Volume; Vet Details; " + d +"; ";
            }
            break;
            case 1 :
            {
                s = "Food name; Food Amount; Feeder Details; " + d +"; ";
            }
            break;
            case 2:
            {
                s = "Height; Mass; Value; Examiners Details; " + d +"; ";
            }
            break;
            case 3 :
            {
                s = "Location Name ; Location GPS Longitude; Location GPS Latitude; Tracker Details;" + d +"; ";
            }
            break;
            case 4 :
            {
                s = "Distribution Name ; Distribution Location GPS Longitude; Distribution Location GPS Latitude; Market Details;" + d +"; ";
            }
            break;
            case 5:
            {
                s = "Kosher; Halal; Mass Before; Mass After; Value; Butcher Details; " + d +"; ";
            }
            break;
            case 6:
            {
                s = "Package Label; Package Mass; Value; Packager Details; " + d +"; ";
            }
            break;
            default:
            {
                s = "Comments;";
            }

        }
        return s;
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

