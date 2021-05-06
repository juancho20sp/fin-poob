package tests;


import static org.junit.Assert.*;

import domain.AutomataCelular;
import domain.excepciones.AutomataExcepcion;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.awt.*;
import java.io.*;

public class AutomataCelularTests {
    private AutomataCelular au;


    @Before
    public void setUp()
    {
        au = new AutomataCelular();
    }

    /**
     * Verifica que una instancia de 'AutomataCelular' sea creada
     * @result Se creó una nueva instancia correctamente
     */
    @Test
    public void shouldCreateNewAutomata(){
        // TicTacs
        for (int i = 0; i < 3; i++) {
            au.ticTac();
        }

        // Opción nuevo
        AutomataCelular au2 = new AutomataCelular();

        // Verificamos que los tableros sean diferentes
        boolean equal = true;


        for (int i = 0; i < au2.getLongitud(); i++){
            for(int j = 0; j < au2.getLongitud(); j++){
                if (!au.getElemento(i,j).equals(au2.getElemento(i,j))){
                  equal = false;
                  break;
                }
            }
        }

        assertFalse(equal);
    }


    /**
     * Verifica que un archivo '.dat' se pueda abrir
     * @result Se abrió el archivo correctamente
     */
    @Test
    public void shouldOpenFile(){
        // Abrimos el archivo
        try{
            ObjectInputStream in = new ObjectInputStream(new FileInputStream("tests/test.dat"));

            AutomataCelular au2 = (AutomataCelular) in.readObject();

            // Verificamos que los objetos sean iguales
            boolean equal = true;


            for (int i = 0; i < au2.getLongitud(); i++){
                for(int j = 0; j < au2.getLongitud(); j++){
                    if (!au.getElemento(i,j).getColor().equals(au2.getElemento(i,j).getColor())){
                        equal = false;
                        break;
                    }
                }
            }

            assertTrue(equal);

            in.close();
        } catch (IOException ex){
            System.out.println(ex.getMessage());
            fail();

        } catch (ClassNotFoundException ex) {
            System.out.println(ex.getMessage());
            fail();
        }
    }

    /**
     * Verifica que se pueda guardar el estado del programa en un archivo '.dat'
     * @result Se abrió el archivo correctamente
     */
    @Test
    public void shouldSaveFile(){
        // Guardamos el estado del juego
        try {
            // Creamos el stream
            ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream("tests/test.dat"));

            // Guardamos el objeto
            out.writeObject(au);

            // Cerramos el stream
            out.close();

        } catch(IOException ex){
            System.out.println(ex.getMessage());
            fail();
        }

        // Abrimos el archivo
        try{
            ObjectInputStream in = new ObjectInputStream(new FileInputStream("tests/test.dat"));

            AutomataCelular au2 = (AutomataCelular) in.readObject();

            // Verificamos que los objetos sean iguales
            boolean equal = true;


            for (int i = 0; i < au2.getLongitud(); i++){
                for(int j = 0; j < au2.getLongitud(); j++){
                    if (!au.getElemento(i,j).getColor().equals(au2.getElemento(i,j).getColor())){
                        equal = false;
                        break;
                    }
                }
            }

            assertTrue(equal);

            in.close();
        } catch (IOException ex){
            System.out.println(ex.getMessage());
            fail();

        } catch (ClassNotFoundException ex) {
            System.out.println(ex.getMessage());
            fail();
        }
    }

    /**
     * Verifica que un archivo '.txt' se pueda abrir
     * @result Se abrió el archivo correctamente
     */
    @Test
    public void shouldImportFile(){
        // Abrimos el archivo
        try {
            BufferedReader bIn = new BufferedReader(new FileReader("tests/test.txt"));

            int lines = 0;
            String line = bIn.readLine();

            while (line != null){
                line = line.trim();

                assertTrue(line.equals("Esta es una prueba"));

                line = bIn.readLine();
            }

        } catch (FileNotFoundException fileNotFoundException) {
            fileNotFoundException.printStackTrace();
            fail();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * Verifica que se pueda exportar el estado del juego a un archivo '.txt'
     * @result Se exportó el archivo correctamente
     */
    @Test
    public void shouldExportFile(){
        // Exportamos el archivo
        try {
            PrintWriter pw = new PrintWriter(new FileOutputStream("tests/test2.txt"));

            for (int f = 0; f < au.getLongitud(); f++){
                for (int c = 0; c < au.getLongitud(); c++){
                    if (au.getElemento(f, c).getColor() != Color.white){
                        pw.println(au.getElemento(f, c).getClass().toString().replace("class ", "") + " " + f + " " + c);
                    }
                }
            }

            pw.close();
        } catch (FileNotFoundException ex){
            fail();
        }

        // Abrimos el archivo
        try {
            BufferedReader bIn = new BufferedReader(new FileReader("tests/test2.txt"));

            int lines = 0;
            String line = bIn.readLine();

            // Verificamos que los datos sean correctos
            boolean equal = true;

            while (line != null){
                line = line.trim();

                lines++;

                line = bIn.readLine();
            }


            assertTrue(lines > 0);

        } catch (FileNotFoundException fileNotFoundException) {
            fileNotFoundException.printStackTrace();
            fail();
        } catch (IOException e) {
            e.printStackTrace();
            fail();
        }
    }


        @After
    public void tearDown()
    {
    }
}
