/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.calculadora.imc.model;

/**
 *
 * @author andyj
 */
public class CalculadoraIMC {
    public double calcular(double peso, double altura){
        return peso / (altura*altura);
    }
    public String[] clasificar(double imc){
      if(bajoPeso(imc)) return new String[]{"Bajo Peso", "ORANGE"};  
      if(pesoNormal(imc)) return new String[]{ "Peso Normal", "GREEN"};  
      if(sobrepeso(imc)) return new String[]{"Sobrepeso", "ORANGE"};  
      if(obesidad(imc)) return new String[]{"Obesidad","RED"};  
      return null;
    }
    private boolean bajoPeso(double imc){
        return imc < 18.5;
    }
    private boolean pesoNormal(double imc){
        return imc >= 18.5 && imc < 25;
    }
    private boolean sobrepeso(double imc){
        return imc >= 25 && imc < 30;
    }
    private boolean obesidad(double imc){
        return imc >= 30;
    }
    
}
