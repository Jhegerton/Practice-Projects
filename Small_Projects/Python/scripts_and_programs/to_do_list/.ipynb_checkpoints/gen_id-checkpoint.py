#!/usr/bin/env python3
import random
from errors import TimeOutError

class Gen_id:

    letters = 'abcdefghijklmnopqrstuvwxyz'
    digits = '0123456789'

    def __init__(self, length=4, repeat=8):
        self.length = length
        self.repeat = repeat
        self.unique_id_list = []

    def create_unique_ids(self):
        timeout = 0
        while True:
            section = ''
            uniq_id = ''
            for _ in range(self.repeat):
                for _ in range(self.length):
                    letter, digit = '', ''
                    case = random.choice(['upper', 'lower'])      
                    if case == 'upper':
                        letter = random.choice(self.letters).upper()
                    elif case == 'lower':
                        letter = random.choice(self.letters)
                    digit = random.choice(self.digits)
                    
                    section += random.choice([letter, digit])
                else:
                    uniq_id += section
                    uniq_id += '-'
                    section = ''
                           
                    
            if uniq_id not in self.unique_id_list:
                uniq_id = uniq_id[:-1]
                self.unique_id_list.append(uniq_id)
                yield uniq_id

            else:
                uniq_id = ''
                time_out += 1
                if time_out == 200:
                    raise TimeOutError('The program timed out please try to run it again')
                continue
                    
                        
def main():
    gen_id = Gen_id()
    
    gen = gen_id.create_unique_ids()
    
    for _ in range(50):
        print(next(gen))

if __name__ == '__main__':
    main()

        