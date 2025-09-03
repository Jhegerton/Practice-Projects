from math import ceil, sqrt
class MathUtils:
    _instance: 'MathUtils' = None

    def __new__(cls) -> 'MathUtils':
        if cls._instance is None:
            cls._instance =  super().__new__(cls)
        return cls._instance

    @staticmethod
    def is_prime(number) -> bool:
        min_val = 2
        max_val = ceil(sqrt(number)) + 1
        total_range = range(min_val, max_val)

        for num in total_range:
            if number % num == 0:
                return False
        return True

    @classmethod
    def get_prime_factors(cls, number_to_factor):
        factors : list = [] # List to store prime factors
        min_val : int = 2
        max_val : int = ceil(sqrt(number_to_factor)) + 1
        total_range : range = range(min_val, max_val)

        if not cls.is_prime(number_to_factor):
            for num in total_range:
                if number_to_factor % num == 0:
                    # Divide and Conquer method to find prime factors
                    factors.append(num)
                    factors.extend(cls.get_prime_factors(number_to_factor // num))
                    # Return once we have found all factors
                    return factors
        # if the number is prime return as a list of one
        return [number_to_factor]

    def __repr__(self):
        return f"<<class=MathUtils, id={id(self)}>>"

def main():
    u1 = MathUtils()
    u2 = MathUtils()
    u3 = MathUtils()

    print(f"u1: {u1}")
    print(f"u2: {u2}")
    print(f"u3: {u3}")

    # print(u1.get_prime_factors(24))  # Example usage

if __name__ == "__main__":
    main()