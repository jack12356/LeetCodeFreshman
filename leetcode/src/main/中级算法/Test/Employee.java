package Test;

import TreeNode.TreeNode;


public interface Employee {
    TreeNode t = new TreeNode(0);
    public  void addEmployee(Employee employee); //定义添加员工信息的方法；
    public  void updateEmployee( Employee employee);
}

//import com.lin.bean.Employee;
//public interface EmployeeDAO {
//    public  void addEmployee(Employee employee){
//
//    }; //定义添加员工信息的方法；
//    public  void updateEmployee( Employee employee);
//
//}