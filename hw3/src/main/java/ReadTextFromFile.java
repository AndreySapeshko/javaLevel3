import java.io.*;

public class ReadTextFromFile {

    public static void main(String[] args) throws IOException {
//        System.out.println(readTextInByteArray("C:\\GB\\java\\test.txt"));
//        String[] fileNames = new String[5];
//        for (int i = 1; i < 6; i++) {
//            fileNames[i-1] = String.format("C:\\GB\\java\\test%d.txt", i);
//        }
//        concatFiles("C:\\GB\\java\\test.txt", fileNames);

        long l =  System.currentTimeMillis();
        System.out.println(readFileOnePageAtTime("C:\\GB\\java\\longtext.txt"));
        System.out.println(System.currentTimeMillis() - l);
    }

    public static String readTextInByteArray(String fileName) throws IOException {
        FileInputStream fis = new FileInputStream(fileName);
        String textFromFile = "";
        int n = -1;
        byte[] buffer = new byte[400];
        while ((n = fis.read(buffer)) > 0) {
            textFromFile += new String(buffer);
        }
        fis.close();
        return textFromFile;
    }

    public static void concatFiles(String unaitedFiles, String[] fileNames) throws IOException {
        FileOutputStream fos = new FileOutputStream(unaitedFiles, true);
        for (int i = 0; i < fileNames.length; i++) {
            FileInputStream fis = new FileInputStream(fileNames[i]);
            int n = -1;
            byte[] buffer = new byte[fis.available()];
            while ((n = fis.read(buffer)) > 0) {
                fos.write(buffer, 0, n);
            }
            fis.close();
        }
    }

    public static long readFileOnePageAtTime (String fileToRead) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(new FileInputStream(fileToRead), "windows-1251"));
        String strFromFile = null;
        long startTime = System.currentTimeMillis();
        while (reader.ready()) {
            strFromFile = reader.readLine();
            System.out.println(strFromFile);
        }
        return ((System.currentTimeMillis() - startTime) / 1000);
    }
}
