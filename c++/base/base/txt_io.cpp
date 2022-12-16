#include <fstream>

int main(){
	std::ofstream ofile("test.txt");

	if(ofile.is_open()){
		ofile << "hh";
		ofile.close();
	}

	return 0;
}