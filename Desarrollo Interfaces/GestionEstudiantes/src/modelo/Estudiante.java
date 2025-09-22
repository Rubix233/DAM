/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;
// TODO: Implementar la clase Estudiante
public class Estudiante {
    // Atributos necesarios: id, nombre, apellidos, email, curso
    private String id = "A0000000B";
    private String nombre = "John";
    private String apellidos = "Doe";
    private String email = "John.Doe@gmail.com";
    private int curso = 1;
   
    // Constructor completo
    public Estudiante(String id,String nombre, String apellidos, String email, int curso){
        this.id = id;
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.email = email;
        this.curso = curso;
    }
    // Getters y setters
    public void setEstudiante(String id,String nombre, String apellidos, String email, int curso){
        this.id = id;
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.email = email;
        this.curso = curso;
    }
   public String getId(){
       return this.id;
   }
   public void setId(String id){
       this.id = id;
   }
   public String getNombre(){
       return this.nombre;
   }
   public void setNombre(String nombre){
       this.nombre = nombre;
   }
   public String getApellidos(){
       return this.apellidos;
   }
   public void setApellidos(String apellidos){
       this.apellidos = apellidos;
   }
   public String getEmail(){
       return this.email;
   }
   public void setEmail(String email){
       this.email = email;
   }
   public int getCurso(){
       return this.curso;
   }
   public void setCurso(int curso){
       this.curso = curso;
   }
       
    // toString() para mostrar información
    @Override
   public String toString(){
       return "ID: " + this.id + 
               "\n Nombre: " + this.nombre + 
               "\n Apellidos: "+this.apellidos+
               "\n Email: "+this.email+
               "\n Curso: "+this.curso+"º";
   }
   
    // equals() y hashCode() para comparaciones
   public boolean equals(Estudiante estudiante){
       return this.id.equals(estudiante.id);
   }
}

