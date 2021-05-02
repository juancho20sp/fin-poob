package domain.celulas;
import domain.AutomataCelular;

import java.awt.Color;
import java.io.Serializable;

/**
 * Informacion sobre una célula
 * Las celulas conocen el automata en la que viven, la posición en la que están en ese autómata,su edad, su estado actual y el estado que van a tomar en el siguiente instante
 * Todas las células son de color azul
*/
public class Celula extends Ser implements Elemento, Serializable {
    protected char estadoSiguiente;
    protected Color color;
    private AutomataCelular automata;
    private int fila, columna;


    /**
     * Crea una célula en la posición (fila,columna) del autómta <b>ac</b>.Toda nueva célula va a estar viva en
     * el estado siguiente.
    @param ac automata celular en el que se va a ubicar la nueva célula
    @param fila fila en el automata celular
    @param columna columna en el automata celula
    */
    public Celula(AutomataCelular ac, int fila, int columna){
        automata = ac;
        this.fila = fila;
        this.columna = columna;
        estadoSiguiente = Ser.VIVO;
        automata.setElemento(fila, columna, (Elemento)this);	
        color = Color.blue;
    }

    /**Retorna la fila del automata en que se encuentra 
     @return 
    */
    public final int getFila(){
        return fila;
    }

    /**Retorna la columna del automata en que se encuentra
    @return 
    */
    public final int getColumna(){
        return columna;
    }
    
    /**Retorna la columna del automata en que se encuentra
      @return 
     */
    public final AutomataCelular getAutomata(){
        return automata;
    }

    
    /** Retorna el color de  la célula
    @return 
     */
    public final Color getColor(){
        return color;
    }
    
    //NEW
    /** Retorna el estado actual de la célula
       @return char estado 
     */
    public final char getEstado(){
        return this.estado;
    }
    
    /** 
     * Decide cual va a ser su  siguiente estado 
     */
    @Override
    public void decida(){
    }

    /** Actualiza su estado actual considerando lo definido como siguiente estado
     */
    public final void cambie(){
        cumple();
        estado = estadoSiguiente;
    }
}
