
#include <iostream>
using namespace std;

// Program to calculate GCD of two numbers

int main() {
    int a, b;
    cout << "Enter two numbers: ";
    cin >> a >> b;
    int gcd = 1;
    int minVal = (a < b) ? a : b;
    for (int i = 1; i <= minVal; ++i) {
        if (a % i == 0 && b % i == 0) {
            gcd = i;
        }
    }
    cout << "GCD of " << a << " and " << b << " is: " << gcd << endl;
    return 0;
}


// 1:Write a program that accepts numbers continuously as long as the number is positive and prints the sum of the given numbers.

// #include <iostream>
// using namespace std;

// int main() {
//     int n, sum = 0;
//     cout << "Enter positive numbers (enter a negative to stop): " << endl;
//     while (true) {
//         cin >> n;
//         if (n < 0) break;
//         sum += n;
//     }
//     cout << "Sum = " << sum << endl;
//     return 0;
// }


// 2. Write a program to calculate factors of a given number.


// #include <iostream>
// using namespace std;

// int main() {
//     int n;
//     cout << "Enter a number: ";
//     cin >> n;
//     cout << "Factors of " << n << " are: ";
//     for (int i = 1; i <= n; ++i) {
//         if (n % i == 0) {
//             cout << i << " ";
//         }
//     }
//     cout << endl;
//     return 0;
// }



// 3. Write a program to accept a character, an integer n and display the next n characters.


// #include <iostream>
// using namespace std;

// int main() {
//     char ch;
//     int n;
//     cout << "Enter a character: ";
//     cin >> ch;
//     cout << "Enter n: ";
//     cin >> n;
//     cout << "Next " << n << " characters: ";
//     for (int i = 1; i <= n; ++i) {
//         cout << char(ch + i) << " ";
//     }
//     cout << endl;
//     return 0;
// }
