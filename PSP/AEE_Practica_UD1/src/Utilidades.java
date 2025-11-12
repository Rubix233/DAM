
import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author Andy Jan
 */
public class Utilidades {
    static String ficheroErrores = "ficheros\\ERRORES.DAT";   

    public static void main(String args[]){
        //args = new String[]{"E:\\DAM\\PSP\\AEE_Practica_UD1\\ficheros\\fichero1.txt", "E:\\DAM\\PSP\\AEE_Practica_UD1\\ficheros\\fichero3.txt"};
        //args = new String[]{"Administror"};

        if (args.length == 2) {
            checkFile(new File(args[0]), new File(args[1]));
        } else {
            if (args.length == 1) {
                checkUsuario(args[0]);
            } else {
                System.out.println("Parametros incorrectos");
                System.out.println("Dos parametros para comparar archivos o un parametro para comprobar usuario");
            }
        }

    }

    private static void checkFile(File arch1, File arch2) {
        String so = System.getProperty("os.name").toLowerCase();
        Process p;
        File errores = new File(ficheroErrores);
        
        if (arch1.isFile() && arch2.isFile()) {
            try {
                if (so.contains("win")) {
                    p = new ProcessBuilder("C:\\WINDOWS\\system32\\fc.exe", arch1.toString(), arch2.toString()).redirectError(errores).redirectOutput(ProcessBuilder.Redirect.INHERIT).start();
                } else {
                    p = new ProcessBuilder("/usr/bin/diff", arch1.toString(), arch2.toString()).redirectError(errores).redirectOutput(ProcessBuilder.Redirect.INHERIT).start();
                }
                p.waitFor();
            } catch (InterruptedException inter) {
                inter.printStackTrace();
            } catch (IOException io) {
                io.printStackTrace();
            }
        } else {
            System.out.println("Parametros en sillas de ruedas, osea, invalidos.");
        }
    }

    private static void checkUsuario(String usuario) {
        String so = System.getProperty("os.name").toLowerCase();
        File errores = new File(ficheroErrores);
        Process p;
        BufferedReader br;
        String linea;
        boolean existe = false;
        try{
        if (so.contains("win")) {
                    p = new ProcessBuilder("CMD","/C","NET USER "+usuario).redirectError(errores).start();
                    br = new BufferedReader(new InputStreamReader(p.getInputStream()));
                    if((linea = br.readLine()) != null){
                        existe = true;
                    }
                } else {
                    p = new ProcessBuilder("/bin/cat","/etc/passwd").redirectError(errores).start();
                    br = new BufferedReader(new InputStreamReader(p.getInputStream()));
                    while((linea = br.readLine()) != null){
                        if(linea.split(":")[0].equalsIgnoreCase(usuario)){
                            existe = true;
                        }
                    }
                }
                p.waitFor();
                if (existe){
                    System.out.println("Existe");
                } else{
                    System.out.println("No Existe");
                }
                br.close();
        }catch (InterruptedException inter) {
                inter.printStackTrace();
            } catch (IOException io) {
                io.printStackTrace();
            }
        
    }
}
