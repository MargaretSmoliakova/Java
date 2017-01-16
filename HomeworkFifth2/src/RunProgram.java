import java.io.IOException;

/**
 * Created by Маргарита on 30.11.2016.
 */
public class RunProgram {
    public static void main (String[] args) throws IOException {

        String path = "C:\\ALL\\PROGRAMMING\\JavaProgramming\\HomeworkFifth2\\SparseMatrix.txt";

        SparseMatrix sparseMatrix = new SparseMatrix(path, 5, 5);

        //System.out.println("Please input your coordinates:");

        //sparseMatrix.createFile();

        //System.out.println("\nYour original sparse matrix is:");

        //sparseMatrix.printOut();

        System.out.println("\nYour changed matrix is:");

        try {
            sparseMatrix.printOutChanged();
        } catch (MyException e) {
            System.out.println(e.getMessage());
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }

    }
}
