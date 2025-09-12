// // 19:Create menu driven program for Pizza Shop.And display total amount,

// #include<iostream>
// using namespace std;

// int main() {
//     int qty, total = 0;
//     int choice;

//     do {
//         cout << "\n--- Pizza Shop Menu ---\n";
//         cout << "1. Margherita (100)\n2. Farmhouse (200)\n3. Peppy Paneer (300)\n4. Exit\n";
//         cout << "Enter your choice: ";
//         cin >> choice;

//         if(choice>=1 && choice<=3){
//             cout << "Enter quantity: ";
//             cin >> qty;
//             if(choice==1) total += 100*qty;
//             else if(choice==2) total += 200*qty;
//             else if(choice==3) total += 300*qty;
//         }
//     } while(choice!=4);
//     cout << "Total Amount = " << total << endl;
//     return 0;
// }

// // 20:Accept a single digit from the user and display it in words. For example, if digit entered is 9, display Nine.

// #include <iostream>
// using namespace std;

// int main() {
//     int d;
//     cout << "Enter single digit: ";
//     cin >> d;
//     switch(d){
//         case 0: cout<<"Zero"; break;
//         case 1: cout<<"One"; break;
//         case 2: cout<<"Two"; break;
//         case 3: cout<<"Three"; break;
//         case 4: cout<<"Four"; break;
//         case 5: cout<<"Five"; break;
//         case 6: cout<<"Six"; break;
//         case 7: cout<<"Seven"; break;
//         case 8: cout<<"Eight"; break;
//         case 9: cout<<"Nine"; break;
//         default: cout<<"Not a single digit";
//     }
//     cout << endl;
//     return 0;
// }

// 21. Write a program, which accepts two integers and an operator as a character (+ - * / ), performs the corresponding operation and displays the result.

#include <iostream>
using namespace std;

int main() {
    int a, b;
    char op;
    cout << "Enter two numbers: ";
    cin >> a >> b;
    cout << "Enter operator (+ - * /): ";
    cin >> op;

    switch(op){
        case '+': cout << "Result = " << a+b; break;
        case '-': cout << "Result = " << a-b; break;
        case '*': cout << "Result = " << a*b; break;
        case '/':
            if(b!=0) cout << "Result = " << (float)a/b;
            else cout << "Division by zero not allowed";
            break;
        default: cout << "Invalid operator";
    }
    cout << endl;
    return 0;
}
