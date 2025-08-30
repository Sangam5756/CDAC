#include <iostream>
using namespace std;

int main()
{

    int n;
    cout << "Enter the Size of Stack " << endl;
    cin >> n;
    int arr[n];
    int index = 0;
    int num;
    int ch;
    do
    {
        cout << "\n1.Push In stack " << endl;
        cout << "2.Pop From Stack " << endl;
        cout << "3.Display " << endl;
        cout << "Enter the Choice : ";
        cin >> ch;

        switch (ch)
        {
        case 1:
            // push
            {
                if (index == n)
                {
                    cout << "\n stack is Full" << endl;
                    break;
                }
                cout << "Enter the Array Element To add ";
                cin >> num;
                arr[index] = num;
                index++;
                break;
            }
        case 2:
        {
            if (index == 0)
            {
                cout << "Stack is Empty" << endl;
                break;
            }
            // get last element from the array

            cout << "\n Pop Element is :  " << arr[index - 1] << endl;
            index--;

            break;
        }
        case 3:
        {
            if (index == 0)
            {
                cout << "Stack Is Empty " << endl;
                break;
            }
            else
            {

                cout << "\n Elements in the stack " << endl;
                for (int i = 0; i < index; i++)
                {
                    cout << arr[i] << "  ";
                }
            }
            break;
        }
        default:
            cout << "Exited successfully From the Program" << endl;
            break;
        }

    } while (ch != 0);
}
