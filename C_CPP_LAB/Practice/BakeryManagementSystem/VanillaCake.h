#ifndef VANILLA_H
#define VANILLA_H
#include "Cake.h"
#include <iostream>
using namespace std;

class VanillaCake : public Cake{
    double discount ;
    public:
        VanillaCake(string cakeName,double price,double discount=10.0):Cake(cakeName,price){
            this->discount=discount;
        }
        double calculate_vanillaprice(){
            return getPrice()-(getPrice()*0.10); 
        }
        void display() override{
                Cake::display();
                cout<<"Discount is "<<discount;

        }

};


#endif