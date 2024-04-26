#!/usr/bin/env python3
"""
This module hold the class for creating the unique randomly generated ids for the list items
"""
import random
from typing import List, Generator

from errors import TimeOutError


class GenId[Gen_Id]:
    """
    This class has the methods and constant required to create unique ids
    """

    # Values of letters and digits are stored as immutable but indexable strings
    letters: str = 'abcdefghijklmnopqrstuvwxyz'
    digits: str = '0123456789'
    # timeout value is stored at the class level
    timeout: int = 0

    def __init__(self: Gen_Id, length: int = 4, repeat: int = 8) -> None:
        self.length = length  # the length of the unique id
        self.repeat = repeat  # the length of the repeated sections
        # Initializes a list of strings that is always defined empty
        self.unique_id_list: List[str] = []

    def create_unique_ids(self: Gen_Id) -> Generator[str, None, None] | None:
        """
        Generates unique ids
        :return: Generator[str] | None
        """
        # Sets the variable that keeps count of how many times
        # the method tries to amke a unique string
        timeout: int = 0
        while True:
            # Initializes the string for the individual sections
            # and the outputted unique id
            section: str = ''
            uniq_id: str = ''

            # Iterates over each section for the total defined length of the string
            for _ in range(self.repeat):
                for _ in range(self.length):
                    letter: str = ''
                    digit: str = ''
                    # randomly choose for a lowercase or uppercase letter option
                    case: str = random.choice(['upper', 'lower'])
                    if case == 'upper':
                        letter = random.choice(self.letters).upper()
                    elif case == 'lower':
                        letter = random.choice(self.letters)
                    digit = random.choice(self.digits)

                    # Character by character randomly choose between the letter or the digit
                    section += random.choice([letter, digit])
                else:
                    # Combine the section to create the total string
                    uniq_id += section
                    uniq_id += '-'
                    section = ''

            if uniq_id not in self.unique_id_list:
                uniq_id = uniq_id[:-1]  # Removes the '-' symbol at the end of the string

                # Adds the unique string to the collection which
                # is stored at the class level
                self.unique_id_list.append(uniq_id)
                # Generate the unique string as an infinite iterable so any numbers of unique
                # strings would be created.
                yield uniq_id

            else:
                # Iterates the timeout variable every time the program fails to generate a unique number
                self.timeout += 1
                if self.timeout == 200:
                    # Stops creating new ids if it fails to make a unique number too many times
                    raise TimeOutError('The program timed out please try to run it again')
                # Continues iterating until the timeout variable reaches 200
                continue
                    
                        
def main() -> None:
    """
    This method is a main method for the gen_id module for testing its methods
    :return: None
    """
    gen_id: Gen_Id = Gen_Id()
    
    gen: Generator[str, None, None] | None = gen_id.create_unique_ids()
    # Checks if gen is still a generator object
    if gen:
        # Creates a large amount of ids
        ids: List[str] = [next(gen) for _ in range(10**5)]
        # sorts the ids so that identical ids would follow each other
        ids.sort()
        # assign first id
        prev_id: str = ids.pop()

        # Iterates through every id to see if any match the ones before it
        # Checks if all the values are unique
        while ids:
            curr_id: str = ids.pop()
            if prev_id == curr_id:
                print(prev_id)
                prev_id = curr_id
                break
        else:
            print('All values were unique.')


if __name__ == '__main__':
    main()

        