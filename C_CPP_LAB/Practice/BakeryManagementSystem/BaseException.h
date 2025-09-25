#ifndef BASE_EXCEPTION_H
#define BASE_EXCEPTIOIN_H
#include <iostream>
using namespace std;



class BaseException : public exception{
    string message;

  const char* what(){
        return message.c_str();
    }

    
};



#endif