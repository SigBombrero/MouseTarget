import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class MouseTarget extends JPanel implements MouseListener
{

  private int xCoord, yCoord;
  private boolean isMouseClicked;

  public MouseTarget () {
	  super();

	  xCoord = 0;
	  yCoord = 0;
	  isMouseClicked = false;
  }


  public void paintComponent(Graphics g)
  {
    super.paintComponent(g);

    int w = getWidth();
    int h = getHeight();

    double ratioX = w / 600.0;
    double ratioY = h / 480.0;

	// TODO Add any custom drawings here

	if (isMouseClicked){
            Font f1 = new Font("Monospaced", Font.BOLD, 20);
	    g.setFont(f1);
	    g.setColor(Color.BLACK);
	    g.drawString("Mouse Pressed at Coordinates " + xCoord + " , " + yCoord, (int)(ratioX * (w / 2 - w / 3)), h / 2);
	}

	g.setColor(Color.RED);
	g.drawOval(xCoord - 10, yCoord - 10, 20, 20);
	g.setColor(Color.RED);
	g.drawLine(xCoord, yCoord - 10, xCoord, yCoord + 10);
	g.setColor(Color.RED);
	g.drawLine(xCoord - 10, yCoord, xCoord + 10, yCoord);



  }

  public void mouseClicked(MouseEvent e) {

  }

  public void mouseEntered(MouseEvent e) {

  }

  public void mouseExited(MouseEvent e) {

  }

  public void mousePressed(MouseEvent e) {

    int b = e.getButton();
    int x = e.getX();
    int y = e.getY();

    if(b == MouseEvent.BUTTON1){
        isMouseClicked = true;
        xCoord = x;
        yCoord = y;
    }
    if (b == MouseEvent.BUTTON3) {
        isMouseClicked = true;
        xCoord = x;
        yCoord = y;
    }
    repaint();
  }

  public void mouseReleased(MouseEvent e) {

  }


  public static void main(String[] args)
  {
    JFrame w = new JFrame("Inheritance Test");
    w.setBounds(100, 100, 600, 480);
    w.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    MouseTarget panel = new MouseTarget();
    panel.setBackground(Color.WHITE);
    w.add(panel);
    w.setResizable(true);
    w.setVisible(true);
    panel.addMouseListener(panel);
  }
}
