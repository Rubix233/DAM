
import java.lang.management.ManagementFactory;
import java.lang.management.RuntimeMXBean;
import java.util.Map;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Andy Jan
 */
public class AccesoAJVM {
    public static void main(String[] args) throws InterruptedException{
        RuntimeMXBean run = ManagementFactory.getRuntimeMXBean();
        Map<String, String> mapa = run.getSystemProperties();
        
        Thread.sleep(5000);
        String[] info;
        info = run.getName().split("@");
        System.out.println("PID: " + info[0]);
        System.out.println("Equipo: " + info[1]);
        System.out.println("Classpath: " + ManagementFactory.getRuntimeMXBean().getClassPath());
        //System.out.println("BootClasspath: " + ManagementFactory.getRuntimeMXBean().getBootClassPath());
        //System.out.println("Lista de argumentos de entrada: ");
        System.out.println("Lista de propiedades de sistema:");
        for(Map.Entry<String, String> entry : mapa.entrySet()){
            System.out.println(entry.getKey() + " -> " + entry.getValue());
        }
        
        
        
    }
}
