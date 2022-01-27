import java.io.*;
import java.util.Locale;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        final String YES = "y";
        Scanner sc = new Scanner(System.in);
        System.out.print("Nhập tên file nguồn: ");
        String inputFileName = sc.nextLine();

        if (!fileExist(inputFileName)) {
            System.out.println("File không tồn tại!");
        } else {
            System.out.print("Nhập tên file đích: ");
            String outputFileName = sc.nextLine();

            String confirm = YES;
            if (fileExist(outputFileName)) {
                System.out.print("File đã tồn tại. Bạn có muốn ghi đè file này <y/n>?");
                confirm = sc.next().toLowerCase();
            }

            if (confirm.equals(YES)) {
                copyFile(inputFileName, outputFileName);
            }
        }


    }

    public static boolean fileExist(String fileName) {
        File file = new File(fileName);
        return file.isFile();
    }

    public static void copyFile(String inputFileName, String outputFileName) {
        try {
            FileReader fileReader = new FileReader(inputFileName);
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            FileWriter fileWriter = new FileWriter(outputFileName);
            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);

            String line;
            while ((line = bufferedReader.readLine()) != null) {
                bufferedWriter.write(line + "\n");
            }

            bufferedReader.close();
            fileReader.close();
            bufferedWriter.close();
            fileWriter.close();
        } catch (IOException e) {
            System.err.println(e.getMessage());
        }
    }
}