#include <iostream>
#include <iomanip>

using namespace std;

int main() {
	cout << setiosflags(ios::right);
	cout << "1234567890" << endl;
	cout << setw(10) << "abcde" << endl;
	cout << 45 << endl;

}
