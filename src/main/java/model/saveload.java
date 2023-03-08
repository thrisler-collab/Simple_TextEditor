package model;

import com.example.aufgabe_10.MyPane;

import java.io.*;
import java.util.ArrayList;
import com.example.aufgabe_10.MyPane;
import javafx.scene.control.Alert;

public class saveload {
    MyPane g;
   String tit;
   String co;

    public saveload(MyPane g) {
        this.g = g;
    }

    public String getTit() {
        return tit;
    }

    public String getCo() {
        return co;
    }

    public void setTit(String tit) {
        this.tit = tit;
    }

    public void setCo(String co) {
        this.co = co;
    }

    public void speichernSER(File x){
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(x))) {
            oos.writeObject(g.gettitel());
            oos.writeObject(g.getcontent());
            tit = g.gettitel();
            co = g.getcontent();
        } catch (IOException e) {
            Alert t = new Alert(Alert.AlertType.ERROR);
            t.setTitle("Error");
            t.setHeaderText("Error while Saving");
            t.setContentText("During saving the file there was an error. Please tray again.");
            t.show();
        }


    }

    public void speichernTXT(File x){
        tit = g.gettitel();
        co = g.getcontent();
        try(BufferedWriter pw = new BufferedWriter(new FileWriter(g.getFname() + ".txt"))) {

            pw.write(g.gettitel());
            pw.newLine();
            pw.write(g.getcontent());
        } catch (IOException e) {
            Alert t = new Alert(Alert.AlertType.ERROR);
            t.setTitle("Error");
            t.setHeaderText("Error while Saving");
            t.setContentText("During saving the file there was an error. Please tray again.");
            t.show();
        }

    }

    public void loadTXT(File h){
        try (BufferedReader br = new BufferedReader(new FileReader(h))){
            String t = "";
            String c = "";

            t = br.readLine();
            c = br.readLine();

            tit = t;
            co = c;

            g.setTitel(t);
            g.setcontent(c);

        } catch (IOException e) {
            Alert t = new Alert(Alert.AlertType.ERROR);
            t.setTitle("Error");
            t.setHeaderText("Error while loading");
            t.setContentText("During loading the file there was an error. Please tray again.");
            t.show();
        }
    }

    public void loadSER(File b){
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(b))){
            String t = "";
            String c = "";

            t = (String)ois.readObject();
            c = (String)ois.readObject();

            g.setTitel(t);
            g.setcontent(c);

        } catch (IOException | ClassNotFoundException e) {
            Alert t = new Alert(Alert.AlertType.ERROR);
            t.setTitle("Error");
            t.setHeaderText("Error while loading");
            t.setContentText("During loading the file there was an error. Please tray again.");
            t.show();
        }
    }
}
