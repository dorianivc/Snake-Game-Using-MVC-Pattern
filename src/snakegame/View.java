
package snakegame;

import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;
import javafx.beans.InvalidationListener;
import javafx.beans.Observable;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextArea;


public class View extends JFrame {
//--Atributos--//
    private final int ancho=500;
    private final int largo=300;
    private Serpiente snake;
    private Controller controller;
    public JPanel panel1,panel2;
    public JButton[] ButtonBody = new JButton[200];
    public JButton bonusFood;
    public JTextArea textArea;
    public Fruta fruta;
    public int score;
    public Random random= new Random();
    public JMenuBar myBar;
    public JMenu game, help, levels;
    public int LevelConst;
    public void inicializarValores(){
    score=0;
}
    
    public View(Controller controller){
    super("Snake by Dorian Vallecillo");        
    this.controller=controller;
    snake=controller.getSnake();
    fruta= new Fruta();
    setBounds(200,200,506,380);
    createBar();
    inicializarValores();
    //GUI//
    panel1= new JPanel();
    panel2= new JPanel();
// Tabla de puntos
setResizable(false);
textArea= new JTextArea("Score "+ score);
textArea.setEnabled(false);
textArea.setBounds(400,400,100,100);
textArea.setBackground(Color.BLACK);
//comer y crecer
bonusFood= new JButton();
bonusFood.setEnabled(false);

crearPrimeraSerpiente();
panel1.setLayout(null);
panel2.setLayout(new GridLayout(0,1));
panel1.setBounds(0, 0, ancho, largo);
panel1.setBackground(Color.BLACK);
panel2.setBounds(0,largo,ancho,30);
panel2.setBackground(Color.BLACK);

 panel2.add(textArea); // will contain score board
    // end of UI design
    getContentPane().setLayout(null);
    getContentPane().add(panel1);
    getContentPane().add(panel2);
    show();
    setDefaultCloseOperation(EXIT_ON_CLOSE);
    
    }
    

    private void createBar() {
       myBar= new JMenuBar();
       game= new JMenu("Juego");
       JMenuItem newGame= new JMenuItem("New Game");
       JMenuItem salir= new JMenuItem("Salir");
       newGame.addActionListener(e -> reset());
       salir.addActionListener( new ActionListener(){
           @Override
           public void actionPerformed(ActionEvent ae) {
               System.exit(0);
           }
           
       });
       game.add(newGame);
       game.addSeparator();
       game.add(salir);
       
       myBar.add(game);
       levels= new JMenu("Nivel");
       JMenuItem facil= new JMenuItem("Facil");
       facil.addActionListener(new ActionListener(){
           @Override
           public void actionPerformed(ActionEvent ae) {
               LevelConst=0;
           }
           
       });
       JMenuItem medio= new JMenuItem("Medio");
       facil.addActionListener(new ActionListener(){
           @Override
           public void actionPerformed(ActionEvent ae) {
               LevelConst=1;
           }
           
       });
       JMenuItem dificil= new JMenuItem("Dificil");
       facil.addActionListener(new ActionListener(){
           @Override
           public void actionPerformed(ActionEvent ae) {
               LevelConst=3;
           }
          
       });
       levels.add(facil);
       levels.addSeparator();
       levels.add(medio);
       levels.addSeparator();
       levels.add(dificil);
       myBar.add(levels);
       help= new JMenu("Help");
       JMenuItem creador= new JMenuItem("About");
       creador.addActionListener( new ActionListener(){
           @Override
           public void actionPerformed(ActionEvent ae) {
               JOptionPane.showMessageDialog(panel1, "Programado por Dorian Vallecillo Calderon");
           }
           
       });
       help.add(creador);
       myBar.add(help);
       setJMenuBar(myBar);
       
    }

    private void crearPrimeraSerpiente() {
        
       for(int i=0;i<3;i++){
           ButtonBody[i]= new JButton(" "+ i);
           ButtonBody[i].setEnabled(false);
           panel1.add(ButtonBody[i]);
           ButtonBody[i].setBounds(snake.x[i], snake.y[i],10,10);
           snake.x[i+1]=snake.x[i]-10;
           snake.y[i+1]=snake.y[i];
           
       }
    }
    public void reset(){
        //controller.reset();
        inicializarValores();
        panel1.removeAll();
        controller.stopGame();
        crearPrimeraSerpiente();
        
        textArea.setText("Puntos: "+ score);
        controller.startGame();
    }
    public void crecer(){
        ButtonBody[snake.getLength()]= new JButton(" "+ snake.getLength());
        ButtonBody[snake.getLength()].setEnabled(false);
        panel1.add(ButtonBody[snake.getLength()]);
        ButtonBody[snake.getLength()].setBounds(snake.getPaintBody()[snake.getLength()-1].x,snake.getPaintBody()[snake.getLength()-1].y,10,10);
        snake.setLength(snake.getLength()+1);
    }
    public void move(){
        for(int i=0;i<snake.getLength();i++){
            snake.getPaintBody()[i]=ButtonBody[i].getLocation();
            
        }
        snake.x[0]+=snake.getDireccionX();
        snake.y[0]+=snake.getDireccionY();
        ButtonBody[0].setBounds(snake.x[0], snake.y[0],10,10);
        for(int i=1;i<snake.getLength();i++){
            ButtonBody[i].setLocation(snake.getPaintBody()[i-1]);
        }
        
        if(snake.x[0]==ancho){
            controller.stopGame();
        }else if(snake.x[0]==0){
            controller.stopGame();
        }else if(snake.y[0]==largo){
            controller.stopGame();
        }else if(snake.y[0]==0){
           controller.stopGame();
        }
        crearFruta();
        colisisonFruta();
        panel1.repaint();
    }

    private void crearFruta() {
        if(!this.fruta.isFood()){
            panel1.add(bonusFood);
            bonusFood.setBounds((10*random.nextInt(50)),(10*random.nextInt(25)),10,10);
            fruta.setPunto(bonusFood.getLocation());
            fruta.setFood(true);
        }
    }
    private void colisisonFruta() {
       if(fruta.isFood()){
           if(fruta.getPunto().x==snake.x[0]&& fruta.getPunto().y==snake.y[0]){
               panel1.remove(bonusFood);
               score+=1;
               crecer();
               textArea.setText("Score: " + score);
               fruta.setFood(false);
           }
       }
    
    }
    
    
    
    
}
