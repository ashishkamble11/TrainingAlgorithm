public class NQueen
{
    final int N=4;

    void printBoard(int board[][])
    {
        for(int i=0;i<N; i++)
        {
            for(int j=0;j<N; j++)
            {
                System.out.print(board[i][j]+" ");
            }
            System.out.println();
        }
    }

    boolean placeQueen(int board[][], int row, int col)
    {
        int i,j;

            for(i=0; i<col; i++)
            {
                if(board[row][i]==1)
                    return false;
            }

        for(i=row, j=col; i>=0 && j>=0; i--, j--)
        {
            if(board[i][j] == 1)
                return false;
        }

        for(i=row, j=col; j>=0 && i<N; i++, j--)
        {
            if(board[i][j] == 1)
                return false;
        }
        return true;
    }

    boolean tryPlacing(int board[][], int col)
    {
        if(col>=N)
            return true;

        for(int i=0; i<N; i++)
        {
            if(placeQueen(board,i,col))
            {
                board[i][col]=1;
                if(tryPlacing(board,col+1)==true)
                    return true;

                board[i][col]=0;
            }
        }
        return false;
    }

    public static void main(String[] args)
    {
        NQueen queen=new NQueen();

        int board[][] = { { 0, 0, 0, 0 }, { 0, 0, 0, 0 }, { 0, 0, 0, 0 }, { 0, 0, 0, 0 } };

        if (queen.tryPlacing(board, 0) == false) {
            System.out.print("Solution does not exist");
        }

        queen.printBoard(board);
    }
}
