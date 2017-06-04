/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.ijse.gdse41.dominos.view.controller;

import com.jfoenix.controls.JFXTextField;
import javafx.scene.control.Alert;
import javafx.scene.control.DialogPane;
import javafx.scene.input.KeyEvent;

import javax.xml.transform.sax.SAXSource;
import java.awt.*;

import static java.awt.Color.red;

/**
 *
 * @author SHEHANKA
 */
public class ValidationController {

    private static final Runnable runnable = (Runnable) (Toolkit.getDefaultToolkit().getDesktopProperty("win.sound.default"));

    public static void onlyNumeric(KeyEvent evt) {
        String s = evt.getCharacter();
        if (!(s.matches("\\d") || s.equals("\b"))) {
            if (runnable != null) {
                runnable.run();
            }
            System.out.println("evt");
            evt.consume();
            System.out.println(evt.isConsumed());
        }
    }

    public static void onlyAlpha(KeyEvent evt) {
        String s = evt.getCharacter();
        System.out.println(s);
        if (!(s.matches("[A-z]") || s.equals("\b"))) {
            if (runnable != null) {
                runnable.run();
            }
            evt.consume();
            System.out.println(evt.isConsumed());
        }
    }

    public static void monetary(KeyEvent evt) {
        String s = evt.getCharacter();
        if (!(s.matches("\\d") || s.equals("\b") || s.equals("."))) {
            if (runnable != null) {
                runnable.run();
            }
            evt.consume();
            System.out.println(evt.isConsumed());
        }
    }

    public static void validateTelephoneNumber(JFXTextField txt) {
        if (txt.getText().matches("^(((00|[+])\\d{2}[-]?)?(\\d{2}|\\d{3})[-]?(\\d{7}))$")) {
            //txt.setSt
        } else {
            txt.setStyle("-fx-text-fill: #f22613");
        }
    }

    public static void validateNIC(TextField txt) {
        if (txt.getText().matches("^(\\d{9}|\\d{12})[VvXx]$")) {
            //txt.setId(null);
        } else {
            //txt.setId("txtRed");
        }
    }

    public static void validateEMail(TextField txt) {
        if (txt.getText().matches("(?:[a-z0-9!#$%&'*+/=?^_`{|}~-]+(?:\\.[a-z0-9!#$%&'*+/=?^_`{|}~-]+)*|\"(?:[\\x01-\\x08\\x0b\\x0c\\x0e-\\x1f\\x21\\x23-\\x5b\\x5d-\\x7f]|\\\\[\\x01-\\x09\\x0b\\x0c\\x0e-\\x7f])*\")@(?:(?:[a-z0-9](?:[a-z0-9-]*[a-z0-9])?\\.)+[a-z0-9](?:[a-z0-9-]*[a-z0-9])?|\\[(?:(?:25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?)\\.){3}(?:25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?|[a-z0-9-]*[a-z0-9]:(?:[\\x01-\\x08\\x0b\\x0c\\x0e-\\x1f\\x21-\\x5a\\x53-\\x7f]|\\\\[\\x01-\\x09\\x0b\\x0c\\x0e-\\x7f])+)\\])")) {
            //txt.setId(null);
        } else {
            //txt.setId("txtRed");
        }
    }


}
