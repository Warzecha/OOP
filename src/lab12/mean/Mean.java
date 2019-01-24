package lab12.mean;

import java.util.Locale;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

public class Mean {

    static double[] array;
    static BlockingQueue<Double> results = new ArrayBlockingQueue<Double>(100);

    static void initArray(int size){
        array = new double[size];
        for(int i=0;i<size;i++){
            array[i]= Math.random()*size/(i+1);
        }
    }



    static class MeanCalc extends Thread{
        private final int start;
        private final int end;
        double mean = 0;

        MeanCalc(int start, int end){
            this.start = start;
            this.end=end;
        }
        public void run(){

            for (int i = start; i < end; i++) {
                mean += array[i];
            }
            mean /= (end - start);
//            System.out.printf(Locale.US,"%d-%d mean=%f\n",start,end,mean);
            try {
                results.put(mean);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

    }



    static void parallelMean(int cnt) throws InterruptedException {
        // utwórz tablicę wątków
        MeanCalc threads[]=new MeanCalc[cnt];
        // utwórz wątki, podziel tablice na równe bloki i przekaż indeksy do wątków
        // załóż, że array.length dzieli się przez cnt)
        int step = (array.length) / cnt;

        for (int i=0; i < cnt; i++) {
            threads[i] = new MeanCalc(i * step, (i + 1) * step);
        }

        double t1 = System.nanoTime()/1e6;

        //uruchom wątki
        for(MeanCalc mc : threads) {
            mc.start();
        }
        double t2 = System.nanoTime()/1e6;

        // oblicz średnią ze średnich
        double mean = 0;
        for (int i = 0; i < cnt; i++) {
            mean = (mean*(i) + results.take()) / (i + 1);
        }
        double t3 = System.nanoTime()/1e6;



        System.out.printf(Locale.US,"size = %d cnt=%d >  t2-t1=%f t3-t1=%f mean=%f\n",
                array.length,
                cnt,
                t2-t1,
                t3-t1,
                mean);
    }




    public static void main(String[] args) {
        initArray(128000000);
        for(int cnt:new int[]{1,2,4,8,16,32,64,128}){
            try {
                parallelMean(cnt);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

    }



}