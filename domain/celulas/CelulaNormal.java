package domain.celulas;


import domain.AutomataCelular;

/**
 * class CelulaNormal .
 * presenta la reglas de vida de una celula  normal
 */
public class CelulaNormal extends Celula
{
    /**Crea una célula normal en la posición (<b>fila,columna</b>) del autómta <b>ac</b>.
     *@param ac automata celular en el que se va a ubicar la nueva célula
     *@param fila fila en el automata celular
     *@param columna columna en el automata celula
     */
    public CelulaNormal(AutomataCelular ac, int fila, int columna)
    {
        super(ac, fila, columna);
    }

    
    
    /**
     * Decide cual va a ser su  siguiente estado 
     */
    @Override
    public void decida(){
        if (getEdad() >= 3){
            //System.out.println("Normal");
            estadoSiguiente = Ser.MUERTO;
        }
        cambie();
    }
}
