package practicumopdracht.controller;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import practicumopdracht.MainApplication;
import practicumopdracht.comparators.ModelComparator;
import practicumopdracht.data.DAO;
import practicumopdracht.models.Brand;
import practicumopdracht.models.Model;
import practicumopdracht.views.ModelView;
import java.time.LocalDate;

/**
 * Controller for the detail items
 *
 * @author Mohammed Malloul
 */

public class ModelController extends Controller {

    private DAO<Model> modelDAO;
    private ModelView modelView;
    private ObservableList<Model> modelObservableList;
    private Brand brand;
    private Model model;

    public ModelController(Brand selectedBrand) {
        modelDAO = MainApplication.getModelDAO();
        modelView = new ModelView();
        brand = selectedBrand;

        //Adds a model to the list.
        modelView.getSave().setOnAction(actionEvent -> onAddOrUpdateModel());

        //deletes a model from the list.
        modelView.getDelete().setOnAction(actionEvent -> {
            onRemoveModel();
        });
        //displays the data from the selected model in the fields.
        modelView.getModelListView().getSelectionModel().selectedItemProperty().addListener((bs, oldValue, newValue) -> {
            this.modelView.setModel(newValue);
            this.model = (newValue);
        });
        //Changes the listView to models only with the selected brand
        modelView.getComboBox().getSelectionModel().selectedItemProperty().addListener((obs, oldValue, newValue) -> {
            updateListView(newValue);
        });

        //Sets the combobox with a brand from the DAO.
        this.modelView.getComboBox().setItems(FXCollections.observableArrayList(MainApplication.getBrandDAO().getAll()));
        this.modelView.getComboBox().setValue(this.brand);

        //Opens up the Model view
        modelView.getBackButton().setOnAction(actionEvent -> {
            BrandController brandController = new BrandController();
            MainApplication.switchController(brandController);
        });

        //clear model fields
        modelView.getNewModel().setOnAction(actionEvent -> {
            clearFields();
        });

        //sorts the models descending
        modelView.getAscending().setOnAction(actionEvent -> {
            ModelComparator modelComparator = new ModelComparator(false);
            sort(modelComparator);
        });

        //sorts the models ascending
        modelView.getDescending().setOnAction(actionEvent -> {
            ModelComparator modelComparator = new ModelComparator(true);
            sort(modelComparator);
        });

        //updates the ListView.
        updateListView(this.brand);

        //Sorts list from A-Z on start up
        ModelComparator startComparator = new ModelComparator(true);
        sort(startComparator);

    }

    /**
     * The observable list gets data from the DAO
     * and updates it to the Listview
     * it only updates if there a brand selected in the comboBox
     * the models that are being updated into the listview have to have a relation with the brand
     * @param brand - a selected brand
     */
    public void updateListView(Brand brand) {
        modelObservableList = FXCollections.observableArrayList(MainApplication.getModelDAO().getAllFor(brand));
        modelView.getModelListView().setItems(modelObservableList);
    }

    /**
     * Calls the updateListView() method so the menu controller can use it.
     */
    public void refresh() {
        updateListView(this.brand);
    }

    /**
     * This method removes a selected model from the listview.
     * The Model selectedModel gets the selected model.
     * getAlertDelete will show if there is no model selected an alert will show to let the user know that there is no field selected.
     * getAlertDeleteList will show If there is a model selected and the user will have to confirm that he wants the model deleted
     * If the user wants the model deleted the remove() method will remove the selected brand from the data.
     */
    private void onRemoveModel() {
        Model selectedModel = modelView.getModelListView().getSelectionModel().getSelectedItem();
        if (selectedModel != null) {
            modelView.getAlertDelete().showAndWait();
            modelDAO.remove(selectedModel);
        } else {
            modelView.getAlertDeleteList().setContentText("- No field selected");
            modelView.getAlertDeleteList().showAndWait();
        }
        updateListView(this.brand);
    }

    /**
     * This method adds or updates a model
     * selectedModel is a selected model from the listView
     * if selectedModel is null, then a model will be added.
     * if selectedModel is not null, then the selected model will be updated
     */
    private void onAddOrUpdateModel() {
        Model selectedModel = modelView.getModelListView().getSelectionModel().getSelectedItem();

        String modelName = modelView.getModelName().getText();
        String color = modelView.getColor().getText();
        String price = modelView.getPrice().getText();
        LocalDate releaseDate = modelView.getDatePicker().getValue();
        boolean saleChoice = modelView.getSaleCheckBox().isSelected();
        Brand brand = modelView.getComboBox().getValue();


        //checks what alert string to send to the alert
        validateModel(modelName, price, color, releaseDate);
        if (!checkString(modelName) && checkDouble(price) && !checkString(color) && dateChecker(releaseDate)) {
            if (selectedModel == null) {
                //if there is no selected model a new model will be added
                this.model = new Model(brand, modelName, color, Double.parseDouble(price), releaseDate, saleChoice);
                modelDAO.addOrUpdate(this.model);
            } else {
                //if there is a selected model than the new values of the model wil be set here.
                selectedModel.setBrand(brand);
                selectedModel.setModelName(modelName);
                selectedModel.setColor(color);
                selectedModel.setPrice(Double.parseDouble(price));
                selectedModel.setReleaseDate(releaseDate);
                selectedModel.setSaleChoice(saleChoice);
            }
            //clears textfield and checkbox after submit
            clearFields();
            //updates list
            updateListView(this.brand);
        } else {
            //calls in the alert incase input is not valid
            modelView.getAlertSave().showAndWait();
        }

    }

    /**
     * this methods clears the input fields
     */
    private void clearFields() {
        modelView.getModelListView().getSelectionModel().clearSelection();
        modelView.getModelName().clear();
        modelView.getColor().clear();
        modelView.getPrice().clear();
        modelView.getDatePicker().getEditor().clear();
        modelView.getSaleCheckBox().setSelected(false);
    }

    /**
     * This method sorts the list
     *
     * @param modelComparator -  Object from the ModelComparator Class
     */
    public void sort(ModelComparator modelComparator) {
        modelView.getModelListView().getItems().sort(modelComparator);
    }


    /**
     * Methods validates the params and returns and adds and alertString to the saveAlert from the modelView
     *
     * @param modelName -  String name of model
     * @param price - Double price of model
     * @param color - String color of model
     * @param releaseDate - LocalDate release date of model
     */
    private void validateModel(String modelName, String price, String color, LocalDate releaseDate) {
        String alertString = "";

        if (!checkDouble(price)) {
            alertString = alertString + "- Price is only valid with digits and is obligated\n";
            modelView.getAlertSave().setContentText(alertString);
        }
        if (checkString(modelName)) {
            alertString = alertString + "- Model name is obligated\n";
            modelView.getAlertSave().setContentText(alertString);
        }
        if (checkString(color)) {
            alertString = alertString + "- Color is obligated\n";
            modelView.getAlertSave().setContentText(alertString);
        }
        if (!dateChecker(releaseDate)) {
            alertString = alertString + "- Release date has to be valid and is obligated\n";
            modelView.getAlertSave().setContentText(alertString);
        }
    }

    /**
     * checks if the release date is not null
     * @param date - Localdate
     * @return boolean true if not null, false if null
     */
    private boolean dateChecker(LocalDate date) {
        return date != null;
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

    /**
     * This methods checks if a Double matches the regex
     *
     * @param text - Double that needs to be checked
     * @return returns true if Double matches, else it is false
     */
    public boolean checkDouble(String text) {
        return text.matches("^\\d+(\\.\\d+)+$");
    }


    public ModelView getView() {
        return modelView;
    }
}
