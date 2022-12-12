#include <stdio.h>

void printA(){
	int num = 65;
	char ch = 'A';

	printf("num : %d, ch : %c\n", num, ch);
	printf("num -> char : %c\n", num, ch, num);
}

void printB(){
	int num = 65;
	double pie = 3.14;

	printf("num : %d\n", num);
	printf("num : %5d\n", num);
	printf("num : %05d\n", num);
	printf("num : %-5d\n", num);

	printf("\n");

	printf("num : %f\n", pie);
	printf("num : %10f\n", pie);
	printf("num : %.2f\n", pie);
	printf("num : %010.2f\n", pie);
	printf("num : %-10.2f\n", pie);
}

void scanA(){
	int a, b;
	int sum;

	printf("a + b = sum\n ���� �� a, b�� �Է����ּ���");
	scanf("%d %d", &a, &b);

	sum = a + b;

	printf("a + b = %d �Դϴ�.\n", sum);
}

int main(){
	printA();

	printf("\n");
	
	printB();

	printf("\n");

	scanA();

	return 0;
}