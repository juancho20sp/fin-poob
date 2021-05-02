package domain.celulas;
import java.awt.Color;

/**
* Interface Elemento  presenta los metodos que posee un elemento
*/
public interface Elemento{
  int REDONDA = 1;
  int CUADRADA = 2;


  default void decida(){
  };
   
  default void cambie(){
  };
  
  default int forma(){
      return REDONDA;
  }
  
  default Color getColor(){
      return Color.black;
  };
  
  //NEW
  
  default char getEstado(){
      return '+';
  };
  
  default void checkColor(){
  };
  
  default void setEstado(){
  };
  
  default boolean isVivo(){
      return false;
  }
  
}
