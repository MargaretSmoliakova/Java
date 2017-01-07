import java.io.*;
import java.util.Arrays;
import java.util.NoSuchElementException;
import java.util.Scanner;
import java.lang.String;

public class Matrix {

    private String path;
    private int col;
    private int row;

    public Matrix() {

    }

    public Matrix(String path, int col, int row) {
        this.path = path;
        this.col = col;
        this.row = row;
    }

    public void createFile () {

        int i = 0, j = 0;
        String tempString = "";

        try {
            File file = new File(path);
            OutputStream outputStream = new FileOutputStream(file);
            Writer outputStreamWriter = new OutputStreamWriter(outputStream);
            BufferedWriter bufferedWriter = new BufferedWriter(outputStreamWriter);

            for (i = 1; i <= row; i++) {
                for (j = 1; j <= col; j++) {
                    tempString += (char)((int)(Math.random() * 10) + '0') + " ";
                }

                bufferedWriter.write(tempString);
                tempString = "";
                bufferedWriter.newLine();
            }

            bufferedWriter.close();
            outputStreamWriter.close();
            outputStream.close();

        } catch (FileNotFoundException e) {
            System.out.println("Sorry but your file does not exist...");
        } catch (IOException e) {
            System.out.println("Sorry but you could not rite down into your file anything...");
        }
    }

    public void printOutFile () throws FileNotFoundException {

        File file = new File(path);
        Scanner sc = null;


        sc = new Scanner(file);

        while (sc.hasNextLine()) {
            System.out.println(sc.nextLine());
        }

        sc.close();
    }

    public void PrintOutOrderedArray () throws FileNotFoundException, MatrixCorrectnessException {

        File file = new File(path);
        Scanner sc = null;
        int[][] intMatrixArray = new int[row][col];
        int [] tempIntArray = new int[col];
        int  min = 0, max = 0, maxIndex = 0, minIndex = 0, tempSum = 0;

        sc = new Scanner(file);

        try {
            for (int i = 0; i < row; i++)
                for (int j = 0; j < col; j++) intMatrixArray[i][j] = sc.nextInt();
        } catch (NoSuchElementException ex) {
            throw new MatrixCorrectnessException ("Your matrix is incorrect...");
        }

        max = this.countSumCol(intMatrixArray, 0);
        min = max;

        for (int i = 0; i < row; i++) {
            tempSum = this.countSumCol(intMatrixArray, i);
            if (max < tempSum) {
                max = tempSum;
                maxIndex = i;
            }

            if (min > tempSum) {
                min = tempSum;
                minIndex = i;
            }
        }


            for (int j = 0; j < col; j++) {
                    tempIntArray[j] = intMatrixArray[minIndex][j];
                    intMatrixArray[minIndex][j] = intMatrixArray[maxIndex][j];
                }



        intMatrixArray[maxIndex] = Arrays.copyOfRange(tempIntArray, 0, row);

        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                System.out.print(intMatrixArray[i][j]);
            }

            System.out.println("");
        }

        sc.close();
    }

    private int countSumCol (int[][] intMatrixArray, int i) {

        int sum = 0;

        for (int j = 0; j < col; j++) {
            sum += intMatrixArray[i][j] - '0';
        }

        return sum;
    }
}
