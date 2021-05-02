package domain.celulas;
import domain.AutomataCelular;

import java.awt.Color;

/**
 * CelulaEspecial correspondiente al ciclo 2.
 */
public class CelulaEspecial extends Celula
{
    /**Crea una célula especial en la posición (<b>fila,columna</b>) del autómta <b>ac</b>.
     *@param ac automata celular en el que se va a ubicar la nueva célula
     *@param fila fila en el automata celular
     *@param columna columna en el automata celular
     */
    public CelulaEspecial(AutomataCelular ac, int fila, int columna)
    {
        super(ac,fila,columna);
        color = Color.green;
    }
    
    /** Decide cual va a ser su  siguiente estado 
     */
    @Override
    public void decida()
    {
       int cont = 0;
       boolean banderaCasillasNull  = true;
       //boolean banderaCasillasMuertas = true;
       int f = getFila();
       int c = getColumna();
       AutomataCelular automata = getAutomata();
       int[] a = {0, 0};
       for(int i = f - 1; i <= f + 1; i++)
       {
           for(int j = c - 1; j <= c + 1; j++)
           {
               if(!(i == f && j == c)  && automata.getElemento(i,j) != null && automata.getElemento(i,j).isVivo())
               {
                   banderaCasillasNull = false;
               }
               
               else if(!(i == f && j == c) && automata.getElemento(i,j) != null  && automata.getElemento(i,j).getEstado() == Ser.MUERTO)
               {
                   cont ++;
               }
               
               if(!(i == f && j == c) && automata.getElemento(i,j) == null)
               {
                    a[0] = i;
                    a[1] = j;
               }
           }
       }
       
       if(cont == 8)
       {
           estadoSiguiente = Ser.MUERTO;
       }
       
       else  if(banderaCasillasNull)
       {
            estadoSiguiente = Ser.VIVO;
            CelulaNormal celula = new CelulaNormal(automata, a[0], a[1]);
            celula.estado = Ser.VIVO;
       }
       cambie();
    }
    
    
}