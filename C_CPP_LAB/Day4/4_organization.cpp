/*
1 Solve this.
Fresh business scenario to apply inheritance , polymorphism   to emp based organization scenario.

Create Emp based organization structure --- Emp , Mgr , Worker


1.1 Emp state--- id(int), name, deptId , basicSalary(double)
Accept all of above in constructor arguments.

Methods ---
1.2. compute net salary ---ret 0
(eg : public double computeNetSalary(){return 0;})

1.2 Mgr state  ---id,name,basic,deptId , perfBonus
Add suitable constructor
Methods ----
1. compute net salary (formula: basic+perfBonus) -- override computeNetSalary


1.3 Worker state  --id,name,basic,deptId,hoursWorked,hourlyRate
Methods : 
1.  compute net salary (formula:  = basic+(hoursWorked*hourlyRate) --override computeNetSalary
2. get hrlyRate of the worker  -- add a new method to return hourly rate of a worker.(getter)

Create suitable array to store organization details.
Provide following options
1. Hire Manager
I/P : all manager details

2. Hire Worker  
I/P : all worker details

3. Display information of all employees net salary (by invoking computeNetSal), 

4. Exit
----------------------------------------------------
*/




#include <iostream>
using namespace std;

class Emp
{
    int id;
    string name;
    int deptId;

protected:
    double basicSalary;

public:
    Emp()
    {
        id = 101;
    name:
        "EmployeeName";
    deptId:
        1001;
    }
    Emp(int id, string name, int deptId, double basicSalary)
    {
        this->id = id;
        this->name = name;
        this->deptId;
        this->basicSalary = basicSalary;
    }

    double computeNetSalary() { return 0; }
};

class Mgr : public Emp
{
    int perfBonus;

public:
    Mgr(int id, string name, int deptId, double basicSalary, int perfBonus) : Emp(id, name, deptId, basicSalary)
    {
        this->perfBonus = perfBonus;
    }

    double computeNetSalary()
    {
        int salary = basicSalary + perfBonus;
        cout << "Salary of Manager is " << salary;
        return salary;
    }
};

class Worker : public Emp
{
    int hoursWorked, hourlyRate;

public:
    Worker(int id, string name, int deptId, double basicSalary, int hourlyRate, int hoursWorked) : Emp(id, name, deptId, basicSalary)
    {
        this->hourlyRate = hourlyRate;
        this->hoursWorked = hoursWorked;
    }

    double computeNetSalary()
    {
        double salary = basicSalary + (hoursWorked * hourlyRate);
        cout << "Workers Salary :" << salary;
        return salary;
    }

    int getHrlyRate()
    {
        return hourlyRate;
    }
};

int main()
{

    Mgr mg(1, "mg", 101, 200000, 30000);

    mg.computeNetSalary();
    cout << endl;
    Worker w(2, "worker", 102, 30000, 1000, 7);

    int rate = w.getHrlyRate();
    cout << "Worker hourly Rate : " << rate;
    cout << endl;
    w.computeNetSalary();

    Emp employee[5];

    employee[0] = mg;

    employee[0].computeNetSalary();
}