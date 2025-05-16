/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Andy Jan y Jaime Martín
 */
import java.util.GregorianCalendar;

public class Mensaje {
    // Constante APIPA

    private static final String APIPA = "169.254.0.0";
    // Atributos privados
    private String usuario;
    private GregorianCalendar fecha;
    private String ip;
    private String texto;

    // Constructor por defecto
    public Mensaje() {
        this.usuario = "System";
        this.fecha = new GregorianCalendar();
        this.ip = APIPA;
        this.texto = encripta("Por defecto");
    }

    // Constructor con parámetros
    public Mensaje(String usuario, String ip, String texto) {
        this.usuario = usuario;
        this.fecha = new GregorianCalendar();
        
        if(esValida(ip)){
            this.ip = ip;
        }else {
            this.ip = APIPA;
        }
        
        this.texto = encripta(texto);
    }

    // Getters públicos
    public static String getAPIPA() {
        return APIPA;
    }

    public String getUsuario() {
        return usuario;
    }

    public String getFecha() {
        int dia = fecha.get(GregorianCalendar.DAY_OF_MONTH);
        int mes = fecha.get(GregorianCalendar.MONTH)+1;
        int anio = fecha.get(GregorianCalendar.YEAR);
        
        
        return "Fecha: " + dia + "/" + mes + "/" + anio;
    }

    public String getIp() {
        return this.ip;
    }

    public String getTexto() {
        return desencripta(this.texto);
    }

    //Compruebo si es valido con regex
    private static boolean esValida(String ip) {
        String regex = "((25[0-5]|2[0-4]\\d|[01]?\\d\\d?)\\.){3}(25[0-5]|2[0-4]\\d|[01]?\\d\\d?)";
        return ip.matches(regex);
    }

    private static String encripta(String msg) {
        String invertida = reverse(msg).toUpperCase(); 
        String resultado = "";

        for (int i = 0; i < invertida.length(); i++) {
            char c = invertida.charAt(i);
            if (c >= 'A' && c <= 'Z') {
                c = (char) ((c - 'A' - 3 + 26) % 26 + 'A');
            }
            resultado += c; 
        }
        return resultado;
}

    private static String desencripta(String msg) {
        String desplazado = "";  
        msg = msg.toUpperCase();
        for (int i = 0; i < msg.length(); i++) {
            char c = msg.charAt(i);
            if (c >= 'A' && c <= 'Z') {
                c = (char) ((c - 'A' + 3) % 26 + 'A');
            }
        desplazado += c;  
        }
    return reverse(desplazado);  
}

    private static String reverse(String cad) {
        String[] palabras = cad.split(" ");
        String resultado = "";  
        
        for (int i = 0; i < palabras.length; i++) {
            String palabraInvertida = ""; 
            
            for (int j = palabras[i].length() - 1; j >= 0; j--) {
                palabraInvertida += palabras[i].charAt(j);  
            }
            resultado += palabraInvertida; 
            if (i < palabras.length - 1) {
                resultado += " ";  
            }
        }
        return resultado;
    }
}
