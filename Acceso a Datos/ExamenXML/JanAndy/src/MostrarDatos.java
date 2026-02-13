/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
import java.io.File;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;

/**
 *
 * @author Andy Jan
 */
public class MostrarDatos {
    public static void main(String[] args) {
        try{ 
            int pHabilidad = 0;
            int pTecnico = 0;
            float hPorCien,tPorCien;
            int total;
            
            
            //El contexto del JAXB
            JAXBContext contexto = JAXBContext.newInstance(Competiciones.Competiciones.class);
            Unmarshaller unmarshall = contexto.createUnmarshaller();
            
            //Volcamos el xml usando el jaxb para crear los objetos
            Competiciones.Competiciones raizCompeticiones = (Competiciones.Competiciones) unmarshall.unmarshal(new File("ContenidoProporcionado/competiciones.xml"));
            
            
            for(Competiciones.TipoCompeticion competicion: raizCompeticiones.getCompeticion()){    
                for(Competiciones.TipoPruebas.Prueba prueba: competicion.getPruebas().getPrueba()){
                   
                    if(prueba.getTipo().equalsIgnoreCase("habilidad")){
                        pHabilidad++;
                    }else{
                        pTecnico++;
                    }                
                }  
            }
            
            total = pHabilidad+pTecnico;
            hPorCien = ((float)100/total)*pHabilidad;
            tPorCien = ((float)100/total)*pTecnico;
            
            System.out.println("Nº de pruebas de habilidad realizadas: "+pHabilidad);
            System.out.println("Nº de pruebas técnicas realizadas: "+pTecnico);
            System.out.println("Pruebas de habilidad " + hPorCien + "% de las totales realizadas.");
            System.out.println("Pruebas técnicas "+tPorCien+ "% de las totales realizadas.");
   
        } catch (JAXBException ex) {
            Logger.getLogger(CrearParticipantes.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
