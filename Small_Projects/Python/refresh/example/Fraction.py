__author__ = ["Harrison Egerton"]
__export__ = ["Fraction"]

import math

class Fraction:
    """
    A class to represent a fraction
    """
    def __init__(self, numer: int | None=None, denom: int | None =None) -> None:
        """
        Initialise a fraction with the given numerator and denominator
        """
        self._numer = numer
        self._denom = denom
        if None not in self.__dict__.values():
            self.simplify() # Make sure that the fraction is simplified

    def __setattr__(self, name: str, value: any) -> None:
        """
        Restrict the attributes that can be set
        """
        if name not in "_numer _denom":
            raise AttributeError("Only a numerator and denominator can be assigned")
        super().__setattr__(name, value)

    @property
    def numer(self) -> int:
        """
        Get the numerator of a fraction
        :return: the numerator
        """
        return self._numer

    @numer.setter
    def numer(self, value: int) -> None:
        """
        Set the numerator of a fraction
        :param value: The new numerator
        """
        self._numer = value

    @property
    def denom(self) -> int:
        """
        Get the denominator of a fraction
        :return: the denominator
        """
        return self._denom

    @denom.setter
    def denom(self, value: int) -> None:
        """
        Set the denominator of a fraction
        :param value: The new denominator
        """
        if value == 0:
            raise ValueError("The denominator cannot be zero.")
        self._denom = value


    def simplify(self) -> 'Fraction':
        """
        Simplify the fraction in place
        :return: The fraction itself
        """
        if None in self.__dict__.values():
            raise ValueError(
                "Fraction cannot be simplified because it has missing values."
            )
        gcd: int = math.gcd(self._numer, self._denom)
        self._numer //= gcd
        self._denom //= gcd
        return self

    def __float__(self) -> float:
        """
        Return the fraction as a float
        :return: The fraction as a float
        """
        return float(self._numer) / float(self._denom)

    def __int__(self) -> int:
        """
        Return the fraction as an int if possible
        :return: The fraction as an int
        ""
        """
        if self._denom == 1:
            return int(self._numer)
        else:
            raise ValueError("Cannot convert to int because the denominator is not 1.")

    def __add__(self, other: 'Fraction') -> 'Fraction':
        """
        Add two fractions together
        :param other: The second fraction to add
        :return: The sum
        """
        numer = (self._numer * other.denom) + (other.numer * self._denom)
        denom = self._denom * other.denom
        temp =  Fraction(numer, denom)
        return temp.simplify()

    def __sub__(self, other: 'Fraction') -> 'Fraction':
        """
        Subtract two fractions together
        :param other: The second fraction to subtract
        :return: The difference
        """
        numer = (self._numer * other.denom) - (other.numer * self._denom)
        denom = self._denom * other.denom
        temp = Fraction(numer, denom)
        return temp.simplify()

    def __mul__(self, other: 'Fraction') -> 'Fraction':
        """
        Multiply two fractions together
        :param other: The second fraction to multiply
        :return: The product
        """
        numer = self._numer * other.numer
        denom = self._denom * other.denom
        temp = Fraction(numer, denom)
        return temp.simplify()

    def __truediv__(self, other: 'Fraction') -> 'Fraction':
        """
        Divide two fractions together
        :param other: The second fraction to divide
        :return: The quotient
        """
        numer = self._numer * other.denom
        denom = self._denom * other.numer
        temp = Fraction(numer, denom)
        return temp.simplify()

    def __repr__(self) -> str:
        """
        Return a string representation of the fraction
        """
        return (f"<<Fraction, id={id(self)}> "
                f"{', '.join(f'{key}={value}' for key, value in self.__dict__.items())}>")

    def __str__(self) -> str:
        """
        Return a natural language representation of the fraction
        """
        return f"{self.numer}/{self.denom}"