// This applet displays a message moving horizontally
// across the screen.

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class BannerAlt extends JApplet
  implements ActionListener
{
  private int xPos, yPos, msgID;  // hold the coordinates of the banner

  public void init()
  {
    Container c = getContentPane();
    c.setBackground(Color.WHITE);
    msgID = 1;
    xPos = c.getWidth() / 2 - 30;
    yPos = c.getHeight() / 2;
    Timer clock = new Timer(2000, this);  // fires every 2 seconds
    clock.start();
  }

  // Called automatically after a repaint request
  public void paint(Graphics g)
  {
    super.paint(g);
    g.setColor(Color.BLACK);
    if (msgID == 1) {
    	g.drawString("East or West", xPos, yPos);
    } else if(msgID == -1) {
    	g.drawString("Java is the best", xPos, yPos);
    }
  }

  // Called automatically when the timer fires
  public void actionPerformed(ActionEvent e)
  {
    Container c = getContentPane();
    
    
    xPos = c.getWidth() / 2 - 30;
    yPos = c.getHeight() / 2;
    msgID = -msgID;
    
    repaint();
  }
}


