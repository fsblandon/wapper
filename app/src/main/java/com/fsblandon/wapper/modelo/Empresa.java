package com.fsblandon.wapper.modelo;

/**
 * Created by fsblandon on 7/23/16.
 */
public class Empresa {
    private String nombre;
    private int imagen;

    public Empresa(String nombre,int imagen){
        this.setNombre(nombre);
        this.setImagen(imagen);
    }


    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getImagen() {
        return imagen;
    }

    public void setImagen(int imagen) {
        this.imagen = imagen;
    }
}
