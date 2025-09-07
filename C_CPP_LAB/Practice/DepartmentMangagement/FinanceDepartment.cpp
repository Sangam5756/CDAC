#include <iostream>
#include "FinanceDepartment.h"

using namespace std;

void FinanceDepartment::generateFinancialReport()
{
    cout << "Report Generated Successfully And Sent via Email ";
}

// constructor implementation
void FinanceDepartment::accept()
{
    Department::accept();
    cout << "Enter the Budget : ";
    cin >> budget;
}

void FinanceDepartment::display() const
{
    Department::display();
    cout << "The Budget is : " << budget << endl;
}

// to avoid garbage values always intialize the members with appropriate values
FinanceDepartment::FinanceDepartment()
{
    budget = 0;
}
