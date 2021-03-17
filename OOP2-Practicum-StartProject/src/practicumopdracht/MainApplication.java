package practicumopdracht;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;
import practicumopdracht.controller.BrandController;
import practicumopdracht.controller.Controller;
import practicumopdracht.controller.MenuController;
import practicumopdracht.data.*;

/**
 * @author Mohammed Malloul
 */

public class MainApplication extends Application {

    private static BorderPane mainPane;
    private static BrandDAO brandDAO = new FakeBrandDAO();
    private static ModelDAO modelDAO = new TextModelDAO();

    private static Stage mainStage;

    public static void switchController(Controller controller) {
        mainStage.setScene(new Scene(controller.getView().getRoot()));
    }

    public static BrandDAO getBrandDAO() {
        return brandDAO;
    }

    public static ModelDAO getModelDAO() {
        return modelDAO;
    }

    @Override
    public void start(Stage stage) {
        mainStage = stage;
        brandDAO.load();
        modelDAO.load();

        if (!Main.launchedFromMain) {
            System.err.println("Je moet deze applicatie opstarten vanuit de Main-class, niet de MainApplication-class!");
            System.exit(1337);

            return;
        }

        mainPane = new BorderPane();
        mainPane.setTop(new MenuController(stage).getView().getRoot());

        stage.setTitle(String.format("Practicumopdracht OOP2 - %s", Main.studentNaam));
        stage.setWidth(640);
        stage.setHeight(480);
        stage.show();

        BrandController controller = new BrandController();
        switchController(controller);

    }


}
