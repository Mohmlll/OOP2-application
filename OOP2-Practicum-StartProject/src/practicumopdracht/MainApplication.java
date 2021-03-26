package practicumopdracht;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;
import practicumopdracht.controller.BrandController;
import practicumopdracht.controller.Controller;
import practicumopdracht.controller.MenuController;
import practicumopdracht.data.BinaryBrandDAO;
import practicumopdracht.data.BrandDAO;
import practicumopdracht.data.ModelDAO;
import practicumopdracht.data.ObjectModelDAO;

/**
 * @author Mohammed Malloul
 */

public class MainApplication extends Application {

    private static BorderPane mainPane;
    private static MenuController menuController;
    private static BrandController brandController;

    private static final BrandDAO brandDAO = new BinaryBrandDAO();
    private static final ModelDAO modelDAO = new ObjectModelDAO();

//    private static BrandDAO brandDAO = new TextBrandDAO();
//    private static ModelDAO modelDAO = new TextModelDAO();
//    private static ModelDAO modelDAO = new FakeModelDAO();
//    private static BrandDAO brandDAO = new FakeBrandDAO();

    public static void switchController(Controller controller) {
        mainPane.setCenter(controller.getView().getRoot());
    }

    public static BrandDAO getBrandDAO() {
        return brandDAO;
    }

    public static ModelDAO getModelDAO() {
        return modelDAO;
    }

    public static BrandController getBrandController() {
        return brandController;
    }

    @Override
    public void start(Stage stage) {
        if (!Main.launchedFromMain) {
            System.err.println("Je moet deze applicatie opstarten vanuit de Main-class, niet de MainApplication-class!");
            System.exit(1337);

            return;
        }

        mainPane = new BorderPane();

        brandDAO.load();
        modelDAO.load();

        brandController = new BrandController(brandDAO.getAll());
        switchController(brandController);

        menuController = new MenuController(stage);
        mainPane.setTop(menuController.getView().getRoot());

        stage.setScene(new Scene(mainPane));

        stage.setTitle(String.format("Practicumopdracht OOP2 - %s", Main.studentNaam));
        stage.setWidth(640);
        stage.setHeight(480);
        stage.show();
    }
}
