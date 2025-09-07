#ifndef DEPARTMENT_H
#define DEPARTMENT_H

#include <iostream>

using namespace std;

class Department
{
private:
    int dept_Id;
    string dept_name;

public:
    Department();
     void virtual accept();
    void virtual display() const;
    ~Department() {};
};

#endif