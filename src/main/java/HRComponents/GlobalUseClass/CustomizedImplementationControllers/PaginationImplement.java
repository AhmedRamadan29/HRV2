package HRComponents.GlobalUseClass.CustomizedImplementationControllers;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.stream.Collectors;
@Component
public class PaginationImplement<T> implements Cloneable{
    private static PaginationImplement paginationImplement=null;
    private PaginationImplement(){
    }
    /**
     Returns a singleton instance of the PaginationImplement class.
     @param <T> the type of elements in the pagination
     @return a singleton instance of PaginationImplement for the specified type
     */

    public static <T> PaginationImplement<T> getInstance(){
        if(paginationImplement==null)
            paginationImplement=new PaginationImplement<>();
        return (PaginationImplement<T>)paginationImplement;
    }
    /**
     Paginates a list by returning a sublist corresponding to the specified page and page size.
     @param list the list to be paginated; must not be null or empty
     @param page the zero-based page index to retrieve
     @param pageSize the number of items per page
     @return a sublist of the original list representing the specified page
     @throws NoSuchElementException if the list is null or empty
     */
    private List<T> paginate(List<T> list,long page,long pageSize){
        if(list==null||list.isEmpty())
            throw new NoSuchElementException("The page is empty or null");
        return list.stream().skip(page*pageSize).limit(pageSize).collect(Collectors.toList());
    }
    /**
     Overrides the clone method to provide a deep copy of the PaginationImplement object.
     This method is necessary to maintain the singleton pattern
     and prevent unintended modifications to the shared instance.
     @return a deep copy of the PaginationImplement object
     @throws CloneNotSupportedException if the object's class does not support the Cloneable interface
     */

    @Override
    protected PaginationImplement<T> clone() throws CloneNotSupportedException{
        return (PaginationImplement<T>)super.clone();
    }
    public List<T> createPagination(List<T> list,long page,long pageSize){
        return this.paginate(list,page,pageSize);
    }
}