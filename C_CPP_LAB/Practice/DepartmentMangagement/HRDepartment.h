#ifndef HRDEPARTMENT_H
#define HRDEPARTMENT_H

#include <iostream>
#include "Department.h"

class HRDepartment : public Department
{
    int num_recruiters, open_positions;

public:
    HRDepartment();
    void virtual conductInterviews() const;
    virtual void accept();
    virtual void display() const;
};

#endif
