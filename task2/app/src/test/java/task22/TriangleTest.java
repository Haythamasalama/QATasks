package task22;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class TriangleTest {
    @Test
    public void testValidScaleneTriangle() throws Exception {
        Triangle.TriangleType result = Triangle.classify(4, 5, 6);
        assertEquals(Triangle.TriangleType.SCALENE, result);
    }

    @Test
    public void testValidIsoscelesTriangle() throws Exception {
        Triangle.TriangleType result = Triangle.classify(5, 5, 6);
        assertEquals(Triangle.TriangleType.ISOSCELES, result);
    }

    @Test
    public void testValidEquilateralTriangle() throws Exception {
        Triangle.TriangleType result = Triangle.classify(4, 4, 4);
        assertEquals(Triangle.TriangleType.EQUILATERAL, result);
    }

    @Test
    public void testInvalidTriangle() {

        assertThrows(
                InvalidTriangleException.class,
                () -> Triangle.classify(0, 0, 0),
                "invalid triangle"
        );

        assertThrows(
                InvalidTriangleException.class,
                () -> Triangle.classify(-3, -4, -5),
                "invalid triangle"
        );


        assertThrows(
                InvalidTriangleException.class,
                () -> Triangle.classify(3, 4, 8),
                "invalid triangle"
        );

        assertThrows(
                InvalidTriangleException.class,
                () -> Triangle.classify(3, 3, 6),
                "invalid triangle"
        );

        assertThrows(
                InvalidTriangleException.class,
                () -> Triangle.classify(0, 4, 6),
                "invalid triangle"
        );
    }
}
