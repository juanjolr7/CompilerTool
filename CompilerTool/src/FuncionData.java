/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author franc
 */
public class FuncionData {
    private int filaInicio;
    private int filaFinal;
    private String nombre;
    private boolean isStatic;
    private String tipoDato;

    public FuncionData(int filaInicio, int filaFinal, String nombre, boolean isStatic, String tipoDato) {
        this.filaInicio = filaInicio;
        this.filaFinal = filaFinal;
        this.nombre = nombre;
        this.isStatic = isStatic;
        this.tipoDato = tipoDato;
    }

    public int getFilaInicio() {
        return filaInicio;
    }

    public int getFilaFinal() {
        return filaFinal;
    }

    public String getNombre() {
        return nombre;
    }

    public boolean isIsStatic() {
        return isStatic;
    }

    public String getTipoDato() {
        return tipoDato;
    }

    public void setFilaInicio(int filaInicio) {
        this.filaInicio = filaInicio;
    }

    public void setFilaFinal(int filaFinal) {
        this.filaFinal = filaFinal;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setIsStatic(boolean isStatic) {
        this.isStatic = isStatic;
    }

    public void setTipoDato(String tipoDato) {
        this.tipoDato = tipoDato;
    }

    @Override
    public String toString() {
        return "FuncionData{" + "filaInicio=" + filaInicio + ", filaFinal=" + filaFinal + ", nombre=" + nombre + ", isStatic=" + isStatic + ", tipoDato=" + tipoDato + '}';
    }
    
}
