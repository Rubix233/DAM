
import java.util.LinkedHashMap;
import java.util.Map;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Andy Jan
 */
public class Ud13Act5 {
    public static void main(String[] args){
        Map<String, Integer> miMapa = new LinkedHashMap<String, Integer>();
        String intro;
        
        intro = Leer.dato();
        intro = intro.toLowerCase();
        
        for (int i = 0; i < intro.length() - 1; i++) {
            String par = intro.substring(i, i + 2);

            if (par.matches("[a-z]{2}")) {
                if (miMapa.containsKey(par)) {
                    miMapa.put(par, miMapa.get(par) + 1);
                } else {
                    miMapa.put(par, 1);
                }
            }

        }
        
        for (Map.Entry<String, Integer> par : miMapa.entrySet()){
            System.out.println(par.getKey()+": "+par.getValue());
        }
    }
}
