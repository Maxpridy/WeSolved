#include <stdio.h>
#include <stdlib.h>
int main(int argc, char* argv[])
{
    int g = 0;
    scanf("%d", &g);
    if (g >= 90)
    {
        printf("A");
    }
    else if (g >= 80)
    {
        printf("B");
    }
    else if (g >= 70)
    {
        printf("C");
    }
    else if (g >= 60)
    {
        printf("D");
    }
    else
    {
        printf("F");
    }
    return 0;
}