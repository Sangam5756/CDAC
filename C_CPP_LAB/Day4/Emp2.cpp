// 2:Create Employee class with members id(int),name(string),dob(Date).Use above created Date class.
// Write default and parameterised constructor in Employee Class.Write accept() function to accept information and display() to display emp information.

#include <iostream>

using namespace std;


class Date {
    int day, month, year;

    public:
     Date(){
        day = 10;
        month = 6;
        year = 2025;
    }
       Date(int day, int month, int year){
        this-> day = day;
        this-> month = month;
        this-> year = year;
    }

    void setDob(int day, int month, int year){
        this-> day = day;
        this-> month = month;
        this-> year = year;
    }
\
    void display(){
        cout<<day<<"-"<<month<<"-"<<year<<endl;
    }

};
class Employee{
    int id;
    string name;
    Date dob;

    public:
        Employee(){
            id=1;
            name="test";
        }

    void acceptInfo(int id, string name,Date dob){
        this->id=id;
        this->name=name;
        this->dob=dob;
    }

    void display(){
        cout<<id<<name;
        dob.display();
    }

};


int main(){
    Employee emp;
    emp.display();
    Date dob;
    dob.setDob(12,12,2025);

    emp.acceptInfo(12,"employeeName",dob);
    emp.display();
}
