package domain.excepciones;

public class AutomataExcepcion extends Exception{
    public static final String NOT_AVAILABLE = "Esta funcionalidad está en construcción";
    public static final String ERROR_GENERAL = "Este es un mensaje de error general";
    public static final String CLASS_NOT_FOUND = "El archivo que está tratando de abrir no coincide con la clase " +
            "esperada";
    public static final String IO_ERROR = "Error de serialización: \nEl archivo que intenta abrir no corresponde al" +
            " formato esperado (.dat) o fue creado con una versión antigua del programa";
    public static final String SAVE_ERROR = "Ocurrió un error al momento de guardar el archivo, inténtelo nuevamente " +
            "o pongáse en contacto con el programador";
    public static final String FORMAT_ERROR = "El archivo que intenta abrir no tiene el formato adecuado";

    // Minicompilador
    public static final String NAME_ERROR = "La clase no existe";
    public static final String X_POS_ERROR = "El valor de la coordenada en X de la célula está fuera del rango";
    public static final String Y_POS_ERROR = "El valor de la coordenada en Y de la célula está fuera del rango";
    /**
     * Método para lanzar excepciones
     * @param msg El téxto que tendrá la excepción
     */
    public AutomataExcepcion(String msg){
        super(msg);
    }
}
