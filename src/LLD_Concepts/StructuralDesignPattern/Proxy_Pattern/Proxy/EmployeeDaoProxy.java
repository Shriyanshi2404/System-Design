package LLD_Concepts.StructuralDesignPattern.Proxy_Pattern.Proxy;

import LLD_Concepts.StructuralDesignPattern.Proxy_Pattern.ConcreteClass.EmployeeDaoImpl;
import LLD_Concepts.StructuralDesignPattern.Proxy_Pattern.Interface.EmployeeDao;
import LLD_Concepts.StructuralDesignPattern.Proxy_Pattern.model.EmployeeDO;

public class EmployeeDaoProxy implements EmployeeDao {
    private EmployeeDao empDaoObj;
    private String clientRole;

    public EmployeeDaoProxy(String clientRole)
    {
        this.empDaoObj = new EmployeeDaoImpl();
        this.clientRole = clientRole;
    }

    @Override
    public void getEmployeeInfo(int empId)
    {
        if(clientRole.equals("ADMIN") || clientRole.equals("USER"))
        {
            System.out.println("Client role is: " + clientRole + " so granting the access to fetch the data about employe with id : "+ empId);
            empDaoObj.getEmployeeInfo(empId);
        }
        else
            throw new RuntimeException("Access denied");
    }
    @Override
    public void createEmployee(EmployeeDO empObj)
    {
        if(clientRole.equals("ADMIN"))
        {
            System.out.println("Client role is: " + clientRole + " so granting the access to create the employee");
            empDaoObj.createEmployee(empObj);
        }
        else
            throw new RuntimeException("Access denied");
    }
}
