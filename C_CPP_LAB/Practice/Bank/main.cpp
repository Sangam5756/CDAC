#include <iostream>
#include <exception>
#include <vector>
using namespace std;

class balanceNegativeException : public exception
{
    const char *what() const noexcept override
    {
        return "Balance cannot be negative";
    }
};

class InsufficentFundException : public exception
{
    const char *what() const noexcept override
    {
        return "Fund is not availalble";
    }
};

class Account
{
    int accNo;
    double balance;

public:
    Account(int accNo, double balance)
    {
        this->accNo = accNo;
        this->balance = balance;
    }
    double getBalance()
    {
        return balance;
    }
    int getAccountNo()
    {
        return accNo;
    }
    void setBalance(double amount)
    {
        this->balance = amount;
    }

    virtual void display()
    {
        cout << "\n"
             << "Account No is " << accNo << "\nbalance is " << balance << endl;
    }
};

class SavingAccount : public Account
{
    double interest;

public:
    SavingAccount(int accNo, double balance, double interest) : Account(accNo, balance)
    {
        this->interest = interest;
    }
    double calculateInterest()
    {
        return this->getBalance() + (this->getBalance() * interest);
    }

    void display()
    {
        cout << "\nAccount Type : Saving Account ";
        Account::display();
        cout << "\nInterestRate is " << interest << endl;
    }
};

class CurrentAccount : public Account
{
    double overDraftLimit;

public:
    CurrentAccount(int accNo, double balance, double overDraftLimit) : Account(accNo, balance)
    {
        this->overDraftLimit = overDraftLimit;
    }
    void overDraftWithdraw(double amount)
    {
        if (amount < 0)
        {
            throw balanceNegativeException();
        }
        if (amount > getBalance() + overDraftLimit)
        {
            throw InsufficentFundException();
        }
        else
        {
            setBalance(this->getBalance() - amount);
            cout << "Withdrawl successfull";
        }
    }

    void display()
    {
        cout << "\nAccount Type : Current Account ";
        Account::display();
        cout << "Overdraft Limit is " << overDraftLimit << endl;
        cout << "Available balance with limit is " << getBalance() + overDraftLimit << endl;
    }
};

int main()
{

    Account acc(12, 2000);

    Account *Sacc = new SavingAccount(123, 1000, 10);
    Account *Curr = new CurrentAccount(111, 1000, 2000);

    // SavingAccount *Sdown = dynamic_cast<SavingAccount *>(Sacc);

    // if (Sdown)
    // {
    //     try
    //     {
    //         cout << Sdown->calculateInterest();
    //     }
    //     catch (const std::exception &e)
    //     {
    //         cout << e.what();
    //     }
    // }
    // Sdown->display();
    // cout << Sdown->calculateInterest();

    // will call withdraw method of class Curr
    // it is calling the dispay of Current even though the pointer is of type Account due to overriding

    // Curr->display();

    // but i cant call the method of current account which is overdraftlimit
    // need to do the downcast to currentACccount

    // CurrentAccount *currDown = dynamic_cast<CurrentAccount *>(Curr);
    // if (currDown)
    // {

    //     try
    //     {
    //         currDown->overDraftWithdraw(10000);
    //     }
    //     catch (const exception  &e)
    //     {
    //         cout << e.what();
    //     }
    // }

    //  now we will use the vector to do it
    vector<Account *> vec;
    // vec.push_back(Curr);
    // vec.push_back(Sacc);

    

    // try
    // {
    //     for (auto acc : vec)
    //     {
    //         acc->display();

    //         // CurrentAccount *curr = dynamic_cast<CurrentAccount *>(acc);
    //         //  if we call the overdraft of class current it will throw compiler eroor as he dont know that there is function is or not so
    //         // to resolve that we need to down cast to currentAccount

    //         // if account type is current
    //         CurrentAccount *curr = dynamic_cast<CurrentAccount *>(acc);
    //         if (curr)
    //         {
    //             curr->overDraftWithdraw(120);
    //         }

    //         // for saving account
    //         SavingAccount *saving = dynamic_cast<SavingAccount *>(acc);

    //         if (saving)
    //         {

    //             cout << "saving account calculate" << saving->calculateInterest();
    //         }
    //     }
    // }
    // catch (const exception &e)
    // {
    //     cout << e.what();
    // }

    // int ch;
    // try
    // {
    //     do
    //     {
    //         cout << "\n1. Add saving account " << endl;
    //         cout << "2. Add Current ACcount" << endl;
    //         cout << "3. CalculateInterest" << endl;
    //         cout << "4. Overdraft Limit" << endl;
    //         cout << "5. display" << endl;

    //         cout << "Enter the choice ";
    //         cin >> ch;
    //         try
    //         {
    //             switch (ch)
    //             {
    //             case 1:
    //                 vec.push_back(Curr);

    //                 break;
    //             case 2:
    //                 vec.push_back(Sacc);
    //                 break;
    //             case 3:
    //             {
    //                 auto currAccd = dynamic_cast<CurrentAccount *>(vec.at(0));
    //                 currAccd->overDraftWithdraw(-111);
    //                 break;
    //             }
    //             case 4:
    //                 for (Account *acc : vec)
    //                 {
    //                     acc->display();
    //                     cout << "entering dispy";
    //                 }
    //                 cout << "exiting dispy";
    //                 break;

    //             default:
    //                 break;
    //             }
    //         }
    //         catch (const exception &e)
    //         {
    //             cout << e.what();
    //         }

    //     } while (ch != 0);
    // }
    // catch (const exception &e)
    // {
    //     cout << e.what();
    // }

    delete Curr;
    delete Sacc;
    return 0;
}