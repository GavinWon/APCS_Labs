
import java.awt.*;
import javax.swing.*;

public class Target extends JPanel
{
  public void paintComponent(Graphics g)
  {
    super.paintComponent(g);  // Call JPanel's paintComponent method
                              //   to paint the background
    int xCenter = getWidth() / 2;
    int yCenter = getHeight() / 2;
    g.setColor(Color.RED);
    g.fillOval(xCenter - 40 , yCenter - 40 , 100 , 100);
    g.setColor(Color.WHITE);
    g.fillOval(xCenter - 20, yCenter - 20, 60, 60 );
    g.setColor(Color.RED);
    g.fillOval(xCenter, yCenter , 20, 20);
  }

  public static void main(String[] args)
  {
    JFrame window = new JFrame("Target");
    window.setBounds(300, 300, 200, 200);
    window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    Target panel = new Target();
    panel.setBackground(Color.WHITE);
    Container c = window.getContentPane();
    c.add(panel);
    window.setVisible(true);
  }
}
