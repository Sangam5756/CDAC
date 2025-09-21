#ifndef DELUXEROOM_H
#define DELUXEROOM_H
#include<iostream>
#include "Room.h"
using namespace std;

class DeluxeRoom :public Room{
    string special_service;

    public:
    DeluxeRoom(int room_number,string room_type,double price_per_day,int no_of_days,string special_service):Room( room_number, room_type, price_per_day, no_of_days){
        this->special_service=special_service;
    }
    int  calculate_bill(){
        cout<<"CalCulate bill of the Deluxe CLASS"<<endl;
       return this->getprice_per_day()*this->get_no_days(); 
    }
    void display(){
        Room::display();
        cout<<"Special Service "<<special_service<<endl;
    }
    
    
    void special_services(){
        cout<<"Special Service  of Standard Room"<<endl;
    }
    


};

#endif