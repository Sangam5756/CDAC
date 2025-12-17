public class Threading1 {

    


    public static void main(String[] args) {

        MyTask task = new MyTask();
        MyTask task1 = new MyTask();

        Thread t = new Thread(task);
        Thread t1 = new Thread(task1);

        t.start();
        t1.start();



    }


}


class MyTask implements Runnable{


     @Override
    public void run(){
        for(int i=0;i<=5;i++){
            System.out.println(Thread.currentThread().getName()+" -> "+i);
        }
    }
    
    


}