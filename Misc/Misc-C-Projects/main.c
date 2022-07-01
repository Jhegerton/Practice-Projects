#include <stdio.h>


int main() {
    char entry[2][10];

    printf("%s\n", "Enter a choice");
    scanf("%s", entry[0]);
    printf("%s\n", "Enter a choice");
    scanf("%s", entry[1]);
    printf("%s\n", entry[0]);
    printf("%s\n", entry[1]);

    return 0;
}
