#include <iostream>
using namespace std;
#define PI 3.14

inline int AreaOfsquare(int side)
{
    return side * side;
}

inline int AreaOfRectangel(int length, int breadth)
{
    return length * breadth;
}

inline float AreaOfCircle(float rad)
{
    return PI * rad * rad;
}

int main()
{

    int n, choice;

    do
    {
        cout << "1.Calculate Area of Square \n2.Calculate Area of Rectangle \n3.Calculate Area of circle \n";
        cout << "Enter the Choice : ";
        cin >> choice;

        switch (choice)
        {

        case 1:
        {
            cout << "Enter the Side to Calculate the area of Square : ";
            cin >> n;
            int areaSquare = AreaOfsquare(n);
            cout << "Area of Square is :" << areaSquare << endl;
            break;
        }
        case 2:
        {
            int length, breadth;
            cout << "Enter the length of Rectangle : ";
            cin >> length;
            cout << "Enter the breadth of Rectangle : ";
            cin >> breadth;
            int areaRect = AreaOfRectangel(length, breadth);
            cout << "Area of Rectangle is :" << areaRect << endl;
            break;
        }
        case 3:
        {
            float n = 0;
            cout << "Enter the Radius to calculate area of circle : ";
            cin >> n;
            float areaCircle = AreaOfCircle(n);
            cout << "Area of Rectangle is :" << areaCircle << endl;
        }
        case 4:
            cout << "Exited from program" << endl;
            break;

        default:
            cout << "Invalid Choice" << endl;
            break;
        }

    } while (choice != 5);
}