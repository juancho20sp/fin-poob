package domain.celulas;
import domain.AutomataCelular;

import java.awt.Color;

/**
 * Write a description of class Calefactor cambia de amarillo a rojo.
 */
public class Calefactor implements Elemento
{
    protected char estadoSiguiente;
    protected Color color;
    private AutomataCelular automata;
    private int fila, columna;
    /**
     * Crea un nuevo calefactor
     */
    public Calefactor(AutomataCelular ac,int fila, int columna)
    {
        automata = ac;
        this.fila = fila;
        this.columna = columna;
        automata.setElemento(fila, columna, (Elemento)this);
        color = Color.red;
    }
    
    /**
     * Retorna el color del calefactor
     */
    public Color getColor()
    {
        return color;
    }

    /** 
     * Decide cual va a ser su  siguiente estado 
     */
    public void decida()
    {
        if(color == Color.red)
        {
            color = Color.yellow;
        }
        
        else if(color == Color.yellow){
            color = Color.red;
        }
    }
    
    /**
     * Retorna la forma del calefactor
     */
    public int forma()
    {
        return Elemento.CUADRADA;
    }
    
    /**Retorna si está vivo
     *@return verdadero, si esta vivo; falso, DLC
     */
    public boolean isVivo(){
      return true;
    }
}
