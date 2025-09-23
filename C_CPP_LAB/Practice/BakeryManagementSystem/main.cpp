#include <iostream>
#include "Cake.h"
#include "VanillaCake.h"
#include "ChocolateCake.h"
#include <vector>
using namespace std;

int main()
{

    // // create the object of the pointer
    // Cake *cakes[5];

    // Cake *chocolate = new ChocolateCake("RasMalai",1200,"Fudge");
    // Cake *vanilla = new VanillaCake("GreenApple",100,10);

    // cakes[0] = chocolate;
    // cakes[1] = vanilla;

    // cakes[0]->display();
    // // auto cake = dynamic_cast<ChocolateCake *>(cakes[0]);
    // // cout<< cake->calculateChocolatePrice();
    // // cake->display();

    vector<Cake *> cakes;
    int ch;

    do
    {
        cout << "\n=== Bakery Management System ===\n";
        cout << "1. Add Chocolate Cake\n";
        cout << "2. Add Vanilla Cake\n";
        cout << "3. Display All Cakes\n";
        cout << "4. Show Final Price of Each Cake\n";
        cout << "5. Exit\n";
        cout << "Enter your choice: ";
        cin >> ch;

        switch (ch)
        {
        case 1:
        {

            string name, type;
            double price;
            cout << "Enter Cake Name: ";
            cin >> name;
            cout << "Enter Base Price: ";
            cin >> price;
            cout << "Enter Chocolate Type (Fudge/BlackForest): ";
            cin >> type;

            cakes.push_back(new ChocolateCake(name,price,type));
            break;
        }

        case 2:
        {
            string name;
            double price;
            cout << "Enter Cake Name: ";
            cin >> name;
            cout << "Enter Base Price: ";
            cin >> price;
            cakes.push_back(new VanillaCake(name,price));
            cout << "Vanilla Cake Added!\n";

            break;
        }

        case 3:
        {
            cout << "\n--- Cake Details ---\n";
            for (auto cake : cakes)
            {
                cake->display();
            }

            break;
        }

        case 4:
        {
            cout << "\nFinal Prices \n";
            for(auto cake : cakes){
                auto chocolateCake = dynamic_cast<ChocolateCake *>(cake);
                if(chocolateCake){
                   cout<<"Price of Chocolate is : "<<cake->getCakeName()<<"  " << chocolateCake->calculateChocolatePrice();
                }
                auto vanillaCake = dynamic_cast<VanillaCake *>(cake);
                if(vanillaCake){
                    cout<<"Price Of Vanilla is : "<<cake->getCakeName()<<"  "<<vanillaCake->calculate_vanillaprice();
                }
            }
            break;
        }

        case 5:
        {
            cout << "Exiting Program...\n";

            break;
        }

        default:
            cout << "Invalid choice! Try again.\n";

            break;
        }

    } while (ch != 5);

    for (auto cake : cakes)
    {
        delete cake;
    }

    return 0;
}
