#include <iostream>
#include <map>
#include <random>
#include <string.h>

int nextPrime(int first);
void arrayCopy(char** src, char** dest, int start, int finish);

using namespace std;

int main(int argc, char *argv[]) {
    if(argc == 1){
        printf("%s\n", "This program requires at least two arguments, type -h for help.");
        return 1;
    }
    else if(0 == strcmp(argv[1], "-h") || 0 == strcmp(argv[1], "--help")){
        printf("%s\n", "This program will choose from the choices that are provided as arguments.");
        printf("%s\n", "Enter i at the end to see a detailed description");
        return 0;
    }
    else if(argc == 2){
        printf("%s\n", "This program requires at least two arguments, type -h for help.");
        return 1;
    }
    else {
        char *choices[argc - 1];
        arrayCopy(argv, choices, 1, argc);
        random_device rd;
        uniform_int_distribution<int> dist(5500, 8000);

        int count = argc - 1;
        map<int, double> results;

        int prime = nextPrime(dist(rd));
        for (int i = 0; i < prime; i++) {
            int res = dist(rd) % count;
            if (results.count(res)) {
                results[res] = results[res] + 1;
            } else {
                results.insert({res, 1.0});
            }
        }
        int winner = 0;
        double temp = 0.0;
        double total = 0.0;
        for (auto const &values: results) {
            if (temp < values.second) {
                winner = values.first;
                temp = values.second;
            }
            total += values.second;
        }
        printf("%s\n", choices[winner]);
        char input = ' ';
        scanf("%c", &input);

        if (input == 'i') {
            for (auto const &values: results) {
                printf("%s with %.0f votes (%.2f%%)\n", choices[values.first], values.second,
                       values.second / total * 100);
            }
        }


        return 0;
    }
}

int nextPrime(int first){
    bool check;
    int temp;
    if(first > 10000){
        return 1117;
    }
    for(int i = first; i < first + 1000; i++){
       for(int j = 2; j < i; j++){
           if(i % j != 0){
               temp = i;
               check = true;
           }
           else{
               check = false;
               break;
           }
       }
       if(check){
           return temp;
       }
    }
    return nextPrime(first + 1000);
}
void arrayCopy(char* src[], char* dest[], int start, int finish){
    for(int i = start; i < finish; i++){
        dest[i - start] = src[i];
    }
}
