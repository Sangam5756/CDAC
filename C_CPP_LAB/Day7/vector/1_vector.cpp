// 1:Create an application for storing int values in vector.
// Create menu drivin app for following menu;
// 1:add 2:show all 3:search 4:sort 5:reverse 6:clear

#include <iostream>
#include <vector>
#include <algorithm>
using namespace std;

int main()
{
    int ch;
    vector<int> v;
    int data;
    do
    {
        cout << "1. Add Values in Vector " << endl;
        cout << "2. Show All Values in Vector " << endl;
        cout << "3. Search in Vector " << endl;
        cout << "4.Sort " << endl;
        cout << "5.reverse " << endl;
        cout << "6.clear " << endl;
        cout << "Enter the Choice :";
        cin >> ch;
        switch (ch)
        {
        case 1:
            cout << "Enter the value :";
            cin >> data;
            v.push_back(data);
            break;
        case 2:
        {
            cout << "\nValues in vector \n"
                 << endl;
            for (int val : v)
            {
                cout << " " << val << " ";
            }
            cout << "\n------------------------------" << endl;
            break;
        }
        case 3:
        {
            cout << "Search in vector : ";
            cin >> data;
            bool flag = false;
            for (int val : v)
            {
                if (data == val)
                {
                    flag = true;
                }
            }
            if (flag)
            {

                cout << "\n Data Found \n"
                     << endl;
            }
            else
            {
                cout << "Not Found" << endl;
            }
            break;
        }
        case 4:
        {
            sort(v.begin(), v.end());
            break;
        }

        case 5:
            reverse(v.begin(), v.end());
            break;
        case 6:
            v.clear();
            break;
        default:
            break;
        }
    } while (ch != 0);

    return 0;
}