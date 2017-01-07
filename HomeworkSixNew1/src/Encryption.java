import java.io.*;
import java.util.*;

/**
 * Created by Маргарита on 07.12.2016.
 */
public class Encryption {

    String pathEncryption;
    String path;

    public Encryption() {

    }

    public Encryption(String path, String pathEncryption) {

        this.path = path;
        this.pathEncryption = pathEncryption;
    }

    public void changeText() throws IOException {

        File file = new File(path);
        File fileForEncryption = new File(pathEncryption);
        Scanner sc = new Scanner(file, "cp1251");

        OutputStream outputStream = new FileOutputStream(fileForEncryption);
        Writer outputStreamWriter = new OutputStreamWriter(outputStream, "cp1251");
        BufferedWriter bufferedWriter = new BufferedWriter(outputStreamWriter);

        char[] tempCharArrayFinal;
        char[] tempCharArray;
        int j = 0, lengthTempCharArrayFinal;
        List<String> tokensArray = new ArrayList<>();
        String tempStringForTokens;

        while (sc.hasNextLine()) {
            String tempString = sc.nextLine();
            StringTokenizer st = new StringTokenizer(tempString, ".,-:; ");
            while (st.hasMoreTokens()) {
                tokensArray.add(st.nextToken());
            }
        }

        int i = 0;

        while(i < tokensArray.size()) {
            System.out.println(tokensArray.get(i));

            tempCharArray = tokensArray.get(i).toCharArray();
            lengthTempCharArrayFinal = tempCharArray.length;
            tempCharArrayFinal = new char[lengthTempCharArrayFinal + 1];
            tempCharArrayFinal[i] = tempCharArray[j];
            i++;
            if (i < tokensArray.size()) {
                tempCharArrayFinal[i] = tempCharArray[tempCharArray.length - 1 - j];
                i++;
                j++;
            } else break;

            tempCharArrayFinal[lengthTempCharArrayFinal - 1] = '#';

            bufferedWriter.write(tempCharArrayFinal);
        }


        bufferedWriter.close();
        outputStreamWriter.close();
        outputStream.close();
    }
}

