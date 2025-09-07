#include <iostream>
#include "Department.h"
#include "HRDepartment.h"
#include "FinanceDepartment.h"

#include <memory>
#include <vector>

using namespace std;

int main()
{

    // Department *dept[3];

    // // create object of hr department

    // Department *hr = new HRDepartment();
    // Department *fd = new FinanceDepartment();
    // // even though we created refernce of indirect referencing so Hr display getting called
    // hr->display(); // hr display
    // dept[0] = hr;

    // // will call the function without the virtual will see the behaviour
    // cout << " \n\nThe Display of Referece" << endl;
    // dept[0]->display(); // only calling to the Department Display print deptid and name || due to upcasting

    // return 0;

    // Will See Down Casting
    // Department *dept[3];

    // create object of hr department

    // Department *hr = new HRDepartment();
    // Department *fd = new FinanceDepartment();

    // dept[0] = hr;
    // dept[1] = fd;

    // we are getting error as Department has no method conductsinterivew
    //  as it present on HrDepartment but compiler goes by type of reference not object type
    // so we need to do rtti so at runtime will called the method of HrDepartment by doing downcasting

    // dept[0]->conductInterview(); // error department no method conductInterview

    // downcasting becasue to call specific method of the class
    // auto p = dynamic_cast<HRDepartment *>(dept[0]);
    // p->conductInterviews();

    // delete hr;
    // delete fd;

    // using the Unique ptr smart pointers

    vector<unique_ptr<Department>> dept;
    unique_ptr<Department> hr = make_unique<HRDepartment>();
    unique_ptr<Department> fd = make_unique<FinanceDepartment>();

    dept.push_back(make_unique<HRDepartment>());
    // dept.push_back(fd);
    dept[0]->display();

        return 0;
}