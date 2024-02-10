import java.util.Scanner;
import java.util.Stack;

public class Q2 {

    public static void main(String[] args) {
        Scanner kbrd = new Scanner(System.in);
        pair points = new pair();
        int[][] arr = createArray();
        System.out.println("Starting Array: \n");
       display(arr);
//        createArray();
        System.out.println("Where would you like to start?");
        System.out.println("Enter the column: ");
        points.setCol(kbrd.nextInt());
        System.out.println("Enter the Row: ");
        points.setRow(kbrd.nextInt());
        floodfill(points.getRow(), points.getCol(), arr ,points );
        System.out.println("The Array has been filled: ");
        display(arr);
    }

    public static int[][] createArray(){
        int[][] arr = new int[10][10];
        for (int i = 0; i < 10; i++)
        {
            for (int x = 0; x < 10; x++)
            {
                arr[i][x] = 0;
            }
        }
        return arr;
    }

    public static void display(int[][] arr){
        for (int x = 0; x < 10; x++)
        {
            for (int y = 0; y < 10; y++)
            {
                System.out.printf("%4d", arr[x][y]);
            }
            System.out.println();
        }
    }

    public static void floodfill(int row, int column, int[][] arr, pair points){
        Stack<pair> cord = new Stack<>();
        int count = 1;
        cord.push(points);

        while (!cord.isEmpty()){
            pair current = cord.pop();
            int c = current.col;
            int r = current.row;

            if(c>= 0 && c < 10 && r>=0 && r<10 && arr[r][c]==0){
//                if(arr[r][c]==0){
                arr[r][c] = count;
                    count++;


                    //Up

                    if(r-1>=0 && arr[r-1][c] == 0){
                        cord.push(new pair(r-1, c));
//                        current.setRow(r-1);
//                        current.setCol(c);
//                        cord.push(current);
                    }
                    //Right

                    if(c+1<10 && arr[r][c+1] == 0){
//                        current.setRow(r);
//                        current.setCol(c+1);
//
//                        cord.push(current);

                        cord.push(new pair(r, c+1));
                    }
                    //Down

                    if(r+1<10 && arr[r+1][c] == 0){
//                        current.setRow(r+1);
//                        current.setCol(c);
//
//                        cord.push(current);

                        cord.push(new pair(r+1, c));
                    }
                    //Left

                    if(c-1>= 0 && arr[r][c-1] == 0){
//                        current.setRow(r);
//                        current.setCol(c-1);
//
//                        cord.push(current);

                        cord.push(new pair(r, c-1));
                    }
//                }
            }
        }
    }
}
