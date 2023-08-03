import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static int TotalIntake =0;
    public static int Max =0;
    public static int Min =0;

    public static void main(String[] args) {
        File diplomaFile = new File("diploma.csv");

        int index = 0;

        ArrayList<DiplomaData> diploma = new ArrayList<>();
        ArrayList<DiplomaData> kursus = new ArrayList<>();

        if(diplomaFile.exists()){
            System.out.println("File existed.");

            if(diplomaFile.canRead()){
                System.out.println("File is readable.");
            } else {
                System.out.println("File is unreadable.");
            }

            try(Scanner reader = new Scanner(diplomaFile)){
                while (reader.hasNext()){
                    String fileLine = reader.nextLine();
                    if(index >0){
                        String [] fileItems = fileLine.split(",");
                        DiplomaData fileData = new DiplomaData(fileItems[0],fileItems[1],fileItems[2],fileItems[3],
                                fileItems[4],fileItems[5],fileItems[6],fileItems[7],fileItems[8]);

                        TotalIntake = TotalIntake + fileData.getTotalIntake();
                        Max = Max + fileData.getMaxIntake();
                        Min = Min + fileData.getMinIntake();

                        if(" Diploma Lanjutan".equals(fileItems[1])){
                            diploma.add(fileData);
                        } else if("Kursus Pengkhususan".equals(fileItems[1])){
                            kursus.add(fileData);
                        }
                        try(PrintWriter writer = new PrintWriter(new File("Diploma Lanjutan.txt"))){
                            for(DiplomaData row: diploma) {
                                writer.println(row);
                            }
                        } catch (FileNotFoundException exception) {
                            System.out.println(exception.getMessage());
                        }
                        try(PrintWriter writer = new PrintWriter(new File("Kursus Pengkhususan.txt"))){
                            for(DiplomaData row: kursus) {
                                writer.println(row);
                            }
                        } catch (FileNotFoundException exception) {
                            System.out.println(exception.getMessage());
                        }
                    }
                    index ++;
                }
            }
            catch (FileNotFoundException exception) {
                System.out.println(exception.getMessage());
            }
        }else{
            System.out.println("File can't exists.");
        }
    }
}