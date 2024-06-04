#include <vector>
#include <cmath>
#include <algorithm>
class Solution {
public:
    bool isPalindrome(int x) {
        if(x >= 0 && x < std::pow(2, 31) - 1){
            std::vector<int> places;

            while(x > 0){
                places.push_back(x % 10);
                x = (x - (x % 10)) / 10;
            }

            std::vector<int> places_reversed(places.size());
            std::reverse_copy(places.begin(), places.end(), places_reversed.begin());

            for(int i = 0; i < places.size(); i++){
                if(places[i] != places_reversed[i]){
                    return false;
                }
            }
            return true;
        }
        return false;
    }
};