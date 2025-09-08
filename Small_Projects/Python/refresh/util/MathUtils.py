__author__ = ['Harrison Egerton']
__export__ = ['MathUtils']

from math import ceil, sqrt # unpack math functions
from typing import Generator


class MathUtils: # Singleton class
    """
    MathUtils class contains methods to help with math operations
    """
    _instance: 'MathUtils' = None

    def __new__(cls) -> 'MathUtils':
        """
        Create a new instance of the class only if it doesn't already exist
        """
        if cls._instance is None: # If it doesn't exist create a new instance
            cls._instance =  super().__new__(cls)
        return cls._instance # Always returns the same instance

    @staticmethod
    def is_prime(number) -> bool:
        """
        Returns true if the number is prime or not
        @param number: The number to check if it is prime or not
        @return: True if the number is prime, False otherwise
        """
        # Determine a range of possible divisors
        min_val = 2
        max_val = ceil(sqrt(number)) + 1
        total_range = range(min_val, max_val)

        for num in total_range:
            # Check if the number is divisible by any of the possible divisors
            if number % num == 0:
                return False # If divisible by any divisor, it's not prime
        else:
            return True # If no divisors were found, then it's a prime number

    @classmethod
    def get_prime_factors(cls, number_to_factor) -> list[int]:
        """
        Returns a list of prime factors of the given number
        @param number_to_factor: The number to factor into prime factors
        @return: A list of prime factors
        """
        factors : list = [] # List to store prime factors
        # Determine a range of possible divisors
        min_val : int = 2
        max_val : int = ceil(sqrt(number_to_factor)) + 1
        total_range : range = range(min_val, max_val)

        if number_to_factor == 2: # Handle special case for 2:
           return [2] # Smallest prime number
        else:
            for num in total_range:
                if number_to_factor % num == 0:
                    # Divide and Conquer method to find prime factors
                    # Treat like factor tree
                    factors.extend(cls.get_prime_factors(num))
                    factors.extend(cls.get_prime_factors(number_to_factor // num))
                    # Return once we have found all factors
                    return factors
        # If number is prime, return it as a list of itself
        return [number_to_factor]

    @classmethod
    def get_next_prime_gen(cls, number:int, stop:int=None) -> Generator[int]:
        """
        A generator to get next prime number
        @yield: The next prime number
        """
        has_next: bool = True if stop is None else (number < stop)
        while has_next: # While there is a next prime number to find
            number += 1
            if cls.is_prime(number):
                yield number


    def __repr__(self) -> str:
        """
        Get a standard representation of the object
        @return: A string representation of the object
        """
        return f"<<class=MathUtils, id={id(self)}>>"






def main():
    """
    Main function for testing math utils
    """
    u1 = MathUtils()

if __name__ == "__main__":
    main()