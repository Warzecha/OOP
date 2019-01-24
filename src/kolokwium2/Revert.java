package kolokwium2;


import java.util.concurrent.Semaphore;

public class Revert {


    static double[] array;

    static Semaphore sem = new Semaphore(0);


    static void initArray(int size){
        array = new double[size];
        for(int i=0;i<size;i++){
            array[i]= i+1;
        }
    }


    static class RevertCalc extends Thread{
        private final int start;
        private final int end;

        RevertCalc(int start, int end){
            this.start = start;
            this.end=end;
        }
        public void run(){


            for(int i = 0; i < (end - start)/2; i++) {

                double buff = array[start + i];
                array[start + i] = array[end - i - 1];
                array[end - i-1] = buff;


            }

            sem.release();

        }
    }


    static void parallelRevert(int cnt) throws InterruptedException {

        RevertCalc threads[]=new RevertCalc[cnt];
        int step = (array.length) / cnt;

        for (int i=0; i < cnt; i++) {
            threads[i] = new RevertCalc(i * step, (i + 1) * step);
        }



        for(RevertCalc rc : threads) {
            rc.start();
        }
        sem.acquire(cnt);


        for (int i=0; i < cnt; i++) {
//            threads[i] = new RevertCalc(i * step, (i + 1) * step);

            for (int j = 0; j < array.length / cnt; j++) {

            }

        }




    }


    public static void main(String[] args) {
        initArray(1000);

        try {
            parallelRevert(10);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }


        System.out.println(array);

        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i] + ", ");
        }

    }


}
