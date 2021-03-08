package practicumopdracht.controller;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import practicumopdracht.MainApplication;
import practicumopdracht.models.Model;
import practicumopdracht.views.ModelView;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Date;

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
        String price = modelView.getPrice().getText();
        LocalDate releaseDate = modelView.getDatePicker().getValue();


        if (validateText(modelName) && validateDouble(price)) {
            Model model = new Model("brandname", modelName, Double.parseDouble(price), releaseDate);
            modelObservableList.add(model);
        } else if(validateText(modelName) && !validateDouble(price)){
            modelView.getAlertSave().setContentText("- Price mag alleen nummers hebben");
            modelView.getAlertSave().showAndWait();
        } else if (!validateText(modelName) && validateDouble(price)){
            modelView.getAlertSave().setContentText("- Niet alle velden zijn ingevuld");
            modelView.getAlertSave().showAndWait();
        }else{
            modelView.getAlertSave().setContentText("- Niet alle velden zijn ingevuld\n- Price mag alleen nummers hebben");
            modelView.getAlertSave().showAndWait();
        }
    }

    private boolean validateText(String text){
        return brandController.checkString(text);
    }
    private boolean validateDouble(String text){
        return brandController.checkDouble(text);
    }
    public ModelView getView() {
        return modelView;
    }
}