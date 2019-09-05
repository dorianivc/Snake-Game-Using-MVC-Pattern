
package snakegame;

import java.awt.Point;
import java.awt.event.KeyEvent;


public class Serpiente {
    private Point[] paintBody= new Point[300];
    private int length;
    
    private boolean derecha;
    private boolean izquierda;
    private boolean arriba;
    private boolean abajo;
    
    private int direccionX;
    private int direccionY;
    public int[] x= new int[300];
    public int[] y= new int[300];
    
    public Serpiente(){
        arriba=true;
        derecha=true;
        abajo=false;
        izquierda=false;
        direccionX=10;
        direccionY=0;
        length=3;
        y[0]=150;
        x[0]=100;
        
    }
    public void enMovimiento(int step){
        switch(step){
            case KeyEvent.VK_LEFT:
                if(izquierda){
                    direccionX=(-10);
                    direccionY=0;
                    derecha=false;
                    arriba=true;
                    abajo=true;
                }
                break;
            case KeyEvent.VK_UP:
                if(arriba){
                    direccionX=(0);
                    direccionY=-10;
                    abajo=false;
                    izquierda=true;
                    derecha=true;
                }
                break;
            case KeyEvent.VK_DOWN:
                if(abajo){
                    direccionX=0;
                    direccionY=10;
                    arriba=false;
                    derecha=true;
                    izquierda=true;
                }
                break;
            case KeyEvent.VK_RIGHT:
                if(derecha){
                    direccionX=10;
                    direccionY=0;
                    izquierda=false;
                    arriba=true;
                    abajo=true;
                }
                break;
            default: break;
        }
    }

    public Point[] getPaintBody() {
        return paintBody;
    }

    public void setPaintBody(Point[] paintBody) {
        this.paintBody = paintBody;
    }

    public int getLength() {
        return length;
    }

    public void setLength(int length) {
        this.length = length;
    }

    public boolean isDerecha() {
        return derecha;
    }

    public void setDerecha(boolean derecha) {
        this.derecha = derecha;
    }

    public boolean isIzquierda() {
        return izquierda;
    }

    public void setIzquierda(boolean izquierda) {
        this.izquierda = izquierda;
    }

    public boolean isArriba() {
        return arriba;
    }

    public void setArriba(boolean arriba) {
        this.arriba = arriba;
    }

    public boolean isAbajo() {
        return abajo;
    }

    public void setAbajo(boolean abajo) {
        this.abajo = abajo;
    }

    public int getDireccionX() {
        return direccionX;
    }

    public void setDireccionX(int direccionX) {
        this.direccionX = direccionX;
    }

    public int getDireccionY() {
        return direccionY;
    }

    public void setDireccionY(int direccionY) {
        this.direccionY = direccionY;
    }

    public int[] getX() {
        return x;
    }

    public void setX(int[] x) {
        this.x = x;
    }

    public int[] getY() {
        return y;
    }

    public void setY(int[] y) {
        this.y = y;
    }
    
}
