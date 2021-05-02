package domain.celulas;
import domain.AutomataCelular;

import java.awt.Color;

/**
 * class celula bipolar ciclo 4
 */
public class CelulaBipolar extends Celula
{
    /**Crea una célula bipolar en la posición (<b>fila,columna</b>) del autómta <b>ac</b>.
     *@param ac automata celular en el que se va a ubicar la nueva célula
     *@param fila fila en el automata celular
     *@param columna columna en el automata celular
     */
    public CelulaBipolar(AutomataCelular ac, int fila, int columna)
    {
        super(ac, fila, columna);
        color = Color.gray;
    }
    
    /**
     * Decide cual va a ser su  siguiente estado 
     */
    @Override
    public void decida(){
        int contIguales = 0;
        int contDiferentes = 0;
        int contMuertos = 0;
        //boolean banderaCasillasMuertas = true;
        int f = getFila();
        int c = getColumna();
        AutomataCelular automata = getAutomata();
        for(int i = f - 1; i <= f + 1; i++)
        {
           for(int j = c - 1; j <= c + 1; j++)
           {
               if(!(i == f && j == c) && automata.getElemento(i,j) != null && automata.getElemento(i,j).getEstado() == Ser.MUERTO)
               {
                   contMuertos ++;
               }
               
               if(!(i == f && j == c)  && automata.getElemento(i,j) != null && automata.getElemento(i,j) instanceof CelulaBipolar && automata.getElemento(i,j).getEstado() != Ser.MUERTO)
               {
                   contIguales ++;
               }
               
               if(!(i == f && j == c) && automata.getElemento(i,j) != null  && !(automata.getElemento(i,j) instanceof CelulaBipolar) && automata.getElemento(i,j).getEstado() != Ser.MUERTO)
               {
                   contDiferentes ++;
               }
           }
        }
        if(contMuertos >= 2)
        {
            estadoSiguiente = Ser.MUERTO;
        }
        
        else if(contIguales > contDiferentes)
        {
            color = Color.magenta;
            estadoSiguiente = Ser.VIVO;
        }
        
        else if(contIguales <= contDiferentes)
        {
            color = Color.cyan;
            estadoSiguiente = Ser.VIVO;
        }
        cambie();
    }
}
