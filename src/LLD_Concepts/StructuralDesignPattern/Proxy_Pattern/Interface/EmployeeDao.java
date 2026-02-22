package LLD_Concepts.StructuralDesignPattern.Proxy_Pattern.Interface;

import LLD_Concepts.StructuralDesignPattern.Proxy_Pattern.model.EmployeeDO;

public interface EmployeeDao {
    void getEmployeeInfo(int empId);
    void createEmployee(EmployeeDO empObj);
}
