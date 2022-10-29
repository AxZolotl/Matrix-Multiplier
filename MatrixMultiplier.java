import java.util.*;

public class Dimal_Activity2 {
    public static void main(String[] args) {
        new Dimal_Activity2();
    }

    //Class Variables
    boolean correctInput;
    Scanner sc = new Scanner(System.in);

    //Class Constructor
    public Dimal_Activity2() {
        while (correctInput == false) {
            correctInput = true;

            System.out.println("Input:");

            /* 
             * Inputs number of rows and columns of the first matrix and its values
             * Inputs number of rows and columns of the second matrix and its values
             * Multiplies the two matrices 
             * Prints the resulting matrix
             */
            printResult(multiplyMatrices(makeMatrix(specifyRandC("first")), makeMatrix(specifyRandC("second"))));
        }
    }

    /**
     * Specify matrix's number of rows and columns
     * @param position order of the matrix
    */
    public int[][] specifyRandC(String position) {
        if(correctInput == true) {
            int[][] matrix = new int[0][0];
            //System.out.print("Enter number of rows and columns of the " + position + " matrix: ");  

            String[] input = sc.nextLine().split(" ");

            if(input.length != 2) {
                System.out.println("\nIncorrect input format. Please begin from the start again.");
                correctInput = false;

                return null;
            }

            try {
                matrix = new int[Integer.parseInt(input[0])][Integer.parseInt(input[1])];
            } catch (NumberFormatException e) {
                System.out.println("\nIncorrect input format. Please begin from the start again.");
                correctInput = false;

                return null;
            }
            //System.out.println("Enter the values of the matrix:");

            return matrix;
        } else {
            return null;
        }
    }

    /**
     * Create matrix according to specified dimension
     * @param matrix the matrix with its dimensions but with default values
     */
    public int[][] makeMatrix(int[][] matrix) {
        if(correctInput == true) {
            for(int i = 0; i < matrix.length; i++) {
                String[] input = sc.nextLine().split(" ");

                if(input.length != matrix[i].length) { 
                    System.out.println("\nIncorrect input format. Please begin from the start again.");
                    correctInput = false;
                    
                    return null;
                }

                try {
                    int[] values = Arrays.stream(input)
                    .mapToInt(Integer::parseInt)
                    .toArray();
                    matrix[i] = values;
                } catch (NumberFormatException e) {
                    System.out.println("\nIncorrect input format. Please begin from the start again.");
                    correctInput = false;

                    return null;
                }
            } return matrix;
        } else {
            return null;
        }
    }

    /**
     * Peform multiplication operation on two matrices
     * @param matrixA first matrix
     * @param matrixB second matrix
     */
    public int[][] multiplyMatrices(int[][] matrixA, int[][] matrixB) {
        if(correctInput == true) {
            int[][] result = new int[matrixA.length][matrixB[matrixB.length-1].length];
    
            if(matrixA[matrixA.length-1].length == matrixB.length) {
                for(int i = 0; i < matrixA.length; i++) {
                    for(int j = 0; j < matrixB[matrixB.length-1].length; j++) {
                        for(int k = 0; k < matrixA[matrixA.length-1].length; k++) {
                            result[i][j] += matrixA[i][k] * matrixB[k][j];
                        }
                    }
                } return result;
            } else {
                System.out.println("The dimensions of the two matrices are not compatible!\n" +
                                   "\nPlease begin from the start again.");

                correctInput = false;
                return null;
            }
        } else {
            return null;
        }
        
    }

    /**
     * Prints the values of the resulting matrix
     * @param result the resulting matrix
     */
    public void printResult(int[][] result) {
        if(correctInput == true) {
            System.out.println("\nOutput:");

            for(int i = 0; i < result.length; i++) {
                for(int j = 0; j < result[i].length; j++) 
                    System.out.print(result[i][j] + " ");
    
                System.out.println();
            }

            correctInput = false;

            System.out.println();
        }
    }
}