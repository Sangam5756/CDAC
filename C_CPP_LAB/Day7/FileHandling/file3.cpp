// 5: Create an File IO application for basic operation
//    1:Write file:accept data from user and store in file
//    2:Read file:display line by line
//    3:copy data from one file into another file

#include <iostream>
#include <fstream>
#include <string>
using namespace std;

// class of file handling
class FileHandling
{
    string filename, data;

public:
    FileHandling(string filename)
    {
        this->filename = filename;
    }
    void writeFile(string data)
    {
        ofstream file(filename + ".txt", ios::app);
        file << data << endl;
        file.close();
    }
    void readFile()
    {
        ifstream file(filename + ".txt");
        while (getline(file, data))
        {
            cout << data << endl;
        }
    }

    void modify()
    {
    }
    void deleteFile()
    {
    }
    void rename()
    {
    }
};

int main()
{

    // menu driven program
    int ch;
    string filename;

    cout << "Enter the File Name :";
    cin >> filename;

    FileHandling file(filename);

    do
    {
        cout << "1. Write Data" << endl;
        cout << "2. Read Data" << endl;
        cout << "3. Modify data" << endl;
        cout << "4. Rename File" << endl;
        cout << "5. Delete File" << endl;
        cout << "Enter Choice : ";
        cin >> ch;

        switch (ch)
        {
        case 1:
        {
            string data;
            cout << "Enter the Data :";
            cin.ignore(1);
            getline(cin, data);
            file.writeFile(data);
            break;
        }
        case 2:
        {
            cout << "\t\t\t -----------DATA FROM FILE ------------" << endl;
            file.readFile();
            cout << endl;
            cout << endl;
            break;
        }

        default:
            cout << "Invalid Choice" << endl;
            break;
        }

    } while (ch != 0);
}