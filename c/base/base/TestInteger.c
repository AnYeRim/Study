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