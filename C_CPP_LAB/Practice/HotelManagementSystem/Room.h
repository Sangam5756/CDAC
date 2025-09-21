#ifndef ROOM_H
#define ROOM_H

#include<iostream>
using namespace std;

class Room{
    int room_number;
    string room_type;
    double price_per_day;
    int no_of_days;
    public:
    Room(int room_number,string room_type,double price_per_day,int no_of_days){
        this->room_number=room_number;
        this->room_type=room_type;
        this->price_per_day=price_per_day;
        this->no_of_days=no_of_days;

    }
    virtual ~Room(){};
    int virtual calculate_bill(){
        cout<<"CalCulate bill of the ROOM CLASS";
       return price_per_day*no_of_days; 
    }
    double getprice_per_day(){
        return price_per_day;
    }
    
    int get_no_days(){
        return no_of_days;

    }
    void virtual display(){
        cout<<"roomNo : "<<room_number<<" Room Type : "<<room_type<<" PricePerDay"<<price_per_day<<" NoOfDays"<<no_of_days<<endl;
    }
    
    
};

#endif