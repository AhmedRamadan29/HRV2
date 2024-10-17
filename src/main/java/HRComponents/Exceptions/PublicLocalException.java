package HRComponents.Exceptions;
public class PublicLocalException extends Exception{
    /**
     Constructs a new PublicLocalException with the specified exception message class and message.
     @param ExceptionMessageClass the class or module where the exception occurred
     @param ExceptionMessage the detailed message of the exception
     */
    public PublicLocalException(String ExceptionMessageClass,String ExceptionMessage){
        super(ExceptionMessageClass+"::=-->"+ExceptionMessage);
    }
}
