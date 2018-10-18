package lab2.matrix;


public class Matrix {
    double[]data;
    private int rows;
    private int cols;


    Matrix(int rows, int cols)
    {
        this.rows = rows;
        this.cols = cols;
        data = new double[rows*cols];
    }

    public Matrix(double[][] d)
    {
        this.rows = d.length;
        this.cols = d[0].length;

        this.data = new double[this.rows * this.cols];

        for(int i = 0; i < this.rows; i++)
        {
            for (int j = 0; j < this.cols; j++)
            {
                this.data[i * this.cols + j] = d[i][j];
            }
        }
    }


    public double[][] asArray()
    {
        double to_return[][] = new double[this.rows][this.cols];

        for(int i = 0; i < this.rows; i++)
        {
            for (int j = 0; j < this.cols; j++)
            {
                to_return[i][j] = this.data[i * this.cols + j];
            }
        }

        return to_return;
    }

    public int getRows() {
        return rows;
    }

    public int getCols() {
        return cols;
    }


    public void setRows(int rows) {
        this.rows = rows;
    }

    public void setCols(int cols) {
        this.cols = cols;
    }


    double get(int r,int c) {
        return this.data[this.rows * r + c];
    }
    void set (int r,int c, double value) {
        this.data[this.rows * r + c] = value;
    }

    public String toString(){
        StringBuilder buf = new StringBuilder();
        buf.append("[");
        for(int i=0;i<rows;i++){
            buf.append("[");
            for (int j=0; j<cols; j++)
            {
                buf.append(data[rows * i + j]);
                buf.append(", ");
            }
            buf.deleteCharAt(buf.length()-2);
            buf.append("]\n");
        }

        buf.deleteCharAt(buf.length()-1);
        buf.append("]");
        return buf.toString();
    }


    public void reshape(int newRows,int newCols){
        if(rows*cols != newRows*newCols)
            throw new RuntimeException(String.format("%d x %d matrix can't be reshaped to %d x %d",rows,cols,newRows,newCols));
        else {
            this.rows = newRows;
            this.cols = newCols;

        }

    }

    public int[] shape() {
        int[] shape = new int[2];
        shape[0] = rows;
        shape[1] = cols;
        return shape;
    }


    public Matrix add(Matrix m) {

        if (this.shape() == m.shape())
            throw new RuntimeException("Can not add matrices of different shapes");

        Matrix newMatrix = new Matrix(this.rows, this.cols);
        double[] newData = this.data.clone();

        for(int i=0; i<newData.length; i++) {
            newData[i] += m.data[i];
        }

        newMatrix.data = newData;
        return newMatrix;
    }


    public Matrix sub(Matrix m) {

        if (this.shape() == m.shape())
            throw new RuntimeException("Can not subtract matrices of different shapes");

        Matrix newMatrix = new Matrix(this.rows, this.cols);

        double[] newData = this.data.clone();
        for(int i=0; i<newData.length; i++) {
            newData[i] -= m.data[i];
        }

        newMatrix.data = newData;
        return newMatrix;
    }

    public Matrix mul(Matrix m) {

        if (this.shape() == m.shape())
            throw new RuntimeException("Can not multiply matrices of different shapes");

        Matrix newMatrix = new Matrix(this.rows, this.cols);

        double[] newData = this.data.clone();
        for(int i=0; i<newData.length; i++) {
            newData[i] *= m.data[i];
        }

        newMatrix.data = newData;
        return newMatrix;
    }

    public Matrix div(Matrix m) {

        if (this.shape() == m.shape())
            throw new RuntimeException("Can not divide matrices of different shapes");

        Matrix newMatrix = new Matrix(this.rows, this.cols);

        double[] newData = this.data.clone();
        for(int i=0; i<newData.length; i++) {
            newData[i] /= m.data[i];
        }

        newMatrix.data = newData;
        return newMatrix;
    }



    public Matrix add(double w){
        Matrix newMatrix = new Matrix(this.rows, this.cols);

        double[] newData = this.data.clone();
        for(int i=0; i<newData.length; i++) {
            newData[i] += w;
        }

        newMatrix.data = newData;
        return newMatrix;

    }

    public Matrix sub(double w){
        Matrix newMatrix = new Matrix(this.rows, this.cols);

        double[] newData = this.data.clone();
        for(int i=0; i<newData.length; i++) {
            newData[i] -= w;
        }

        newMatrix.data = newData;
        return newMatrix;

    }


    public Matrix mul(double w){
        Matrix newMatrix = new Matrix(this.rows, this.cols);

        double[] newData = this.data.clone();
        for(int i=0; i<newData.length; i++) {
            newData[i] *= w;
        }

        newMatrix.data = newData;
        return newMatrix;

    }



    public Matrix div(double w){
        Matrix newMatrix = new Matrix(this.rows, this.cols);

        double[] newData = this.data.clone();
        for(int i=0; i<newData.length; i++) {
            newData[i] /= w;
        }

        newMatrix.data = newData;
        return newMatrix;

    }



    public Matrix dot(Matrix other) {
        if (this.getRows() != other.getCols() || this.getCols() != other.getRows())
            throw new RuntimeException("Can only calculate dot product of matrices n x m and m x n");


        return new Matrix(2,2);
    }




}