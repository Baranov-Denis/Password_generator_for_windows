package Controller;

import Model.Model;
import Viewer.Viewer;

import javax.swing.*;

public class Controller {

    private final Model model;
    private Viewer viewer;

    public Controller(Model model) {
        this.model = model;
    }

    public void addViewer(Viewer viewer){
        this.viewer = viewer;
    }

    public void runApp() {
        SwingUtilities.invokeLater(viewer::runMainPage);
    }

    public void runGenerate(String resource, String key) {
        viewer.setPasswordText(model.createPassword(resource, key)) ;
        viewer.runMainPage();
    }
}
