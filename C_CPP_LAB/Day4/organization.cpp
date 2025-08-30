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