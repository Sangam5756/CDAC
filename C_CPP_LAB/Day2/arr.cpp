#include <iostream>
#include <cmath>
using namespace std;

void output_array(int arr[], int n)
{
    cout << "Array is : ";
    for (int i = 0; i < n; i++)
    {
        cout << arr[i] << " ";
    }
}
void inputArray(int arr[], int n)
{
    for (int i = 0; i < n; i++)
    {
        cout << "The " << i << " element is: ";
        cin >> arr[i];
    }
}

void reverseArray(int arr[], int n)
{
    cout << "\nThe reverse array is : ";
    for (int i = n - 1; i >= 0; i--)
    {
        cout << arr[i] << " ";
    }
}

void swap(int arr[], int a, int b)
{
    int temp = arr[a];
    arr[a] = arr[b];
    arr[b] = temp;
}

void bubbleSort(int arr[], int n)
{
    cout << "Bubble Sort" << endl;

    for (int i = 0; i < n - 1; i++)
    {
        for (int j = i + 1; j < n; j++)
        {
            if (arr[i] > arr[j])
            { // 10 < 5
                swap(arr, i, j);
            }
        }
    }

    output_array(arr, n);
}

double secondLargest(int arr[], int n)
{

    double firstL = -INFINITY;
    double secondL = INFINITY;
    for (int i = 0; i < n; i++)
    {
        if (arr[i] > firstL)
        {
            secondL = firstL;
            firstL = arr[i];
        }
        else if (arr[i] > secondL && arr[i] != firstL)
        {
            secondL = arr[i];
        }
    }
    return secondL;
}

int main()
{
    int choice;
    int n=0;
    int *arr = new int[n];

    do
    {
        cout << "\n1.Input array \n2.Display the array \n3.sum and average of array \n4.Find Maximum and Minimum \n5.Search an Element (Linear Search)\n6.Reverse Array\n";
        cout << "Enter the Choice : ";
        cin >> choice;

        switch (choice)
        {
        case 1:
        {
            cout << "Enter the size of array : ";
            cin >> n;
            inputArray(arr, n);
            break;
        }
        case 2:
        {if(n ==0){
            cout<<"Array Is Empty"<<endl;
            break;
        }
            output_array(arr, n);
        }

        default:
            break;
        }

    } while (choice != 0);

    // reverseArray(arr, n);

    // bubbleSort(arr,n);
    double large = secondLargest(arr, n);
    cout << "Second Largest is : " << large;

    // output_array(arr,n);
}