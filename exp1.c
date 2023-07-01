#include <stdio.h>
#include <string.h>
int main()
{
    char s[20] = "helloWorld";
    char result[10];
    int i, len;
    len = strlen(s);
    for (i = 0; i < len; i++) {
        result[i] = s[i] ^ 0;
        printf("%c", result[i]);
    }
}