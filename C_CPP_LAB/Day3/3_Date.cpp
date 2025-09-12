// 3. Create a class Date with data members as dd, mm, yy. Write getters and setters for all the data members. Also add the display function. Create Default and Parameterized constructors. Create the object of this class in main method and invoke all the methods in that class. 

#include <iostream>
using namespace std;

class Date {
private:
    int dd;
    int mm;
    int yy;
public:
    Date() {
        dd = 15;
        mm = 3;
        yy = 2003;
    }
    Date(int d, int m, int y) {
        dd = d;
        mm = m;
        yy = y;
    }
    void setDay(int d) {
        dd = d;
    }
    void setMonth(int m) {
        mm = m;
    }
    void setYear(int y) {
        yy = y;
    }
    int getDay() {
        return dd;
    }
    int getMonth() {
        return mm;
    }
    int getYear() {
        return yy;
    }
    void display() {
        cout << "Date: " << dd << "/" << mm << "/" << yy << endl;
    }
};

int main() {
    Date d1;
    d1.display();
    d1.setDay(15);
    d1.setMonth(8);
    d1.setYear(2025);
    d1.display();
    Date d2(2, 9, 2025);
    d2.display();
    return 0;
}
