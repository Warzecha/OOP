package lab2.matrix;

import org.junit.jupiter.api.Test;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.CoreMatchers.is;

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

        Matrix wrongSizeMatrix = generateSample2x2Matrix();
        try {
            m1.add(wrongSizeMatrix);
            fail();
        }
        catch(RuntimeException e) {
            assertThat(e.getMessage(), is("Can not add matrices of different shapes"));
        }

    }

    @Test
    void sub() {

        Matrix m1 = generateSample2x3Matrix();
        Matrix m2 = generate2x3MatrixFilledWith(1);
        Matrix m3 = generate2x3MatrixFilledWith(5.2);

        Matrix sub1 = m1.sub(m2);
        Matrix sub2 = m1.sub(m3);



        assertEquals(0, sub1.get(0, 0));
        assertEquals(1, sub1.get(0, 1));
        assertEquals(2, sub1.get(0, 2));
        assertEquals(3, sub1.get(1, 0));
        assertEquals(4, sub1.get(1, 1));
        assertEquals(5, sub1.get(1, 2));


        assertEquals(-4.2, sub2.get(0, 0), 0.1);
        assertEquals(-3.2, sub2.get(0, 1), 0.1);
        assertEquals(-2.2, sub2.get(0, 2), 0.1);
        assertEquals(-1.2, sub2.get(1, 0), 0.1);
        assertEquals(-0.2, sub2.get(1, 1), 0.1);
        assertEquals( 0.8, sub2.get(1, 2), 0.1);

        Matrix wrongSizeMatrix = generateSample2x2Matrix();
        try {
            m1.sub(wrongSizeMatrix);
            fail();
        }
        catch(RuntimeException e) {
            assertThat(e.getMessage(), is("Can not subtract matrices of different shapes"));
        }


    }

    @Test
    void mul() {
        Matrix m1 = generateSample2x3Matrix();
        Matrix m2 = generate2x3MatrixFilledWith(2);
        Matrix m3 = generate2x3MatrixFilledWith(-5.2);
        Matrix m4 = generate2x3MatrixFilledWith(0);

        Matrix mul1 = m1.mul(m2);
        Matrix mul2 = m1.mul(m3);
        Matrix mul3 = m1.mul(m4);


        assertEquals(2, mul1.get(0, 0));
        assertEquals(4, mul1.get(0, 1));
        assertEquals(6, mul1.get(0, 2));
        assertEquals(8, mul1.get(1, 0));
        assertEquals(10, mul1.get(1, 1));
        assertEquals(12, mul1.get(1, 2));


        assertEquals(-5.2, mul2.get(0, 0), 0.1);
        assertEquals(-10.4, mul2.get(0, 1), 0.1);
        assertEquals(-15.6, mul2.get(0, 2), 0.1);
        assertEquals(-20.8, mul2.get(1, 0), 0.1);
        assertEquals(-26, mul2.get(1, 1), 0.1);
        assertEquals(-31.2, mul2.get(1, 2), 0.1);

        assertEquals(0, mul3.get(0, 0));
        assertEquals(0, mul3.get(0, 1));
        assertEquals(0, mul3.get(0, 2));
        assertEquals(0, mul3.get(1, 0));
        assertEquals(0, mul3.get(1, 1));
        assertEquals(0, mul3.get(1, 2));


        Matrix wrongSizeMatrix = generateSample2x2Matrix();
        try {
            m1.mul(wrongSizeMatrix);
            fail();
        }
        catch(RuntimeException e) {
            assertThat(e.getMessage(), is("Can not multiply matrices of different shapes"));
        }

    }

    @Test
    void div() {

        Matrix m1 = generateSample2x3Matrix();
        Matrix m2 = generate2x3MatrixFilledWith(-2);
        Matrix m3 = generate2x3MatrixFilledWith(5.2);
        Matrix m4 = generate2x3MatrixFilledWith(1);

        Matrix div1 = m1.div(m2);
        Matrix div2 = m1.div(m3);
        Matrix div3 = m4.div(m1);



        assertEquals(-0.5, div1.get(0, 0), 0.1);
        assertEquals(-1, div1.get(0, 1), 0.1);
        assertEquals(-1.5, div1.get(0, 2), 0.1);
        assertEquals(-2, div1.get(1, 0), 0.1);
        assertEquals(-2.5, div1.get(1, 1), 0.1);
        assertEquals(-3, div1.get(1, 2), 0.1);


        assertEquals(0.192, div2.get(0, 0), 0.1);
        assertEquals(0.385, div2.get(0, 1), 0.1);
        assertEquals(0.577, div2.get(0, 2), 0.1);
        assertEquals(0.769, div2.get(1, 0), 0.1);
        assertEquals(0.962, div2.get(1, 1), 0.1);
        assertEquals(1.154, div2.get(1, 2), 0.1);

        assertEquals(1.00, div3.get(0, 0), 0.1);
        assertEquals(0.50, div3.get(0, 1), 0.1);
        assertEquals(0.33, div3.get(0, 2), 0.1);
        assertEquals(0.25, div3.get(1, 0), 0.1);
        assertEquals(0.20, div3.get(1, 1), 0.1);
        assertEquals(0.17, div3.get(1, 2), 0.1);


        Matrix wrongSizeMatrix = generateSample2x2Matrix();
        try {
            m1.div(wrongSizeMatrix);
            fail();
        }
        catch(RuntimeException e) {
            assertThat(e.getMessage(), is("Can not divide matrices of different shapes"));
        }

    }

    @Test
    void addNumber() {

        Matrix m1 = generateSample2x3Matrix();
        Matrix m2 = generate2x3MatrixFilledWith(5.2);



        Matrix sum1 = m1.add(2);
        Matrix sum2 = m2.add(-1);



        assertEquals(3, sum1.get(0, 0));
        assertEquals(4, sum1.get(0, 1));
        assertEquals(5, sum1.get(0, 2));
        assertEquals(6, sum1.get(1, 0));
        assertEquals(7, sum1.get(1, 1));
        assertEquals(8, sum1.get(1, 2));


        assertEquals(4.2, sum2.get(0, 0), 0.1);
        assertEquals(4.2, sum2.get(0, 1), 0.1);
        assertEquals(4.2, sum2.get(0, 2), 0.1);
        assertEquals(4.2, sum2.get(1, 0), 0.1);
        assertEquals(4.2, sum2.get(1, 1), 0.1);
        assertEquals(4.2, sum2.get(1, 2), 0.1);

    }

    @Test
    void subNumber() {
        Matrix m1 = generateSample2x3Matrix();
        Matrix m2 = generate2x3MatrixFilledWith(5.2);



        Matrix sub1 = m1.sub(-2);
        Matrix sub2 = m2.sub(1);



        assertEquals(3, sub1.get(0, 0));
        assertEquals(4, sub1.get(0, 1));
        assertEquals(5, sub1.get(0, 2));
        assertEquals(6, sub1.get(1, 0));
        assertEquals(7, sub1.get(1, 1));
        assertEquals(8, sub1.get(1, 2));


        assertEquals(4.2, sub2.get(0, 0), 0.1);
        assertEquals(4.2, sub2.get(0, 1), 0.1);
        assertEquals(4.2, sub2.get(0, 2), 0.1);
        assertEquals(4.2, sub2.get(1, 0), 0.1);
        assertEquals(4.2, sub2.get(1, 1), 0.1);
        assertEquals(4.2, sub2.get(1, 2), 0.1);
    }

    @Test
    void mulByNumber() {
        Matrix m1 = generateSample2x3Matrix();
        Matrix m2 = generate2x3MatrixFilledWith(5.2);



        Matrix mul1 = m1.mul(0.3);
        Matrix mul2 = m2.mul(-2);



        assertEquals(0.3, mul1.get(0, 0), 0.1);
        assertEquals(0.6, mul1.get(0, 1), 0.1);
        assertEquals(0.9, mul1.get(0, 2), 0.1);
        assertEquals(1.2, mul1.get(1, 0), 0.1);
        assertEquals(1.5, mul1.get(1, 1), 0.1);
        assertEquals(1.8, mul1.get(1, 2), 0.1);


        assertEquals(-10.4, mul2.get(0, 0), 0.1);
        assertEquals(-10.4, mul2.get(0, 1), 0.1);
        assertEquals(-10.4, mul2.get(0, 2), 0.1);
        assertEquals(-10.4, mul2.get(1, 0), 0.1);
        assertEquals(-10.4, mul2.get(1, 1), 0.1);
        assertEquals(-10.4, mul2.get(1, 2), 0.1);
    }

    @Test
    void divByNumber() {


        Matrix m1 = generateSample2x3Matrix();
        Matrix m2 = generate2x3MatrixFilledWith(5.2);



        Matrix div1 = m1.div(0.3);
        Matrix div2 = m2.div(-2);



        assertEquals(3.333, div1.get(0, 0), 0.1);
        assertEquals(6.666, div1.get(0, 1), 0.1);
        assertEquals(10.00, div1.get(0, 2), 0.1);
        assertEquals(13.33, div1.get(1, 0), 0.1);
        assertEquals(16.66, div1.get(1, 1), 0.1);
        assertEquals(20.00, div1.get(1, 2), 0.1);


        assertEquals(-2.6, div2.get(0, 0), 0.1);
        assertEquals(-2.6, div2.get(0, 1), 0.1);
        assertEquals(-2.6, div2.get(0, 2), 0.1);
        assertEquals(-2.6, div2.get(1, 0), 0.1);
        assertEquals(-2.6, div2.get(1, 1), 0.1);
        assertEquals(-2.6, div2.get(1, 2), 0.1);



    }

    @Test
    void dot() {
        Matrix m1 = generateSample2x3Matrix();
        Matrix m2 = generate2x3MatrixFilledWith(5);
        m2.reshape(3, 2);


        Matrix dotProduct = m1.dot(m2);


        assertEquals(30, dotProduct.get(0, 0), 0.1);
        assertEquals(30, dotProduct.get(0, 1), 0.1);
        assertEquals(75, dotProduct.get(1, 0), 0.1);
        assertEquals(75, dotProduct.get(1, 1), 0.1);


        Matrix wrongSizeMatrix = generateSample2x2Matrix();
        try {
            m1.dot(wrongSizeMatrix);
            fail();
        }
        catch(RuntimeException e) {
            assertThat(e.getMessage(), is("Can only calculate dot product of matrices n x m and m x n"));
        }

    }

    @Test
    void frobenius() {

        Matrix m1 = generateSample2x3Matrix();
        double norm = m1.frobenius();

        assertEquals(9.5393,norm, 0.1);

    }
}