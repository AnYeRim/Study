// CharTest.cpp : Defines the entry point for the console application.
//

#include "stdafx.h"
#include <stdio.h>

void printfTest()
{
	char ch;
    ch='A';

	printf("������ �� %d, ������ �� %c\n", ch, ch);
}

void printfTest2()
{
	char ch;
	unsigned char uch;

	for(int i=-128; i<128; i++){
		ch = i;
		printf("������ �� %d, ������ �� %c\n", i, ch);
	}

	for(int i=0; i<255; i++){
		uch = i;
		printf("������ �� %d, ������ �� %c\n", i, uch);
	}
}

int _tmain(int argc, _TCHAR* argv[])
{
	//printfTest();

	printfTest2();

	return 0;
}

