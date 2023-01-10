// CharTest.cpp : Defines the entry point for the console application.
//

#include "stdafx.h"
#include <stdio.h>

void printfTest()
{
	char ch;
    ch='A';

	printf("정수일 때 %d, 문자일 때 %c\n", ch, ch);
}

void printfTest2()
{
	char ch;
	unsigned char uch;

	for(int i=-128; i<128; i++){
		ch = i;
		printf("정수일 때 %d, 문자일 때 %c\n", i, ch);
	}

	for(int i=0; i<255; i++){
		uch = i;
		printf("정수일 때 %d, 문자일 때 %c\n", i, uch);
	}
}

int _tmain(int argc, _TCHAR* argv[])
{
	//printfTest();

	printfTest2();

	return 0;
}

