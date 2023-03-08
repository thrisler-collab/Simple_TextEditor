package Controler;

import com.example.aufgabe_10.MyPane;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.stage.FileChooser;
import model.saveload;
import java.io.File;
import java.io.IOException;


public class controler implements EventHandler<ActionEvent> {
    
    private MyPane view;
    private saveload model;

    public controler(MyPane view, saveload model) {
        this.view = view;
        this.model = model;
    }


    @Override
    public void handle(ActionEvent actionEvent) {
        String todo = "";
        
        if (actionEvent.getSource() instanceof Button){
            todo = (String)((Button)actionEvent.getSource()).getUserData();
        }
        switch (todo){
            case "save": speichern(); break;
            case "load": laden(); break;
        }
    }

    private void laden() {
    }

    private void speichern() {
        FileChooser fc = new FileChooser();
        fc.setTitle("Save File");
        File file = fc.showSaveDialog(view.getScene().getWindow());

        if (file != null){
            if (view.binaer()){
                model.speichernSER(file);
            }

            if(view.txt()){
                model.speichernTXT(file);
            }
        }

    }
}
