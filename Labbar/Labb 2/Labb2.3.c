#include <stdio.h>

static void rearrange(int* array, int size)
{
	if(size == 1)
		return;

	int i;
	int j = 0;
	int tmp;

	for(i = 0 ; i < size ; i++)
	{
		if(array[i] < 0)
		{
			tmp = array[i];
			array[i] = array[j];
			array[j++] = tmp;
		}
	}
}

int main(){
	int integers[] = {-1,-2,3,-66,8,3,6,9,-3,-8,-2};
	int arraySize = 11;
	rearrange(integers , arraySize);

	for(int i = 0 ; i < arraySize ; i++)
	{
		printf("%d, ", integers[i]);
	}
}