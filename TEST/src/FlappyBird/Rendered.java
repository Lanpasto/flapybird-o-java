package FlappyBird;
import java.awt.Graphics;
import javax.swing.JPanel;

import javax.swing.*;
import java.awt.*;

public class Rendered extends JPanel
{
    private static final long serialVersionUID =1L;

    @Override
    protected void paintComponent(Graphics g)
    {
        super.paintComponent(g);

        FlappyBird.flappyBird.repaint(g);
    }
}
