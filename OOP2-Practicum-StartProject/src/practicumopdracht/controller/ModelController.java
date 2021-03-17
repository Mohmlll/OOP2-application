package practicumopdracht.controller;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import practicumopdracht.MainApplication;
import practicumopdracht.data.DAO;
import practicumopdracht.models.Brand;
import practicumopdracht.models.Model;
import practicumopdracht.views.ModelView;

import java.time.LocalDate;

public class ModelController extends Controller {

    private final DAO<Model> modelDAO;
    private final ModelView modelView;
    private ObservableList<Model> modelObservableList;
    private final Brand brand;
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
            modelView.setModel(newValue);
            this.model = (newValue);
        });
        //Changes the listView to models only with the selected brand
        modelView.getComboBox().getSelectionModel().selectedItemProperty().addListener((obs, oldValue, newValue) -> {
            updateListView(newValue);
        });

        //Sets the combobox with a brand from the DAO.
        this.modelView.getComboBox().setItems(FXCollections.observableArrayList(MainApplication.getBrandDAO().getAll()));
        this.modelView.getComboBox().setValue(brand);

        //Opens up the Model view
        modelView.getBackButton().setOnAction(actionEvent -> {
            BrandController brandController = new BrandController();
            MainApplication.switchController(brandController);

        });

        //clear model fields
        modelView.getNewModel().setOnAction(actionEvent -> {
            clearFields();
        });

        //updates the ListView.
        updateListView(brand);

    }

    //method to update the listview with the observableList.
    //It only adds models with the selected brand from the comboBox.
    private void updateListView(Brand brand) {
        modelObservableList = FXCollections.observableArrayList(MainApplication.getModelDAO().getAllFor(brand));
        modelView.getModelListView().setItems(modelObservableList);
    }

    //method that loads in the models from the DAO and updates the list
    private void onLoadModel() {
        modelDAO.load();
        updateListView(brand);
    }

    //methods that deletes a model (outdated)
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

    //method that adds a model
    private void onAddOrUpdateModel() {
        Model model = modelView.getModelListView().getSelectionModel().getSelectedItem();

        String modelName = modelView.getModelName().getText();
        String color = modelView.getColor().getText();
        String price = modelView.getPrice().getText();
        LocalDate releaseDate = modelView.getDatePicker().getValue();
        boolean saleChoice = modelView.getSaleCheckBox().isSelected();
        Brand brand = modelView.getComboBox().getValue();


        //checks what alert string to send to the alert
        validateModel(modelName, price, color, releaseDate);
        if (!checkString(modelName) && checkDouble(price) && !checkString(color) && dateChecker(releaseDate)) {
            if (model == null) {
                //if there is no selected model a new model will be added
                this.model = new Model(brand, modelName, color, Double.parseDouble(price), releaseDate, saleChoice);
                modelDAO.addOrUpdate(this.model);
            } else {
                //if there is a selected model than the new values of the model wil be set here.
                model.setBrand(brand);
                model.setModelName(modelName);
                model.setColor(color);
                model.setPrice(Double.parseDouble(price));
                model.setReleaseDate(releaseDate);
                model.setSaleChoice(saleChoice);
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


    private void clearFields() {
        modelView.getModelListView().getSelectionModel().clearSelection();
        modelView.getModelName().clear();
        modelView.getColor().clear();
        modelView.getPrice().clear();
        modelView.getDatePicker().getEditor().clear();
        modelView.getSaleCheckBox().setSelected(false);
    }

    //method that checks what input is valid and creates an alert string for the Alert in the ModelView
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

    //method checks if date textfield is not empty
    private boolean dateChecker(LocalDate date) {
        return date != null;
    }

    //method checks if textfield input is not empty
    public boolean checkString(String text) {
        return text.matches("^$");
    }

    //method checks if textfield input is a double
    public boolean checkDouble(String text) {
        return text.matches("^\\d+(\\.\\d+)+$");
    }

    public ModelView getView() {
        return modelView;
    }
}
