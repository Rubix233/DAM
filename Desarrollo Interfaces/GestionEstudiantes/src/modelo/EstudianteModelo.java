/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author DAM2
 */
// TODO: Implementar el modelo siguiendo el patrón Observer
public class EstudianteModelo {
    private List<Estudiante> estudiantes;
    private List<Observer> observers;  // Para notificar cambios
   
    // Métodos CRUD:
    public EstudianteModelo(){
        this.estudiantes = new ArrayList();
    }
    // - agregarEstudiante(Estudiante estudiante)
    public boolean agregarEstudiante(Estudiante estudiante){
        for(Estudiante student: this.estudiantes){
            if(student.getId().equals(estudiante.getId())){
                return false;
            }
        }
        this.estudiantes.add(estudiante);
        return true;
    }
    // - obtenerEstudiantes()
    public List getEstudiantes(){
        return this.estudiantes;
    }
    // - buscarPorNombre(String nombre)
    public String buscarPorNombre(String nombre){
        String listaEstudiantes = "";
        for(Estudiante estudiante : this.estudiantes){
            if(estudiante.getNombre().equals(nombre)){
                listaEstudiantes += "\n---------------------\n";
                listaEstudiantes += estudiante.toString();
                
            }
        }
        return listaEstudiantes;
    }
    // - actualizarEstudiante(int id, Estudiante estudiante)
    public boolean actualizarEstudiante(int id, Estudiante estudiante){
        
        for(Estudiante student: this.estudiantes){
            if(student.getId().equals(id)){
                student.setEstudiante(estudiante.getId(), 
                        estudiante.getNombre(), 
                        estudiante.getApellidos(), 
                        estudiante.getEmail(), 
                        estudiante.getCurso());
            }
            return true;
        }
        return false;
    }
    // - eliminarEstudiante(int id)
   public boolean eliminarEstudiante(int id){
       for(Estudiante student: estudiantes){
            if(student.getId().equals(id)){
                this.estudiantes.remove(student);
            }
            return true;
        }
        return false;
   }
    // Métodos Observer:
    // - addObserver(Observer observer)
    // - notifyObservers()
}

