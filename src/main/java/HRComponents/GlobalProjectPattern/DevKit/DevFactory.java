package HRComponents.GlobalProjectPattern.DevKit;
import HRComponents.AbstractionImp.CRUDImpService.CRUDImpServiceJoinsEntitys.UsersJoinSystemUsersMethod;
import HRComponents.AbstractionImp.CRUDImpService.CRUDImpServiceSingleEntity.CRUDUsersServiceMethod;
public abstract class DevFactory{
    abstract CRUDUsersServiceMethod crudUsersServiceMethod();
    abstract UsersJoinSystemUsersMethod usersJoinSystemUsersMethod();
}
