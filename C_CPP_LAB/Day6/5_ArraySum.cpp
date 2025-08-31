// Function Template – Array Sum
//  Write a function template sumArray() that accepts an array of any type and returns the sum of its elements.

#include <iostream>
using namespace std;

template <class T>
void ArraySum(T arr[], int n)
{
    T sum = 0;
    for (int i = 0; i < n; i++)
    {
        sum += arr[i];
    }

    cout << "Array Sum is : " << sum << endl;
}

template <class T>
void printArray(T arr[], int n)
{
    for (int i = 0; i < n; i++)
    {
        cout << " " << arr[i];
    }
    cout << endl;
}

int main()
{
    int ch;
    int n;

    do
    {
        cout << "1.Integer Array" << endl;
        cout << "2.Double Array" << endl;
        cout << "3.Float Array" << endl;
        cout << "Enter the Choice : ";
        cin >> ch;
        switch (ch)
        {
        case 1:
        {
            cout << "Enter the Number of Elements" << endl;
            cin >> n;
            int arr[n];
            for (int i = 0; i < n; i++)
            {
                int temp;
                cout << "Enter the " << i + 1 << " th Element :";
                cin >> temp;
                arr[i] = temp;
            }
            // nested do while for printing the array and thise
            do
            {

                cout << "1.PrintArray" << endl;
                cout << "2.Arraysum" << endl;
                cout << "3.Go Back" << endl;
                cout << "Enter the choice :";
                cin >> ch;
                // nested switch
                switch (ch)
                {
                case 1:
                    printArray(arr, n);
                    break;
                case 2:
                    ArraySum(arr, n);
                case 3:
                    break;
                default:
                    break;
                }

            } while (ch != 3);
            break;
        }
        case 2:
        {
            cout << "Enter the Number of Elements" << endl;
            cin >> n;
            double arr[n];
            for (int i = 0; i < n; i++)
            {
                double temp;
                cout << "Enter the " << i + 1 << " th Element :";
                cin >> temp;
                arr[i] = temp;
            }
            // nested do while for printing the array and thise
            do
            {

                cout << "1.PrintArray" << endl;
                cout << "2.Arraysum" << endl;
                cout << "3.Go Back" << endl;
                cout << "Enter the choice :";
                cin >> ch;
                // nested switch
                switch (ch)
                {
                case 1:
                    printArray(arr, n);
                    break;
                case 2:
                    ArraySum(arr, n);
                case 3:
                    break;
                default:
                    break;
                }

            } while (ch != 3);
            break;
        }
        case 3:
        {
            cout << "Enter the Number of Elements" << endl;
            cin >> n;
            float arr[n];
            for (int i = 0; i < n; i++)
            {
                float temp;
                cout << "Enter the " << i + 1 << " th Element :";
                cin >> temp;
                arr[i] = temp;
            }
            // nested do while for printing the array and thise
            do
            {

                cout << "1.PrintArray" << endl;
                cout << "2.Arraysum" << endl;
                cout << "3.Go Back" << endl;
                cout << "Enter the choice :";
                cin >> ch;
                // nested switch
                switch (ch)
                {
                case 1:
                    printArray(arr, n);
                    break;
                case 2:
                    ArraySum(arr, n);
                case 3:
                    break;
                default:
                    break;
                }

            } while (ch != 3);
            break;
        }

        default:
            cout << "invalid choice" << endl;
            break;
        }

    } while (ch != 0);

    return 0;
}