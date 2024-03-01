import java.io.IOException;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Vector> originalVectors = FileHandler.fileIntoVectors("input.txt");
        FileHandler.nearestVectorsOutput("output.txt",originalVectors);
    }
}