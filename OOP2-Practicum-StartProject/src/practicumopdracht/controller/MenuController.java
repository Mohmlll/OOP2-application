package practicumopdracht.controller;

import javafx.stage.Stage;
import practicumopdracht.MainApplication;
import practicumopdracht.data.BrandDAO;
import practicumopdracht.data.ModelDAO;
import practicumopdracht.views.MenuView;
import practicumopdracht.views.View;

public class MenuController extends Controller {

    private final MenuView view;

    public MenuController(Stage window) {
        BrandDAO brand = MainApplication.getBrandDAO();
        ModelDAO model = MainApplication.getModelDAO();

        this.view = new MenuView();

        this.view.getMenuSave().setOnAction(e -> {
            brand.save();
            model.save();
        });

        this.view.getMenuLoad().setOnAction(e -> {
            brand.load();
            model.load();
        });

        this.view.getMenuClose().setOnAction(e -> {
            window.close();
        });
    }

    @Override
    public View getView() {
        return view;
    }
}
