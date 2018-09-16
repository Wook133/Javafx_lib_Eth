package sample;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.control.TitledPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Region;
import javafx.stage.Stage;

public class start extends Application {
    public static void main(String[] args) {
        launch(args);
    }
    public Scene createScene() {
        BorderPane borderPane = new BorderPane();
        borderPane.setPrefWidth(300.0);
        FlowPane flowPane = new FlowPane();
        /*GridPane grid = new GridPane();
        grid.setVgap(4);*/
        Label lbl = new Label("Select your Keystore: ");
        Button btnLoad = new Button("Load");
        btnLoad.setId("load");
        Button btnLogin = new Button("Login");
        btnLogin.setId("login");
        TextField txtPassword = new TextField("");
        txtPassword.setId("password");
        Label lbl2 = new Label("Enter your password: ");

        /*grid.setPadding(new Insets(5, 5, 5, 5));
        grid.add(lbl, 0, 0);
        grid.add(btnLoad, 1, 0);
        grid.add(lbl2, 0, 1);
        grid.add(txtPassword, 1, 1);
        grid.add(btnLogin, 0, 2, 2,2);*/
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

        return new Scene(borderPane);

        // add some buttons
        /*TitledPane gridTitlePane = new TitledPane();
        GridPane grid = new GridPane();
        grid.setVgap(4);
        grid.setPadding(new Insets(5, 5, 5, 5));
        grid.add(new Label("Select your Keystore: "), 0, 0);

        Button btnLoad = new Button("Load");
        btnLoad.setId("load");
        Button btnLogin = new Button("Login");
        btnLogin.setId("login");
        TextField txtPassword = new TextField("Enter Password");
        txtPassword.setId("password");

        grid.add(btnLoad, 1, 0);
        grid.add(new Label("Password: "), 0, 1);
        grid.add(txtPassword, 1, 1);
        grid.add(new Label("Login ready: "), 0, 2);
        grid.add(btnLogin, 1, 2);

        Canvas canvas = new Canvas(500, 500);
        canvas.setId("canvas");

        gridTitlePane.setText("Login");
        gridTitlePane.setContent(grid);
        borderPane.setTop(gridTitlePane);
        borderPane.setCenter(canvas);

        return new Scene(borderPane);*/
    }
    @Override
    public void start(Stage primaryStage) throws Exception {
        primaryStage.setTitle("deVill Wagyu");

        Scene scene = createScene();
        loginController controller = new loginController();
        controller.linkToUI(primaryStage, scene);

        primaryStage.setScene(scene);
        primaryStage.show();
    }

}
