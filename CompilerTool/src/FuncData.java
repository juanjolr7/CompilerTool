
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author franc
 */
public class FuncData {
     
    private HashMap<String,String> parametros = new HashMap<String,String>();//nombre tipo
    private HashMap<String,String> variables = new HashMap<String,String>();//nombre tipo
    List<String> nombresP = new ArrayList<>();
    List<String> tiposP = new ArrayList<>();
    List<String> nombresV = new ArrayList<>();
    List<String> tiposV = new ArrayList<>();
    
    public boolean setParametro(String nombre, String tipo){
        if(parametros.containsKey(nombre)){
           return false; 
        }else{
           parametros.put(nombre, tipo);
        }
        return true;
    }
    public boolean setVariable(String nombre, String tipo){
    
        if(variables.containsKey(nombre)){
           return false; 
        }else{
           variables.put(nombre, tipo);
        }
        return true;
    }
    public String getTParametro(String nombre){
        return parametros.get(nombre);
    }
    public String getTVariable(String nombre){
        return variables.get(nombre);
    }
    public boolean contKParametro(String nombre){
        return parametros.containsKey(nombre);
    }
    public boolean contKVaribale(String nombre){
        return variables.containsKey(nombre);
    }
    public HashMap<String,String> getParametros(){
        return parametros;
    }
    public HashMap<String,String> getVaribles(){
        return variables;
    }
    public void setNombreP(String nombre){
        nombresP.add(nombre);
    }
    public void setTipoP(String tipo){
        tiposP.add(tipo);
    }
    public void setNombresP(List<String> nombres){
        this.nombresP= nombres;
    }
    public void setTiposP(List<String> tipos){
        this.tiposP= tipos;
    }
    public List<String> getNombresP(){
        return this.nombresP;
    }
    public List<String> getTiposP(){
        return this.tiposP;
    }
     public void setNombreV(String nombre){
        nombresV.add(nombre);
    }
    public void setTipoV(String tipo){
        tiposV.add(tipo);
    }
    public void setNombresV(List<String> nombres){
        this.nombresV= nombres;
    }
    public void setTiposV(List<String> tipos){
        this.tiposV= tipos;
    }
    public List<String> getNombresV(){
        return this.nombresV;
    }
    public List<String> getTiposV(){
        return this.tiposV;
    }
}
