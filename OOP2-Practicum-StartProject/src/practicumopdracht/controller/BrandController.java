package practicumopdracht.controller;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import practicumopdracht.MainApplication;
import practicumopdracht.data.DAO;
import practicumopdracht.models.Brand;
import practicumopdracht.views.BrandView;

import java.util.List;

/**
 * @author Mohammed Malloul
 */

public class BrandController extends Controller {

    private List<Brand> brands;
    private final DAO<Brand> brandDAO;
    private final BrandView brandView;
    private ObservableList<Brand> brandObservableList;


    public BrandController() {
        brandDAO = MainApplication.getBrandDAO();
        brandView = new BrandView();

        //adds a new brand name
        brandView.getSave().setOnAction(actionEvent -> {
            onAddBrand();
        });

        //deletes a brand name from the list
        brandView.getDelete().setOnAction(actionEvent -> {
            brandView.getDelete().setOnAction(e -> {
                onRemoveBrand();
            });
        });
        //Detail button gets disabled, listener added to selection and value is send to the setBrand method
        brandView.getListView().getSelectionModel().selectedItemProperty().addListener((obs, oldValue, newValue) -> {
            brandView.setBrand(newValue);

        });
        //opens up the Model view
        brandView.getDetails().setOnAction(actionEvent -> {
            moveToDetails();
        });

        //empties model fields
        brandView.getNewBrand().setOnAction(actionEvent -> {
            clearFields();
        });

        //updates the listView
        updateListView();
    }


    public BrandController(List<Brand> brands) {
        this();
        this.setBrand(brands);
    }

    public void setBrand(List<Brand> brands) {
        this.brands = brands;
        this.brandView.setBrands(brands);
    }

    //Checks if a brand is selected, if yes it allows acces to the switch controller
    private void moveToDetails() {
        Brand selectedBrand = brandView.getSelectedBrand();

        if (selectedBrand != null) {
            ModelController modelController = new ModelController(selectedBrand);
            MainApplication.switchController(modelController);
        }
    }

    //updates the listView with the observable list
    private void updateListView() {
        brandObservableList = FXCollections.observableArrayList(brandDAO.getAll());
        brandView.getListView().setItems(brandObservableList);
    }

    //method that loads in the brands from the DAO and updates the list
    private void onLoadBrand() {
        brandDAO.load();
        updateListView();
    }

    //methods that deletes a brand (outdated)
    private void onRemoveBrand() {
        Brand selectedBrand = brandView.getListView().getSelectionModel().getSelectedItem();

        if (selectedBrand != null) {
            brandView.getAlertDelete().showAndWait();
            brandDAO.remove(selectedBrand);
        } else {
            brandView.getAlertDeleteList().setContentText("- No field selected");
            brandView.getAlertDeleteList().showAndWait();
        }
        updateListView();
    }

    //method that adds a brand (outdated)
    private void onAddBrand() {
        Brand brand = brandView.getListView().getSelectionModel().getSelectedItem();

        String brandName = brandView.getBrandName().getText();
        String nameCEO = brandView.getNameCeo().getText();
        String networthCEO = brandView.getNetworth().getText();
        String descriptrion = brandView.getTextArea().getText();
        validateBrand(brandName, networthCEO, nameCEO);
        if (!checkString(brandName) && !checkString(nameCEO) && checkDouble(networthCEO)) {

            if (brand == null) {
                //if there is no selected brand a new brand will be added
                Brand brandInput = new Brand(brandName, nameCEO, networthCEO, descriptrion);

                brandDAO.addOrUpdate(brandInput);
            } else {
                //if there is a selected brand than the new values of the brand wil be set here.
                brand.setBrandName(brandName);
                brand.setCeo(nameCEO);
                brand.setNetWorth(networthCEO);
                brand.setDescription(descriptrion);
            }
            //clears textfield and checkbox after submit
            clearFields();
            //updates list
            updateListView();

        } else {
            //calls in the alert incase input is not valid
            brandView.getAlertSave().showAndWait();
        }
    }

    //methode that clears field of model list.
    private void clearFields() {
        brandView.getListView().getSelectionModel().clearSelection();
        brandView.getBrandName().clear();
        brandView.getNameCeo().clear();
        brandView.getNetworth().clear();
        brandView.getTextArea().clear();
    }

    //method that checks what input is valid and creates an alert string for the Alert in the BrandView
    private void validateBrand(String brandName, String networthCEO, String nameCEO) {
        String alertString = "";

        if (!checkDouble(networthCEO)) {
            alertString = alertString + "- Networth is only valid with digits and is obligated\n";
            brandView.getAlertSave().setContentText(alertString);
        }
        if (checkString(brandName)) {
            alertString = alertString + "- Brand name is obligated\n";
            brandView.getAlertSave().setContentText(alertString);
        }
        if (checkString(nameCEO)) {
            alertString = alertString + "- Name CEO is obligated\n";
            brandView.getAlertSave().setContentText(alertString);
        }
    }

    //method checks if date textfield is not empty
    public boolean checkString(String text) {
        return text.matches("^$");
    }

    //method checks if textfield input is not empty
    public boolean checkDouble(String text) {
        return text.matches("^\\d+(\\.\\d+)+$");
    }

    //method checks if textfield input is a double
    public BrandView getView() {
        return brandView;
    }

}
