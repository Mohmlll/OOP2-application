package practicumopdracht.controller;

import javafx.scene.control.ButtonType;
import javafx.stage.Stage;
import practicumopdracht.MainApplication;
import practicumopdracht.comparators.BrandComparator;
import practicumopdracht.data.BrandDAO;
import practicumopdracht.data.ModelDAO;
import practicumopdracht.views.MenuView;
import practicumopdracht.views.View;

import java.util.Optional;

/**
 * Controller for the Menu
 *
 * @author Mohammed Malloul
 */

public class MenuController extends Controller {

    private ModelController modelController;
    private final MenuView view;
    private final BrandController brandController;

    public MenuController(Stage window) {
        this.view = new MenuView();
        this.brandController = MainApplication.getBrandController();
        this.modelController = MainApplication.getModelController();

        BrandDAO brand = MainApplication.getBrandDAO();
        ModelDAO model = MainApplication.getModelDAO();

        //with confirmation from the alert the data from the brands and models will be saved into the DAOs
        this.view.getMenuSave().setOnAction(e -> {
            view.getMenuAlert().setTitle("Save");
            view.getMenuAlert().setContentText("are you sure you want to save?");
            Optional<ButtonType> alert = view.getMenuAlert().showAndWait();
            if (alert.get() == ButtonType.OK) {
                brand.save();
                model.save();
            }
        });

        //with confirmation from the alert the data from the brands and models will be loaded from the DAOs
        this.view.getMenuLoad().setOnAction(e -> {
            view.getMenuAlert().setTitle("Load");
            view.getMenuAlert().setContentText("are you sure you want to load?");
            Optional<ButtonType> alert = view.getMenuAlert().showAndWait();
            if (alert.get() == ButtonType.OK) {

                brand.load();
                brandController.refresh();

                model.load();
                modelController.refresh();


            }
        });

        //with confirmation from the alert when exiting the data from the brands and models will be saved into the DAOs
        this.view.getMenuClose().setOnAction(e -> {
            view.getMenuAlert().setTitle("Exit");
            view.getMenuAlert().setContentText("Do you want to save before exiting?");
            Optional<ButtonType> alert = view.getMenuAlert().showAndWait();
            if (alert.get() == ButtonType.OK) {
                brand.save();
                model.save();
            }
            window.close();
        });

        //sorts the brands in a ascending way
        this.view.getAscending().setOnAction(e -> {
            BrandComparator brandComparator = new BrandComparator(true);
            brandController.sort(brandComparator);
        });

        //sorts the brands in a descending way
        this.view.getDescending().setOnAction(e -> {
            BrandComparator brandComparator = new BrandComparator(false);
            brandController.sort(brandComparator);
        });
    }

    @Override
    public View getView() {
        return view;
    }
}
