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
        Model model = (Model) modelView.getModelListView().getSelectionModel().getSelectedItem();

        if (model == null) {
            model = new Model("brandname", modelName, Double.parseDouble(price), releaseDate);
            modelObservableList.add(model);
        } else {
            model.setModelName(modelName);
            model.setPrice(Double.parseDouble(price));
            model.setReleaseDate(releaseDate);

            int index = modelObservableList.indexOf(model);
            modelObservableList.set(index, model);
        }
    }

    public ModelView getView() {
        return modelView;
    }
}