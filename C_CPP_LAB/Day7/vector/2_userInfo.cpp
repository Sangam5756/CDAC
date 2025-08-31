// 2:Create an application for storing user information in vector.
//   (Hint:User class with data member userid,name,email,pwd)
//   Create Menu Driven app
//   1:add user
//   2:display all users
//   3:search user
//   4:change pwd
//   5:delete all

#include <iostream>
#include <vector>
using namespace std;

class User
{
    int userId;
    string name, email, pwd;
    static int count;

public:
    User(string name, string email, string pwd) : userId(count++), name(name), email(email), pwd(pwd) {}
    void setName(string name)
    {
        this->name = name;
    }
    void setEmail(string email)
    {
        this->email = email;
    }
    void setPwd(string pwd)
    {
        this->pwd = pwd;
    }
    void display()
    {
        cout << "User ID : " << userId << endl;
        cout << "Name    : " << name << endl;
        cout << "Email   : " << email << endl;
        cout << "------------------------" << endl;
    }
    // getters
    int getUserId() const { return userId; }
    string getEmail() const { return email; }
    bool checkPassword(string newpwd)
    {
        return pwd == newpwd;
    }
};

int User::count = 101;

int main()
{
    vector<User> users;
    int ch;

    string name, email, pwd;
    do
    {
        cout << "\n--- User Management Menu ---\n";
        cout << "1. Add User\n";
        cout << "2. Display All Users\n";
        cout << "3. Search User by Email\n";
        cout << "4. Change Password\n";
        cout << "5. Delete All Users\n";
        cout << "6. Exit\n";

        cout << "Enter the choice : ";
        cin >> ch;

        switch (ch)
        {
        case 1:
        {
            cout << "Enter the Name :";
            cin >> name;
            cout << "Enter the Email : ";
            cin >> email;
            cout << "Enter the Password";
            cin >> pwd;

            User u1(name, email, pwd);
            users.push_back(u1);
            break;
        }
        case 2:
        {
            for (User u : users)
            {
                u.display();
            }
            break;
        }
        case 3:
        {
            cout << "Enter the email to search : ";
            cin >> email;
            bool found = false;
            for (User u : users)
            {
                if (u.getEmail() == email)
                {
                    u.display();
                    found = true;
                    break;
                }
            }
            if (!found)
                cout << "User not found!\n";

            break;
        }
        case 4:
        {

            cout << "Enter your email to change Password : ";
            cin >> email;
            bool found = false;
            for (User u : users)
            {
                if (u.getEmail() == email)
                {
                    found = true;
                    cout << "Enter You Old Password";
                    cin >> pwd;
                    if (u.checkPassword(pwd))
                    {
                        string newpwd;
                        cout << "Enter New Password";
                        cin >> newpwd;
                        u.setPwd(pwd);
                    }
                    else
                    {
                        cout << "please enter Valid Password";
                    }
                }
            }
            if (!found)
                cout << "user not found";

            break;
        }
        case 5:
        {
            cout << "All Users has been deleted";
            users.clear();
        }
        default:
            break;
        }
    } while (ch != 0);

    return 0;
}