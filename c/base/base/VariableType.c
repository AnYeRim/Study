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

     printf("���� �Ҽ��� : %f\n",d);
     printf("�ε� �Ҽ��� : %e\n",d);
     printf("�Ϲ��� : %g\n",d);
}

void printChar1()
{
	char ch;
    ch='A';

	printf("������ �� %d, ������ �� %c\n", ch, ch);
}

void printChar2()
{
	char ch;
	unsigned char uch;
	int i;

	for(i=-128; i<128; i++){
		ch = i;
		printf("������ �� %d, ������ �� %c\n", i, ch);
	}

	for(i=0; i<255; i=i++){
		uch = i;
		printf("������ �� %d, ������ �� %c\n", i, uch);
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