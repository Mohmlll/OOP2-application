package practicumopdracht.controller;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import practicumopdracht.MainApplication;
import practicumopdracht.comparators.BrandComparator;
import practicumopdracht.data.DAO;
import practicumopdracht.models.Brand;
import practicumopdracht.views.BrandView;
import practicumopdracht.views.View;

import java.util.List;

/**
 * Controller for the master items
 *
 * @author Mohammed Malloul
 */

public class BrandController extends Controller {

    private DAO<Brand> brandDAO;
    private BrandView brandView;
    private ObservableList<Brand> brandObservableList;
    private ModelController modelController;

    public BrandController() {
        brandDAO = MainApplication.getBrandDAO();
        brandView = new BrandView();
        modelController = MainApplication.getModelController();

        //adds a new brand name

        brandView.getSave().setOnAction(actionEvent -> {
            onAddOrUpdateBrand();
        });

        //deletes a brand name from the list
        brandView.getDelete().setOnAction(actionEvent -> {
            brandView.getDelete().setOnAction(e -> {
                onRemoveBrand();
            });
        });
        //Detail button gets disabled, listener added to selection and value is send to the setBrand method
        brandView.getListView().getSelectionModel().selectedItemProperty().addListener((obs, oldValue, newValue) -> {
            brandView.setSelectedBrand(newValue);

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

        //sorts the brands from A tot Z on start up
        BrandComparator comparator = new BrandComparator(true);
        sort(comparator);
    }

    /**
     * Constructor chaining for a selected brand
     *
     * @param brands list of brands
     */
    public BrandController(List<Brand> brands) {
        this();
        this.setBrand(brands);
    }

    /**
     * Methods calles the SetBrand() method from the BrandView Class
     *
     * @param brands list of brands
     */
    public void setBrand(List<Brand> brands) {
        this.brandView.setBrands(brands);
    }

    /**
     * The observable list gets data from the DAO
     * and updates it to the Listview
     */
    private void updateListView() {
        brandObservableList = FXCollections.observableArrayList(brandDAO.getAll());
        brandView.getListView().setItems(brandObservableList);
    }

    /**
     * Calls the updateListView() method so the menu controller can use it.
     */
    public void refresh() {
        updateListView();
    }

    /**
     * Checks if a brand is selected,
     * if yes it allows acces to the switch controller
     */
    private void moveToDetails() {
        if (selectedBrand() != null) {
            modelController = new ModelController(selectedBrand());
            MainApplication.switchController(modelController);
        }
    }

    /**
     * Method that gets a selected brand from the brand view.
     *
     * @return a selected from the listview
     */
    private Brand selectedBrand() {
        return brandView.getSelectedBrand();
    }

    /**
     * This method removes a selected brand from the listview.
     * The Brand selectedBrand gets the selected brand.
     * getAlertDelete will show if there is no brand selected an alert will show to let the user know that there is no field selected.
     * getAlertDeleteList will show If there is a brand selected and the user will have to confirm that he wants the brand deleted
     * If the user wants the brand deleted the remove() method will remove the selected brand from the data.
     */
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

    /**
     * This method adds or updates a brand
     * selectedBrand is a selected brand from the listView
     * if selectedBrand is null, then a brand will be added.
     * if selectedBrand is not null, then the selected brand will be updated
     */
    private void onAddOrUpdateBrand() {
        Brand selectedBrand = brandView.getListView().getSelectionModel().getSelectedItem();

        String brandName = brandView.getBrandName().getText();
        String nameCEO = brandView.getNameCeo().getText();
        String networthCEO = brandView.getNetworth().getText();
        String descriptrion = brandView.getTextArea().getText();
        validateBrand(brandName, networthCEO, nameCEO);

        if (!checkString(brandName) && !checkString(nameCEO) && !checkString(networthCEO)) {
            if (selectedBrand == null) {
                //if there is no selected brand a new brand will be added
                Brand brandInput = new Brand(brandName, nameCEO, networthCEO, descriptrion);

                brandDAO.addOrUpdate(brandInput);
            } else {
                //if there is a selected brand than the new values of the brand wil be set here.
                selectedBrand.setBrandName(brandName);
                selectedBrand.setCeo(nameCEO);
                selectedBrand.setNetWorth(networthCEO);
                selectedBrand.setDescription(descriptrion);
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

    /**
     * this methods clears the input fields
     */
    private void clearFields() {
        brandView.getListView().getSelectionModel().clearSelection();
        brandView.getBrandName().clear();
        brandView.getNameCeo().clear();
        brandView.getNetworth().clear();
        brandView.getTextArea().clear();
    }

    /**
     * This method sorts the list
     *
     * @param brandComparator -  Object from the BrandComparator Class
     */
    public void sort(BrandComparator brandComparator) {
        brandView.getListView().getItems().sort(brandComparator);
    }

    //method that checks what input is valid and creates an alert string for the Alert in the BrandView

    /**
     * Methods validates the params and returns and adds and alertString to the saveAlert from the brandView
     *
     * @param brandName   - String name from brand
     * @param networthCEO - String Networth from CEO
     * @param nameCEO     -  String name from CEO
     */
    private void validateBrand(String brandName, String networthCEO, String nameCEO) {
        String alertString = "";

        if (checkString(networthCEO)) {
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

    /**
     * This methods checks if a String matches the regex
     *
     * @param text - String text that needs to be checked
     * @return returns true if text matches, else it is false
     */
    public boolean checkString(String text) {
        return text.matches("^$");
    }

    public ModelController getModelController() {
        return modelController;
    }

    public View getView() {
        return brandView;
    }
}
