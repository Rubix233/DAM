module com.mycompany.calculadoraimc {
    requires javafx.controls;
    requires javafx.fxml;

    opens com.calculadora.imc.main to javafx.fxml;
    opens com.calculadora.imc.controller to javafx.fxml; 
    
    exports com.calculadora.imc.main;
}
