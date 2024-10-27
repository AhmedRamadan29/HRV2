package HRComponents.Exceptions;
import java.util.List;
/**
 This record represents a ThreadExceptionHandel object that holds information about a thread's exception.
 @param ThreadID The unique identifier of the thread.
 @param ThreadName The name of the thread.
 @param CountTime The time taken for the thread to execute. */
public record ThreadExceptionHandel(long ThreadID,String ThreadName,long CountTime){
    /**
     Overrides the default toString method
     to provide a formatted string representation of the ThreadExceptionHandel object.
     @return A string representation of the ThreadExceptionHandel object.
     */
    @Override
    public String toString(){
        return "ThreadException !!!:=----------> ID::=("+ThreadID+") TreedName ::= "+ThreadName+"-------->CountTime ::=("+CountTime+")";
    }
    /**
     Retrieves a list of strings representing the toString method's output.
     @return A list of strings, where each string is a line from the toString method's output.
     */
    public List<String> getResult(){
        return this.toString().lines().toList();
    }
    /**
     Retrieves a list of strings representing the exception message.
     @param exception The exception object to retrieve the message from.
     @return A list of strings, where each string is a line from the exception message.
     */
    public List<String> getResult(Exception exception){
        return exception.getMessage().lines().toList();
    }
}

