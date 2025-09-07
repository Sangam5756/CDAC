#include <iostream>
#include "HRDepartment.h"
using namespace std;

void HRDepartment::accept()
{
    Department::accept();
    cout << "Enter the No of Recruiters : ";
    cin >> num_recruiters;
    cout << "Enter the No open positions   : ";
    cin >> open_positions;
}

void HRDepartment::display() const
{
    Department::display();
    cout << "The No Of Recruiters are : " << num_recruiters;
    cout << "The No Of Open Position : " << open_positions;
}

void HRDepartment::conductInterviews() const
{

    cout << "[HR] Conducting interviews for " << open_positions << " positions." << endl;
}

HRDepartment::HRDepartment()
{
    num_recruiters = 0;
    open_positions = 0;
}
