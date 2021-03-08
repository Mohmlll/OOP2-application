package practicumopdracht.controller;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import practicumopdracht.MainApplication;
import practicumopdracht.data.DAO;
import practicumopdracht.models.Brand;
import practicumopdracht.views.BrandView;

/**
 * @author Mohammed Malloul
 */

public class BrandController extends Controller {

    private final DAO<Brand> brandDAO;
    private final BrandView brandView;
    private ObservableList<Brand> brandObservableList;


    public BrandController() {
        brandDAO = MainApplication.getBrandDAO();
        brandView = new BrandView();

        updateListView();

        brandView.getMenuLoad().setOnAction(actionEvent -> onLoadBrand());
        //adds a new brand name
        brandView.getSave().setOnAction(actionEvent -> {
            onAddBrand();
        });

        //deletes a brand name from the list
        brandView.getDelete().setOnAction(actionEvent -> {
            brandView.getDelete().setOnAction(e -> {
                onDeleteBrand();
            });
        });

        //opens up the Model view
        brandView.getModels().setOnAction(actionEvent -> {
            Controller modelController = new ModelController();
            MainApplication.switchController(modelController);
        });
    }

    private void updateListView() {
        brandObservableList = FXCollections.observableArrayList(brandDAO.getAll());
        brandView.getListView().setItems(brandObservableList);
    }

    private void onLoadBrand() {
        brandDAO.load();
        updateListView();
    }

    private void onDeleteBrand() {
        Brand selectedBrand = brandView.getListView().getSelectionModel().getSelectedItem();

        if (selectedBrand != null) {
            brandView.getAlertDelete().showAndWait();
            brandObservableList.remove(selectedBrand);
        } else {
            brandView.getAlertDeleteList().showAndWait();
        }

    }

    private void onAddBrand() {
        String brandName = brandView.getBrandName().getText();
        String nameCEO = brandView.getNameCeo().getText();
        String networthCEO = brandView.getNetworth().getText();
        String descriptrion = brandView.getTextArea().getText();

        if (checkString(brandName) && checkString(nameCEO) && checkString(networthCEO) && checkString(descriptrion)) {
            Brand brandInput = new Brand(brandName, nameCEO, networthCEO, descriptrion);
            brandDAO.addOrUpdate(brandInput);
            updateListView();
        } else {
            brandView.getAlertSave().showAndWait();
        }
    }

    public boolean checkString(String text) {
        return text.matches("\"[a-zA-Z]\"");
    }

    public boolean checkDouble(String text) {
        return text.matches("\"^(-?)(0|([1-9][0-9]*))(\\\\.[0-9]+)?$\"");
    }

    public BrandView getView() {
        return brandView;
    }

}
