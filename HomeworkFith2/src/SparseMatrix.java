import java.io.*;
import java.util.Scanner;


public class SparseMatrix {

    private String path;
    private int col;
    private int row;

    public SparseMatrix () {

    }

    public SparseMatrix(String path, int col, int row) {
        this.path = path;
        this.col = col;
        this.row = row;
    }

    public void createFile () throws IOException {

        String tempString = "";

        Scanner userInput = new Scanner(System.in);

        File file = new File(path);
        OutputStream outputStream = new FileOutputStream(file);
        Writer outputStreamWriter = new OutputStreamWriter(outputStream);
        BufferedWriter bufferedWriter = new BufferedWriter(outputStreamWriter);

        tempString = userInput.nextLine();
        char[] tempInt = tempString.toCharArray();

        bufferedWriter.close();
        outputStreamWriter.close();
        outputStream.close();

    }

    public void printOut () throws FileNotFoundException {

        File file = new File(path);
        Scanner scanner = new Scanner(file);

        while (scanner.hasNextInt()) System.out.print(scanner.nextInt());
    }

    public void printOutChanged () throws MyException, IOException {


        int[][] sparseMatrixChanged = new int[row][col];


        File file = new File(path);
        Scanner scanner = new Scanner(file);

// get coordinates of 1 ints from the file

        while(scanner.hasNextInt()) {
            sparseMatrixChanged[scanner.nextInt()][scanner.nextInt()] = 1;             // catch the Exception

        }


        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                System.out.print(sparseMatrixChanged[i][j]);
            }
            System.out.println("");
        }
    }
}
