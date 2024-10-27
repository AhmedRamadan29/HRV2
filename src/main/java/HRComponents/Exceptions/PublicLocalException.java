package HRComponents.Exceptions;
public class PublicLocalException extends Exception{
    public PublicLocalException(String ExceptionMessageClass,String ExceptionMessage){
        super(ExceptionMessageClass+"::=------------->"+ExceptionMessage);
    }
}
