#include <iostream>
using namespace std;

//#include "./average.h"

int average(int a, int b);

int main() {
	cout << "average of 2 and 5: " << average(2,5) << "\n";
}

int average(double a, double b) {
	return (a+b)/2;
}
