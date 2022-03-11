#include <stdio.h>

void iterative_reverse()
{
    char a[10];
    int i = 9;
    char x;
    while((x = getchar()) != '\n' && i > -1)
    {
        a[i] = x;    

        i--;
    }
    
    int j = i + 1;
    for(j ; j < 10 ; j++)
    {
        putchar(a[j]);
    }
}

int main()
{
    iterative_reverse();
}