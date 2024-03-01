package hu.peterstanga;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<VectorsContainer> originalVectorsContainers = FileHandler.fileIntoVectors("/input.txt");

        FileHandler.nearestVectorsOutput("output.txt", originalVectorsContainers);
    }
}