package sample;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.collections.transformation.FilteredList;
import javafx.collections.transformation.SortedList;
import javafx.fxml.FXML;
import javafx.scene.Scene;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class InformationTableController {
    @FXML
    private TextField filterField;
    @FXML
    private TableView<Information> informationTable;
    @FXML
    private TableColumn<Information, String> firstNameColumn;
    @FXML
    private TableColumn<Information, String> middleNameColumn;
    @FXML
    private TableColumn<Information, String> lastNameColumn;
    private ObservableList<Information> masterData = FXCollections.observableArrayList();

    public InformationTableController(ArrayList<Information> rawData) {
        masterData.addAll(rawData);
    }


    public TableView<Information> getInformationTable() {
        return informationTable;
    }

    @FXML
    private void initialize() {
        // 0. Initialize the columns.
        firstNameColumn.setCellValueFactory(cellData -> cellData.getValue().cowAddressProperty());
        middleNameColumn.setCellValueFactory(cellData -> cellData.getValue().ownerAddressProperty());
        lastNameColumn.setCellValueFactory(cellData -> cellData.getValue().infoProperty());
        // 1. Wrap the ObservableList in a FilteredList (initially display all data).
        FilteredList<Information> filteredData = new FilteredList<>(masterData, p -> true);

        // 2. Set the filter Predicate whenever the filter changes.
        filterField.textProperty().addListener((observable, oldValue, newValue) -> {
            filteredData.setPredicate(info -> {
                // If filter text is empty, display all persons.
                if (newValue == null || newValue.isEmpty()) {
                    return true;
                }

                // Compare first name and last name of every person with filter text.
                String lowerCaseFilter = newValue.toLowerCase();

                if (info.getCowAddress().toLowerCase().contains(lowerCaseFilter)) {
                    return true; // Filter matches cow address.
                }
                else if (info.getOwnerAddress().toLowerCase().contains(lowerCaseFilter)) {
                    return true; // Filter matches owner address.
                }
                else if (info.getInfo().toLowerCase().contains(lowerCaseFilter)) {
                    return true; // Filter matches information.
                }
                return false; // Does not match.
            });
        });

        // 3. Wrap the FilteredList in a SortedList.
        SortedList<Information> sortedData = new SortedList<>(filteredData);

        // 4. Bind the SortedList comparator to the TableView comparator.
        sortedData.comparatorProperty().bind(informationTable.comparatorProperty());

        // 5. Add sorted (and filtered) data to the table.
        informationTable.setItems(sortedData);
    }

    public void linkToScene(Scene scene)
    {
        initialize();

    }


}



