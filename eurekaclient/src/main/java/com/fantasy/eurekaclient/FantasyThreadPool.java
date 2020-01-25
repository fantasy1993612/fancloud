package com.fantasy.eurekaclient;



public class FantasyThreadPool implements Runnable{
    protected int countDown = 10;
    private static int taskCount = 0;
    private final int id = taskCount++;
    public FantasyThreadPool(){

    }

    public FantasyThreadPool(int countDown){
        this.countDown = countDown;
    }

    public String status(){
        return "#"+id+"("+(countDown > 0 ? countDown : "liftoff")+")";
    }


    @Override
    public void run() {
        while(countDown -- > 0){
            System.out.println(status());
        }
    }

}
