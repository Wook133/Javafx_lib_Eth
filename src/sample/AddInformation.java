package sample;

import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

public class AddInformation extends Application {
    ArrayList<String> comboboxOptions = new ArrayList<>();


    public static void main(String[] args) {
        launch(args);
    }



    String address = " ";

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

    @Override public void start(Stage stage) {

        stage.setScene(setAddInformationScene(stage));
        stage.show();
    }
}
