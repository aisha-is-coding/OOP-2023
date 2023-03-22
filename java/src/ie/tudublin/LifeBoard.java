package ie.tudublin;

import processing.core.PApplet;

public class LifeBoard {
    boolean[][] board; // store our board on 3d array

    private int size;
    PApplet p;

    float cellWidth;

    public boolean  getCell(int row, int col)
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

    public int countCells(int row, int col)
    {
        int count = 0;
        for(int i = -1; i<=1; i++)
        {
            for (int j = - 1; j<= 1; j++)
            {
                if (!(i == 0) && (j == 0))
                {
                    if(getCell(i, j))
                    {
                        count++;
                    }
                }
            }
        }
        return count;
    }

    public void applyRules()
    {
        for (int row = 0; row < size; row++)
        {
            for (int col = 0; col < size; col++)
            {
                int count = countCells(row, col);
                if (board[row][col]) // if the cell is alive
                {
                    if (count == 2 || count == 3) // 
                }
                else
                {
                    next[row][col] = true;
                }
                // <2> 3 dies 
                // 2-3 survives
                // dead with 3 neighbours come to life
            }
        }
    }
    public LifeBoard(int size, PApplet p) // constructor
    { 
        this.size = size;
        board = new boolean[size][size];
        this.p = p;
        cellWidth = p.width;
    }

    public void randomise()
    {
        for (int row = 0; row<size; row++)
        {
            for (int col = 0; col<size; col++)
            {
                float dice = p.random(0.1f, 1.0f);
                board[row][col] = (dice <= 0.5f);
            }
        }
    }

    public void render()
    {
        p.stroke(255);
        for (int row = 0; row<size; row++)
        {
            for (int col = 0; col<size; col++)
            {
                float x = col * cellWidth;
                float y = row * cellWidth;

                if (board[row][col])
                {
                    p.fill(0, 255, 0);
                }
                else
                {
                    p.noFill();
                }
                p.rect(x, y, cellWidth, cellWidth);
            }
        }
    }

    // getters & setters 
    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }
}
