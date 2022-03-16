import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvException;
import java.io.FileReader;
import java.io.IOException;
import java.util.List;

public class Activity13_1 {

    public static void main(String[] args) throws IOException, CsvException {
        FileReader fileReader=new FileReader("src/test/java/sample.csv");
        CSVReader reader=new CSVReader(fileReader);

        List<String []> list=reader.readAll();

        System.out.println("Total number of rows are:"+list.size());

        for (String[] str : list) {
            for (String s : str) System.out.print(" " + s);
            System.out.println(" ");

        }

    }
}

