//  3: Class Template – Box
//  Implement a class template Box<T> that stores one value of any type and provides          getValue() and setValue() methods.


#include<iostream>
using namespace std;


template <class T>
class Box
{

    T a;

public:
    Box()
    {
        a = 10;
    }
    void setValueA(T a)
    {
        this->a = a;
    }
    T getValueA()
    {
        return a;
    }
};


int main(){
    Box <int> b1;
    b1.setValueA(100);
    cout<<"value of a is :"<<b1.getValueA();
}