import java.io.File;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) throws Exception {

        Functions functions = new Functions();
        ArrayList<String> initialDebitorList = new ArrayList<>();
        ArrayList<String> initialKreditorList = new ArrayList<>();


        File file = new File("full-clean-debitor-kreditor.csv");
        List<String> lines = Files.readAllLines(file.toPath());
        for (String line: lines) {
            String[] array = line.split(";");
            if (array.length > 8) {
                initialDebitorList.add(array[8]);
                initialKreditorList.add(array[11]);
            }
        }

        initialDebitorList.remove(0);
        initialKreditorList.remove(0);

        ArrayList<Double> doubleDebitorList = functions.ConvertToDouble(initialDebitorList);
        ArrayList<Double> doubleKreditorList = functions.ConvertToDouble(initialKreditorList);

        ArrayList<Double> cleanDebitorList = functions.CleanList(doubleDebitorList);
        ArrayList<Double> cleanKreditorList = functions.CleanList(doubleKreditorList);

        System.out.println(cleanDebitorList);
        System.out.println(cleanKreditorList);

        for (int d = 0; d < cleanDebitorList.size(); d++) {
            for (int k = 0; k < cleanKreditorList.size(); k++) {
                if (cleanKreditorList.get(k).equals(cleanDebitorList.get(d))) {
                    cleanKreditorList.remove(cleanKreditorList.get(k));
                    cleanDebitorList.remove(d);
                    System.out.println(cleanDebitorList);
                }
                break;
            }
        }
        System.out.println("\n");
        System.out.println(cleanDebitorList);
        System.out.println(cleanKreditorList);
    }
}