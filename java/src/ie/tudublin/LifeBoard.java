package ie.tudublin;

import java.util.Map;

import processing.core.PApplet;

public class LifeBoard {
    
    boolean[][] board;
    boolean[][] next;

    int rows;
    int cols;

    float cellWidth;
    float cellHeight;
    PApplet p;

    public LifeBoard(int rows, int cols, PApplet p)
    {
        this.rows = rows;
        this.cols = cols;
        this.p = p; 
        board = new boolean[rows][cols];
        cellWidth = p.width / (float) cols;
        cellHeight = p.height / (float) rows;
        
    }



    void randomize()
    {
        for(int row = 0 ; row < rows ; row ++)
        {
            for(int col = 0 ; col < cols ; col ++)
            {
                float dice = p.random(1.0f);
                board[row][col] = (dice < 0.5f);                
            }
        }
    }


    public void update()
    {
        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < cols; col++) {
                int aliveNeighbors = countAliveNeighbors(row, col);
                
                //rules of the game
                if (board[row][col]) {
                    //If the cell is alive:
                    if (aliveNeighbors < 2 || aliveNeighbors > 3) {
                        // Loneliness or overcrowding
                        next[row][col] = false; // the cell dies
                    } else {
                        // else the cell survives
                        next[row][col] = true;
                    }
                } else {
                    // If the cell is dead
                    if (aliveNeighbors == 3) {
                        // the cell comes to life
                        next[row][col] = true;
                    } else {
                        next[row][col] = false;
                    }
                }
            }
        }

         // Swap board
         boolean[][] temp = board;
         board = next;
         next = temp;
     }

    public void setCell(int row, int col, boolean value)
    {
        if (row > 0 && col > 0 && row < rows && col < cols)
        {
            board[row][col] = value;
        }
    }

    public boolean getCell(int row, int col)
    {
        if (row > 0 && col > 0 && row < rows && col < cols)
        {
            return board[row][col];
        }
        return false;
    }

    public int countCells(int row, int col)
    {
        return 0;
    }

    public void render()
    {
        for(int row = 0 ; row < rows ; row ++)
        {
            for(int col = 0 ; col < cols ; col ++)
            {
                float x = p.map(col, 0, cols, 0, p.width);
                float y = row * cellHeight;
                p.stroke(200,255, 255);
                if (board[row][col])
                {
                    p.fill(100, 255, 255);
                }
                else
                {
                    p.noFill();
                }
                p.rect(x, y, cellWidth, cellHeight);
            }
        }
        
    }



}
