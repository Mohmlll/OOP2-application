package practicumopdracht;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;
import practicumopdracht.controller.PhoneController;

/**
 * @author Mohammed Malloul
 */

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
        PhoneController controller = new PhoneController();

        Scene scene = new Scene(controller.getView().getRoot());
        stage.setScene(scene);
    }
}
