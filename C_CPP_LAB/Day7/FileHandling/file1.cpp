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