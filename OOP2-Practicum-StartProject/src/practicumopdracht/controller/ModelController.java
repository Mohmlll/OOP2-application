package practicumopdracht.controller;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import practicumopdracht.MainApplication;
import practicumopdracht.models.Model;
import practicumopdracht.views.ModelView;

import java.time.LocalDate;
import java.util.ArrayList;

public class ModelController extends Controller {

    private final ModelView modelView;
    private final ObservableList<Model> modelObservableList;
    BrandController brandController = new BrandController();
    String TODO = "TODO";

    public ModelController() {
        modelView = new ModelView();

        ArrayList<Model> modelArrayList = new ArrayList<>();
        modelObservableList = FXCollections.observableList(modelArrayList);
        modelView.getModelListView().setItems(modelObservableList);

        //Adds a model to the list
        modelView.getSave().setOnAction(actionEvent -> onAddModel());

        //deletes a model from the list
        modelView.getDelete().setOnAction(actionEvent -> {
            onDeleteModel();
        });

        modelView.getComboBox().getItems().add(TODO);
        //opens up the Model view
        modelView.getBrandButton().setOnAction(actionEvent -> {
            BrandController brandController = new BrandController();
            MainApplication.switchController(brandController);

        });
    }

    private void onDeleteModel() {
        Model selectedModel = (Model) modelView.getModelListView().getSelectionModel().getSelectedItem();

        if (selectedModel == null) {
            return;
        }
        modelObservableList.remove(selectedModel);
    }

    private void onAddModel() {
        String modelName = modelView.getModelName().getText();
        String color = modelView.getColor().getText();
        String price = modelView.getPrice().getText();
        LocalDate releaseDate = modelView.getDatePicker().getValue();
        boolean saleChoice = modelView.getSaleCheckBox().isSelected();

        validateModel(modelName, price, color, releaseDate, saleChoice);
        if (!checkString(modelName) && checkDouble(price) && !checkString(color) && dateChecker(releaseDate)) {
            Model model = new Model(modelName, color, Double.parseDouble(price), releaseDate, saleChoice);
            modelObservableList.add(model);
            modelView.getModelName().clear();
            modelView.getColor().clear();
            modelView.getPrice().clear();
            modelView.getDatePicker().getEditor().clear();
            modelView.getSaleCheckBox().setSelected(false);
        } else {
            modelView.getAlertSave().showAndWait();
        }
    }

    private void validateModel(String modelName, String price, String color, LocalDate releaseDate, boolean saleChoice) {
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

    private boolean dateChecker(LocalDate date) {
        return date != null;
    }

    public boolean checkString(String text) {
        return text.matches("^$");
    }

    public boolean checkDouble(String text) {
        return text.matches("[0-9]+");
    }

    public ModelView getView() {
        return modelView;
    }
}