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
import java.util.Random;
import java.util.Scanner;

/**
 *
 * @author Luz Pinto Castillo
 * @author Sebastian Henriquez Cartagena
 */
public class MicroBasural extends Caracteristicas implements Interfaz {

    public MicroBasural MB=new MicroBasural();
    ArrayList<MicroBasural> Lmb=new ArrayList<MicroBasural>();
    //Zona de prueba ID----------------------------------------------------------------
    Random Azar =new Random();
    int ID;

    public MicroBasural(float Latitud, float Longitud, int NCalle, String Calle) {
        super(Latitud, Longitud, NCalle, Calle);
    }

    public MicroBasural() {
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
    public int getNCalle(){
        return NCalle;
    }


    //Comportamiento
    
    /**
     * 
     * @param Objeto 
     */
    public void Crear(float longitud,float latitud,int Ncalle,String Calle){
        //Crea un objeto de tipo microbasural
        
        MicroBasural nuevoMB=new MicroBasural();

        nuevoMB.Longitud=longitud;
        nuevoMB.Latitud= latitud;
        nuevoMB.Calle= Calle;
        nuevoMB.NCalle= Ncalle;
        nuevoMB.ID=Azar.nextInt(100 + 1)+1;
        Lmb.add(nuevoMB);
        System.out.println("Creado con exito!!");  
        
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
                bfwriter.write(microbasural.getLongitud()+";"+microbasural.getLatitud()+";" +microbasural.getID()+";"+microbasural.getCalle()+";"+microbasural.getNCalle());
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
                    e.setNCalle(delimitar.nextInt());
                    
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
                    bfwriter.write(microbasural.getLongitud()+";"+ microbasural.getLatitud()+";"+microbasural.getID()+";"+microbasural.getCalle()+";"+microbasural.getNCalle());
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
  
    public void MostrarLista(){
        for(int i=0;i<Lmb.size();i++){
            System.out.println("Longitud: "+MB.Longitud);
            System.out.println("Latitud: "+MB.Latitud);
            System.out.println("Calle: "+MB.Calle);
            System.out.println("Numero de Calle: "+MB.NCalle);
        }    
    }
    
    public void BuscarCalle(String calle){
        for(int i=0;i<Lmb.size();i++){
            if(MB.Calle.equals(calle)){
            System.out.println("Longitud: "+MB.Longitud);
            System.out.println("Latitud: "+MB.Latitud);
            System.out.println("Calle: "+MB.Calle);
            System.out.println("Numero de Calle: "+MB.NCalle); 
            }
        }    
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
        
                
        MB.setLongitud(nuevoMB.Longitud);
        MB.setLatitud(nuevoMB.Latitud);
        MB.setCalle(nuevoMB.Calle);
        MB.setNCalle(nuevoMB.NCalle);
        
    }
}
