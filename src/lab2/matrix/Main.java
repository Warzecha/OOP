package lab2.matrix;

public class Main {

    public static void main(String[] args) {


        double[][] arr2d = new double[1][2];

        arr2d[0][0] = 1;
        arr2d[0][1] = 2;
//        arr2d[1][0] = 3;
//        arr2d[1][1] = 4;


        Matrix m = new Matrix(arr2d);

        Matrix m2 = m.add(2);


        Matrix dot = m.dot(m);



        System.out.print(dot);






    }


}




