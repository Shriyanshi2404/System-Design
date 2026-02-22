package LLD_Concepts.StructuralDesignPattern.Proxy_Pattern.Client;

import LLD_Concepts.StructuralDesignPattern.Proxy_Pattern.Interface.EmployeeDao;
import LLD_Concepts.StructuralDesignPattern.Proxy_Pattern.Proxy.EmployeeDaoProxy;
import LLD_Concepts.StructuralDesignPattern.Proxy_Pattern.model.EmployeeDO;

public class EmployeeManagement {
    public static void main(String[] args)
    {
        System.out.println("===== Proxy Design Pattern =====");
        EmployeeDao adminProxy = new EmployeeDaoProxy("ADMIN");
        adminProxy.getEmployeeInfo(20);
        adminProxy.createEmployee(new EmployeeDO());
        EmployeeDao userProxy = new EmployeeDaoProxy("USER");
        userProxy.getEmployeeInfo(15);
        userProxy.createEmployee(new EmployeeDO()); // Access denied
    }
}
