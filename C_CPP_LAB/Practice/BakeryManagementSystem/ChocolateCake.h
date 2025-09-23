#ifndef CHOCOLATECAKE_H
#define CHOCOLOLATE_H
#include "Cake.h"
#include <iostream>
using namespace std;

class ChocolateCake : public Cake{
    string chocolateType;
    public:
        ChocolateCake(string cakeName,double price,string chocolateType):Cake(cakeName,price){
            this->chocolateType=chocolateType;
        }
        double calculateChocolatePrice(){
            double basePrice =getPrice();
            // if fudge then 5% extra
            // if black forest 10 % extra
            if(chocolateType == "Fudge"){
                basePrice =(getPrice() +(getPrice()*0.05));
            }
             if(chocolateType == "BlackForest"){
                basePrice  =(getPrice() +(getPrice()*0.10));
            }
            return basePrice;

        }

        void display() override{
            Cake::display();
            cout<<"Chocolate Type : "<<chocolateType<<endl;
        }

};


#endif