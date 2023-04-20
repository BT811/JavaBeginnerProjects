import java.util.Scanner;

public class MineSweeper {
    Scanner input = new Scanner(System.in);
    int row;
    int col;
    int mine;
    String[][] board;
    String[][] mineMap;

     MineSweeper(){
     }

    public void run(){System.out.print("Select the number of rows: ");
        this.row= input.nextInt();

        System.out.print("Select the number of columns: ");
        this.col = input.nextInt();

        this.mine = (row*col)/4;

        this.mineMap = new String[row][col];
        createmap();
        select();

    }

    public void createmap(){

        for (int i = 0; i < this.row; i++) {
            for (int j = 0; j < col; j++) {
                this.mineMap[i][j] = "-";
            }
        }

        System.out.println("***************************");


        int i = 0;
        while (i < this.mine){
            int mineRow = (int) ((Math.random()*100)%row);
            int mineCol = (int) ((Math.random()*100)%col);

             if(this.mineMap[mineRow][mineCol] == "-"){
                 this.mineMap[mineRow][mineCol] = "*";
             }else{
                 i--;
             }
             i++;
        }

        for (int k = 0; k < this.row; k++) {
            for (int j = 0; j < col; j++) {
                System.out.print(this.mineMap[k][j] + " ");
            }
            System.out.println();
        }
    }

    public void select(){
         int selectRow;
         int selectCol;
         int notMine = (this.row*this.col)-mine;

         int isWin = 0;

         while (isWin < notMine){
             int count = 0;
             System.out.println("Enter the row number...");
             selectRow = input.nextInt();
             System.out.println("Enter the column number...");
             selectCol = input.nextInt();
             System.out.println("**********************");



             if(this.mineMap[selectRow][selectCol] == "*"){
                 System.out.println();
                 pmap();
                 System.out.println();
                 System.out.println("**** You Lose  ****");
                 break;

             } else if ( this.mineMap[selectRow][selectCol] != "-") {
                 System.out.println("You can't select this location again.");
                 pmap();
             }else{

                 if(selectRow != this.row-1) {
                     if (this.mineMap[selectRow + 1][selectCol] == "*") {
                         count++;
                     }
                 }
                 if(selectCol != this.col-1) {
                     if (this.mineMap[selectRow][selectCol + 1] == "*") {
                         count++;
                     }
                 }
                  if(selectRow != 0) {
                      if (this.mineMap[selectRow - 1][selectCol] == "*") {
                          count++;
                      }
                  }
                  if(selectCol != 0) {
                      if (this.mineMap[selectRow][selectCol - 1] == "*") {
                          count++;
                      }
                  }
                 if(selectRow != this.row-1 && selectCol != this.col-1) {
                     if (this.mineMap[selectRow + 1][selectCol + 1] == "*") {
                         count++;
                     }
                 }
                 if(selectCol != 0 && selectRow != this.row-1) {
                     if (this.mineMap[selectRow + 1][selectCol - 1] == "*") {
                         count++;
                     }
                 }
                 if(selectCol != 0 && selectRow != 0) {
                     if(this.mineMap[selectRow - 1][selectCol - 1] == "*") {
                         count++;
                     }
                 }
                 if(selectRow != 0 && selectCol != this.col-1) {
                     if (this.mineMap[selectRow - 1][selectCol + 1] == "*") {
                         count++;
                     }
                 }
                 this.mineMap[selectRow][selectCol] = String.valueOf(count);
                 isWin++;
                 pmap();
             }

         }

         if(isWin == notMine) System.out.println("You win!!");
    }


    public void pmap(){
        for (int i = 0; i < this.row; i++) {
            for (int j = 0; j <this.col; j++) {
                System.out.print(this.mineMap[i][j] + " ");
            }
            System.out.println();
        }

    }

}
