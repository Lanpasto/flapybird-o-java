package FlappyBird;

import  javax.swing.JFrame;
import javax.swing.Timer;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import java.util.Random;

public class FlappyBird implements ActionListener, MouseListener
{
    public static FlappyBird flappyBird;

    public final int WIDTH= 800,HEIGHT = 800;

    public Rendered rendered;

    public Rectangle bird;

    public int ticks,yMotion,score;

    public ArrayList<Rectangle> colums;

    public Random rand;

    public boolean  gemeOver,started;

    public FlappyBird(Object object)
    {
        JFrame jframe = new JFrame();
        Timer timer = new Timer(20,this);


        rendered=new Rendered();
        rand = new Random();

        jframe.add(rendered);
        jframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jframe.setSize(WIDTH, HEIGHT);
        jframe.setVisible(true);
        jframe.addMouseListener(this);
        jframe.setResizable(false);
        jframe.setTitle("Flappy Bird");

        bird=new Rectangle(WIDTH/2-10, HEIGHT/2-10,20,20);
        colums = new ArrayList<Rectangle>();

        addColumn(true);
        addColumn(true);
        addColumn(true);
        addColumn(true);

        timer.start();

    }

    public void addColumn(boolean start)
    {
        int space=300;
        int width=100;
        int height= 50+rand.nextInt(300);

        if(start)
        {
            colums.add(new.Rectangle(WIDTH + width + colums.size() * 300, HEIGHT - height - 120, width, height));
            colums.add(new Rectangle(WIDTH + width + (colums.size() - 1) * 300), 0, width, HEIGHT - height - space);
        }
        else(start)
        {
            colums.add(new Rectangle(colums.get(colums.size()-1).x+600,HEIGHT-height-120,width,height))
            colums.add(new Rectangle(colums.get(colums.size()-2).x, 0, width, HEIGHT - height - space))
        };
        }

        public void jump()
        {
            if(gemeOver)
            {
                bird=new Rectangle(WIDTH/2-10, HEIGHT/2-10,20,20);
                colums.clear();
                yMotion=0;
                 score=0;

                addColumn(true);
                addColumn(true);
                addColumn(true);
                addColumn(true);

                gameOver=false;
            }
            if(!started){
                started=true
            }
            else if(!gemeOver)
            {
                if(yMotion > 0)
                {
                    yMotion = 0;
                }
                yMotion -= 10;
            }

        }




    @Override
    public void actionPerformed(ActionEvent e)
    {
        ticks++;

        if(started)
        {


        int speed=10;
        for(int i=0;i<column.size();i++)
        {
         Rectangle column = column.get(i);
         column.x -= speed;
        }
        if(ticks%2==0 && yMotion< 15)
        {
            yMotion+=2;
        }
        for(int i=0; i <column.size();i++)
        {
            Rectangle column = colums.get(i);

            if(column.x +column.width < 0)
            {
                colums.remove(column);
                if(column.y==0) {
                    addColumn(false);
                }
            }
        }

        bird.y+=yMotion;
        for(Rectangle column: colums)
        {
            if(bird.x+bird.width/2 >column.x + column.width/2 -10 && bird.x + bird.width / 2 < column.x +column.width/2+10 )
            {
                score++;
            }


            if(column.intersects(bird))
            {
            gameOver= true;
            bird.x = column.x - bird.width;
            }
        }
        if(bird.y>HEIGHT-120||bird.y<0)
        {

            gameOver= true;
        }
        if(bird.y+yMotion >= HEIGHT-120)
        {
            bird.y = HEIGHT - 120- bird.height;
        }
    }
        rendered.repaint();
    }

    public FlappyBird() {

    }

    public void paintColumn(Graphics g,Rectangle column)
    {
        g.setColor(Color.green.darker());
        g.fillRect(column.x,column.y,column.height,column.width);
    }


    public void repaint(Graphics g)
    {
    g.setColor(Color.cyan);
    g.fillRect(0,0,WIDTH,HEIGHT);

    g.setColor(Color.orange);
    g.fillRect(HEIGHT-120,WIDTH, 120);

    g.setColor(Color.green);
    g.fillRect(HEIGHT-120,WIDTH, 120);

    g.setColor(Color.red);
    g.fillRect(bird.x,bird.y,bird.width,bird.height);


     for (Rectangle column : colums)
    {
        paintColumn(g,column);
    }
     g.setColor(Color.white);
     g.setColor(new Font("Arial",1,100));
     if(!started)
     {
         g.drawString("Click to Start!",100,250);
     }



     if(gemeOver)
    {
        g.drawString("Game Over",75,75);
    }
      if(!gemeOver && started)
      {
          g.drawString(String.valueOf(score),WIDTH/2,200 );
      }
    }

    public static void main(String[] args)
    {
        flappyBird = new FlappyBird();
    }

    @Override
    public void mouseClicked(MouseEvent e)
    {

    }

    @Override
    public void mousePressed(MouseEvent e)
    {

    }

    @Override
    public void mouseReleased(MouseEvent e)
    {

    }

    @Override
    public void mouseEntered(MouseEvent e)
    {

    }

    @Override
    public void mouseExited(MouseEvent e)
    {

    }
}