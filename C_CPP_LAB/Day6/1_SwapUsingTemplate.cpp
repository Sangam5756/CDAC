// 🔹 Basic Template Assignments
// Function Template – Swap
//  Write a function template swapValues() that swaps two variables of any type.
// Test with int, double, and string.


#include<iostream>
using namespace std;


template<class T>
void cswap(T&a, T&b){
    T temp = a;
    a = b;
    b = temp;
}

int main(){
    int a = 5, b = 6;
    cout<<"Before swap of a is "<<a<<" and b is "<<b<<endl;
    cswap(a, b);
    cout<<"Before swap of a is "<<a<<" and b is "<<b<<endl;
    return 0;
}