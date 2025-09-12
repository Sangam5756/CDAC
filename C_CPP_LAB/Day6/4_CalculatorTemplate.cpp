//4 . Class Template – Calculator
//  Create a class template Calculator<T> with functions:
// add(), subtract(), multiply(), divide().
//  Test with int and double.

#include <iostream>

using namespace std;

template <class T>
class Calculator
{

    T result, a, b;
    string operation;

public:
    Calculator(T a, T b)
    {
        this->a = a;
        this->b = b;
    }
    T add()
    {
        operation = "Addition";
        result = a + b;
        return result;
    }
    T subtract()
    {
        operation = "Subtraction";
        result = a - b;
        return result;
    }
    T divide()
    {
        operation = "Divide";
        result = a / b;
        return result;
    }
    T multiply()
    {
        operation = "Multiply";
        result = a * b;
        return result;
    }

    void display()
    {
        cout << "Data type is " << typeid(a).name() << "  and Result of " << operation << " is : " << result << endl;
    }
};

int main()
{
    // create object and pass two value of any type
    // for int value
    Calculator c1(5, 10);
    c1.add();
    c1.display();

    c1.subtract();
    c1.display();

    c1.multiply();
    c1.display();

    c1.divide();
    c1.display();

    // for double value
    Calculator c2(34343.34343434, 1039334.343434);
    c2.add();
    c2.display();

    c2.subtract();
    c2.display();

    c2.multiply();
    c2.display();

    c2.divide();
    c2.display();

    return 0;
}
