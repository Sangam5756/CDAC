#ifndef CHOCOLATECAKE_H
#define CHOCOLOLATE_H
#include "Cake.h"
#include <iostream>
using namespace std;

enum chocolateType{
    FUDGE,BLACK_FOREST
};

class ChocolateCake : public Cake{
    chocolateType chocolate;
    public:
        ChocolateCake(string cakeName,double price,chocolateType chocolate):Cake(cakeName,price){
            this->chocolate=chocolate;
        }
        double calculateChocolatePrice(){
            double basePrice =getPrice();
            // if fudge then 5% extra
            // if black forest 10 % extra
            if(chocolate == FUDGE){
                basePrice =(getPrice() +(getPrice()*0.05));
            }
             if(chocolate == BLACK_FOREST){
                basePrice  =(getPrice() +(getPrice()*0.10));
            }
            return basePrice;

        }

        void display() override{
            Cake::display();
            cout<<"Chocolate Type : "<<chocolate<<endl;
        }

};


#endif