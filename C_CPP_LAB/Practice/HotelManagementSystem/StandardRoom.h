#ifndef STANDARDROOM_H
#define STANDARDROOM_H

#include<iostream>
#include "Room.h"
using namespace std;

class StandardRoom :public Room{
    string amenities;

    public:
    StandardRoom(int room_number,string room_type,double price_per_day,int no_of_days,string amenities):Room( room_number, room_type, price_per_day, no_of_days){
        this->amenities=amenities;
    }
    void special_amenities(){
        cout<<"Special ammenties of Standard Room"<<endl;
    }
     void display(){
        Room::display();
        cout<<"Amenities  "<<amenities<<endl;
    }
    int  calculate_bill(){
        cout<<"CalCulate bill of the ROOM CLASS"<<endl;
       return this->getprice_per_day()*this->get_no_days(); 
    }
    


};

#endif