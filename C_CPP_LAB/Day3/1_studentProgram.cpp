// 1:Write a program to create student class with data members rollno, marks1,mark2,mark3.
// Accept data (acceptInfo()) and display  using display member function.
// Also display total,percentage and grade.
#include <iostream>
using namespace std;

class Student
{
    int rollno;
    double marks1, marks2, marks3;
    double total, percentage;
    char grade;

    void calculateAcedemics()
    {
        total = marks1 + marks2 + marks3;
        percentage = (total / 300.0) * 100;
        if (percentage >= 80)
        {
            grade = 'A';
        }
        else if (percentage >= 70)
        {
            grade = 'B';
        }
        else
        {
            grade = 'C';
        }
    }

public:
    Student() : rollno(101), marks1(80), marks2(60), marks3(90) {};
    void acceptInfo(int rollno, float marks1, float marks2, float marks3)
    {
        this->rollno = rollno;
        this->marks1 = marks1;
        this->marks2 = marks2;
        this->marks3 = marks3;
    }

    void display();
};

void Student::display()
{
    cout << "Roll No: " << rollno << endl;
    cout << "Marks 1: " << marks1 << endl;
    cout << "Marks 2: " << marks2 << endl;
    cout << "Marks 3: " << marks3 << endl;
    calculateAcedemics();
    cout << "Total : " << total << endl;
    cout << "Percentage : " << percentage << endl;
    cout << "Grade : " << grade << endl;
}

int main()
{
    Student s1;
    s1.acceptInfo(101, 75, 80, 90);
    s1.display();

    return 0;
}