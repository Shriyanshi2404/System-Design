package LLD_Concepts.StructuralDesignPattern.Proxy_Pattern.ConcreteClass;

import LLD_Concepts.StructuralDesignPattern.Proxy_Pattern.Interface.EmployeeDao;
import LLD_Concepts.StructuralDesignPattern.Proxy_Pattern.model.EmployeeDO;

public class EmployeeDaoImpl implements EmployeeDao {

    @Override
    public void getEmployeeInfo(int empID)
    {
        System.out.println("Fetching employee info for ID: " + empID);
    }

    @Override
    public void createEmployee(EmployeeDO empObj)
    {
        System.out.println("Creating new employee");
    }
}
