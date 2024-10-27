package HRComponents.GlobalProjectPattern.RunnableThreadsGlobal;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import java.util.concurrent.ForkJoinPool;
@Component
@Scope("prototype")
public class ForkBoolTreed{
    /**
     Private constructor to prevent instantiation of this utility class.
     */
    private ForkBoolTreed(){}
    /**
     Creates a new {@link ForkJoinPool} instance with the specified number of threads.
     @param count the number of threads in the pool
     @return a new {@link ForkJoinPool} instance
     */
    public ForkJoinPool CreateFork(int count){
        return new ForkJoinPool(count);
    }
}
