package hu.peterstanga;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class FileHandler {
    private static final Logger logger = LogManager.getLogger(FileHandler.class);

    public static List<VectorsContainer> fileIntoVectors(String inputPath) {
        List<VectorsContainer> vectorsContainers = new ArrayList<>();

        InputStream resourceStream = Optional.ofNullable(FileHandler.class.getResourceAsStream(inputPath)).orElseThrow();

        try (BufferedReader reader = new BufferedReader(new InputStreamReader(resourceStream))) {
            String line;

            while ((line = reader.readLine()) != null) {
                List<Double> coords = new ArrayList<>();

                for (String element : line.split("\\s+")) {
                    coords.add(Double.parseDouble(element));
                }

                vectorsContainers.add(new VectorsContainer(coords));
            }
        } catch (IOException e) {
            logger.error(e.getMessage(), e);
        }

        return vectorsContainers;
    }

    public static void nearestVectorsOutput(String outputPath, List<VectorsContainer> originalVectorsContainers) {
        List<VectorsContainer> newVectorsContainers = VectorsContainer.getNearestVectors(originalVectorsContainers);

        VectorsContainer x = newVectorsContainers.get(0);
        VectorsContainer y = newVectorsContainers.get(1);

        int indexFirst = originalVectorsContainers.indexOf(x) + 1;
        int indexSecond = originalVectorsContainers.indexOf(y) + 1;

        StringBuilder firstLine = new StringBuilder(indexFirst + ":    ");
        StringBuilder secondLine = new StringBuilder(indexSecond + ":    ");

        for (int i = 0; i < x.coordinates().size(); i++) {
            firstLine.append(x.coordinates().get(i)).append(" ");
            secondLine.append(y.coordinates().get(i)).append(" ");
        }

        try (BufferedWriter writer = new BufferedWriter(new FileWriter(outputPath))) {
            writer.write(firstLine.toString());
            writer.newLine();
            writer.write(secondLine.toString());
        } catch (IOException e) {
            logger.error(e.getMessage(), e);
        }
    }
}
