#include <stdio.h>
 

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