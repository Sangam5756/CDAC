#include <iostream>
#include "Room.h"
#include "StandardRoom.h"
#include "DeluxeRoom.h"
using namespace std;

int main()
{

    int n;
    cout << "Enter the No of Rooms to Add " << endl;
    cin >> n;

    Room *rooms[n];
    int roomno, noofDays;
    double priceperDay;
    string roomType;
    int index = 0;
    int ch;
    do
    {

        cout << "1.Add Standard Room" << endl;
        cout << "2.Add Deluxe Room" << endl;
        cout << "3.Dispay Details  " << endl;
        cout << "4.Special service  " << endl;
        cout << "5.Exit  " << endl;
        cout << "Enter the choice : ";
        cin >> ch;

        switch (ch)
        {
        case 1:
        {
            string amenities;
            cout << "Enter The Room Details to add : " << endl;
            cout << "Enter the Room Number";
            cin >> roomno;
            cout << "Enter the Room Type";
            cin >> roomType;
            cout << "Enter the No of Days";
            cin >> noofDays;
            cout << "Enter the Price per days";
            cin >> priceperDay;

            cin.ignore();
            cout << "Enter the amentities provided";
            getline(cin, amenities);

            // create the object of standard room
            rooms[index] = new StandardRoom(roomno, roomType, priceperDay, noofDays, amenities);
            index++;
            break;
        }

        case 2:
        {
            string service;
            cout << "Enter The Room Details to add : " << endl;
            cout << "Enter the Room Number";
            cin >> roomno;
            cout << "Enter the Room Type";
            cin >> roomType;
            cout << "Enter the No of Days";
            cin >> noofDays;
            cout << "Enter the Price per days";
            cin >> priceperDay;
            cin.ignore();
            cout << "Enter the special service";
            getline(cin, service);

            // create the object of standard room
            rooms[index] = new DeluxeRoom(roomno, roomType, priceperDay, noofDays, service);
            index++;
            break;
        }

        case 3:
        {
            // display details then will invoke the bill function
            for (int i = 0; i < index; i++)
            {
                double bill = rooms[i]->calculate_bill();
                cout << "The Bill is : " << bill << endl;
                rooms[i]->display();
            }

            break;
        }

        case 4:

        {
            // display details then will invoke the bill function
            for (int i = 0; i < index; i++)
            {

                DeluxeRoom *deluxRoom = dynamic_cast<DeluxeRoom *>(rooms[i]);
                if (deluxRoom != nullptr)
                {

                    deluxRoom->special_services();
                }

                StandardRoom *stdRoom = dynamic_cast<StandardRoom *>(rooms[i]);
                if (stdRoom != nullptr)
                {
                    stdRoom->special_amenities();
                }
            }

            break;
        }
        case 0:{
            cout<<"program exited successfully"<<endl;
            break;
        }
        default:
            break;
        }

    } while (ch != 0);

    for (int i = 0; i < index; i++) {
    delete rooms[i];
}

    return 0;
}