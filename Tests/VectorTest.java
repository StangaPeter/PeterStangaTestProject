import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.*;

public class VectorTest {

    @org.junit.Test
    public void add()
    {
        Vector x = new Vector(Arrays.asList(1.0, 2.0, 3.0));
        Vector y = new Vector(Arrays.asList(4.0, 5.0, 6.0));
        Vector z = x.add(y);

        List<Double> result = z.coordinates;
        List<Double> expected = Arrays.asList(5.0, 7.0, 9.0);

        assertEquals(expected, result);
    }

    @org.junit.Test
    public void multiply()
    {
        Vector x = new Vector(Arrays.asList(1.0, 2.0, 3.0));
        Vector y = x.multiply(2.0);

        List<Double> result = y.coordinates;
        List<Double> expected = Arrays.asList(2.0, 4.0, 6.0);

        assertEquals(expected, result);
    }

    @org.junit.Test
    public void length()
    {
        Vector x = new Vector(Arrays.asList(3.0, 4.0));

        double result = x.length();

        assertEquals(5.0, result, 0.0001);
    }

    @org.junit.Test
    public void distance()
    {
        Vector x = new Vector(Arrays.asList(1.0, 2.0, 3.0));
        Vector y = new Vector(Arrays.asList(4.0, 5.0, 6.0));

        double result = x.distance(y);

        assertEquals(5.196, result, 0.001);
    }

    @org.junit.Test
    public void getNearestVectors()
    {
        Vector x = new Vector(Arrays.asList(1.0, 2.0, 3.0));
        Vector y = new Vector(Arrays.asList(3.0, 3.0, 3.0));
        Vector z = new Vector(Arrays.asList(7.0, 8.0, 9.0));

        List<Vector> vectors = Arrays.asList(x, y, z);

        List<Vector> result = Vector.getNearestVectors(vectors);
        List<Vector> expected = Arrays.asList(x, y);

        assertEquals(expected, result);
    }
}