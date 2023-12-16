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
public class Disponible implements IEstado {

    public Disponible() {
    }

    @Override
    public void Disponible(Estado e) throws Exception {
        e.setMensaje("La Bicicleta se encuentra Disponible");
        e.setEstadoActual("Disponible");
        throw new Exception("La Bicicleta se encuentra Disponible");

    }

    @Override
    public void Reservado(Estado e) {
        e.setEstado(new Reservado());
        e.setMensaje("La Bicicleta paso a ser Reservada");
        e.setEstadoActual("Reservado");
    }

    @Override
    public void Alquilado(Estado e) {
        e.setEstado(new Alquilado());
        e.setMensaje("La Bicicleta paso a ser alquilada");
        e.setEstadoActual("Alquilado");
    }

    @Override
    public void Devuelto(Estado e) throws Exception {
        e.setMensaje("La Bicicleta no puede ser devuelta");
        e.setEstadoActual("Devuelto");
        throw new Exception("La Bicicleta no puede ser devuelta");
    }
}
