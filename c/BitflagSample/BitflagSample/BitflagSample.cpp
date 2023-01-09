// BitflagSample.cpp : Defines the entry point for the console application.
//

#include "stdafx.h"

#include <string>

#include "BitflagSample.h"

void initFlag()
{
	for(int i = 0; i < FLAG_MAX; i++)
	{
		m_flag[i] = (1 << i); 
	}
}

bool getCheckBit(char nSrc, int nCheckbit)
{

	bool bResult = false;

	bResult = nSrc & (0x01 << nCheckbit) ? 1 : 0; 

	return bResult;
}

void testBit1()
{
	int nSrc = 0x61; // 0110 0001
 	//int nBit = 0x01 << 0x00; // 0000 0001
	//int nBit = 0x01 << 0x01; // 0000 0010
	//int nBit = 0x01 << 0x02; // 0000 0100
	//int nBit = 0x01 << 0x03; // 0000 1000
	//int nBit = 0x01 << 0x04; // 0001 0000
	//int nBit = 0x01 << 0x05; // 0010 0000
	//int nBit = 0x01 << 0x06; // 0100 0000
	
	int nBit = 0x05;

	//printf("result : check bit [%d] = %d\n", nBit, nSrc & nBit > 0 ? 1 : 0);

	bool bResult = getCheckBit(nSrc, nBit);

	printf("result : check bit [%d] = %d\n", nBit, bResult? 1 : 0);
}

void testBit2()
{
	int nSrc = 0xAF; // 1010 1111
	bool bResult = false;

	for(int i = 0; i < FLAG_MAX; i++){
		bResult = nSrc & m_flag[i] ? 1 : 0; 
		printf("result : check bit [%d] = %d\n", i, bResult? 1 : 0);
	}
}

int _tmain(int argc, _TCHAR* argv[])
{
	// testBit1();

	initFlag();
	testBit2();

	system("pause");
	return 0;
}

