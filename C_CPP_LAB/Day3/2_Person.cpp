// 2. Create a class Person with data members as name, age, city. Write getters and setters for all the data 
// members. Also add the display function. Create Default and Parameterized constructors. Create the 
// object of this class in main method and invoke all the methods in that class.

#include <iostream>
#include <string>
using namespace std;

class Person {
private:
    string name;
    int age;
    string city;
public:
    Person() {
        name = "";
        age = 0;
        city = "";
    }
    Person(string n, int a, string c) {
        name = n;
        age = a;
        city = c;
    }
    void setName(string n) {
        name = n;
    }
    void setAge(int a) {
        age = a;
    }
    void setCity(string c) {
        city = c;
    }
    string getName() {
        return name;
    }
    int getAge() {
        return age;
    }
    string getCity() {
        return city;
    }
    void display() {
        cout << "Name: " << name << endl;
        cout << "Age: " << age << endl;
        cout << "City: " << city << endl;
    }
};

int main() {
    Person p1;
    p1.setName("sangam");
    p1.setAge(21);
    p1.setCity("Pune");
    p1.display();
    Person p2("Tushar", 21, "Pune");
    p2.display();
    return 0;
}
