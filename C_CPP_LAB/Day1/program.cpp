#include <iostream>
using namespace std;

// 2:Write a program to adddition of two numbers .
int add(int a, int b)
{
    return a + b;
}

// 3:Write a program to swap two numbers.
void swapNumbers(int &a, int &b)
{
    int temp = a;
    a = b;
    b = temp;
}

// 4. Write a program to accept an integer and check if it is even or odd.
inline bool isEvenOdd(int n)
{
    return n % 2 == 0 ? true : false;
}

// 5. Write a program to accept a number and check if it is divisible by 5 and 7.
inline bool isDivisibleBy5And7(int n)
{
    return (n % 5 == 0 && n % 7 == 0) ? true : false;
}

// Write a program, which accepts annual basic salary of an employee and calculates and displays the
// Income tax as per the following rules.
// Basic: < 1, 50,000 Tax = 0
//  1, 50,000 to 3,00,000 Tax = 20%
//  > 3,00,000 Tax = 30%
void calculateTax(double num)
{
    if (num < 150000)
    {
        cout << num << " Tax is 0% " << endl;
    }
    else if (num >= 50000 && num < 300000)
    {
        cout << num << " Tax is " << num * 0.20 << " ruppes" << endl;
    }
    else if (num > 30000)
    {
        cout << num << " tax is " << num * 0.30 << " ruppes" << endl;
    }
}

// 7. Accept a lowercase character from the user and check whether the character is a vowel or consonant.
bool isVowelConsonant(char c)
{
    if (c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u')
        return true;
    else
        return false;
}

// 8. Write a  program to input angles of a triangle and check whether triangle is valid or not.
bool isTriangle(int a, int b, int c)
{
    return (a + b + c) == 180 ? true : false;
}

// 9:Write a program to find factorial of a given number. ex:no5  fact=5*4*3*2*1=120
int factorial(int n)
{
    // Recursive approach
    // if (n == 1 || n == 0)
    //     return 1;
    // return n * factorial(n - 1);

    // iterative approach
    int result = 1;
    for (int i = 1; i <= n; i++)
    {
        result = result * i;
    }
    return result;
}

// 10:Write a program to find m to the power n. m=3 and n=4 so 3*3*3*3
int findPower(int a, int b)
{
    int result = 1;
    for (int i = 1; i <= b; i++)
    {
        result = result * a;
    }
    return result;
}

// 11:Check if number is a prime number or not.
bool isPrime(int num)
{
    if (num <= 1)
    {
        return false;
    }
    for (int i = 2; i < num; i++)
    {
        if (num % i == 0)
        {
            return false;
        }
    }

    return true;
}

// 12:Sum of series :
// 1+2+3+….+n
int printSumOfNaturalNumberTillN(int n)
{
    // first we can do bruetforce
    int sum = 0;
    for (int i = 0; i <= n; i++)
    {
        sum += i;
    }
    return sum;
}

// 13:Check whether the number is palindrome or not?
bool isPalindrome(int num1)
{
    // palindrome means number will read the same in reverse order also
    int temp = num1;
    int rev = 0;
    while (temp > 0)
    {
        int last = temp % 10;
        rev = (rev * 10) + last;
        temp /= 10;
    }
    if (num1 == rev)
    {
        return true;
    }
    return false;
}

// 14:Write a  program to find sum of all even and odd numbers between 1 to n.
void findSumOfEvenOdd(int num)
{
    int evensum = 0;
    int oddSum = 0;
    for (int i = 1; i <= num; i++)
    {
        if (i % 2 == 0)
        {
            evensum += i;
        }
        else
        {
            oddSum += i;
        }
    }

    cout << "\nThe Sum Of Even Is :" << evensum << endl;
    cout << "The Sum Of Odd Is :" << oddSum << endl;
}

// 15: Write a  program to enter a number and print its reverse.
int printReverseNumber(int num)
{
    int reverse = 0;
    while (num > 0)
    {
        int last = num % 10;
        reverse = (reverse * 10) + last;
        num /= 10;
    }

    return reverse;
}

// 16:Write a program to print all Prime numbers between 1 to n.

void printPrimeNumbers(int num)
{

    for (int i = 1; i <= num; i++)
    {
        if (isPrime(i))
        {

            cout << "Prime Number " << i << endl;
        }
    }
}

//  17:Write a program to check entered number is Armstrong number or not.
bool isArmstrong(int num)
{
    // count the digits of number
    int count = 0;
    int temp = num;
    while (temp > 0)
    {
        count++;
        temp /= 10;
    }
    temp = num;
    int sum = 0;
    while (temp > 0)
    {
        // get last
        int last = temp % 10;
        // find the power
        int n = findPower(last, count);
        // add into sum
        sum += n;
        // remove last
        temp /= 10;
    }
    // check the sum and num is equal then its armstrong number
    if (sum == num)
    {
        return true;
    }
    return false;
}

// 18:Write a program to find greatest of three numbers using nested if-else.
void maxOfThree(int a, int b, int c)
{
    int max = a;
    if (a >= b)
    {
        if (a >= c)
        {
            cout << "A is Greater" << a << endl;
        }
        else
        {
            cout << "C is Greater" << c << endl;
        }
    }
    else
    {
        if (b >= a)
        {
            if (b >= c)
            {
                cout << "B is Greater" << b << endl;
            }
            else
            {
                cout << "C is Greater" << c << endl;
            }
        }
    }
}

int main()
{
    int choice;
    int num1, num2, result;

    do
    {
        cout << "\n===== MENU =====" << endl;
        cout << "1. Add two numbers" << endl;
        cout << "2. Swap two numbers" << endl;
        cout << "3. Find Number is Even of Odd" << endl;
        cout << "4. Find Number is divisible by 5 and 7" << endl;
        cout << "5. Find Income tax on salary" << endl;
        cout << "6. check whether the character is a vowel or consonant" << endl;
        cout << "7. check whether triangle is valid or not " << endl;
        cout << "8. find factorial of a given number " << endl;
        cout << "9. a program to find m to the power n " << endl;
        cout << "10.Check if number is a prime number or not" << endl;
        cout << "11.Find sum of Series 1 to n " << endl;
        cout << "12.Check whether the number is palindrome or not?" << endl;
        cout << "13.find sum of all even and odd numbers between 1 to n" << endl;
        cout << "14.program to enter a number and print its reverse" << endl;
        cout << "15.program to print all Prime numbers between 1 to n" << endl;
        cout << "16.check entered number is Armstrong number or not" << endl;
        cout << "0. Exit" << endl;
        cout << "================" << endl;

        cout << "Enter your choice: ";
        cin >> choice;

        if (choice < 0 || choice > 20)
        {
            cout << "\nInvalid choice. Please try again." << endl;
            continue;
        }

        switch (choice)
        {

        case 0:
        {
            cout << "\nExited successfully from the program." << endl;
            break;
        }
        case 1:
        {
            cout << "\nEnter the first number: ";
            cin >> num1;
            cout << "Enter the second number: ";
            cin >> num2;

            result = add(num1, num2);
            cout << "\nResult: " << num1 << " + " << num2
                 << " = " << result << endl;
            break;
        }
        case 2:
        {
            cout << "\nEnter the first number: ";
            cin >> num1;
            cout << "Enter the second number: ";
            cin >> num2;

            cout << "\n--- Before Swap ---" << endl;
            cout << "A = " << num1 << ", B = " << num2 << endl;

            swapNumbers(num1, num2);

            cout << "--- After Swap ---" << endl;
            cout << "A = " << num1 << ", B = " << num2 << endl;
            break;
        }
        case 3:
        {
            int num;
            cout << "\nEnter the Number to check : ";
            cin >> num;

            if (isEvenOdd(num))
            {
                cout << "Number is Even " << num << endl;
            }
            else
            {
                cout << "Number is Odd " << num << endl;
            }
            break;
        }
        case 4:
        {
            cout << "Enter the Number to check the its divisible by 5 and 7 : ";
            cin >> num1;
            if (isDivisibleBy5And7(num1))
            {
                cout << num1 << " Divisible by 5 and 7 " << endl;
            }
            else
            {
                cout << num1 << " Not divisible by 5 and 7 " << endl;
            }
            break;
        }
        case 5:
        {
            double num1;
            cout << "Enter the Anual Salary : ";
            cin >> num1;
            calculateTax(num1);
            break;
        }
        case 6:
        {
            char ch;
            cout << "Enter the character to check it vowel or consonant  ";
            cin >> ch;
            char c = tolower(ch);

            if (isVowelConsonant(c))
                cout << "characters is vowel " << endl;
            else
                cout << "character is consonant" << endl;
            break;
        }
        case 7:
        {
            int a, b, c;
            cout << "Enter the Angel A of Triangle : ";
            cin >> a;
            cout << "Enter the Angel B of Triangle : ";
            cin >> b;
            cout << "Enter the Angel C of Triangle : ";
            cin >> c;
            if (isTriangle(a, b, c))
            {
                cout << "its Valid Triangle " << endl;
            }
            else
            {
                cout << "its Not Valid Triangle " << endl;
            }
            break;
        }
        case 8:
        {
            cout << "Enter the Number to calculate factorial : ";
            cin >> num1;
            result = factorial(num1);
            cout << "\nFactorial is " << result << endl;
            break;
        }
        case 9:
        {
            cout << "Enter the value to find Power of that : ";
            cin >> num1;

            cout << "Enter the value of Power : ";
            cin >> num2;

            result = findPower(num1, num2);
            cout << "Answer is : " << result;
            break;
        }
        case 10:
        {
            cout << "Enter the Number to Check its Prime or Not ";
            cin >> num1;
            result = isPrime(num1);
            if (result)
            {
                cout << "\nits Prime" << endl;
            }
            else
            {
                cout << " \nits Not Prime" << endl;
            }

            break;
        }
        case 11:
        {
            cout << "Enter the Number from 1 to n to find their sum : ";
            cin >> num1;
            result = printSumOfNaturalNumberTillN(num1);
            cout << "\n Sum of Natural Number 1  to " << num1 << " is :" << result << endl;
            break;
        }
        case 12:
        {
            cout << "Enter the Number to check its Palindrome or Not : ";
            cin >> num1;
            if (isPalindrome(num1))
            {
                cout << "\n Number is Palindrome " << endl;
            }
            else
            {
                cout << "\n Number is Not Palindrome " << endl;
            }
            break;
        }
        case 13:
        {
            cout << "Enter the Number  1 to n ";
            cin >> num1;
            findSumOfEvenOdd(num1);
            break;
        }
        case 14:
        {
            cout << "Enter the Number to print Reverse : ";
            cin >> num1;
            int result = printReverseNumber(num1);
            cout << "Reverse of Number " << num1 << " is " << result << endl;
            break;
        }
        case 15:
        {
            cout << "Enter the Number from 1 to n to print prime series :";
            cin >> num1;
            printPrimeNumbers(num1);
            break;
        }
        case 16:
        {
            cout << "Enter the number to check : ";
            cin >> num1;
            if (isArmstrong(num1))
            {
                cout << num1 << " is Armstrong" << endl;
            }
            else
            {
                cout << num1 << " is Not Armstrong" << endl;
            }
            break;
        }
        case 17:
        {
            int a, b, c;
            cout << "Enter First Number : ";
            cin >> a;
            cout << "Enter Second Number : ";
            cin >> b;
            cout << "Enter Third Number : ";
            cin >> c;
            maxOfThree(a, b, c);
            cout << endl;
            break;
        }
        default:
            cout << "\nInvalid choice. Please try again." << endl;
            break;
        }

    } while (choice != 0);

    return 0;
}
