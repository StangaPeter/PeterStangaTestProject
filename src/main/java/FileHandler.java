
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class FileHandler {
    public static List<Vector> fileIntoVectors(String inputPath) {
        List<Vector> vectors = new ArrayList<>();
        String line;
        String[] elements;
        List<Double> coords = new ArrayList<Double>();

        try (java.io.BufferedReader reader = new java.io.BufferedReader(new FileReader(inputPath))) {

            while ((line = reader.readLine()) != null) {
                elements = line.split("\\s+");
                for (int i = 0; i < elements.length; i++) {
                    coords.add(Double.parseDouble(elements[i]));
                }
                vectors.add(new Vector(coords));
                coords.clear();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return vectors;
    }

    public static void nearestVectorsOutput(String outputPath, List<Vector> originalVectors) {
        List<Vector> newVectors = Vector.getNearestVectors(originalVectors);

        Vector x = newVectors.get(0);
        Vector y = newVectors.get(1);

        int indexFirst = originalVectors.indexOf(x) + 1;
        int indexSecond = originalVectors.indexOf(y) + 1;

        String firstLine = indexFirst + ":    ";
        String secondLine = indexSecond + ":    ";

        for (int i = 0; i < x.coordinates.size(); i++) {
            firstLine += x.coordinates.get(i) + " ";
            secondLine += y.coordinates.get(i) + " ";
        }

        try (BufferedWriter writer = new BufferedWriter(new FileWriter(outputPath))) {
            writer.write(firstLine);
            writer.newLine();
            writer.write(secondLine);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
