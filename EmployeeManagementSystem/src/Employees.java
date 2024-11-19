/*
 * The purpose of this class is to get and set the data in the employee table in this class.
 */

import java.sql.Date;
import java.time.LocalDate;


public class Employees 
{
    private String _FName, _LName, _Email, _Division, _Job_Title;
    private int _Empid;
    private float _Salary;
    private LocalDate _hireDate;



    public Employees() 
    {
        this._FName = new String();
        this._LName = new String();
        this._Email = new String();
        this._Job_Title = new String();
        this._Empid = 0;
        this._Salary = 0;
        this._hireDate = null;
    }

    //public Employees(String _FName, String _LName, String _Email, String _Division, String _Job_Title, 
    //int _Empid, float _Salary, LocalDate _hireDate)
    
    public Employees(String _FName, String _LName, String _Email, String _Division, 
    int _Empid, float _Salary, LocalDate _hireDate)
    {
        this._FName = _FName;
        this._LName = _LName;
        this._Email = _Email;
        //this._Division = _Division;
        this._Job_Title = _Job_Title;
        this._Empid = _Empid;
        this._Salary = _Salary;
        this._hireDate = _hireDate;
    }

    public String getFname() 
    {
        return _FName;
    }

    public String getLName()
    {
        return _LName;
    }

    public String getEmail()
    {
        return _Email;
    }

    /* 
    public String getDivision()
    {
        return _Division;
    }
    */

    public String getJob_Title()
    {
        return _Job_Title;
    }
    

    public int getEmpid()
    {
        return _Empid;
    }

    public float getSalary()
    {
        return _Salary;
    }

    public void setFName(String _FName) {
        this._FName = _FName;
    }
    
    public void setLName(String _LName) {
        this._LName = _LName;
    }
    
    public void setEmail(String _Email) {
        this._Email = _Email;
    }
    
    /* 
    public void setDivision(String _Division) {
        this._Division = _Division;
    }
    */
    public void setJobTitle(String _Job_Title) {
        this._Job_Title = _Job_Title;
    }
    
    public void setEmpid(int _Empid) {
        this._Empid = _Empid;
    }
    
    public void setSalary(float _Salary) {
        this._Salary = _Salary;
    }
    
    public void setHireDate(LocalDate _hireDate) {
        this._hireDate = _hireDate;
    }
}
