import java.io.FileNotFoundException;

public class RunProgram {
    public static void main (String[] args) throws FileNotFoundException {

        String path= "C:\\ALL\\PROGRAMMING\\JavaProgramming\\HomeworkFifth1\\Matrix.txt";

        Matrix matrix = new Matrix(path, 5, 6);

        //matrix.createFile();

        System.out.println("\nThis is your matrix:");

        matrix.printOutFile();

        System.out.println("\nThis is your ordered matrix:");

        try {
            matrix.PrintOutOrderedArray();
        } catch (MatrixCorrectnessException e) {
            System.out.println (e.getMessage());
        }

        System.out.println("\nDone");
    }
}
