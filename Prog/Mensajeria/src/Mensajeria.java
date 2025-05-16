/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Jaime Martín
 */
public class Mensajeria {
    public static void main(String[] args){
        int op;
        Cola cola;
        cola = new Cola();
        Mensaje mensaje;
        String usuario, ip, texto, continuar;

        do{
            System.out.println("1. Envío instantáneo.");
            System.out.println("2. Enviar mensaje.");
            System.out.println("3. Recibir mensaje.");
            System.out.println("4. Salir");
            op = Leer.datoInt();
            switch(op){
                case 1:
                    mensaje = new Mensaje();
                    cola.meterEnCola(mensaje);
                    break;
                case 2:
                    System.out.println("Introduce tu nombre de usuario");
                    usuario = Leer.dato();
                    System.out.println("Introduce tu ip");
                    ip = Leer.dato();
                    System.out.println("Introduce el texto");
                    texto = Leer.dato();
                    
                    mensaje = new Mensaje(usuario,ip,texto);
                    cola.meterEnCola(mensaje);
                    break;
                case 3:
                    if(!cola.esColaVacia()){
                        mensaje = (Mensaje)cola.sacarDeCola();
                        System.out.println("Usuario:"+mensaje.getUsuario());
                        System.out.println("Fecha:"+mensaje.getFecha());
                        System.out.println("IP:"+mensaje.getIp());
                        System.out.println("Texto:");
                        System.out.println(mensaje.getTexto());
                    }else{
                        System.out.println("No hay mas mensajes");
                    }

                    break;
                case 4:
                    if(!cola.esColaVacia()){
                        System.out.println("Hay mensajes pendientes de recibir ¿Salir de todas formas? (S/N)");
                        continuar = Leer.dato();
                        if(continuar.equals("S")){
                            
                        }else{
                            op=3;
                        }
                    }   
                    break;
                default:
                    System.out.println("Opción no existe");
                    break;
            }
            
        }while(op != 4);
    }
}
