
package snakegame;

import java.awt.Point;


public class Fruta {
      //---Inicio Atributos--//
    private Point punto;
    private boolean food;
    //---Fin Atributos--//
    
    //Miembros de la clase
    
    public Fruta(){
        punto= new Point();
        
    }

    public Point getPunto() {
        return punto;
    }

    public void setPunto(Point punto) {
        this.punto = punto;
    }

    public boolean isFood() {
        return food;
    }

    public void setFood(boolean food) {
        this.food = food;
    }
    
    
    
}
