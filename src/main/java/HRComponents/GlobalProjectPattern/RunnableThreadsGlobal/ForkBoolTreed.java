package HRComponents.GlobalProjectPattern.RunnableThreadsGlobal;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import java.util.concurrent.ForkJoinPool;
@Component
@Scope("prototype")
public class ForkBoolTreed{
private ForkBoolTreed (){}
 public ForkJoinPool CreateFork( int count) {return new ForkJoinPool(count);}
    
    
    
    
    





}
