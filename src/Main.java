import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {

        List<Vector> originalVectors = FileHandler.fileIntoVectors("input.txt");
        FileHandler.nearestVectorsOutput("output.txt",originalVectors);
    }
}