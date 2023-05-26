/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package mvc;

import com.binarybrain.divisas.View;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

/**
 *
 * @author SIMJA
 */
public class Controller implements ActionListener {

    private Model modelo;
    private View vista;
    private Double cantidad;

    public Controller(Model modelo, View vista) {
        this.modelo = modelo;
        this.vista = vista;

        this.vista.txtOne.addActionListener(this);
        this.vista.txtTwo.addActionListener(this);
    }

    public void iniciarVista() {
        vista.setTitle("Conversor de Divisas" + "☕");
        vista.setVisible(true);
    }

    public void actionPerformed(ActionEvent evento) {
        String cb1 = vista.getCboxOne();
        String cb2 = vista.getCboxTwo();

        if (vista.txtOne == evento.getSource()) {
            if ("".equals(vista.txtOne.getText().trim())) {
                vista.showAlert();
            }
            modelo.setExchangeRate(cb1, cb2);
            calcular(cb1, cb2, vista.txtTwo);
        }
        
        if (vista.txtTwo == evento.getSource()) {
            if ("".equals(vista.txtTwo.getText().trim())) {
                vista.showAlert();
            }
            modelo.setExchangeRate(cb2, cb1);
            calcular(cb1, cb2, vista.txtOne);
        }

    }

    public void calcular(String op1, String op2, JTextField res) {
        try {
            cantidad = Double.parseDouble(vista.txtOne.getText());
            modelo.setCantidad(cantidad);

            if (op1.equals(op2) || op1.equals(op2)) {
                modelo.setMoneda(1.0);
            } else {
                modelo.setMoneda();
            }

            modelo.convetirMoneda();
            res.setText(modelo.getResultado());
        } catch (NumberFormatException e) {
            vista.showAlert("Introduzca una cantidad valida...");
        }
    }

}
