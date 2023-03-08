package com.example.aufgabe_10;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.*;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import Controler.controler;
import javafx.scene.text.Text;
import model.saveload;

public class MyPane extends FlowPane {
    private controler con;
    private saveload model;

    //Alles was mach später zum bearbeiten brauchst immer außen Definiere bzw deklarieren.
      private TextField datnametxt;
      private TextField tit;
      private TextArea co;
      private RadioButton binaer;
      private  RadioButton txt;
    public MyPane(){
        model = new saveload();
        con = new controler(this, model);

        init();
    }

    public void init(){
        HBox header = new HBox();
        Label datname = new Label("Filename:");
        datnametxt = new TextField("*.pos");
        txt = new RadioButton("Text");
        txt.setSelected(true);
        binaer = new RadioButton("Binary");
        ToggleGroup tg = new ToggleGroup();
        binaer.setToggleGroup(tg);
        txt.setToggleGroup(tg);
        Button load = new Button("Load File");
        load.setUserData("load");
        load.setOnAction(con);
        Button save  = new Button("Save File");
        save.setUserData("save");
        save.setOnAction(con);
        header.setPadding(new Insets(10));
        header.setSpacing(10);
        header.setAlignment(Pos.CENTER);
        header.getChildren().addAll(datname, datnametxt, txt, binaer, load, save);

        VBox main = new VBox();
        Label title = new Label("Titel:");
        tit = new TextField();
        tit.setMinWidth(300);
        Label content = new Label("Content:");
         co = new TextArea();
        co.setMinWidth(300);
        co.setMinHeight(400);
        main.setPadding(new Insets(10));
        main.setSpacing(10);
        main.getChildren().addAll(title, tit, content,co);



        this.getChildren().addAll(header, main);


    }

    public String filename(){ return datnametxt.getText();}
    public String gettitel(){ return tit.getText();}
    public String getcontent(){return co.getText();}

    public void setTitel(String f){tit.setText(f);}

    public void setcontent(String f){co.setText(f);}

    public String getFname(){return datnametxt.getText();}

    public boolean binaer(){ return binaer.isSelected();}
    public boolean txt(){ return txt.isSelected();}

}
