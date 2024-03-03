package ie.tudublin;

import processing.core.PApplet;

<<<<<<< HEAD
public class LifeBoard extends PApplet{
    
=======
public class LifeBoard {
>>>>>>> bf7090454cd3074c638cd2dad6eb9b99b7b2023c
    boolean[][] board;
    boolean[][] next;
    int size;
    float cellSize;
    PApplet pa;

    public LifeBoard(int size, PApplet pa)
    {
        board = new boolean[size][size];
        next = new boolean[size][size];
        this.size = size;
        this.pa = pa;
        cellSize = pa.width / (float) size;
    }

<<<<<<< HEAD
    public LifeBoard() {
        //TODO Auto-generated constructor stub
    }

    void randomize()
=======
    public void randomise()
>>>>>>> bf7090454cd3074c638cd2dad6eb9b99b7b2023c
    {
        for(int row = 0 ; row < size ; row ++)
        {
            for(int col = 0 ; col < size ; col ++)
            {
                board[row][col] = pa.random(1.0f) > 0.5f;
            }
        }
    }

<<<<<<< HEAD

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
=======
    public void update()
    {
        // If cell is alive
        // 2 -3 - Survives
        // if a dead cell has 3 neighbours - comes to life

        for(int row = 0 ; row < size ; row ++)
        {
            for (int col = 0 ; col < size ; col ++)
            {
                int count = countCellsAround(row, col);

                if (isAlive(row, col))
                {
                    if (count == 2 || count == 3)
                    {
                        next[row][col] = true;
                    }
                    else
                    {
                        next[row][col] = false;
                    }
                }
                else
                {
                    if (count == 3)
                    {
                        next[row][col] = true;
                    }
                    else
                    {
                        next[row][col] = false;
>>>>>>> bf7090454cd3074c638cd2dad6eb9b99b7b2023c
                    }
                }
            }
        }
<<<<<<< HEAD
        return count;
=======

        boolean[][] temp;
        temp = board;
        board = next;
        next = temp;
>>>>>>> bf7090454cd3074c638cd2dad6eb9b99b7b2023c
    }

    public int countCellsAround(int row, int col)
    {
        int count = 0;

        // Your bit goes here!

        for(int i = row - 1 ; i <= row + 1 ; i ++)
        {
            for(int j = col -1 ; j <= col + 1; j ++)
            {
                if (! (i == row && j == col))
                {
                    if (isAlive(i, j))
                    {
                        count ++;
                    }
                }
            }
        }

        return count;
    }

    public void setAlive(int row, int col, boolean alive)
    {
        if (row >= 0 && row < size && col >= 0 && col < size)
        {
            board[row][col] = alive;
        }
    }

    public boolean isAlive(int row, int col)
    {
        if (row >= 0 && row < size && col >= 0 && col < size)
        {
            return board[row][col]; 
        }
        else
        {
            return false;
        }
    }

    public void render()
    {
        pa.background(0);
        for(int row = 0 ; row < size ; row ++)
        {
            for(int col = 0 ; col < size ; col ++)
            {
<<<<<<< HEAD
                float x = PApplet.map(col, 0, cols, 0, p.width);
                float y = row * cellHeight;
                p.stroke(200,255, 255);
=======
                float x = PApplet.map(col, 0, size, 0, pa.width);
                float y = PApplet.map(row, 0, size, 0, pa.height);
                x = cellSize * col;
                y = cellSize * row;

>>>>>>> bf7090454cd3074c638cd2dad6eb9b99b7b2023c
                if (board[row][col])
                {
                    pa.fill(0, 255, 0);
                }
                else
                {
                    pa.noFill();
                }
                pa.rect(x, y, cellSize, cellSize);
            }
        }
        
    }
<<<<<<< HEAD

=======
>>>>>>> bf7090454cd3074c638cd2dad6eb9b99b7b2023c
}
