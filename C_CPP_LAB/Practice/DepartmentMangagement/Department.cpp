#include <iostream>
#include "Department.h"

using namespace std;


Department::Department()
{
    dept_Id = 101;
    dept_name = "Dept_name";
}

void Department::accept()
{
    cout << "Enter the DeptId : ";
    cin >> dept_Id;
    cout << endl;

    cout << "Enter the Dept name : ";
    cin >> dept_name;
}

void Department::display() const
{
    cout << "DeptId : " << dept_Id << "  " << "dept name : " << dept_name << endl;
}
