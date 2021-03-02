package practicumopdracht.controller;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import practicumopdracht.MainApplication;
import practicumopdracht.models.Brand;
import practicumopdracht.views.BrandView;
import practicumopdracht.views.ModelView;

import java.util.ArrayList;

/**
 * @author Mohammed Malloul
 */

public class BrandController extends Controller {

    private final BrandView brandView;
    private ModelView modelView;
    private final ObservableList<Brand> brandObservableList;
    private final ArrayList<Brand> brandArrayList;

    public BrandController() {
        brandView = new BrandView();

        brandArrayList = new ArrayList<>();
        brandArrayList.add(new Brand("Samsung", "Kim Ki Num", "$300 Billion", "No descriptrion"));
        brandArrayList.add(new Brand("Apple", "Tim Cook", "$1.3 Trillion", "No descriptrion"));

        brandObservableList = FXCollections.observableList(brandArrayList);
        brandView.getListView().setItems(brandObservableList);

        //adds a new brand name
        brandView.getSave().setOnAction(actionEvent -> onAddBrand());

        //deletes a brand name from the list
        brandView.getDelete().setOnAction(actionEvent -> {
            brandView.getDelete().setOnAction(e -> {
                brandView.getAlert().showAndWait();
                onDeleteBrand();
            });

        });

        //opens up the Model view
        brandView.getModels().setOnAction(actionEvent -> {
            ModelController modelController = new ModelController();
            MainApplication.switchController(modelController);
        });

    }

    private void onDeleteBrand() {
        Brand selectedBrand = brandView.getListView().getSelectionModel().getSelectedItem();

        if (selectedBrand == null) {
            return;
        }
        brandObservableList.remove(selectedBrand);
    }

    private void onAddBrand() {
        String brandName;
        brandName = brandView.getBrandName().getText();
        String nameCEO = brandView.getNameCeo().getText();
        String networthCEO = brandView.getNetworth().getText();
        String descriptrion = brandView.getTextArea().getText();
        if (descriptrion != null) {
            Brand brand = new Brand(brandName, nameCEO, networthCEO, descriptrion);
            brandObservableList.add(brand);
        } else {
            descriptrion = "No descriptrion";
            Brand brand = new Brand(brandName, nameCEO, networthCEO, descriptrion);
            brandObservableList.add(brand);
        }

    }

    public ObservableList<Brand> getBrandObservableList() {
        return brandObservableList;
    }

    public BrandView getView() {
        return brandView;
    }

}
