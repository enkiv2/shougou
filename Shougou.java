import javax.swing.*;
import java.awt.*;
import java.applet.*;
public class Shougou extends Applet
{
    int size;
    Game game;
    boolean going=false;
    public Shougou()
    {
    }
    public void init()
    {
    }
    public void destroy()
    {
    }
    public void paint(Graphics g)
    {
        if (!going)
        {
            going = true;
    JOptionPane.showMessageDialog(null, "Thank you for playing the new strategy game Shougou. Please read the Readme for rules before playing (double click on the document icon in the BlueJ window).");
   size=inputInt("Please input the size of the board.");
    game=new Game(size);
    g.setColor(Color.black);
    g.fillRect(0, 0, 500, 500);
    g.setColor(Color.white);
    for (int i=0; i<size; i++)
        {
        g.drawLine(0, i*(500/size), 500, i*(500/size));
        g.drawLine(i*(500/size), 0, i*(500/size), 500);
        }
    int currPlayer=1;
    int moves=1;
    while (!(game.gameOver()))
        {
        int x=inputInt("Player "+currPlayer+", please input your x-coordinate for move #"+moves);
        int y=inputInt("Player "+currPlayer+", please input your y-coordinate for move #"+moves);
        String temp=game.place(x+1, y+1, currPlayer);
        if (temp.equals("Move OK"))
            {
            Color outColor, inColor;
            if (currPlayer==1)
                {
                outColor=Color.white;
                inColor=Color.black;
                }
            else{
                outColor=Color.black;
                inColor=Color.white;
            }
            g.setColor(inColor);
            g.fillOval((y*(500/size)), (x*(500/size)), ((500/size)), ((500/size)));
            g.setColor(outColor);
            g.drawOval((y*(500/size)), (x*(500/size)), ((500/size)), ((500/size)));
            if (currPlayer==1)
                {
                currPlayer=2;
                }
            else currPlayer=1;
            moves++;
            }
        JOptionPane.showMessageDialog(null,temp);
        }
    JOptionPane.showMessageDialog(null,"Game over. Winner is: "+game.winner());
} else repaint(g);
    }
    public void repaint(Graphics g)
    {
        Color outColor, inColor;
            g.setColor(Color.black);
            g.fillRect(0, 0, 500, 500);
            g.setColor(Color.white);
            for (int i=0; i<size; i++)
            {
                g.drawLine(0, i*(500/size), 500, i*(500/size));
                g.drawLine(i*(500/size), 0, i*(500/size), 500);
        }
        for (int x=0; x<size;x++)
        {
            for (int y=0; y<size; y++)
            {
                if (game.board[x][y]!=0)
                {
                            if (game.board[x][y]==1)
                {
                outColor=Color.white;
                inColor=Color.black;
                }
            else{
                outColor=Color.black;
                inColor=Color.white;
            }
            g.setColor(inColor);
            g.fillOval((y*(500/size)), (x*(500/size)), ((500/size)), ((500/size)));
            g.setColor(outColor);
            g.drawOval((y*(500/size)), (x*(500/size)), ((500/size)), ((500/size)));
        }
    }
}
    }
    public int inputInt(String s)
    {
	try {
	    return (Integer.parseInt(JOptionPane.showInputDialog(null,s)));
	}
	catch (Throwable t)
	    {
		return inputInt(s);
	    }
    }
}
