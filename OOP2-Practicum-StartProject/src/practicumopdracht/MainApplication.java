package practicumopdracht;

import javafx.application.Application;
import javafx.stage.Stage;

public class MainApplication extends Application {

    @Override
    public void start(Stage stage) {
        if (!Main.launchedFromMain) {
            System.err.println("Je moet deze applicatie opstarten vanuit de Main-class, niet de MainApplication-class!");
            System.exit(1337);

            return;
        }

        stage.setTitle(String.format("Practicumopdracht OOP2 - %s", Main.studentNaam));
        stage.setWidth(640);
        stage.setHeight(480);
        stage.show();


//        HBox rootHbox = new HBox();
//
////        Button button1 = new Button("knop 1");
////        Button button2 = new Button("knop 1");
////        Button button3 = new Button("knop 1");
////
////        TextField textField = new TextField();
////
////        rootHbox.getChildren().addAll(button1,button2,button3, textField);
//
//        StackPane stackPane = new StackPane();
//
//        VBox vBox = new VBox();
//
//        HBox usernameBox = new HBox();
//        Label usernameLabel = new Label("Username:");
//        TextField usernameTextfield = new TextField();
//        usernameBox.getChildren().addAll(usernameLabel, usernameTextfield);
//        vBox.getChildren().addAll(usernameBox);
//        stackPane.getChildren().addAll(vBox);
//        Scene scene = new Scene(stackPane);
//
//        stage.setScene(scene);
    }
}
