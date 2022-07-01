#include <stdio.h>


int main() {
    char greeting[] = "Hello World";
    for(int i = 0; i < 5; i++){
        printf("%s , %u \n",greeting, i);
    }
    return 0;
}
