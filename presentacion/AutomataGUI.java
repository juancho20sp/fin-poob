package presentacion;
import domain.*;
import domain.celulas.Elemento;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.FileAlreadyExistsException;

public class AutomataGUI extends JFrame{  
    public static final int CELDA=21;
    public static final int DIMENSION=CELDA*32;
    
    private JButton botonTicTac;
    private JLabel lFila;
    private JLabel lColumna;
    private JTextField tFila;
    private JTextField tColumna;
    private JPanel panelControl;
    private JPanel panelNueva;
    private JPanel panelBNueva;
    private JButton botonViva;
    private JButton botonLatente;
    private FotoAutomata foto;
    
    private AutomataCelular automata;

    private JMenu menu;
    private JMenuBar menuBar;
    private JMenuItem nuevo;
    private JMenuItem abrir;
    private JMenuItem guardarComo;
    private JMenuItem importar;
    private JMenuItem exportarComo;
    private JMenuItem salir;

    public AutomataGUI() {
        automata = new AutomataCelular();
        prepareElementos();
        prepareAcciones();
    }
    
    private void prepareElementos() {
        setTitle("Automata celular");

        // Menú
        menuBar = new JMenuBar();
        setJMenuBar(menuBar);

        menu = new JMenu("Juego");
        menuBar.add(menu);

        // Ítem
        nuevo = new JMenuItem("Nuevo");
        menu.add(nuevo);

        menu.addSeparator();

        abrir = new JMenuItem("Abrir");
        menu.add(abrir);

        guardarComo = new JMenuItem("Guardar como");
        menu.add(guardarComo);

        importar = new JMenuItem("Importar");
        menu.add(importar);

        exportarComo = new JMenuItem("Exportar como");
        menu.add(exportarComo);

        menu.addSeparator();

        salir = new JMenuItem("Salir");
        menu.add(salir);

        foto=new FotoAutomata(this);
        botonTicTac=new JButton("Tic-tac");
        setLayout(new BorderLayout());
        add(foto,BorderLayout.NORTH);
        add(botonTicTac,BorderLayout.SOUTH);
        setSize(new Dimension(DIMENSION-21,DIMENSION+50));
        setResizable(false);
        setLocationRelativeTo(null);
        foto.repaint();
    }

    private void prepareAcciones(){
        setDefaultCloseOperation(EXIT_ON_CLOSE);       
        botonTicTac.addActionListener(
            new ActionListener()
            {
                public void actionPerformed(ActionEvent e) {
                    botonTicTacAccion();
                }
            }
        );

        nuevo.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                opcionNuevo();
            }
        });

        abrir.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                opcionAbrir();
            }
        });

        guardarComo.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                opcionGuardar();
            }
        });

        importar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                opcionImportar();
            }
        });

        exportarComo.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                opcionExportar();
            }
        });

        salir.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                opcionSalir();
            }
        });
    }

    /**
     * Método para empezar un nuevo autómata
     */
    private void opcionNuevo(){
        automata = new AutomataCelular();
        repaint();
    }

    /**
     * Método para abrir un archivo
     */
    private void opcionAbrir() {
        // JFileChooser
        JFileChooser chooser = new JFileChooser();
        chooser.setDialogTitle("Seleccione un archivo");
        int selected = chooser.showOpenDialog(this);

        switch(selected){
            case JFileChooser.APPROVE_OPTION:
                File file = chooser.getSelectedFile();

                try {
                    automata = automata.abra(file);
                    repaint();

                } catch (IOException ex){
                    JOptionPane.showMessageDialog(null, ex.getMessage());
                }
                break;
            case JFileChooser.ERROR_OPTION:
                JOptionPane.showMessageDialog(null, "Something bad happened");
                break;
            case JFileChooser.CANCEL_OPTION:
                JOptionPane.showMessageDialog(null, "Cancel everything!");
                break;

        }
    }

    /**
     * Método para guardar un archivo
     */
    private void opcionGuardar(){
        // JFileChooser
        JFileChooser chooser = new JFileChooser();
        int selected = chooser.showSaveDialog(this);

        switch(selected){
            case JFileChooser.APPROVE_OPTION:
                File file = chooser.getSelectedFile();

                try {
                    automata.guarde(file);
                } catch (IOException ex){
                    JOptionPane.showMessageDialog(null, ex.getMessage());
                }

                break;
            case JFileChooser.ERROR_OPTION:
                JOptionPane.showMessageDialog(null, "Something bad happened");
                break;
            case JFileChooser.CANCEL_OPTION:
                JOptionPane.showMessageDialog(null, "Cancel everything!");
                break;
        }
    }

    /**
     * Método para exportar un archivo
     */
    private void opcionExportar(){
        // JFileChooser
        JFileChooser chooser = new JFileChooser();
        int selected = chooser.showSaveDialog(this);


        switch(selected){
            case JFileChooser.APPROVE_OPTION:
                File file = chooser.getSelectedFile();
                //System.out.println("\nEsta lógica está en construcción");
                //System.out.println("Saving " + file.getName() + " at " +file.getAbsolutePath());

                try {
                    automata.exporte(file);
                } catch (FileNotFoundException e) {
                    JOptionPane.showMessageDialog(null, e.getMessage());
                }
                break;
            case JFileChooser.ERROR_OPTION:
                JOptionPane.showMessageDialog(null, "Something bad happened");
                break;
            case JFileChooser.CANCEL_OPTION:
                JOptionPane.showMessageDialog(null, "Cancel everything!");
                break;
        }


    }

    /**
     * Método para importar un archivo
     */
    private void opcionImportar(){
        // JFileChooser
        JFileChooser chooser = new JFileChooser();
        chooser.setDialogTitle("Seleccione un archivo");
        int selected = chooser.showOpenDialog(this);

        switch(selected){
            case JFileChooser.APPROVE_OPTION:
                File file = chooser.getSelectedFile();

                try {
                    automata = automata.importe(file);
                    repaint();
                } catch(IOException e){
                    JOptionPane.showMessageDialog(null, e.getMessage());
                }


                break;
            case JFileChooser.ERROR_OPTION:
                JOptionPane.showMessageDialog(null, "Something bad happened");
                break;
            case JFileChooser.CANCEL_OPTION:
                JOptionPane.showMessageDialog(null, "Cancel everything!");
                break;

        }
    }

    /**
     * Método para salir
     */
    private void opcionSalir(){
        System.exit(0);
    }

    private void botonTicTacAccion() {
        automata.ticTac();
        foto.repaint();
    }

    public AutomataCelular getAutomata(){
        return automata;
    }
    
    public static void main(String[] args) {
        AutomataGUI ca = new AutomataGUI();
        ca.setVisible(true);
    }  
}

class FotoAutomata extends JPanel{
    private AutomataGUI gui;

    public FotoAutomata(AutomataGUI gui) {
        this.gui=gui;
        setBackground(Color.white);
        setPreferredSize(new Dimension(gui.DIMENSION, gui.DIMENSION));         
    }


    public void paintComponent(Graphics g){
        AutomataCelular automata=gui.getAutomata();
        super.paintComponent(g);
         
        for (int f=0;f<=automata.getLongitud();f++){
            g.drawLine(f*gui.CELDA,0,f*gui.CELDA,automata.getLongitud()*gui.CELDA);
        }
        for (int c=0;c<=automata.getLongitud();c++){
            g.drawLine(0,c*gui.CELDA,automata.getLongitud()*gui.CELDA,c*gui.CELDA);
        }       
        for (int f=0;f<automata.getLongitud();f++){
            for(int c=0;c<automata.getLongitud();c++){
                if (automata.getElemento(f,c)!=null){
                    g.setColor(automata.getElemento(f,c).getColor());
                    if (automata.getElemento(f,c).forma() == Elemento.CUADRADA){
                        if (automata.getElemento(f,c).isVivo()){
                            g.fillRoundRect(gui.CELDA*c+1,gui.CELDA*f+1,gui.CELDA-2,gui.CELDA-2,2,2);
                        }else{
                            g.drawRoundRect(gui.CELDA*c+1,gui.CELDA*f+1,gui.CELDA-2,gui.CELDA-2,2,2);    

                        }
                    }else {
                        if (automata.getElemento(f,c).isVivo()){
                            g.fillOval(gui.CELDA*c+1,gui.CELDA*f+1,gui.CELDA-2,gui.CELDA-2);
                        } else {
                            g.drawOval(gui.CELDA*c+1,gui.CELDA*f+1,gui.CELDA-2,gui.CELDA-2);
                        }
                    }
                }
            }
        }
    }
}