/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Andy Jan
 */
public class Alumno {

    public int codigo;
    public float nota;
   

    public Alumno() {
    }

    public Alumno(int codigo, float nota) {
        this.nota = nota;
        this.codigo = codigo;
    }

    public float getNota() {
        return this.nota;
    }

    public int getCodigo() {
        return this.codigo;
    }

    public void setNota(float nota) {
        this.nota = nota;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }
}
