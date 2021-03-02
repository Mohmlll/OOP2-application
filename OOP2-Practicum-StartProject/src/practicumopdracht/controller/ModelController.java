package practicumopdracht.controller;

import javafx.collections.ObservableList;
import practicumopdracht.models.Model;
import practicumopdracht.views.ModelView;

public class ModelController extends Controller {

    private final ModelView modelView;
    private ObservableList<Model> modelObservableList;


    public ModelController() {
        modelView = new ModelView();
    }


    public ModelView getView() {
        return modelView;
    }
}
