package sample;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import org.apache.commons.lang3.tuple.Triple;

import java.util.ArrayList;

public class TestTableUI extends Application {

    ArrayList<Information> listRealInfo = new ArrayList<>();
    ObservableList<Information> observeInfo = FXCollections.observableArrayList(listRealInfo);
    public Scene createViewInformation(Stage stage)
    {
        System.out.print("Creating Table");
        VBox root = new VBox();
        root.setSpacing(10);
        root.setFillWidth(true);
        root.setPadding(new Insets(5));

        TableView<Information> tblInformation = new TableView<>();
        TableColumn colCowAdd = new TableColumn("Wagyu Address");

        colCowAdd.setCellValueFactory(new PropertyValueFactory("wagyu_address"));
        colCowAdd.setPrefWidth(200);

        TableColumn colOwnerAdd = new TableColumn("Owner Address");
        colOwnerAdd.setCellValueFactory(new PropertyValueFactory("owner_address"));
        colOwnerAdd.setPrefWidth(200);

        TableColumn colInfo = new TableColumn("Information");
        colInfo.setCellValueFactory(new PropertyValueFactory("information"));
        colInfo.setPrefWidth(400);

        tblInformation.setId("table");
        tblInformation.getColumns().addAll(colCowAdd, colOwnerAdd, colInfo);
        listRealInfo.add(new Information("c0", "a0", "I0"));
        listRealInfo.add(new Information("c0", "a0", "I1"));
        listRealInfo.add(new Information("c1", "a0", "I0"));
        listRealInfo.add(new Information("c1", "a0", "I1"));
        listRealInfo.add(new Information("c2", "a1", "I0"));
        listRealInfo.add(new Information("c2", "a1", "I1"));
        listRealInfo.add(new Information("c2", "a1", "I0"));
        listRealInfo.add(new Information("c2", "a1", "I1"));
        observeInfo.addAll(listRealInfo);
        tblInformation.setItems(observeInfo);

        Button btnMenu = new Button("Menu");
        root.getChildren().addAll(
                new Label("Information"), btnMenu);

        return new Scene(root);
    }

    public static ObservableList<Information> popObservableData(ArrayList<Information> listInfo)
    {
        ObservableList<Information> data = FXCollections.observableArrayList(listInfo);
        return data;
    }
    public Scene setStageInformation(Stage stage)
    {
        Scene scene = new Scene(new Group());
        stage.setTitle("All Information");
        stage.setWidth(850);
        stage.setHeight(520);
        TableView table = new TableView();
        final Label label = new Label("Address Book");
        label.setFont(new Font("Arial", 16));
        table.setEditable(true);
        TableColumn colCowAdd = new TableColumn("Wagyu Address");
        colCowAdd.setCellValueFactory(new PropertyValueFactory<Information, String>("cowAddress"));
        colCowAdd.setPrefWidth(200);
        TableColumn colOwnerAdd = new TableColumn("Owner Address");
        colOwnerAdd.setPrefWidth(200);
        colOwnerAdd.setCellValueFactory(new PropertyValueFactory<Information, String>("ownerAddress"));
        TableColumn colInfo = new TableColumn("Information");
        colInfo.setCellValueFactory(new PropertyValueFactory<Information, String>("info"));
        colInfo.setPrefWidth(400);

        listRealInfo.add(new Information("c0", "a0", "I0"));
        listRealInfo.add(new Information("c0", "a0", "I1"));
        listRealInfo.add(new Information("c1", "a0", "I0"));
        listRealInfo.add(new Information("c1", "a0", "I1"));
        listRealInfo.add(new Information("c2", "a1", "I0"));
        listRealInfo.add(new Information("c2", "a1", "I1"));
        listRealInfo.add(new Information("c2", "a1", "I0"));
        listRealInfo.add(new Information("c2", "a1", "I1"));

        Button btnMenu = new Button("Menu");
        final ObservableList<Information> data  = popObservableData(listRealInfo);
        table.setItems(data);
        table.getColumns().addAll(colCowAdd, colOwnerAdd, colInfo);
        final VBox vbox = new VBox();
        vbox.setSpacing(5);
        vbox.setPadding(new Insets(10, 0, 0, 10));
        vbox.getChildren().addAll(label, table, btnMenu);
        ((Group) scene.getRoot()).getChildren().addAll(vbox);
        //stage.setScene(scene);
        return scene;
    }
   /* @Override
    public void start(Stage primaryStage) throws Exception {
        primaryStage = setStage(primaryStage);
        primaryStage.setTitle("Example 4");
        primaryStage.show();
    }*/
   @Override
   public void start(Stage stage) {
       stage.setScene(setStageInformation(stage));
       stage.show();
   }
}
