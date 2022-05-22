/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.microbasuralesapp;

/**
 *
 * @author Luz Pinto Castillo
 * @author Sebastian Henriquez Cartagena
 */
public abstract class Caracteristicas {
    public float Latitud;
    public float Longitud;
    public int NCalle;
    public String Calle;
    public int ID=0000;

    public Caracteristicas(float Latitud, float Longitud, int NCalle, String Calle) {
        this.Latitud = Latitud;
        this.Longitud = Longitud;
        this.NCalle = NCalle;
        this.Calle = Calle;
    }

    public Caracteristicas() {
    }

   

    public void setLatitud(float Latitud) {
        this.Latitud = Latitud;
    }

    public void setLongitud(float Longitud) {
        this.Longitud = Longitud;
    }

    public void setNCalle(int NCalle) {
        this.NCalle = NCalle;
    }

    public void setCalle(String Calle) {
        this.Calle = Calle;
    }

    public void setID(int ID) {
        this.ID = ID;
    }
    
    public abstract int Eliminar(int ID);
            
}