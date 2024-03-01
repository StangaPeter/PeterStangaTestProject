package hu.peterstanga;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class VectorsContainerTest {
    @Test
    public void add_positiveTest() {
        VectorsContainer x = new VectorsContainer(Arrays.asList(1.0, 2.0, 3.0));
        VectorsContainer y = new VectorsContainer(Arrays.asList(4.0, 5.0, 6.0));
        VectorsContainer z = x.add(y);

        assertEquals(Arrays.asList(5.0, 7.0, 9.0), z.coordinates());
    }

    @Test
    public void add_negativeTest() {
        VectorsContainer x = new VectorsContainer(Arrays.asList(1.0, 2.0));
        VectorsContainer y = new VectorsContainer(Arrays.asList(4.0, 5.0, 6.0));

        assertThrows(IllegalArgumentException.class, () -> x.add(y));
    }

    @Test
    public void multiply_positiveTest() {
        VectorsContainer x = new VectorsContainer(Arrays.asList(1.0, 2.0, 3.0));
        VectorsContainer y = x.multiply(2.0);

        assertEquals(Arrays.asList(2.0, 4.0, 6.0), y.coordinates());
    }

    @Test
    public void length() {
        VectorsContainer x = new VectorsContainer(Arrays.asList(3.0, 4.0));

        assertEquals(5.0, x.length());
    }

    @Test
    public void distance_positiveTest() {
        VectorsContainer x = new VectorsContainer(Arrays.asList(1.0, 2.0, 3.0));
        VectorsContainer y = new VectorsContainer(Arrays.asList(4.0, 5.0, 6.0));

        double result = x.distance(y);
        double expected = 5.196;

        assertEquals(expected, result, 0.001);
    }

    @Test
    public void distance_negativeTest() {
        VectorsContainer x = new VectorsContainer(Arrays.asList(1.0, 2.0, 3.0));
        VectorsContainer y = new VectorsContainer(Arrays.asList(4.0, 5.0));

        assertThrows(NullPointerException.class, () -> x.distance(null));
        assertThrows(IllegalArgumentException.class, () -> x.distance(y));
    }

    @Test
    public void getNearestVectorsContainers_positiveTest() {
        VectorsContainer x = new VectorsContainer(Arrays.asList(1.0, 2.0, 3.0));
        VectorsContainer y = new VectorsContainer(Arrays.asList(3.0, 3.0, 3.0));
        VectorsContainer z = new VectorsContainer(Arrays.asList(7.0, 8.0, 9.0));

        List<VectorsContainer> VectorsContainers = Arrays.asList(x, y, z);

        List<VectorsContainer> result = VectorsContainer.getNearestVectors(VectorsContainers);
        List<VectorsContainer> expected = Arrays.asList(x, y);

        assertEquals(expected, result);
    }

    @Test
    public void getNearestVectorsContainers_negativeTest() {
        List<VectorsContainer> vectorsContainerList = List.of(new VectorsContainer(Arrays.asList(1.0, 2.0, 3.0)));

        assertThrows(IllegalArgumentException.class, () -> VectorsContainer.getNearestVectors(null));
        assertThrows(IllegalArgumentException.class, () -> VectorsContainer.getNearestVectors(vectorsContainerList));
    }
}