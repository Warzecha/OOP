package lab2.matrix;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MatrixTest {


    private Matrix generateSample2x2Matrix() {
        double[][] arr2d = new double[2][2];
        arr2d[0][0] = 1;
        arr2d[0][1] = 2;
        arr2d[1][0] = 3;
        arr2d[1][1] = 4;
        return new Matrix(arr2d);
    }

    private Matrix generateSample2x3Matrix() {
        Matrix m = new Matrix(2, 3);
        m.set(0, 0, 1);
        m.set(0, 1, 2);
        m.set(0, 2, 3);
        m.set(1, 0, 4);
        m.set(1, 1, 5);
        m.set(1, 2, 6);
        return m;
    }

    private Matrix generate2x3MatrixFilledWith(double n) {
        Matrix m = new Matrix(2, 3);
        m.set(0, 0, n);
        m.set(0, 1, n);
        m.set(0, 2, n);
        m.set(1, 0, n);
        m.set(1, 1, n);
        m.set(1, 2, n);
        return m;
    }


    @Test
    void asArray() {

        Matrix m = generateSample2x2Matrix();

        double matrixAsArray[][] = m.asArray();
        assertEquals(matrixAsArray[0][0], 1);
        assertEquals(matrixAsArray[0][1], 2);
        assertEquals(matrixAsArray[1][0], 3);
        assertEquals(matrixAsArray[1][1], 4);

    }

    @Test
    void getRows() {

        Matrix m = new Matrix(7, 5);
        assertEquals(7, m.getRows());


    }

    @Test
    void getCols() {
        Matrix m = new Matrix(7, 5);
        assertEquals(5, m.getCols());
    }


    @Test
    void get() {
        Matrix m = generateSample2x2Matrix();

        assertEquals(1, m.get(0, 0));
        assertEquals(2, m.get(0, 1));
        assertEquals(3, m.get(1, 0));
        assertEquals(4, m.get(1, 1));

    }



    @Test
    void set() {


        Matrix m = generateSample2x3Matrix();
//        System.out.print(m.toString());

        assertEquals(1, m.get(0, 0));
        assertEquals(2, m.get(0, 1));
        assertEquals(3, m.get(0, 2));
        assertEquals(4, m.get(1, 0));
        assertEquals(5, m.get(1, 1));
        assertEquals(6, m.get(1, 2));



    }

    @Test
    void testToString() {
//        Matrix m = generateSample2x3Matrix();
//
//        String expected = "[[1, 2, 3],\n[4, 5, 6]]";
//        assertEquals(expected, m.toString());

    }

    @Test
    void reshape() {
    }

    @Test
    void shape() {
        Matrix m = generateSample2x3Matrix();
        int shape[] = m.shape();
        assertEquals(2, shape[0]);
        assertEquals(3, shape[1]);

    }

    @Test
    void add() {
        Matrix m1 = generateSample2x3Matrix();
        Matrix m2 = generate2x3MatrixFilledWith(1);
        Matrix m3 = generate2x3MatrixFilledWith(5.2);

        Matrix sum1 = m1.add(m2);
        Matrix sum2 = m1.add(m3);



        assertEquals(2, sum1.get(0, 0));
        assertEquals(3, sum1.get(0, 1));
        assertEquals(4, sum1.get(0, 2));
        assertEquals(5, sum1.get(1, 0));
        assertEquals(6, sum1.get(1, 1));
        assertEquals(7, sum1.get(1, 2));


        assertEquals(6.2, sum2.get(0, 0), 0.1);
        assertEquals(7.2, sum2.get(0, 1), 0.1);
        assertEquals(8.2, sum2.get(0, 2), 0.1);
        assertEquals(9.2, sum2.get(1, 0), 0.1);
        assertEquals(10.2, sum2.get(1, 1), 0.1);
        assertEquals(11.2, sum2.get(1, 2), 0.1);



    }

    @Test
    void sub() {

        Matrix m1 = generateSample2x3Matrix();
        Matrix m2 = generate2x3MatrixFilledWith(1);
        Matrix m3 = generate2x3MatrixFilledWith(5.2);

        Matrix sum1 = m1.sub(m2);
        Matrix sum2 = m1.sub(m3);



        assertEquals(0, sum1.get(0, 0));
        assertEquals(1, sum1.get(0, 1));
        assertEquals(2, sum1.get(0, 2));
        assertEquals(3, sum1.get(1, 0));
        assertEquals(4, sum1.get(1, 1));
        assertEquals(5, sum1.get(1, 2));


        assertEquals(-4.2, sum2.get(0, 0), 0.1);
        assertEquals(-5.2, sum2.get(0, 1), 0.1);
        assertEquals(-6.2, sum2.get(0, 2), 0.1);
        assertEquals(-7.2, sum2.get(1, 0), 0.1);
        assertEquals(-8.2, sum2.get(1, 1), 0.1);
        assertEquals(-9.2, sum2.get(1, 2), 0.1);




    }

    @Test
    void mul() {
    }

    @Test
    void div() {
    }

    @Test
    void add1() {
    }

    @Test
    void sub1() {
    }

    @Test
    void mul1() {
    }

    @Test
    void div1() {
    }

    @Test
    void dot() {
    }

    @Test
    void frobenius() {
    }
}