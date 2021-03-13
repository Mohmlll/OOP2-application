package practicumopdracht.controller;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import practicumopdracht.Main;
import practicumopdracht.MainApplication;
import practicumopdracht.data.DAO;
import practicumopdracht.models.Brand;
import practicumopdracht.models.Model;
import practicumopdracht.views.BrandView;
import practicumopdracht.views.ModelView;

import java.time.LocalDate;

public class ModelController extends Controller {

    private DAO<Model> modelDAO;
    private ModelView modelView;
    private ObservableList<Model> modelObservableList;
    private Brand brand;

    public ModelController(Brand selectedBrand) {
        modelDAO = MainApplication.getModelDAO();
        modelView = new ModelView();
        brand = selectedBrand;
        //updates the ListView
        updateListView(brand);

        //load fake daoModel
        modelView.getMenuLoad().setOnAction(actionEvent -> onLoadModel());

        //Adds a model to the list
        modelView.getSave().setOnAction(actionEvent -> onAddModel());

        //deletes a model from the list
        modelView.getDelete().setOnAction(actionEvent -> {
            onDeleteModel();
        });

        //Sets the combobox with a brand from the DAO
        this.modelView.getComboBox().setItems(FXCollections.observableArrayList(MainApplication.getBrandDAO().getAll()));
        this.modelView.getComboBox().setValue(brand);
        //opens up the Model view
        modelView.getBackButton().setOnAction(actionEvent -> {
            BrandController brandController = new BrandController();
            MainApplication.switchController(brandController);

        });
    }

    //method to update the listview with the observableList
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
    private void onDeleteModel() {
        Model selectedModel = (Model) modelView.getModelListView().getSelectionModel().getSelectedItem();

        if (selectedModel == null) {
            return;
        }
        modelObservableList.remove(selectedModel);
    }

    //method that adds a model (outdated)
    private void onAddModel() {
        String modelName = modelView.getModelName().getText();
        String color = modelView.getColor().getText();
        String price = modelView.getPrice().getText();
        LocalDate releaseDate = modelView.getDatePicker().getValue();
        boolean saleChoice = modelView.getSaleCheckBox().isSelected();
        //tempory brand
        Brand brand = modelView.getComboBox().getValue();
        //checks what alert string to send to the alert
        validateModel(modelName, price, color, releaseDate);
        if (!checkString(modelName) && checkDouble(price) && !checkString(color) && dateChecker(releaseDate)) {
            Model model = new Model(brand, modelName, color, Double.parseDouble(price), releaseDate, saleChoice);
            modelObservableList.add(model);

            //clears textfield and checkbox after submit
            modelView.getModelName().clear();
            modelView.getColor().clear();
            modelView.getPrice().clear();
            modelView.getDatePicker().getEditor().clear();
            modelView.getSaleCheckBox().setSelected(false);
        } else {
            //calls in the alert incase input is not valid
            modelView.getAlertSave().showAndWait();
        }
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
        return text.matches("[0-9]+");
    }

    public ModelView getView() {
        return modelView;
    }
}