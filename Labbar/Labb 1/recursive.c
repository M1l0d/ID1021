#include <stdio.h>

void reverse()
{
    char x = getchar();
    if(x != '\n')
    {
        reverse();
    }
    putchar(x);
}

int main()
{
    reverse();
}