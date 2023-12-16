/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Negocio.Estado;

/**
 *
 * @author steph
 */
public class Estado {
    
    protected IEstado estado;
    
    public static String alquilado = "Alquilado";
    public static String devuelto = "Devuelto";
    public static String disponible = "Disponible";
    public static String reservado = "Reservado";
    
    public String estadoActual = "";
    public String mensaje = "";
    //constructores
    public Estado() {
        this.setEstado(new Disponible());
        this.setMensaje("La Bicicleta paso a estar disponible");
        this.setEstadoActual("Disponible");
    }
    
    public Estado(IEstado estado) {
        this.estado = estado;        
    }

    public Estado(String estadoactual, IEstado estado) {
        this.estado = estado;
        this.estadoActual = estadoactual;
    }
    
    //iniciar con un estado
    public void setDisponible(){
        this.setEstado(new Disponible());
    }
    
    public void setReservado(){
        this.setEstado(new Reservado());
    }
    
    public void setAlquilado(){
        this.setEstado(new Alquilado());
    }
    
    public void setDevuelto(){
        this.setEstado(new Devuelto());
    }
    //siguiente
    public void nextDisponible() throws Exception{
        estado.Disponible(this);
    }
    
    public void nextReservado() throws Exception{
        estado.Reservado(this);
    }
    
    public void nextAlquilado() throws Exception{
        estado.Alquilado(this);
    }
    
    public void nextDevuelto() throws Exception{
        estado.Devuelto(this);
    }
    //metodo select 
    public void updateEstado(String resEst) throws Exception{                
        if (Estado.disponible.equals(resEst)) {
            this.setDisponible(); 
        } else if (Estado.reservado.equals(resEst)) {
            this.setReservado(); 
        } else if (Estado.alquilado.equals(resEst)) {
            this.setAlquilado(); 
        } else if (Estado.devuelto.equals(resEst)) {
            this.setDevuelto();
        } else {
            throw new Exception("Error NBicicleta modificar updateEstado: no se encontro estado");
        }
    }
    
    public void nextEstado(String est) throws Exception{
        
        if (Estado.disponible.equals(est)) {
            this.nextDisponible();
        } else if (Estado.reservado.equals(est)) {
            this.nextReservado(); 
        } else if (Estado.alquilado.equals(est)) {
            this.nextAlquilado(); 
        } else if (Estado.devuelto.equals(est)) {
            this.nextDevuelto();
        } else {
            throw new Exception("Error NBicicleta modificar nextEstado: no se encontro estado");
        }
    }
    
    //otro metodos
    public void setEstado(IEstado estado) {
        this.estado = estado;
    }
    
    public void setEstadoActual(String estadoActual) {
        this.estadoActual = estadoActual;
    }

    public String getEstadoActual() {
        return estadoActual;
    }

    public void setMensaje(String mensaje) {
        this.mensaje = mensaje;
    }

    public IEstado getEstado() {
        return estado;
    }

    public String getMensaje() {
        return mensaje;
    }
    
}
