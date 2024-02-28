import java.util.ArrayList;
import java.util.List;

public class Vector {
    public List<Double> coordinates;
    public Vector(List<Double> coordinates)
    {
        this.coordinates = new ArrayList<>(coordinates);
    }
    public Vector add(Vector other)
    {
        if (this.coordinates.size() != other.coordinates.size())
        {
            throw new IllegalArgumentException("Dimension mismatch: Cannot add vectors with different dimensions.");
        }

        List<Double> resultCoordinates = new ArrayList<>();
        for (int i = 0; i < this.coordinates.size(); i++)
        {
            resultCoordinates.add(this.coordinates.get(i) + other.coordinates.get(i));
        }

        return new Vector(resultCoordinates);
    }
    public Vector multiply(double scalar)
    {
        List<Double> resultCoordinates = new ArrayList<>();
        for (double coordinate : coordinates)
        {
            resultCoordinates.add(coordinate * scalar);
        }

        return new Vector(resultCoordinates);
    }
    public double length()
    {
        double sumOfSquares = 0.0;
        for (double coordinate : coordinates)
        {
            sumOfSquares += coordinate * coordinate;
        }
        return Math.sqrt(sumOfSquares);
    }

    public double distance(Vector other)
    {
        if (this.coordinates.size() != other.coordinates.size())
        {
            throw new IllegalArgumentException("Dimension mismatch: Cannot calculate distance between vectors of different dimensions.");
        }
        return this.add(other.multiply(-1)).length();
    }

    public static List<Vector> getNearestVectors(List<Vector> vectors)
    {
        if (vectors == null || vectors.size() < 2)
        {
            throw new IllegalArgumentException("At least two vectors are required to calculate minimum distance.");
        }
        List<Vector> nearestVectors = new ArrayList<>();
        Vector x;
        Vector y;
        double currentDistance;
        double minDistance = Double.MAX_VALUE;

        for (int i = 0; i < vectors.size() - 1; i++)
        {
            x = vectors.get(i);
            for (int j = i + 1; j < vectors.size(); j++)
            {
                y = vectors.get(j);
                currentDistance = x.distance(y);
                if(currentDistance < minDistance)
                {
                    minDistance = currentDistance;
                    nearestVectors.clear();
                    nearestVectors.add(x);
                    nearestVectors.add(y);
                }
            }
        }
        return nearestVectors;
    }
}
