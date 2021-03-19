package practicumopdracht;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;
import practicumopdracht.controller.BrandController;
import practicumopdracht.controller.Controller;
import practicumopdracht.controller.MenuController;
import practicumopdracht.data.BrandDAO;
import practicumopdracht.data.ModelDAO;
import practicumopdracht.data.TextBrandDAO;
import practicumopdracht.data.TextModelDAO;

/**
 * @author Mohammed Malloul
 */

public class MainApplication extends Application {

    private static BorderPane mainPane;
    private static MenuController menuController;
    private static BrandDAO brandDAO = new TextBrandDAO();
    private static ModelDAO modelDAO = new TextModelDAO();

    public static BrandDAO getBrandDAO() {
        return brandDAO;
    }

    public static ModelDAO getModelDAO() {
        return modelDAO;
    }

    @Override
    public void start(Stage stage) {

        menuController = new MenuController(stage);

        if (!Main.launchedFromMain) {
            System.err.println("Je moet deze applicatie opstarten vanuit de Main-class, niet de MainApplication-class!");
            System.exit(1337);

            return;
        }

        brandDAO.load();
        modelDAO.load();

        mainPane = new BorderPane();

        mainPane.setTop(menuController.getView().getRoot());

        Controller controller = new BrandController(brandDAO.getAll());

        switchController(controller);

        stage.setScene(new Scene(mainPane));

        stage.setTitle(String.format("Practicumopdracht OOP2 - %s", Main.studentNaam));
        stage.setWidth(640);
        stage.setHeight(480);
        stage.show();


    }

    public static void switchController(Controller controller) {
        mainPane.setCenter(controller.getView().getRoot());
    }

}
