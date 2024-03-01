package hu.peterstanga;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public record VectorsContainer(List<Double> coordinates) {

    public VectorsContainer add(VectorsContainer other) {
        if (this.coordinates.size() != other.coordinates.size()) {
            throw new IllegalArgumentException("Dimension mismatch: Cannot add vectors with different dimensions.");
        }

        List<Double> resultCoordinates = new ArrayList<>();

        for (int i = 0; i < this.coordinates.size(); i++) {
            resultCoordinates.add(this.coordinates.get(i) + other.coordinates.get(i));
        }

        return new VectorsContainer(resultCoordinates);
    }

    public VectorsContainer multiply(double scalar) {
        List<Double> resultCoordinates = new ArrayList<>();

        for (double coordinate : coordinates) {
            resultCoordinates.add(coordinate * scalar);
        }

        return new VectorsContainer(resultCoordinates);
    }

    public double length() {
        double sumOfSquares = 0.0;

        for (double coordinate : coordinates) {
            sumOfSquares += coordinate * coordinate;
        }

        return Math.sqrt(sumOfSquares);
    }

    public double distance(VectorsContainer other) {
        Objects.requireNonNull(other, "The other vector must not be null.");

        if (this.coordinates.size() != other.coordinates.size()) {
            throw new IllegalArgumentException("Dimension mismatch: Cannot calculate distance between vectors of different dimensions.");
        }

        return this.add(other.multiply(-1)).length();
    }

    public static List<VectorsContainer> getNearestVectors(List<VectorsContainer> vectorsContainers) {
        if (vectorsContainers == null || vectorsContainers.size() < 2) {
            throw new IllegalArgumentException("At least two vectors are required to calculate minimum distance.");
        }

        double minDistance = Double.MAX_VALUE;
        List<VectorsContainer> nearestVectorsContainers = new ArrayList<>();

        for (int i = 0; i < vectorsContainers.size() - 1; i++) {
            for (int j = i + 1; j < vectorsContainers.size(); j++) {
                double currentDistance = vectorsContainers.get(i).distance(vectorsContainers.get(j));

                if (currentDistance < minDistance) {
                    minDistance = currentDistance;
                    nearestVectorsContainers = List.of(vectorsContainers.get(i), vectorsContainers.get(j));
                }
            }
        }

        return nearestVectorsContainers;
    }
}
