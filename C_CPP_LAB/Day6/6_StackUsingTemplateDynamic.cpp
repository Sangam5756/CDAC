
//    6: Class Template – Stack
//  Implement a class template Stack<T> with functions:
// push(), pop(), peek(), isEmpty().
//  Test with int and string.
#include <iostream>
using namespace std;

template <typename T>
class CustomStack
{
    int index, n;
    T *arr;

public:
    CustomStack()
    {
        n = 5;
        index = 0;
        arr = new T[n];
    }
    CustomStack(int n)
    {
        this->n = n;
        index = 0;
        arr = new T[n];
    }
    // as we have created space in heap need to be clear
    ~CustomStack()
    {
        delete[] arr;
    }
    void resize()
    {
        int newCapacity = n * 2;
        T *newArr = new T[newCapacity];
        for (int i = 0; i < index; i++)
        {
            newArr[i] = arr[i];
        }
        delete[] arr;
        arr = newArr;
        n = newCapacity;
        cout << "Stack resized to capacity: " << n << endl;
    }
    bool isEmpty()
    {
        if (index == 0)
        {
            return true;
        }
        return false;
    }
    bool isFull()
    {
        return index == n;
    }
    void pop()
    {
        if (isEmpty())
        {
            cout << "Stack Is Empty" << endl;
        }
        else
        {

            T data = arr[index - 1];
            cout << "Number " << data << " poped at index: " << index << endl;
            index--;
        }
    }
    void push(T data)
    {
        if (index == n)
        {
            resize();
        }

        arr[index] = data;
        cout << "Number " << data << " pushed at index: " << index << endl;
        index++;
    }
    void peek()
    {
        cout << "Top Element is : " << arr[index - 1];
    }
    void display()
    {
        cout << endl;
        if (isEmpty())
        {
            cout << "Stack Is Empty" << endl;
        }
        else
        {

            for (int i = 0; i < index; i++)
            {
                cout << arr[i] << " ";
            }
        }
    }
};

int main()
{
    int capacity;
    cout << "Enter the Number Of Element to Store in stack : ";
    cin >> capacity;

    CustomStack<double> s(capacity);

    int ch;
    do
    {
        cout << "\nMenu\n1.Push in Stack\n2.Pop Element\n3.Display\n4.peek\n6.Exit" << endl;
        cout << "Enter your choice: ";
        cin >> ch;
        switch (ch)
        {
        case 1:
        {

            cout << "Enter element to push: ";
            double num;
            cin >> num;
            s.push(num);

            break;
        }
        case 2:
            s.pop();
            break;
        case 3:
            s.display();
            break;
        case 4:
            s.peek();
            break;
        default:
            cout << "Exit";
            break;
        }

    } while (ch != 6);

    return 0;
}