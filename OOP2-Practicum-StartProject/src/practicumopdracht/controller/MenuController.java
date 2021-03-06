package practicumopdracht.controller;

import javafx.scene.control.ButtonType;
import javafx.stage.Stage;
import practicumopdracht.MainApplication;
import practicumopdracht.data.BrandDAO;
import practicumopdracht.data.ModelDAO;
import practicumopdracht.views.MenuView;
import practicumopdracht.views.View;

import javax.swing.text.html.Option;
import java.util.Optional;

public class MenuController extends Controller {

    private final MenuView view;

    public MenuController(Stage window) {
        this.view = new MenuView();
        BrandController controller = new BrandController();
        BrandDAO brand = MainApplication.getBrandDAO();
        ModelDAO model = MainApplication.getModelDAO();


        this.view.getMenuSave().setOnAction(e -> {
            view.getMenuAlert().setTitle("Save");
            view.getMenuAlert().setContentText("are you sure you want to save?");
            Optional<ButtonType> alert = view.getMenuAlert().showAndWait();
            if (alert.get() == ButtonType.OK){
                brand.save();
                model.save();
            }


        });

        this.view.getMenuLoad().setOnAction(e -> {
            view.getMenuAlert().setTitle("Load");
            view.getMenuAlert().setContentText("are you sure you want to load?");
            Optional<ButtonType> alert = view.getMenuAlert().showAndWait();
            if (alert.get() == ButtonType.OK){
                brand.load();
                model.load();
            }
        });

        this.view.getMenuClose().setOnAction(e -> {
            view.getMenuAlert().setTitle("Exit");
            view.getMenuAlert().setContentText("Do you want to save before exiting?");
            Optional<ButtonType> alert = view.getMenuAlert().showAndWait();
            if (alert.get() == ButtonType.OK){
                brand.save();
                model.save();
            }
            window.close();

        });
    }

    @Override
    public View getView() {
        return view;
    }
}
