package domain.celulas;
import domain.AutomataCelular;

import java.awt.Color;
import java.io.Serializable;

/**
 * Write a description of class CelulaConway here.
 */
public class CelulaConway extends Celula
{
    /**Crea una célula conway en la posición (<b>fila,columna</b>) del autómta <b>ac</b>.
     *@param ac automata celular en el que se va a ubicar la nueva célula
     *@param fila fila en el automata celular
     *@param columna columna en el automata celula
     */
    public CelulaConway(AutomataCelular ac, int fila, int columna)
    {
        super(ac, fila, columna);
        estado = Ser.VIVO;
        checkColor();
    }
    
    /**
     * Decide cual va a ser su  siguiente estado 
     */
    public void decida()
    {
       int f = getFila();
       int c = getColumna();
       AutomataCelular automata = getAutomata();
       int contador = 0;
       for(int i = f - 1; i <= f + 1; i++)
       {
           for(int j = c - 1; j <= c + 1; j++)
           {
               if(i >= 0 && i <= 29 && j >= 0 && j <= 29)
               {
                   if(!(i == f && j == c)&& automata.getElemento(i,j).isVivo())
                   {
                       contador ++;
                   }
               }
           }
       }
       
       if((this.getEstado() == Ser.MUERTO || this.getEstado() == Ser.DESCONOCIDO)  && contador == 3)
       {
           estadoSiguiente = Ser.VIVO;
       }
       if(this.getEstado() == Ser.VIVO &&  (2 == contador || contador == 3))
       {
           estadoSiguiente = Ser.VIVO;
       }
       if(this.getEstado() == Ser.VIVO && contador < 2 || 3 < contador)
       {
           estadoSiguiente = Ser.MUERTO;
       }
       if ((contador <= 2 || 3 < contador) && this.getEstado() == Ser.DESCONOCIDO)
       {
           estadoSiguiente = Ser.DESCONOCIDO;
       }
       
       if(f == 29 && c == 29)
       {
           cambieAux();
       }
    }
    
    /**
     * Verifica el color que debe de tener la celula dependiendod e su estado.
     */
    public void checkColor()
    {
        if(this.getEstado() == Ser.VIVO)
        {
            color = Color.blue;
        }
        else if(this.getEstado() == Ser.DESCONOCIDO)
        {
            color = Color.white;
        }
    }
    
    /**
     * Asigna como estado desconocido a la celula.
     */
    public void setEstado()
    {
        estado = Ser.DESCONOCIDO;
    }
    
    /**
     * Hace el cambie de todas las células conway del automata celular.
     */
    private void cambieAux()
    {
        int len = getAutomata().getLongitud();
        AutomataCelular automata = getAutomata();
        for (int f = 0; f < len; f++)
        {
            for (int c = 0; c < len; c++)
            {
                 automata.getElemento(f,c).cambie();
                 automata.getElemento(f,c).checkColor();
            }
        }
    }
}
