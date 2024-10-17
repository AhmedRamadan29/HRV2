package HRComponents.GlobalUseClass.RunnableThreadsGlobal;
import HRComponents.Exceptions.PublicLocalException;
import HRComponents.Exceptions.ThreadExceptionHandel;
import org.apache.commons.lang3.time.StopWatch;
import org.springframework.stereotype.Component;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReentrantLock;
@Component
public class ExecutorServiceGlobal{
    int StateTerminatedThreads;
    private ExecutorService executorService;
    private ExecutorService CurrentThread;
    private ReentrantLock reentrantLock;
    private boolean boundsTime;
    private boolean checkTerminated;
    private StopWatch stopWatch;
    /**
     This function is responsible for creating a specified number of threads using an ExecutorService.
     It also handles the termination of the ExecutorService and logs any exceptions
     that occur during the shutdown process.
     @param countThreads The number of threads to create.
     @throws InterruptedException If the current thread is interrupted while waiting for the ExecutorService to terminate.
     */
    public void createThreads(int countThreads) throws InterruptedException{
        this.boundsTime=executorService.awaitTermination(500,TimeUnit.MILLISECONDS);
        this.checkTerminated=executorService.isTerminated();
        if((executorService!=null)&&!(executorService.isShutdown())){
            if(!checkTerminated){
                stopWatch.start();
                assert boundsTime:executorService.shutdownNow();
                stopWatch.stop();
                new ThreadExceptionHandel(Thread.currentThread().getId(),Thread.currentThread().getName(),stopWatch.getTime()).getResult().forEach(System.out::println);
            }
        }
        this.StateTerminatedThreads=((executorService==null)&&(executorService.isShutdown())&&(this.checkTerminated))?0:1;
        switch(StateTerminatedThreads){
        case 0 -> Executors.newFixedThreadPool(countThreads);
        case 1 -> {
            stopWatch.start();
            assert executorService!=null:boundsTime;
            assert boundsTime:executorService.shutdownNow();
            assert !checkTerminated:executorService.shutdownNow();
            stopWatch.stop();
            new ThreadExceptionHandel(Thread.currentThread().getId(),Thread.currentThread().getName(),stopWatch.getTime()).getResult().forEach(System.out::println);
            assert executorService.isShutdown():checkTerminated;
        }
        default -> throw new IllegalStateException("Unexpected value: "+StateTerminatedThreads);
        }
    }
    /**
     Executes a given task using the ExecutorService.
     If the ExecutorService is not valid (i.e., it is null or shutdown),
     a PublicLocalException is thrown.
     @param task The Runnable task to be executed.
     @throws PublicLocalException If the ExecutorService is not valid.
     */
    public void executeTask(Runnable task) throws PublicLocalException{
        if(executorService!=null&&!executorService.isShutdown()){
            executorService.submit(task);
        }else{
            throw new PublicLocalException("executeTask: Thread ID = "+Thread.currentThread().getId()+", Thread Name = "+Thread.currentThread().getName(),"ExecutorService is not valid. Check the thread connection or initialize a new thread ");
        }
    }
    /**
     This function is responsible for shutting down the ExecutorService
     and handling any exceptions that may occur during the shutdown process.
     If the ExecutorService is not null and not shutdown,
     it will attempt to gracefully shut down the ExecutorService by calling the shutdown() method.
     If the ExecutorService does not terminate within 5 seconds,
     it will be forcefully shut down using shutdownNow() and a PublicLocalException will be thrown.
     If an InterruptedException occurs during the shutdown process, the ExecutorService will be forcefully shut down,
     the current thread will be interrupted, and a PublicLocalException will be thrown.
     @throws PublicLocalException If an exception occurs during the shutdown process.
     */
    public void shutdownThread() throws PublicLocalException{
        if(executorService!=null&&!executorService.isShutdown()){
            executorService.shutdown();
            try{
                if(!executorService.awaitTermination(5,TimeUnit.SECONDS)){
                    executorService.shutdownNow();
                    throw new PublicLocalException("Check Thread ID :="+Thread.currentThread().getId()+"  Name := "+Thread.currentThread().getName(),"Thread was AwaitTermination");
                }
            }catch(InterruptedException exception){
                executorService.shutdownNow();
                Thread.currentThread().interrupt();
                throw new PublicLocalException("Check Thread ID :="+Thread.currentThread().getId()+"Name := "+Thread.currentThread().getName()+" ::  Exception  := "+exception.getMessage(),"Thread was interrupted during shutdown");
            }
        }
    }
    public ReentrantLock ReentrantLock(){
        return this.reentrantLock;
    }
}
