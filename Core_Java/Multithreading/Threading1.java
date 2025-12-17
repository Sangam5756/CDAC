public class Threading1 {

    


    public static void main(String[] args) {

        MyTask task = new MyTask();
        MyTask task1 = new MyTask();

        task.start();
        task1.start();



    }


}


class MyTask extends Thread{

    @Override
    public void run(){
        for(int i=0;i<=5;i++){
            System.out.println(Thread.currentThread().getName()+" -> "+i);
        }
    }


}