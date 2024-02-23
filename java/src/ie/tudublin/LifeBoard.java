package ie.tudublin;

import processing.core.PApplet;

public class LifeBoard extends PApplet{
    
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

    public LifeBoard() {
        //TODO Auto-generated constructor stub
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


    public void update() {
        next = new boolean[rows][cols];
        
        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < cols; col++) {
                int neighbors = countNeighbors(row, col);
                if (board[row][col] && (neighbors < 2 || neighbors > 3)) {
                    next[row][col] = false;
                } else if (!board[row][col] && neighbors == 3) {
                    next[row][col] = true;
                } else {
                    next[row][col] = board[row][col];
                }
            }
        }
        board = next;
    }
    
    public int countNeighbors(int row, int col) {
        int count = 0;
        for (int i = -1; i <= 1; i++) {
            for (int j = -1; j <= 1; j++) {
                int neighborRow = row + i;
                int neighborCol = col + j;
                if (i == 0 && j == 0) continue;
                if (neighborRow >= 0 && neighborRow < rows && neighborCol >= 0 && neighborCol < cols) {
                    if (board[neighborRow][neighborCol]) {
                        count++;
                    }
                }
            }
        }
        return count;
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
                float x = PApplet.map(col, 0, cols, 0, p.width);
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
