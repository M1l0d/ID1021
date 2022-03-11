#include <stdio.h>
#include <ctype.h>


int main()
{
	char x = getchar();

	while(x != EOF)
	{
		if(isalpha(x) != 0)
			putchar(x);

		else if(x == ' ')
			putchar(x);

		else if(x == '\n')
			putchar(x);

		else
			putchar(' ');

		x = getchar();		
	}

	return 0;
}


// textfilter.exe < thetext.txt > outputfile1.txt