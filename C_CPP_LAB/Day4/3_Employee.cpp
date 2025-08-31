/*

3:Consider that payroll software needs to be developed for computerization of
operations of an ABC organization. The organization has employees.
3.1. Construct a class Employee with following members using private access
specifies:
 Employee Id integer
 Employee Name string
 Basic Salary double
 HRA double
 Medical double=1000
 PF double
PT double
 Net Salary double
 Gross Salary double
Please use following expressions for calculations://Note:Don't accept HRA,PF PT from user
 * HRA = 50% of Basic Salary
* PF = 12% of Basic Salary
* PT = Rs. 200

3.2. Write methods to display the details of an employee and calculate the gross
and net salary.
* Goss Salary = Basic Salary + HRA + Medical
* Net Salary = Gross Salary – (PT + PF)

Create Object of employee class and assign values and display Details.

*/

#include<iostream>
using namespace std;

class Employee {
    private: 
        int id;
        string name;
        double basicSalary, netSalary, grossSalary;

         double HRA=0.5 * basicSalary;
         double PF = 0.12* basicSalary;
         double PT = 200.00;
         double Medical = 1000.00;

    public:

         Employee(int id, string name, double basicSalary){
            this-> id = id;
            this-> name = name;
            this-> basicSalary = basicSalary;
         }

         void calculate(){
            grossSalary = basicSalary + HRA + Medical;
            netSalary = grossSalary - (PT + PF);
         }


        void display(){
            cout<<"-------------- Employee Details"<<endl;
            cout<<"Employee ID: "<<id<<endl;
            cout<<"Employee Name: "<<name<<endl;
            cout<<"Employee Basic Salary: "<<this->basicSalary<<endl;
            cout<<"Employee Gross Salary: "<<grossSalary<<endl;
            cout<<"Employee Net Salary: "<<netSalary<<endl;

        }
};

int main(){
    Employee emp(1, "Kirtesh", 50000);
    emp.calculate();
    emp.display();

}
