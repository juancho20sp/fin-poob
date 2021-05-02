package domain.celulas;
import domain.AutomataCelular;

import java.awt.Color;

/**
 * class Arcoiris cambia de color aleatoriamente.
 */
public class Arcoiris implements Elemento
{
    protected char estadoSiguiente;
    protected Color color;
    private AutomataCelular automata;
    private int fila, columna;
    private Color[] colores;
    
    /**
     * Crea un nuevo arcoiris
     */
    public Arcoiris(AutomataCelular ac,int fila, int columna)
    {
        automata = ac;
        Color[] aux = {Color.yellow , Color.red, Color.green, Color.blue, Color.cyan, Color.magenta, Color.black, Color.gray, Color.orange, Color.pink};
        colores = aux;
        this.fila = fila;
        this.columna = columna;
        automata.setElemento(fila, columna, (Elemento)this);
        color = Color.white;
    }

    /**
     * Decide cual va a ser su  siguiente estado 
     *
     */
    public void decida()
    {
        int aleatorio = (int)(Math.random()*9+0);
        Color aux = (Color)colores[aleatorio];
        color = aux;
    }
    
    /**
     * Retorna el color del arcoiris
     */
    public Color getColor()
    {
        return color;
    }
    
    /**
     * Retorna la forma del arcoiris
     */
    public int forma()
    {
        int aleatorio = (int)(Math.random()*2+1);
        return aleatorio;
    }
    
    /**Retorna si está vivo
     *@return verdadero, si esta vivo; falso, DLC
     */
    public boolean isVivo(){
      return true;
    }
}
