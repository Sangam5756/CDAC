#ifndef CAKE_H
#define CAKE_H

#include <iostream>

using namespace std;

class Cake{
        string cakename;
        double price;
        public:
            Cake(string cakeName,double price){
                this->cakename=cakeName;
                this->price=price;

            }
            virtual void display(){
                cout<<"CakeName "<<cakename<<"  Price "<<price;
            }
            double getPrice(){
                return price;
            }
            string getCakeName(){
                return cakename;
            }

};



#endif