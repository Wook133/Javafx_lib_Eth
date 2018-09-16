package sample;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.control.TitledPane;
import javafx.scene.layout.*;
import javafx.stage.Stage;

public class start extends Application {
    boolean loggedIn = false;
    public static void main(String[] args) {
        launch(args);
    }
    public Scene createLoginScene() {

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
        if (loggedIn)
        {
            borderPane.setVisible(false);
            btnLoad.setVisible(false);
            btnLogin.setVisible(false);
        }

        borderPane.setTop(flowPane);
        borderPane.setCenter(canvas);

        return new Scene(borderPane);
    }
    @Override
    public void start(Stage primaryStage) throws Exception {
        primaryStage.setTitle("deVill Wagyu");

        Scene sceneLogin = createLoginScene();
        loginController controller = new loginController();
        controller.linkToUI(primaryStage, sceneLogin);

        loggedIn = controller.correctdetails;
        if (loggedIn == false)
        {
            primaryStage.setScene(sceneLogin);
            primaryStage.show();
            System.out.println(loggedIn);
        }
        else {
            Label label2= new Label("This is the second scene");
            Button button2= new Button("Go to scene 1");

            VBox layout2= new VBox(20);
            layout2.getChildren().addAll(label2, button2);
            Scene scene2 = new Scene(layout2,300,250);
            primaryStage.setScene(scene2);
            primaryStage.show();
            System.out.println(loggedIn);
        }




    }

}
