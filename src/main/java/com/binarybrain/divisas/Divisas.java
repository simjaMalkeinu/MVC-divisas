/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Project/Maven2/JavaApp/src/main/java/${packagePath}/${mainClassName}.java to edit this template
 */

package com.binarybrain.divisas;
import mvc.Controller;
import mvc.Model;

/**
 *
 * @author SIMJA
 */
public class Divisas {

    public static void main(String[] args) {
        Model modelo = new Model();
        View vista = new View();
        Controller controlador = new Controller(modelo, vista);
        controlador.iniciarVista();
    }
}
