package practicumopdracht;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;
import practicumopdracht.controller.BrandController;
import practicumopdracht.controller.Controller;
import practicumopdracht.data.BrandTextDao;
import practicumopdracht.data.DAO;
import practicumopdracht.models.Brand;

/**
 * @author Mohammed Malloul
 */

public class MainApplication extends Application {

    private static DAO<Brand> brandDAO;
    private static Stage mainStage;

    public static void switchController(Controller controller) {
        mainStage.setScene(new Scene(controller.getView().getRoot()));
    }

    public static DAO<Brand> getBrandDAO() {
        return brandDAO;
    }

    @Override
    public void start(Stage stage) {
        mainStage = stage;
        if (!Main.launchedFromMain) {
            System.err.println("Je moet deze applicatie opstarten vanuit de Main-class, niet de MainApplication-class!");
            System.exit(1337);

            return;
        }

        stage.setTitle(String.format("Practicumopdracht OOP2 - %s", Main.studentNaam));
        stage.setWidth(640);
        stage.setHeight(480);
        stage.show();

        brandDAO = new BrandTextDao();

        BrandController controller = new BrandController();
        switchController(controller);

    }


}
