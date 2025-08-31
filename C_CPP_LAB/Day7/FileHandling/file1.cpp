// 5: Create an File IO application for basic operation 
//    1:Write file:accept data from user and store in file
//    2:Read file:display line by line
//    3:copy data from one file into another file


#include<iostream>
#include<string>
#include<fstream>
using namespace std;

void writeFile(){

    ofstream fwrite("Hi.txt",ios::app);
    fwrite<<"This is second time witrh file\n";
    
    fwrite.close();

}

void readFile(){
    ifstream file("Hi.txt");
    string s;

    while(getline(file, s)){
    cout<<"The data is : "<<s<<endl;
    }
    
}

int main(){

    writeFile();
    readFile();

    return 0;
}