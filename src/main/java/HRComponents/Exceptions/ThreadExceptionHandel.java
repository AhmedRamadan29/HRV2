package HRComponents.Exceptions;
import java.util.List;
public record  ThreadExceptionHandel ( long ThreadID ,  String ThreadName , long CountTime){
    @Override
    public String toString() {return   "ThreadException !!!:=----------> ID::=("+ThreadID+") TreedName ::= "+ThreadName+"-------->CountTime ::=("+CountTime+")" ;}
    public List<String> getResult () {return this.toString().lines().toList();}

}

