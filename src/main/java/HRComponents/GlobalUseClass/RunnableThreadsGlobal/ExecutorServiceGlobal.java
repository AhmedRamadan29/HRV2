package HRComponents.GlobalUseClass.RunnableThreadsGlobal;
import HRComponents.Exceptions.PublicLocalException;
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
    /**
     This function creates a fixed thread pool with the specified number of threads.
     If the thread pool is already created and not shutdown, it will be shut down and a new one will be created.
     @param countThreads The number of threads to be created in the thread pool.
     @throws IllegalStateException If an unexpected value is encountered while determining the state of the thread pool.
     */
    public void createThreads(int countThreads){
        if(executorService!=null&&!executorService.isShutdown()){
            executorService.shutdownNow();
        }
        this.StateTerminatedThreads=(executorService!=null&&executorService.isTerminated())?0:1;
        this.CurrentThread=switch(StateTerminatedThreads){
            case 0 -> Executors.newFixedThreadPool(countThreads);
            case 1 -> {
                assert executorService!=null;
                executorService.shutdownNow();
                yield Executors.newFixedThreadPool(countThreads);
            }
            default -> throw new IllegalStateException("Unexpected value: "+StateTerminatedThreads);
        };
        this.executorService=CurrentThread;
    }
    /**
     Executes the given task using the ExecutorService.
     @param task The Runnable task to be executed.
     @throws PublicLocalException If the ExecutorService is not valid or has been shutdown.
     <p>
     This function submits the given task to the ExecutorService for execution.
     If the ExecutorService is not valid (i.e., it is null or has been shutdown),
     a PublicLocalException is thrown with an appropriate error message.
     <p>
     The error message includes the current thread's ID and name,
     as well as a suggestion to check the thread connection or initialize a new thread.
     */
    public void executeTask(Runnable task) throws PublicLocalException{
        if(executorService!=null&&!executorService.isShutdown()){
            executorService.submit(task);
        }else{
            throw new PublicLocalException("executeTask: Thread ID = "+Thread.currentThread().getId()+", Thread Name = "+Thread.currentThread().getName(),"ExecutorService is not valid. Check the thread connection or initialize a new thread ");
        }
    }
    /**
     Shuts down the ExecutorService gracefully.
     @throws PublicLocalException If the ExecutorService is not valid or has been shutdown.
     <p>
     This function attempts to gracefully shut down the ExecutorService by calling shutdown().
     If the ExecutorService is not valid (i.e., it is null or has been shutdown),
     a PublicLocalException is thrown with an appropriate error message.
     <p>
     If the shutdown is not immediate, the function waits for up to 5 seconds for the ExecutorService to terminate.
     If the ExecutorService does not terminate within the specified time, it is forcefully shut down using shutdownNow().
     <p>
     The error message includes the current thread's ID and name,
     as well as a suggestion to check the thread connection or initialize a new thread.
     */
    public void shutdownThread() throws PublicLocalException{
        if(executorService!=null&&!executorService.isShutdown()){
            executorService.shutdown();
            try{
                if(!executorService.awaitTermination(5,TimeUnit.SECONDS)){
                    executorService.shutdownNow();
                    throw new PublicLocalException("Check Thread ID :="+Thread.currentThread().getId()+"  Name := "+Thread.currentThread().getName(),"Thread was AwaitTermination");
                }
            }catch(InterruptedException e){
                executorService.shutdownNow();
                Thread.currentThread().interrupt();
                throw new PublicLocalException("Check Thread ID :="+Thread.currentThread().getId()+"   Name := "+Thread.currentThread().getName(),"Thread was interrupted during shutdown");
            }
        }
    }
    public ReentrantLock ReentrantLock(){
        return this. reentrantLock;
    }
}
