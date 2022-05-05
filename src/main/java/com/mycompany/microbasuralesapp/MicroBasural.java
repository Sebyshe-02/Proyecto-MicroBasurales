/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.microbasuralesapp;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author Luz Pinto Castillo
 * @author Sebastian Henriquez Cartagena
 */
public class MicroBasural {
    
    public MicroBasural MB=new MicroBasural();
    
    //Atributos
    private float Longitud;
    private float Latitud;
    private int ID;
    private String Calle;
    private int NumeroCalle;
    /**
     * 
     * @param Longitud
     * @param Latitud
     * @param ID
     * @param Calle
     * @param NumeroCalle 
     */
    public MicroBasural(float Longitud, float Latitud, int ID, String Calle, int NumeroCalle) {
        this.Longitud = Longitud;
        this.Latitud = Latitud;
        this.ID = ID;
        this.Calle = Calle;
        this.NumeroCalle = NumeroCalle;
    }
    
    public MicroBasural(){
        
    }

    //Accesores
    
    /**
     * 
     * @return 
     */
    public float getLatitud(){
        return Latitud;
    }
    /**
     * 
     * @return 
     */
    public float getLongitud(){
        return Longitud;
    }
    /**
     * 
     * @return 
     */
    public int getID(){
        return ID;
    }
    /**
     * 
     * @return 
     */
    public String getCalle(){
        return Calle;
    }
    /**
     * 
     * @return 
     */
    public int getNumeroCalle(){
        return NumeroCalle;
    }


    //Mutadores
    
    /**
     * 
     * @param Latitud1 
     */
    public void setLatitud(float Latitud1){
        Latitud = Latitud1;
    }
    /**
     * 
     * @param Longitud1 
     */
    public void setLongitud(float Longitud1){
        Longitud = Longitud1;
    }
    /**
     * 
     * @param ID1 
     */
    public void setID(int ID1){
        ID = ID1;
    }
    /**
     * 
     * @param NumeroCalle1 
     */
    public void setNumeroCalle(int NumeroCalle1){
        NumeroCalle = NumeroCalle1;
    }
    /**
     * 
     * @param Calle1 
     */
    public void setCalle(String Calle1){
        Calle=Calle1;
    }

    //Comportamiento
    
    /**
     * 
     * @param Objeto 
     */
    public MicroBasural Crear(){
        //Crea un objeto de tipo microbasural
        
        MicroBasural nuevoMB=new MicroBasural();
        
        Scanner Entrada=new Scanner(System.in);
        System.out.println("Longitud: ");
        nuevoMB.Longitud= Entrada.nextFloat();
        
        System.out.println("Latitud: ");
        nuevoMB.Latitud= Entrada.nextFloat();
        System.out.println("Calle: ");
        nuevoMB.Calle= Entrada.next();
        System.out.println("NumeroCalle");
        nuevoMB.NumeroCalle= Entrada.nextInt();
        
        System.out.println("Creado con exito!!");  
        return nuevoMB;
        
        //La ID no se agrego al codigo porque genero error. Esta variable se agregara proximamente.
    }
    
    public class OperacionEnArchivo{
        public static void CrearArchivo(ArrayList LMicroBasurales){
        FileWriter flwriter=null;
        try{
            //Se usa para escribir en el archivo
            flwriter=new FileWriter("C:\\Users\\Luz\\Desktop\\MicroBasuralesApp\\src\\test\\java\\Microbasurales.txt");
            //creacion de buffer
            BufferedWriter bfwriter=new BufferedWriter(flwriter);
            for(MicroBasural microbasural :(ArrayList<MicroBasural>)LMicroBasurales){
                //escribe los datos en archivo
                bfwriter.write(microbasural.getLongitud()+";"+microbasural.getLatitud()+";" +microbasural.getID()+";"+microbasural.getCalle()+";"+microbasural.getNumeroCalle());
            }
            //cierra el buffer
            bfwriter.close();
            System.out.println("Archivo Creado :)");
        }catch(IOException e){
            e.printStackTrace();
        }finally{
            if(flwriter!=null){
                try{
                    flwriter.close();
                }catch(IOException e){
                    e.printStackTrace();
                }
            }
        }
    }
        public static ArrayList leerArchivo() {
            // crea el flujo para leer desde el archivo
            File file = new File("C:\\Users\\Luz\\Desktop\\MicroBasuralesApp\\src\\test\\java\\Microbasurales.txt");
            ArrayList LMicroBasural= new ArrayList<>();
            Scanner scanner;
            try {
                //se pasa el buffer al objeto scanner
                scanner = new Scanner(file);
                while (scanner.hasNextLine()) {
                    // el objeto scanner lee linea a linea desde el archivo
                    String linea = scanner.nextLine();
                    Scanner delimitar = new Scanner(linea);
                    //se usa una expresión regular
                    //que valida que antes o despues de una punto y coma (;) exista cualquier cosa
                    //parte la cadena recibida cada vez que encuentre una coma
                    delimitar.useDelimiter("|\\s*;|\\s*");
                    MicroBasural e= new MicroBasural();
                    e.setLongitud(delimitar.nextFloat());
                    e.setLatitud(delimitar.nextFloat());
                    e.setID(delimitar.nextInt());
                    e.setCalle(delimitar.next());
                    e.setNumeroCalle(delimitar.nextInt());
                    
                    LMicroBasural.add(e);
                }
                //se cierra el ojeto scanner
                scanner.close();
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }
            return LMicroBasural;
        }
        public static void aniadirDatosArchivo(ArrayList LMicroBasural) {
            FileWriter flwriter = null;
            try {//además de la ruta del archivo recibe un parámetro de tipo boolean, que le indican que se va añadir más registros 
                flwriter = new FileWriter("C:\\Users\\Luz\\Desktop\\MicroBasuralesApp\\src\\test\\java\\Microbasural.txt", true);
                BufferedWriter bfwriter = new BufferedWriter(flwriter);
                for(MicroBasural microbasural :(ArrayList<MicroBasural>)LMicroBasural) {
                    //escribe los datos en el archivo
                    bfwriter.write(microbasural.getLongitud()+";"+ microbasural.getLatitud()+";"+microbasural.getID()+";"+microbasural.getCalle()+";"+microbasural.getNumeroCalle());
                }
                bfwriter.close();
                System.out.println("Archivo modificado ;)");

            } catch (IOException e) {
                e.printStackTrace();
            } finally {
                if (flwriter != null) {
                    try {
                        flwriter.close();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }
        }             
    }
    
    public void MostrarListaMicrobasurales(){
      
        System.out.println("Longitud: "+MB.Longitud);
        System.out.println("Latitud: "+MB.Latitud);
        System.out.println("Calle: "+MB.Calle);
        System.out.println("Numero de Calle: "+MB.NumeroCalle);
    }
    
    public MicroBasural BuscarCalle(String calle){
            
        if(MB.Calle.equals(calle)){
            System.out.println("Longitud: "+MB.Longitud);
            System.out.println("Latitud: "+MB.Latitud);
            System.out.println("Calle: "+MB.Calle);
            System.out.println("Numero de Calle: "+MB.NumeroCalle);
            return MB;    
        }
        return null;
    }
    
    public int Eliminar(int ID){
        
        if(MB.ID == ID){
            MB=null;
            return 0;
        }
        return 1;
    }

    public void Actualizar(int ID){
        
        MicroBasural nuevoMB=new MicroBasural();
        
        Scanner Entrada=new Scanner(System.in);
        System.out.println("Longitud: ");
        nuevoMB.Longitud= Entrada.nextFloat();
        
        System.out.println("Latitud: ");
        nuevoMB.Latitud= Entrada.nextFloat();
        System.out.println("Calle: ");
        nuevoMB.Calle= Entrada.next();
        System.out.println("NumeroCalle");
        nuevoMB.NumeroCalle= Entrada.nextInt();
        
        MB.setLongitud(nuevoMB.Longitud);
        MB.setLatitud(nuevoMB.Latitud);
        MB.setCalle(nuevoMB.Calle);
        MB.setNumeroCalle(nuevoMB.NumeroCalle);
        
    }
}
