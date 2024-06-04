function isPalindrome(x: number): boolean {
    if(x >= 0 && x < Math.pow(2, 31) - 1){
        let places: Array<number> = []

        while(x > 0){
            places.push(x%10)
            x = (x - (x % 10)) / 10
        }
        for(let i: number = 0; i < places.length; i++){
            if(places[i] != places.reverse()[i]){
                return false;
            }
        }
        return true

    }
    return false
};