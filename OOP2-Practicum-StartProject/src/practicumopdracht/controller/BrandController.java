package practicumopdracht.controller;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import practicumopdracht.models.Brand;
import practicumopdracht.views.BrandView;

import java.util.ArrayList;

/**
 * @author Mohammed Malloul
 */

public class BrandController {

    private BrandView view;
    private ObservableList<Brand> brandObservableList;

    public BrandController() {
        view = new BrandView();

        ArrayList<Brand> brandArrayList = new ArrayList<>();
        brandArrayList.add(new Brand("Samsung"));
        brandArrayList.add(new Brand("Apple"));

        brandObservableList = FXCollections.observableList(brandArrayList);

        view.getListView().setItems(brandObservableList);
        view.getSave().setOnAction(actionEvent -> onAddBrand());
    }

    private void onAddBrand() {
        String brandName;
        brandName = view.getTextField().getText();

        Brand brand = new Brand(brandName);
        brandObservableList.add(brand);
    }

    public BrandView getView() {
        return view;
    }

}
