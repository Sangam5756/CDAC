#ifndef FINANCEDEPARTMENT_H
#define FINANCEDEPARTMENT_H
#include "Department.h"
#include <iostream>

class FinanceDepartment : public Department
{
    int budget;

public:
    void generateFinancialReport();
    void virtual display() const;
   virtual void accept();
    FinanceDepartment();
};

#endif