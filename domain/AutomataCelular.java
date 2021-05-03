package domain;
import domain.celulas.CelulaConway;
import domain.celulas.Elemento;
import domain.excepciones.AutomataExcepcion;

import javax.swing.*;
import java.awt.*;
import java.io.*;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.Arrays;

/**
* Clase automata celular conforma el conjunto de todas las celulas
*/
    
public class AutomataCelular implements Serializable{
    static private int LONGITUD=30;
    private Elemento[][] automata;
    
     /**
      * Metodo constructor de la clase automata celular
      * 
     */
    public AutomataCelular() {
        automata = new Elemento[LONGITUD][LONGITUD];
        for (int f = 0; f < LONGITUD; f++){
            for (int c = 0; c < LONGITUD; c++){
                automata[f][c] = null;
            }
        }
        algunosElementos();
    }

    /**
     * Método para abrir un archivo
     */
    public AutomataCelular abra(File archivo) throws IOException, ClassNotFoundException {
        try{
            ObjectInputStream in = new ObjectInputStream(new FileInputStream(archivo.getAbsolutePath()));

            AutomataCelular au = (AutomataCelular) in.readObject();

            in.close();

            return au;
        } catch (IOException ex){
            System.out.println(ex.getMessage());
            throw new IOException(AutomataExcepcion.IO_ERROR);

        } catch (ClassNotFoundException ex) {
            throw new ClassNotFoundException(AutomataExcepcion.CLASS_NOT_FOUND);
        }

    }

    /**
     * Método para abrir un archivo
     */
    public void abra00(File archivo){
        JOptionPane.showMessageDialog(null, AutomataExcepcion.NOT_AVAILABLE);
    }

    /**
     * Método para abrir un archivo
     */
    public AutomataCelular abra01(File archivo) throws IOException {
        try{
            ObjectInputStream in = new ObjectInputStream(new FileInputStream(archivo.getAbsolutePath()));

            AutomataCelular au = (AutomataCelular) in.readObject();

            in.close();

            return au;
        } catch (IOException | ClassNotFoundException ex){
            //throw new IOException(AutomataExcepcion.ERROR_GENERAL);
            System.out.println(ex);
            throw new IOException(ex.getMessage());
        }

    }

    /**
     * Método para guardar un archivo
     */
    public void guarde(File archivo) throws IOException{
        try {
            // Creamos el stream
            ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(archivo.getAbsolutePath()));

            // Guardamos el objeto
            out.writeObject(this);

            // Cerramos el stream
            out.close();

        } catch(IOException ex){
            throw new IOException(AutomataExcepcion.SAVE_ERROR);
        }
    }

    /**
     * Método para guardar un archivo
     */
    public void guarde00(File archivo) {
        JOptionPane.showMessageDialog(null, AutomataExcepcion.NOT_AVAILABLE);
    }

    /**
     * Método para guardar un archivo
     */
    public void guarde01(File archivo) throws IOException{
        try {
            // Creamos el stream
            ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(archivo.getAbsolutePath()));

            // Guardamos el objeto
            out.writeObject(this);

            // Cerramos el stream
            out.close();

        } catch(IOException ex){
            throw new IOException(ex.getMessage());
        }
    }

    /**
     * Método para importar un archivo de texto
     */
    public AutomataCelular importe(File archivo) throws IOException, AutomataExcepcion, ClassNotFoundException, NoSuchMethodException {
        automata = new Elemento[LONGITUD][LONGITUD];
        for (int f = 0; f < LONGITUD; f++){
            for (int c = 0; c < LONGITUD; c++){
                automata[f][c] = null;
            }
        }

        try {
            BufferedReader bIn = new BufferedReader(new FileReader(archivo.getAbsolutePath()));

            int lines = 0;
            String line = bIn.readLine();

            try {
                this.importCell(line);

                lines++;
            } catch (NumberFormatException ex) {
                throw new NumberFormatException(ex.getMessage());
            } catch (AutomataExcepcion ex){
                throw new AutomataExcepcion("Error en la línea " + lines + ":\n" + ex.getMessage());
            } catch(ClassNotFoundException ex){
            throw new ClassNotFoundException(AutomataExcepcion.NAME_ERROR);
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
            throw new NoSuchMethodException(AutomataExcepcion.NAME_ERROR);
        }



            while (line != null){
                line = line.trim();

                // Importamos la célula
                try {
                    this.importCell(line);

                    lines++;
                } catch (NumberFormatException ex) {
                    throw new NumberFormatException(ex.getMessage());
                } catch (AutomataExcepcion ex){
                    throw new AutomataExcepcion("Error en la línea " + lines + ":\n" + ex.getMessage());
                }

                line = bIn.readLine();
            }

            bIn.close();

            return this;
        } catch(FileNotFoundException ex){
            throw new FileNotFoundException(ex.getMessage());
        } catch (IOException e) {
            throw new IOException(e.getMessage());
        }
    }

    /**
     * Método para importar un objeto
     */
    public void importe00(File archivo){
        JOptionPane.showMessageDialog(null, AutomataExcepcion.NOT_AVAILABLE);
    }

    /**
     * Método para importar un archivo de texto
     */
    public AutomataCelular importe01(File archivo) throws IOException, NumberFormatException {
        automata = new Elemento[LONGITUD][LONGITUD];
        for (int f = 0; f < LONGITUD; f++){
            for (int c = 0; c < LONGITUD; c++){
                automata[f][c] = null;
            }
        }

        try {
            BufferedReader bIn = new BufferedReader(new FileReader(archivo.getAbsolutePath()));

            int lines = 0;

            String line = bIn.readLine();
            try {
                //this.importCell(line);
            } catch (NumberFormatException ex) {
                throw new NumberFormatException(ex.getMessage());
            }



            while (line != null){
                line = line.trim();

                // Importamos la célula
                //this.importCell(line);

                line = bIn.readLine();
            }

            bIn.close();

            return this;
        } catch(FileNotFoundException ex){
            throw new FileNotFoundException(ex.getMessage());
        } catch (IOException e) {
            throw new IOException(e.getMessage());
        }

    }

    /**
     * Método para importar un archivo de texto
     */
    public AutomataCelular importe02(File archivo) throws IOException {
        automata = new Elemento[LONGITUD][LONGITUD];
        for (int f = 0; f < LONGITUD; f++){
            for (int c = 0; c < LONGITUD; c++){
                automata[f][c] = null;
            }
        }

        try {
            BufferedReader bIn = new BufferedReader(new FileReader(archivo.getAbsolutePath()));

            int lines = 0;

            String line = bIn.readLine();
            //this.importCell(line);


            while (line != null){
                line = line.trim();

                // Importamos la célula
                //this.importCell(line);

                line = bIn.readLine();
            }

            bIn.close();

            return this;
        } catch(FileNotFoundException ex){
            throw new FileNotFoundException(ex.getMessage());
        } catch (IOException e) {
            throw new IOException(e.getMessage());
        }
    }

    /**
     * Método para importar un archivo de texto
     */
    public AutomataCelular importe03(File archivo) throws IOException, AutomataExcepcion {
        automata = new Elemento[LONGITUD][LONGITUD];
        for (int f = 0; f < LONGITUD; f++){
            for (int c = 0; c < LONGITUD; c++){
                automata[f][c] = null;
            }
        }

        try {
            BufferedReader bIn = new BufferedReader(new FileReader(archivo.getAbsolutePath()));

            int lines = 0;
            String line = bIn.readLine();

            try {
                //this.importCell(line);

                lines++;
            } catch (NumberFormatException ex) {
                throw new NumberFormatException(ex.getMessage());
            //} catch (AutomataExcepcion ex){
                //throw new AutomataExcepcion("Error en la línea " + lines + ":\n" + ex.getMessage());
            }



            while (line != null){
                line = line.trim();

                // Importamos la célula
                try {
                    //this.importCell(line);

                    lines++;
                } catch (NumberFormatException ex) {
                    throw new NumberFormatException(ex.getMessage());
                } //catch (AutomataExcepcion ex){
                    //throw new AutomataExcepcion("Error en la línea " + lines + ":\n" + ex.getMessage());
                //}

                line = bIn.readLine();
            }

            bIn.close();

            return this;
        } catch(FileNotFoundException ex){
            throw new FileNotFoundException(ex.getMessage());
        } catch (IOException e) {
            throw new IOException(e.getMessage());
        }
    }

    /**
     * Método para exportar un objeto
     */
    public void exporte(File archivo) throws FileNotFoundException {
        try {
            PrintWriter pw = new PrintWriter(new FileOutputStream(archivo.getAbsolutePath()));

            for (int f = 0; f < LONGITUD; f++){
                for (int c = 0; c < LONGITUD; c++){
                    if (getElemento(f, c).getColor() != Color.white){
                        pw.println(getElemento(f, c).getClass().toString().replace("class ", "") + " " + f + " " + c);
                    }
                }
            }

            pw.close();
        } catch (FileNotFoundException ex){
            throw new FileNotFoundException(ex.getMessage());
        }
    }

    /**
     * Método para exportar un objeto
     */
    public void exporte00(File archivo){
        JOptionPane.showMessageDialog(null, AutomataExcepcion.NOT_AVAILABLE);
    }

    /**
     * Método para exportar un objeto
     */
    public void exporte01(File archivo) throws FileNotFoundException {
        try {
            PrintWriter pw = new PrintWriter(new FileOutputStream(archivo.getAbsolutePath()));

            for (int f = 0; f < LONGITUD; f++){
                for (int c = 0; c < LONGITUD; c++){
                    if (getElemento(f, c).getColor() != Color.white){
                        pw.println(getElemento(f, c).getClass().toString().replace("class domain.celulas.", "") + " " + f + " " + c);
                    }
                }
            }

            pw.close();
        } catch (FileNotFoundException ex){
            throw new FileNotFoundException(ex.getMessage());
        }
    }

    /**
     * Método para exportar un objeto
     */
    public void exporte02(File archivo) throws FileNotFoundException {
        try {
            PrintWriter pw = new PrintWriter(new FileOutputStream(archivo.getAbsolutePath()));

            for (int f = 0; f < LONGITUD; f++){
                for (int c = 0; c < LONGITUD; c++){
                    if (getElemento(f, c).getColor() != Color.white){
                        pw.println(getElemento(f, c).getClass().toString().replace("class domain.celulas.", "") + " " + f + " " + c);
                    }
                }
            }

            pw.close();
        } catch (FileNotFoundException ex){
            throw new FileNotFoundException(ex.getMessage());
        }
    }

    /**
     * Método para exportar un objeto
     */
    public void exporte03(File archivo) throws FileNotFoundException {
        try {
            PrintWriter pw = new PrintWriter(new FileOutputStream(archivo.getAbsolutePath()));

            for (int f = 0; f < LONGITUD; f++){
                for (int c = 0; c < LONGITUD; c++){
                    if (getElemento(f, c).getColor() != Color.white){
                        pw.println(getElemento(f, c).getClass().toString().replace("class domain.celulas.", "") + " " + f + " " + c);
                    }
                }
            }

            pw.close();
        } catch (FileNotFoundException ex){
            throw new FileNotFoundException(ex.getMessage());
        }
    }



    /**
     * Método para importar una célula
     * @param info Un string con los datos de la célula
     */
    private void importCell(String info) throws NumberFormatException, AutomataExcepcion, ClassNotFoundException, NoSuchMethodException{
        try {
            String[] data = info.split("\\s+");

            String name = data[0];
            int[] pos = new int[]{Integer.parseInt(data[1]), Integer.parseInt(data[2])};


            // Verificamos posición en X
            if (pos[0] < 0 || pos[0] >= LONGITUD){
                throw new AutomataExcepcion(AutomataExcepcion.X_POS_ERROR);
            }

            // Verificamos posición en Y
            if (pos[1] < 0 || pos[1] >= LONGITUD){
                throw new AutomataExcepcion(AutomataExcepcion.Y_POS_ERROR);
            }

            System.out.println(Arrays.toString(data));

            // Creamos la célula a partir del nombre
            Class<?> myClass = Class.forName(name);
            Constructor<?> myConstructor = myClass.getConstructor(AutomataCelular.class, int.class, int.class);
            Object obj = myConstructor.newInstance(new Object[] {this, pos[0], pos[1]});
            automata[pos[0]][pos[1]] = (Elemento)obj;

        } catch (NumberFormatException ex){
            throw new NumberFormatException(AutomataExcepcion.FORMAT_ERROR);
        } catch(ClassNotFoundException ex){
            throw new ClassNotFoundException(AutomataExcepcion.NAME_ERROR);
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
            throw new NoSuchMethodException(AutomataExcepcion.NAME_ERROR);
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }

    }

    /**
     * Método para importar una célula
     * @param info Un string con los datos de la célula
     */
    private void importCell01(String info) throws NumberFormatException, AutomataExcepcion{
        try {
            String[] data = info.split("\\s+");

            String name = data[0];
            int[] pos = new int[]{Integer.parseInt(data[1]), Integer.parseInt(data[2])};


            // Verificamos que el nombre exista
            if (!name.equals("CelulaConway")){
                throw new AutomataExcepcion(AutomataExcepcion.NAME_ERROR);
            }

            // Verificamos posición en X
            if (pos[0] < 0 || pos[0] >= LONGITUD){
                throw new AutomataExcepcion(AutomataExcepcion.X_POS_ERROR);
            }

            // Verificamos posición en Y
            if (pos[1] < 0 || pos[1] >= LONGITUD){
                throw new AutomataExcepcion(AutomataExcepcion.Y_POS_ERROR);
            }

            System.out.println(Arrays.toString(data));

            switch (name){
                case "CelulaConway":
                    automata[pos[0]][pos[1]] = new CelulaConway(this, pos[0], pos[1]);
                    break;
                default:
                    break;
            }
        } catch (NumberFormatException ex){
            throw new NumberFormatException(AutomataExcepcion.FORMAT_ERROR);
        }

    }

    /**
      * Devuelve la logitud de la matriz de elementos
      * @return int longuitud
     */
    public int  getLongitud(){
        return LONGITUD;
    }

    /**
      * Devuleve el elemnto en la posicion indicada
      * @param f fila de la matriz de elementos
      * @param c columna de la matriz de elementos
      * @return Elemento elmento 
     */
    public Elemento getElemento(int f,int c){
        return automata[f][c];
    }

    /**
      * Añade el elemnto en la posicion indicada
      * @param f fila de la matriz de elementos
      * @param c columna de la matriz de elementos
      * @param nueva elemento a añadir
     */
    public void setElemento(int f, int c, Elemento nueva){
        automata[f][c] = nueva;
        checkNull();
    }

    /**
      * Crea los elmentos en el automata celular
      * 
     */
    public void algunosElementos(){
        // CICLO 1
        /*
        CelulaNormal indiana = new CelulaNormal(this, 1, 1);
        CelulaNormal OO7= new CelulaNormal(this, 2, 2);
        */
        
        // CICLO 2
        /*
        CelulaEspecial agamenon = new CelulaEspecial(this, 1, 1);
        CelulaEspecial venus = new CelulaEspecial(this, 2, 2);
        */
        /*
        CelulaEspecial agamenon = new CelulaEspecial(this, 1, 1);
        CelulaEspecial venus = new CelulaEspecial(this, 3, 3);
        */
        
        // CICLO 3
        /*
        Calefactor sureste = new Calefactor(this, 29, 29);
        Calefactor noreste = new Calefactor(this, 0, 29);
        */
        
        // CASO BIPOLAR 1
        /*
        CelulaNormal indiana = new CelulaNormal(this, 0, 1);
        CelulaNormal OO7= new CelulaNormal(this, 0, 0);
        CelulaBipolar pacho = new CelulaBipolar(this, 1, 1);
        CelulaBipolar camilo = new CelulaBipolar(this, 2, 2);
        */
        
        // CASO BIPOLAR 2
        /*
        CelulaNormal indiana = new CelulaNormal(this, 0, 1);
        CelulaBipolar pacho = new CelulaBipolar(this, 1, 1);
        CelulaBipolar camilo = new CelulaBipolar(this, 2, 2);
        */
        
        // CASO ARCOIRIS
        
        /*
        Arcoiris pacho = new Arcoiris(this, 14, 14);
        Arcoiris camilo = new Arcoiris(this, 14, 15);
        Arcoiris camilo2 = new Arcoiris(this, 15, 14);
        Arcoiris pacho2 = new Arcoiris(this, 15, 15);
        */
        
        //
        
        // JUEGO DE LA VIDA
        // // PUNTO 6

        CelulaConway john = new CelulaConway(this, 0, 14);
        CelulaConway horton = new CelulaConway(this, 0, 15);
        
        // // PUNTO 6
        CelulaConway john5 = new CelulaConway(this, 29, 0);
        CelulaConway horton5 = new CelulaConway(this, 29, 1);
        CelulaConway pacho5 = new CelulaConway(this, 28, 0);
        CelulaConway camilo5 = new CelulaConway(this, 28, 1);


        // // PUNTO 7
        CelulaConway john7 = new CelulaConway(this, 28, 14);
        CelulaConway horton7 = new CelulaConway(this, 28, 15);
        CelulaConway pacho7 = new CelulaConway(this, 28, 16);


        // // BARCO
        CelulaConway barco1 = new CelulaConway(this, 1, 1);
        CelulaConway barco2 = new CelulaConway(this, 1, 2);
        CelulaConway barco3 = new CelulaConway(this, 2, 1);
        CelulaConway barco4 = new CelulaConway(this, 2, 3);
        CelulaConway barco5 = new CelulaConway(this, 3, 2);

        // // SAPO
        CelulaConway sapo1 = new CelulaConway(this, 6, 2);
        CelulaConway sapo2 = new CelulaConway(this, 6, 3);
        CelulaConway sapo3 = new CelulaConway(this, 6, 4);
        CelulaConway sapo4 = new CelulaConway(this, 7, 1);
        CelulaConway sapo5 = new CelulaConway(this, 7, 2);
        CelulaConway sapo6 = new CelulaConway(this, 7, 3);
        
        // // PLANEADOR
        CelulaConway plan1 = new CelulaConway(this, 20, 26);
        CelulaConway plan2 = new CelulaConway(this, 20, 27);
        CelulaConway plan3 = new CelulaConway(this, 20, 28);
        CelulaConway plan4 = new CelulaConway(this, 21, 26);
        CelulaConway plan5 = new CelulaConway(this, 22, 27);
        
        // // NAVE LIGERA
        CelulaConway nave1 = new CelulaConway(this, 20, 15);
        CelulaConway nave2 = new CelulaConway(this, 20, 18);
        CelulaConway nave3 = new CelulaConway(this, 21, 14);
        CelulaConway nave4 = new CelulaConway(this, 22, 14);
        CelulaConway nave5 = new CelulaConway(this, 22, 18);
        CelulaConway nave6 = new CelulaConway(this, 23, 14);
        CelulaConway nave7 = new CelulaConway(this, 23, 15);
        CelulaConway nave8 = new CelulaConway(this, 23, 16);
        CelulaConway nave9 = new CelulaConway(this, 23, 17);

        checkNull();
    }
    
    /**
      * Hace el salto de una generacion a otra
      * 
     */
    public void ticTac(){
        for (int f = 0; f < LONGITUD ; f++){
            for (int c = 0; c < LONGITUD ; c++){
                if(automata[f][c] != null)
                {
                    automata[f][c].decida();
                }
            }
        }
    }
    
    /**
      * Revisa si existe una celula conway creada
      * 
     */
    private void checkNull()
    {
        boolean banderaNull = false;
        for (int f = 0; f < LONGITUD; f++)
        {
            for (int c = 0; c < LONGITUD; c++)
            {
                if(automata[f][c] instanceof CelulaConway)
                {
                    banderaNull = true;
                }   
            }
        }
        if(banderaNull)
        {
            for (int f = 0; f < LONGITUD; f++)
            {
                for (int c = 0; c < LONGITUD; c++)
                {
                    if(automata[f][c] == null)
                    {
                        CelulaConway cel = new CelulaConway(this, f, c);
                        cel.setEstado();
                        cel.checkColor();
                    }
                }
            }
        }
    }
}
