package com.bittech;


import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.AbstractQueuedSynchronizer;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;

class NewbeeLock implements Lock{
    private Sync sync = new Sync();

   //内部静态类继承AQS，覆写protected方法
    static class Sync extends AbstractQueuedSynchronizer{

        @Override
        //规定同步状态为1
        protected boolean tryAcquire(int arg){
            if (arg != 1) {
                throw new RuntimeException("arg不为1");
            }
            if (compareAndSetState(0,1)){
                //当前线程成功获取到锁
                setExclusiveOwnerThread(Thread.currentThread());
                return true;
            }
            return false;
        }

        @Override
        protected boolean tryRelease(int arg){
            if (getState() == 0){
                throw new IllegalMonitorStateException();
            }
            setExclusiveOwnerThread(null);
            setState(0);
            return true;
        }

        @Override
        protected boolean isHeldExclusively(){
            return getState() == 1;
        }
    }
    //Lock接口方法------------------------------
    @Override
    public void lock() {
        sync.acquire(1);
    }

    @Override
    public void  lockInterruptibly() throws InterruptedException{
        sync.acquireInterruptibly(1);
    }

    @Override
    public boolean tryLock() {
        return sync.tryAcquire(1);
    }

    @Override
    public boolean tryLock(long time, TimeUnit unit) throws InterruptedException {
        return sync.tryAcquireNanos(1,time);
    }

    @Override
    public void unlock() {
        sync.release(1);
    }

    @Override
    public Condition newCondition() {
        return null;
    }
    //-----------------------------------------
}

class LockThread implements Runnable{

    Lock lock = new NewbeeLock();
    @Override
    public void run() {


      try{
          lock.lock();
          Thread.sleep(10000);
      } catch (InterruptedException e) {
          e.printStackTrace();
      } finally {
          lock.unlock();
      }
    }

}
public class TestLock {
    public static void main(String[] args) {
        LockThread lt = new LockThread();
        for (int i = 0; i < 10 ; i++) {
           Thread thread = new Thread(lt);
           thread.start();
        }
    }
}
