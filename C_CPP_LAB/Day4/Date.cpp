/*
1:Create Date class with members day,month ,year.
Write no argument and parameterised constructor .Create two object s and initialize them using no argument and parameterised constructor
respectively.Print date using display function.
*/
#include<iostream>
using namespace std;

class Date {
    int day, month, year;

    public:
        Date(){
        cout<<"------- Default Constructor ----------"<<endl;
        day = 10;
        month = 6;
        year = 2025;
    }
        Date(int day, int month, int year){
        cout<<"------- Parameterized Constructor ----------"<<endl;

        this-> day = day;
        this-> month = month;
        this-> year = year;
    }


    void display(){
        cout<<"The DD-MM-YYYY: "<<day<<"-"<<month<<"-"<<year<<endl;
    }

};

int main(){
    Date dob;
    dob.display();

    Date dob2(27, 8, 2025);
    dob2.display();
}