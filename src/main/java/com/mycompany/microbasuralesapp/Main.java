package com.mycompany.microbasuralesapp;

import java.io.File;
import java.io.FileNotFoundException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Scanner;
/**
 *
 * @author Sebastian Henriquez Cartagena
 * @author Luz Pinto Castillo
 */ 
public class Main {
    public static InterfazGrafica menu=new InterfazGrafica();
    
    public static Usuario usuario=new Usuario();
    public static Basurero basurero=new Basurero();
    public static MicroBasural microbasural=new MicroBasural();
    public static Consejo consejo= new Consejo();
    
    /**
     * 
     * @param args
     * @throws ParseException 
     */
    public static void main(String args[]) throws ParseException{
        
        ArrayList<Usuario> Lusuarios=new ArrayList<Usuario>();
        Scanner Entrada;
        int opcion;
        String buffer;
        int bufferInt;
        
        
        do{
            
            System.out.println("1- Usuarios");
            System.out.println("2- Puntos de reciclaje");
            System.out.println("3- Consejos");
            System.out.println("4- Microbasurales");
            System.out.println("5- Salir");
            
            System.out.println("Digite una opcion: ");
            Entrada=new Scanner(System.in);
            opcion=Entrada.nextInt();
            
            switch(opcion){
                case 1:
                    do{
                        Entrada=new Scanner(System.in);
                        opcion=Entrada.nextInt();
                        //Usuario
                        System.out.println("1- Crear Usuario");
                        System.out.println("2- Buscar Usuario");
                        System.out.println("3- Mostrar Lista de Usuarios");
                        System.out.println("4- Actualizar Usuario");
                        System.out.println("5- Eliminar Usuario");
                        switch(opcion){
                            case 1:
                                Lusuarios.add(usuario.CrearUsuario());
                            break;

                            case 2:
                                buffer=Entrada.next();
                                int flag=0;
                                for(int i=0;i<Lusuarios.size();i++){
                                    if(usuario.BuscarUsuario(buffer) != null){
                                        System.out.println("Usuario encontrado");
                                        flag = 1;
                                        break;
                                    }
                                }
                                if(flag == 0){
                                    System.out.println("No se encontro el usuario");
                                }    
                            break;
                                
                            case 3:
                                for(int i=0;i<Lusuarios.size();i++){
                                    usuario.MostrarLista();
                                }
                            break;
                            
                            case 4:
                                buffer = Entrada.next();
                                int fflag1 = 0;
                                for(int i=0;i<Lusuarios.size();i++){
                                    if(buffer.equals(Lusuarios.get(i).usuarios.getID())){
                                        Lusuarios.get(i).usuarios.Actualizar(buffer);
                                        System.out.println("Se actualizo con exito el usuario");
                                        fflag1 = 1;
                                    }
                                }
                                if(fflag1 == 0){
                                    System.out.println("No se pudo modificar el usuario");
                                }
                            break;
                            
                            case 5:
                                buffer= Entrada.next();
                                int Flag = 0;
                                for(int i=0;i<Lusuarios.size();i++){
                                    if(Lusuarios.get(i).usuarios.Eliminar(buffer) == 0){
                                        Lusuarios.remove(i);
                                        System.out.println("Se elimino con exito el usuario");
                                        Flag = 1;
                                    }
                                }
                                if(Flag == 0){
                                    System.out.println("No existe el usuario ingresado");
                                }
                            break;
                        }
                    }while(opcion != 6);
                break;
                
                case 2:
                    do{
                        Entrada=new Scanner(System.in);
                        opcion=Entrada.nextInt();
                        //Puntos de reciclaje
                        System.out.println("1- Crear punto de reciclaje");
                        System.out.println("2- Mostrar datos de punto de reciclaje");
                        System.out.println("3- Buscar punto de reciclaje por calle");
                        System.out.println("4- Buscar punto de reciclaje por tipo");
                        System.out.println("5- Eliminar un punto de reciclaje");
                        
                        switch(opcion){
                            case 1:
                                basurero.InsertarDato();
                            break;
                            
                            case 2:
                                basurero.MostrarLista();
                            break;
                            
                            case 3:
                                buffer=Entrada.next();
                                basurero.BuscarCalle(buffer);
                            break;
                            
                            case 4:
                                
                                bufferInt=Entrada.nextInt();
                                basurero.BuscarTipo(bufferInt);
                            break;
                            
                            case 5:
                                bufferInt=Entrada.nextInt();
                                basurero.Eliminar(bufferInt);
                            break;
                        }
                    }while(opcion != 6);
                break;
                
                case 3:
                    //Consejos
                    Entrada=new Scanner(System.in);
                    opcion=Entrada.nextInt();
                    System.out.println("1- Crear un texto informativo");
                    System.out.println("2- Mostrar lista de Consejos");
                    System.out.println("3- Buscar texto");
                    System.out.println("4- Eliminar consejo");
                    do{
                        switch(opcion){
                            
                            case 1:
                                consejo.Crear(consejo);
                            break;
                            
                            case 2:
                                consejo.MostrarConsejos();
                            break;
                            
                            case 3:
                                buffer=Entrada.next();
                                consejo.BuscarInfo(buffer);
                            break;
                            
                            case 4:
                                bufferInt=Entrada.nextInt();
                                consejo.EliminarInfo(bufferInt);
                            break;
                        }
                    }while(opcion != 5);
                break;
                
                case 4:
                    //Microbasurales
                    do{
                        
                        Entrada=new Scanner(System.in);
                        opcion=Entrada.nextInt();
                        System.out.println("1- Crear zona de Microbasural");
                        System.out.println("2- Mostrar lista de Microbasurales");
                        System.out.println("3- Buscar Microbasural por calle");
                        System.out.println("4- Actualizar una zona de Microbasural");
                        System.out.println("5- Eliminar un Microbasural");
                        switch(opcion){
                            
                            case 1:
                                usuario.LMicroBasurales.add(microbasural.Crear());
                            break;
                            
                            case 2:
                                for(int i=0;i<usuario.LMicroBasurales.size();i++){
                                    microbasural.MostrarLista();
                                }
                            break;
                            
                            case 3:
                                buffer=Entrada.next();
                                int flag = 0;
                                for(int i=0;i<usuario.LMicroBasurales.size();i++){
                                    if(microbasural.BuscarCalle(buffer) != null){
                                        System.out.println("Se encontro un microbasural en esa calle");
                                        flag = 1;
                                    }
                                }
                                if(flag == 0){
                                    System.out.println("No se encontro");
                                }
                                
                            break;
                            
                            case 4:
                                bufferInt= Entrada.nextInt();
                                int fflag = 0;
                                for(int i=0;i<usuario.LMicroBasurales.size();i++){
                                    if(usuario.LMicroBasurales.get(i).MB.getID() == bufferInt){
                                        microbasural.Actualizar(bufferInt);
                                        System.out.println("Se actualizo con exito el microbasural");
                                        fflag = 1;
                                    }
                                }
                                if(fflag == 0){
                                    System.out.println("No se pudo modificar el microbasural");
                                }
                            break;
                            
                            case 5:
                                bufferInt= Entrada.nextInt();
                                int Flag = 0;
                                for(int i=0;i<usuario.LMicroBasurales.size();i++){
                                    if(microbasural.Eliminar(bufferInt) == 0){
                                        usuario.LMicroBasurales.remove(i);
                                        System.out.println("Se elimino con exito el microbasural");
                                        Flag = 1;
                                    }
                                }
                                if(Flag == 0){
                                    System.out.println("No existe el microbasural ingresado");
                                }
                                
                            break;
                        }
                    }while(opcion != 6);
                break;
            }   
        }while(opcion != 5);
    }
 
    /*
    public static void InsertaDatosArchivos() throws FileNotFoundException{
        
        String file = "src/test/java/Usuarios.txt";
        int i = 0;
        
        try{
            File archivo = new File(file);
            System.out.println(archivo.getAbsolutePath());
            try (Scanner scanner = new Scanner(archivo)) {
                while(scanner.hasNext()){
                    String []datos = scanner.next().split(";");
                    System.out.print("Linea "+i+ "Nickname:"+datos[0]);
                    System.out.print("Nombre:"+datos[1]);
                    System.out.print("Correo:"+datos[2]);
                    System.out.print("ID:"+datos[3]);
                    i++;
                }
            }
        }catch (FileNotFoundException e){
        }
    }
    
    public static void DatosMicrobasural() throws FileNotFoundException{
        String file = "src/test/java/Microbasurales.txt";
        int i=0;

        try{
            File archivo=new File(file);
            System.out.println(archivo.getAbsolutePath());
            try (Scanner scanner = new Scanner(archivo)) {
                while(scanner.hasNext()){
                    String []datos=scanner.next().split(";");
                    System.out.print("Linea "+i + " Usuario:"+datos[0]);
                    System.out.print(" ID:"+datos[1]);
                    System.out.print(" Latitud:"+datos[2]);
                    System.out.print(" Longitud:"+datos[3]);
                    System.out.println(" Calle:"+datos[4]);
                    System.out.println(" N°:"+datos[5]);
                    i++;
                }
            }
        }catch (FileNotFoundException e){
        }
    }
    
    public static void DatosBasurarero() throws FileNotFoundException{
        String file = "src/test/java/Basureros.txt";
        int i=0;

        try{
            File archivo=new File(file);
            System.out.println(archivo.getAbsolutePath());
            Scanner scanner = new Scanner(archivo);

            while(scanner.hasNext()){
                String []datos=scanner.next().split(";");
                System.out.print("Linea "+i + " ID:"+datos[0]);
                //La idea es poner un if que defina el tipo, sin embargo por desconocimiento queda estipulado de esta forma
                System.out.println("Los tipos de basurero estan definidos por:");
                System.out.println("Tipo 1:Pilas\n 2:Plastico\n Tipo 3:Papel\n Tipo 4:Vidrio\n Tipo 5 :Organico\n Tipo 6:Metales.");
                System.out.print(" Tipo:"+datos[1]);
                System.out.print(" Latitud:"+datos[2]);
                System.out.print(" Longitud:"+datos[3]);
                System.out.println(" Calle:"+datos[4]);
                System.out.println(" N°:"+datos[5]);
                i++;
            }scanner.close();
        }catch (FileNotFoundException e){
            e.printStackTrace();
        }
    }   
    */
}
