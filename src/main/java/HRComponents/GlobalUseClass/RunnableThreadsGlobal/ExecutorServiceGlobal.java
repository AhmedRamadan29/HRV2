package HRComponents.GlobalUseClass.RunnableThreadsGlobal;
import org.springframework.stereotype.Component;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
/**
 A global utility class for managing a fixed thread pool using Java's ExecutorService.
 This class provides methods for executing tasks,shutting down the executor service,
 and checking its termination status.
 @author YourName
 @since 1.0 */
@Component
public class ExecutorServiceGlobal{
    private ExecutorService executorService;
    /**
     Constructor for initializing the ExecutorService with a fixed thread pool.
     @param count the number of threads in the pool
     */
    public ExecutorServiceGlobal(int count){
        this.executorService=Executors.newFixedThreadPool(count);
    }
    /**
     Private constructor to prevent instantiation from outside the class.
     */
    private ExecutorServiceGlobal(){
    }
    /**
     Executes the given task in the executor service.
     @param task the Runnable task to be executed
     */
    public void executeTask(Runnable task){
        try{
            Future<?> future=executorService.submit(task);
            future.get();
        }catch(Exception exception){
            throw new RuntimeException("Error executing task",exception);
        }
    }
    /**
     Shuts down the executor service gracefully.
     If the executor service is not terminated within 200 milliseconds, it is forcefully shut down.
     */
    public void shutdownExecutorService(){
        executorService.shutdown();
        try{
            if(!executorService.awaitTermination(200,TimeUnit.MILLISECONDS)){
                executorService.shutdownNow();
            }
        }catch(InterruptedException e){
            executorService.shutdownNow();
            Thread.currentThread().interrupt();
        }
    }
    /**
     Checks if the executor service has terminated.
     @return true if the executor service has terminated, false otherwise
     */
    public boolean isTerminated(){
        return executorService.isTerminated();
    }
}
