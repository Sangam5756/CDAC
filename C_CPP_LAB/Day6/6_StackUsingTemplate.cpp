
//    6: Class Template – Stack
//  Implement a class template Stack<T> with functions:
// push(), pop(), peek(), isEmpty().
//  Test with int and string.
#include <iostream>
using namespace std;

template<typename T> class CustomStack{
    // LIFO (last in first out)
    // Array for stack
    T index;
    T arr[5];

public:
    CustomStack()
    {
        index = 0;
    }
    void pop()
    {
        if (index == 0)
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
        if (index == 5)
        {
            cout << "Stack is Full" << endl;
        }
        else
        {

            arr[index] = data;
            cout << "Number " << data << " pushed at index: " << index << endl;
            index++;
        }
    }

    void display()
    {
        cout << endl;
        if (index == 0)
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

    CustomStack <double>s;
    int ch;
    do
    {
        cout << "\nMenu\n1.Push in Stack\n2.Pop Element\n3.Display\n4.Exit" << endl;
        cout << "Enter your choice: ";
        cin >> ch;
        switch (ch)
        {
        case 1:
            cout << "Enter element to push: ";
            double num;
            cin >> num;
            s.push(num);
            break;
        case 2:
            s.pop();
            break;
        case 3:
            s.display();
            break;
        default:
            cout << "Exit";
            break;
        }
    } while (ch != 4);

    return 0;
}