// Function Template – Maximum
//  Write a function template findMax() that returns the maximum of two values.
// Test with int, float, and char.

#include <iostream>
using namespace std;

template <class T>
T findMax(T a, T b)
{
    return (a > b ? a : b);
}

int main()
{

    // using integer value
    int max = findMax(10, 12);
    cout << "Max of Integer Value :" << max << endl;
    // using Double
    double max1 = findMax(1000.4545, 12000.4545);
    cout << "Max of Double Value :" << max1 << endl;
    // using float value
    float max2 = findMax(100.23, 10.34);
    cout << "Max of Float Value :" << max2 << endl;

    char max3 = findMax('A', 'B');
    cout << "Max of Char is :" << max3 << endl;

    return 0;
}