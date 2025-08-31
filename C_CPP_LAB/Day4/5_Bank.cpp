// 2:Create cpp application for bank account handling.
// 2.1. Create a class BankAccount -- acct no(int),customer name(string),balance(double)
// Add constr. (2 constrs : first to accept all details )

// 2.2 Add Business logic methods
// Methods
// public void withdraw(double amt)
// public void deposit(double amt)

// ## 2.3: Create object of account class and test withdraw and deposit methods.

#include <iostream>
using namespace std;

class BankAccount
{
    int accNo;
    string cust_name;
    double balance;

public:
    // default constructor
    BankAccount() : accNo(101), cust_name("BankDemo"), balance(5000) {};
    // parameterized construcutor
    BankAccount(int accNo, string cust_name, double balance) : accNo(accNo), cust_name(cust_name), balance(balance) {};

    void withdraw(double amount)
    {
        if (amount < 0)
        {
            cout << "please provide positive amount to withdraw" << endl;
        }
        else if (balance < amount)
        {
            cout << "Low Balance" << endl;
        }
        else if (balance > amount)
        {
            balance = balance - amount;
            cout << "After withdraw balance is : " << balance << endl;
        }
        else
        {
            cout << "something went wrong" << endl;
        }
    }

    void deposit(double amount)
    {
        if (amount < 0)
        {
            cout << "Enter the Positive amount :" << endl;
        }
        else
        {
            balance = balance + amount;
            cout << "Updated Balance is : " << balance;
        }
    }
};

int main()
{
    BankAccount b1;
    b1.deposit(1000);
    cout << endl;
    b1.withdraw(1000);
    return 0;
}