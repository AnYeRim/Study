#include <stdio.h>
 

void overflow()
{
     short a,b,c;
     unsigned short s,t,u;
 
     a=20000;
     b=30000;
     c=a+b;
     printf("%d+%d=%d\n",a,b,c);

     s=20000;
     t=30000;
     u=s-t;
     printf("%d-%d=%d\n",s,t,u);
}

void int64()
{
     __int64 a,b,c;

     a=111111111;
     b=111111111;
     c=a*b;

     printf("%I64d\n",c);
}

void printDouble()
{
     double d;
     d=123.456;

     printf("고정 소수점 : %f\n",d);
     printf("부동 소수점 : %e\n",d);
     printf("일반형 : %g\n",d);
}

void printChar1()
{
	char ch;
    ch='A';

	printf("정수일 때 %d, 문자일 때 %c\n", ch, ch);
}

void printChar2()
{
	char ch;
	unsigned char uch;
	int i;

	for(i=-128; i<128; i++){
		ch = i;
		printf("정수일 때 %d, 문자일 때 %c\n", i, ch);
	}

	for(i=0; i<255; i=i++){
		uch = i;
		printf("정수일 때 %d, 문자일 때 %c\n", i, uch);
	}
}

void printEnum()
{
     enum fruit {
		 APPLE,
		 ORANGE,
		 BANANA
	 } a1, a2, a3;

	 enum fruit a4;
	 
	 a3 = APPLE;
	 a4 = BANANA;

	 printf("a3 = %d\n", a3);
	 printf("a4 = %d\n", a4);
}