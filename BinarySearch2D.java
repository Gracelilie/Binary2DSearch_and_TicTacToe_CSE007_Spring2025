import java.util.Scanner;

/**
 * @since 04/10/2025
 * @author Grace-lilie Acheampong
 * @descr The following program searches for a target value in a 2D sorted array using a binary search approach.
 *
 * CSE 007 HomeWork 5
 * Version java 11 / IDE: VSCode
 */
public class BinarySearch2D {
    public static void main(String[] args) {
        Scanner scnr = new Scanner(System.in);
        boolean valid = true;
        int key = 0;

        //matric which wil be searched
        int[][] matrix = {
                        {2, 4, 6, 8},
                        {12, 14, 16, 18},
                        {20, 22, 24, 26},
                        {28, 30, 32, 34}
        };
         //Invoking function to display array
         displayMatrix(matrix);
                  
         //Validating user's key input
         do{
            valid = true;
            System.out.println("Enter a value to be searched for in matrix: ");

             if(scnr.hasNextInt()){
                 key = scnr.nextInt();
                 valid = false;
             }
             else{
                 System.out.println("Sorry your input must be an integer");
                 scnr.nextLine();
             }
         } while(valid);
 
         // check if the value exists in the matrix.
         boolean validKey = searchMatrix(matrix , key);
         if (validKey){
             System.out.print("Value found in the matrix.");
         }
         else{
             System.out.print("Value not found in the matrix.");
         }

         scnr.close();
     }

     /**
      * Displays a 2D array with every row on a new line.
      * @param matrix The 2D integer array to display.
      * @return None
      */
     public static void displayMatrix(int[][]matrix){
        //using a for-each loop
         for(int[] row :matrix){
             for (int col: row){           
                 System.out.print(col +" ");
             }
             System.out.println();
         }
     }

      /**
      * Performs binary search on provided sorted 2D array.
      * @param matrix The 2D integer array to be searched.
      * @param target The key to be found.
      * @return returns true if key is found, and false otherwise.
      */
     public static boolean searchMatrix(int[][]matrix, int target){
        // flattening the array to 1D array before search
        int row = matrix.length;
        int column = matrix[0].length;
        int low = 0;
        int high = row * column - 1;
        
        int rows = 0;
        int columns = 0; 
        int value= 0;
        
        while(low <= high){
             int mid = low + (high - low) / 2;

            // changing the index back to rows and columns
            rows = mid / column;
            columns = mid % column;
            value = matrix [rows][columns];
             if(value < target){
                 low = mid + 1;
             }
             else if(value > target){
                 high = mid -1;
             }
             else{
                 return true;
             }
 
         }
         return false; // value was not found
     }
}
