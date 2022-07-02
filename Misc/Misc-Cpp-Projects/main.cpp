#include <iostream>
#include <vector>
#include <ctime>
#include <map>

int nextPrime(int first);

using namespace std;

int main() {
    vector<string> vec;
    vector<string> :: iterator it;
    srand((int) time(0));
    map<int, double> results;
    string choice;
    printf("%s\n", "Enter your choices");
    do {
        getline(cin, choice);
        if (choice.length() != 0) {
            vec.push_back(choice);
        }
    }while(choice.length() != 0);

    int count = vec.size();


    for(int i = 0; i < nextPrime(rand()); i++){
        int res = rand() % count;
        if(results.count(res)){
            results[res] = results[res] + 1;
        }else{
            results.insert({res, 1.0});
        }
    }
    int winner = 0;
    double temp = 0.0;
    double total = 0.0;
    for(auto const& values : results){
        if(temp < values.second){
            winner = values.first;
            temp = values.second;
        }
        total += values.second;
    }

    for(auto const& values : results){
        string string_obj(vec[values.first]);
        char* name = &string_obj[0];
        printf("%s with %.0f votes (%.2f%%)\n", name , values.second, values.second / total * 100);
    }
    cout << vec[winner] << endl;
    return 0;
}

int nextPrime(int first){
    bool check;
    int temp;
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

}
