#include <iostream>
#include <chrono>
#include <ctime>
#include <time.h>

void flip_coin(int num_times){
    srand(time(NULL));
    auto start = std::chrono::system_clock::now();
    int side;
    int heads = 0; int tails = 0;

    for(int i = 0; i < num_times; i++){
        side = rand() % 2;
        if(side == 0){
            heads++;
        } else{
            tails++;
        }
    }
    double headsPct = (double) heads / (double) num_times * 100;
    double tailsPct = (double) tails / (double) num_times * 100;
    auto end = std::chrono::system_clock::now();
    std::chrono::duration<double> elapsed_time = end - start;
    printf("Random Test: Heads %.0f%% Tails %.0f%%. Took %.5f seconds\n", headsPct, tailsPct, elapsed_time);

}

int main(){
    // printf("%s!\n", "Hello World");
    flip_coin(1000000000);
    return 0;
}