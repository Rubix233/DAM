/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.calculadora.imc.controller;

import com.calculadora.imc.model.CalculadoraIMC;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.paint.Color;

/**
 *
 * @author andyj
 */
public class IMCController {
    @FXML private TextField txtPeso;
    @FXML private TextField txtAltura;
    @FXML private Label lblResultado;
    @FXML private Label lblClasificacion;
    
    private final CalculadoraIMC calculadora = new CalculadoraIMC();
    
    @FXML private void handleCalcular(){
        String pesoStr = txtPeso.getText().trim();
        String alturaStr = txtAltura.getText().trim();
        double peso, altura, imc;
        String[] clasificacion;
        
        if (pesoStr.isEmpty() || alturaStr.isEmpty()) {
            lblClasificacion.setText("Rellena peso y altura.");
            return;
        }
        
        try{
            peso = Double.parseDouble(pesoStr.replace(',', '.'));
            altura = Double.parseDouble(alturaStr.replace(',', '.'));
        } catch (NumberFormatException nfe){
            lblClasificacion.setText("Error: Datos inválidos");
            return;
        }
        
        imc = calculadora.calcular(peso, altura);
        clasificacion = calculadora.clasificar(imc);
        
        lblResultado.setText(String.format("Tu IMC es: %.2f", imc));
        lblClasificacion.setText(clasificacion[0]);
        lblClasificacion.setTextFill((Color.valueOf(clasificacion[1])));
    }
    
}
