package domain.celulas;

/**
 * clase abstrac presenta las acracteristicas de un Ser
 */
public abstract class Ser{
    public final static char DESCONOCIDO = 'd', VIVO='v', MUERTO='m';
    protected char estado;
    private int edad;

    /**Crea un nuevo ser
     * 
     */
    public Ser(){
        estado = DESCONOCIDO;
        edad = 1;
    }

    /**El ser cumple un lapso de vida
     * 
     */
    protected void cumple(){
        edad++;
    }    
    
    /**Retorna la edad del ser
     @return 
     */   
    public final int getEdad(){
        return edad;
    }    

    /**Retorna si está vivo
    @return verdadero, si esta vivo; falso, DLC
     */
    public final boolean isVivo(){
        return (estado == Ser.VIVO) ;
    }
    
}
