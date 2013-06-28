public class Game
{
    public int [][] board;
    int width, height;
    public Game()
	{
	    board=new int[15][15];
	    width=15;
	    height=15;
	}
    public Game(int s)
	{
	    width=s;
	    height=s;
	    board=new int[s][s];
	}
    public String place(int x, int y, int player)
	{
	    try {
	    x--;
	    y--;
	    if (x<width&&y<height)
		{
		    if (board[x][y]==0)
			{
			    if ((board[x-1][y]!=player)&&(board[x+1][y]!=player)&&(board[x][y-1]!=player)&&(board[x][y+1]!=player))
				{
				    if (((board[x-1][y-1]!=0)||(board[x+1][y+1]!=0)||(board[x+1][y-1]!=0)||(board[x-1][y+1]!=0))||((x==width/2)&&(y==height/2)))
					{
					    board[x][y]=player;
					    return "Move OK";
					}
				    else return "You must put your piece diagonal to another piece.";
				}
			    else return "You may not place your piece vertically or horizontally next to another of your pieces.";
			}
		    else return "You may not place your piece on top of another piece.";
		}
		}catch (Throwable t) {board[x][y]=player; return "Move OK";}
	    return "You must place your piece within the confines of the board.";
	}
    public boolean gameOver()
	{
	    boolean over=true;
	    for (int x=0; x<width; x++)
		{
		    for (int y=0; y<height; y++)
			{
			    if (board[x][y]==0) over=false;
			}
		}
	    return over;
	}
    public int winner()
	{
	    int max=0, maxp=0, p=0, curr=0;
	    for (int i=0; i<width; i++)
		{
		    for (int j=0; j<width; j++)
			{
			    if (board[i][j]==board[i+1][j-1])
				{
				    p=board[i][j];
				    boolean brk=false;
				    curr=1;
				    for (int x=i; (x<width)&&(!brk); x++)
					{
					    for (int y=j; (y>=0)&&(!brk); y--)
						{
						    if (board[x][y]==p)
							{
							    curr++;
							}
						    else{
							brk=true;
						    }
						}
					}
				    if (curr>max)
					{
					    max=curr;
					    maxp=p;
					}
				}
			    if (board[i][j]==board[i+1][j+1])
				{
				    p=board[i][j];
				    boolean brk=false;
				    curr=1;
				    for (int x=i; (x<width)&&(!brk); x++)
					{
					    for (int y=j; (y<height)&&(!brk); y++)
						{
						    if (board[x][y]==p)
							{
							    curr++;
							}
						    else{
							brk=true;
						    }
						}
					}
				    if (curr>max)
					{
					    max=curr;
					    maxp=p;
					}
				}
			}
		}
	    return maxp;
	}
}
