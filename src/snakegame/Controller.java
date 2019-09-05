/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package snakegame;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import javax.swing.Timer;

/**
 *
 * @author Monica
 */
class Controller implements KeyListener, ActionListener{
private Serpiente model;
private View vista;
private Timer mainTimer;
public Controller(){
    model= new Serpiente();
    vista= new View(this);
    vista.addKeyListener(this);
    this.mainTimer= new Timer(150,this);
    mainTimer.start();
    
}
    Serpiente getSnake() {
        return model;
    }

    void stopGame() {
        mainTimer.stop();
    }

    void startGame() {
        mainTimer.start();
    }

    @Override
    public void keyTyped(KeyEvent ke) {
       
    }

    

    @Override
    public void actionPerformed(ActionEvent ae) {
      vista.move();
    }

    @Override
    public void keyPressed(KeyEvent ke) {
        model.enMovimiento(ke.getKeyCode());
    }

    @Override
    public void keyReleased(KeyEvent ke) {
        
    }
    void reset(){
        model= null;
        model= new Serpiente();
    }
    
}
