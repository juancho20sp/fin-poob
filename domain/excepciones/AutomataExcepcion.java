package domain.excepciones;

public class AutomataExcepcion extends Exception{
    public static final String NOT_AVAILABLE = "Esta funcionalidad está en construcción";
    public static final String ERROR_GENERAL = "Este es un mensaje de error general";

    /**
     * Método para lanzar excepciones
     * @param msg El téxto que tendrá la excepción
     */
    public AutomataExcepcion(String msg){
        super(msg);
    }
}
