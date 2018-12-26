/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cr.ac.ucenfotec.ui;

import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXRadioButton;
import javafx.collections.ObservableList;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;

/**
 *
 * @author Dell && !i.getText().matches("[0-9]+")
 */
public class Validation {

    public static boolean textFieldNotEmpty(TextField i) {

        boolean r = false;
        if (i.getText() != null && !i.getText().isEmpty()) {
            r = true;
        }

        return r;
    }

    public static boolean textFieldNotEmpty(TextField i, Label l, String aValidationText) {
        boolean r = true;
        String c = null;
        i.getStyleClass().remove("error2");
        if (!textFieldNotEmpty(i)) {
            r = false;
            c = aValidationText;
            i.getStyleClass().add("error2");
        }
        l.setText(c);
        return r;
    }

    public static boolean textFieldCedulaJuridica(TextField i) {

        boolean r = false;
        if (i.getText().length() == 9) {
            r = true;
        } else {
            r = false;
        }

        return r;
    }

    public static boolean textFieldCedulaJuridica(TextField i, Label l, String aValidationText) {
        boolean r = true;
        String c = null;
        i.getStyleClass().remove("error2");
        if (!textFieldCedulaJuridica(i)) {
            r = false;
            c = aValidationText;
            i.getStyleClass().add("error2");
        }
        l.setText(c);
        return r;
    }

    public static boolean textAreadNotEmpty(TextArea i, Label l, String aValidationText) {
        boolean r = true;
        String c = null;
        i.getStyleClass().remove("error2");
        if (!textAreadNotEmpty(i)) {
            r = false;
            c = aValidationText;
            i.getStyleClass().add("error2");
        }
        l.setText(c);

        return r;
    }

    public static boolean textAreadNotEmpty(TextArea i) {

        boolean r = false;
        if (i.getText() != null && !i.getText().isEmpty()) {
            r = true;
        }

        return r;
    }

    public static boolean textFieldString(TextField i) {

        boolean r = false;
        if (!i.getText().matches("[0-9]+")) {
            r = true;
        }
        return r;
    }

    public static boolean textFieldString(TextField i, Label l, String aValidationText) {
        boolean r = true;
        String c = null;
        i.getStyleClass().remove("error");
        if (!textFieldString(i)) {
            r = false;
            c = aValidationText;
            i.getStyleClass().add("error");
        }
        l.setText(c);
        return r;
    }

    public static boolean tableNotEmpty(ObservableList lista) {

        boolean result = true;
        if (lista.isEmpty()) {
            result = true;
        } else {
            result = false;
        }

        return result;
    }
    
    
     public static boolean tableNotEmpty(JFXComboBox i, Label l, String aValidationText, ObservableList lista) {
        boolean r = true;
        String c = null;
        i.getStyleClass().remove("error");
        if (tableNotEmpty(lista) == true) {
            r = false;
            c = aValidationText;
            i.getStyleClass().add("error");
        }
        l.setText(c);
        return r;
    }
     
     
     
     public static boolean comboBoxEmpty(JFXComboBox i){
         boolean result = false;
               
        
         if(i.getSelectionModel().getSelectedItem() == null){
             result = true;
         }else{
             result = false;
         }
         
         
         return result;
     }
     
     
     
       public static boolean comboBoxEmpty(JFXComboBox i, Label l, String aValidationText) {
        boolean r = true;
        String c = null;
        i.getStyleClass().remove("error");
        if (comboBoxEmpty(i) == true) {
            r = false;
            c = aValidationText;
            i.getStyleClass().add("error");
        }
        l.setText(c);
        return r;
    }
     
       

    public static void textFieldStringRed(TextField i) {

        i.getStyleClass().add("error");

    }

    public static void textFieldStringNoRed(TextField i) {

        i.getStyleClass().remove("error");

    }
    
    
    public static void comboBoxNoRed(JFXComboBox i) {

        i.getStyleClass().remove("error");

    }
    

    public static boolean isValidEmailAddress(TextField i, Label l, String aValidationText) {
        boolean r = true;
        String c = null;
        i.getStyleClass().remove("error");
        if (!isValidEmailAddress(i)) {
            r = false;
            c = aValidationText;
            i.getStyleClass().add("error");
        }
        l.setText(c);
        return r;
    }

    public static boolean isValidEmailAddress(TextField i) {

        boolean result = true;

        try {
            InternetAddress emailAddr = new InternetAddress(i.getText());
            emailAddr.validate();
        } catch (AddressException ex) {
            result = false;
        }

        if (i.getText() == "") {
            result = true;
        }

        return result;
    }

    public static boolean radioButtonEmpty(JFXRadioButton a, JFXRadioButton b, JFXRadioButton c, String aValidationText, Label l) {

        String d = null;
        boolean r = true;

        if (a.isSelected() == false && b.isSelected() == false && c.isSelected() == false) {
            r = false;
            d = aValidationText;

        }

        l.setText(d);
        return r;

    }
}
