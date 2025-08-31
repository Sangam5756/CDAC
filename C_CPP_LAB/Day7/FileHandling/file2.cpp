// 5: Create an File IO application for basic operation 
//    1:Write file:accept data from user and store in file
//    2:Read file:display line by line
//    3:copy data from one file into another file


#include<iostream>
#include<string>
#include<fstream>
using namespace std;


class FileHandle {
    private:
        string str, filename;
    public:
        FileHandle(string filename){
            this->filename = filename;
        }

        void writeFile(){
            ofstream file(filename + ".txt", ios::app);
            cout<<"Enter the data : ";
            cin.ignore(1);
            getline(cin,str);
            file<<str;
            file.close();
        }

        void readFile(){
            ifstream file(filename + ".txt");
              while(getline(file, str)){
              cout<<"The data is : "<<str<<endl;
            }

        }
};

int main(){
    cout<<"Enter the filename: ";
    string filename;
    cin>>filename;

    FileHandle files(filename);
    files.writeFile();
    files.readFile();

    return 0;
}