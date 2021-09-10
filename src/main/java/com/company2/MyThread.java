package com.company2;
public class MyThread extends Thread
{
    
    public Object lock = this;
    public boolean pause = false;

    public void pause ()
    {
        pause = true;
    }

    public void continue_ ()
    {
        pause = false;

        synchronized (lock)
        {
            lock.notifyAll();
        }
    }
    
    private void pauseThread ()
    {
        synchronized (lock)
        {
            if (pause){
                try{
                    lock.wait(); // Note that this can cause an InterruptedException
                }
                catch (InterruptedException e){
                    e.printStackTrace();
                }
            }
        }
    }
    public void run ()
    {
        for(int i=0; i < 3; i++){
            System.out.println(i);
            pauseThread();
            //continue_();
        }
    }
}




