from math import ceil, sqrt
from typing import Self

class MathUtils:
    instance: Self = None

    def ____init__(self: Self):
        pass

    @classmethod
    def get_instance(cls):
        if cls.instance is None:
            cls.instance = cls()
        return cls.instance

    def get_prime_factors(self: Self, num: int):
        factors = []
        min = 2
        max = ceil(sqrt(num))
        ran = range(min,max)
        print(ran, sep=" ")

def main():
    u = MathUtils.get_instance()

if __name__ == "__main__":
    main()