import unittest

from refresh.example.Fraction import Fraction

class TestMyFraction(unittest.TestCase):
    empty_fraction : Fraction = Fraction()
    fract2: Fraction = Fraction(1, 2)
    fract3: Fraction = Fraction(2, 3)

    def test_numer_prop(self):
        self.empty_fraction.numer = 10
        self.assertEqual(self.empty_fraction.numer,
                         10,
                         "Fraction numer property setter failed")

    def test_denom_prop(self):
        self.empty_fraction.denom = 20
        self.assertEqual(self.empty_fraction.denom,
                         20,
                         "Fraction denom property setter failed")

    def test_denom_setter_error(self):
        with self.assertRaises(ValueError):
            self.empty_fraction.denom = 0

    def test_wrong_attribute(self):
        with self.assertRaises(AttributeError):
            self.empty_fraction.wrong_attr = 10

    def test_simplify(self):
        fract = Fraction(6, 8)
        fract_vals = list(fract.__dict__.values())
        self.assertEqual(fract_vals,
                         [3, 4],
                         "Fraction simplification failed")

    def test_float(self):
        self.assertEqual(float(self.fract2),
                         0.5,
                         "Fraction float conversion failed")

    def test_int(self):
        fract = Fraction(2, 1)
        self.assertEqual(int(fract),
                         2,
                         "Fraction int conversion failed")

    def test_int_error(self):
        fract = Fraction(3,5)
        with self.assertRaises(ValueError):
            int(fract)

    def test_add(self):
        add = self.fract2 + self.fract3
        fract_vals = list(add.__dict__.values())
        self.assertEqual(fract_vals,
                         [7, 6],
                         "Fraction addition failed")

    def test_subtract(self):
        sub = self.fract2 - self.fract3
        fract_vals = list(sub.__dict__.values())
        self.assertEqual(fract_vals,
                         [-1, 6],
                         "Fraction subtraction failed")

    def test_multiply(self):
        prod = self.fract2 * self.fract3
        fract_vals = list(prod.__dict__.values())
        self.assertEqual(fract_vals,
                         [1, 3],
                         "Fraction multiplication failed")

    def test_divide(self):
        quot = self.fract2 / self.fract3
        fract_vals = list(quot.__dict__.values())
        self.assertEqual(fract_vals,
                         [3, 4],
                         "Fraction division failed")

    def test_repr(self):
        fract = Fraction(4, 6)
        self.assertEqual(repr(fract),
                         f"<<Fraction, id={id(fract)}> _numer=2, _denom=3>",
                         "repr method failed")

    def test_str(self):
        fract = Fraction(10, 5)
        self.assertEqual(str(fract),
                         "2/1",
                         "str method failed")

if __name__ == '__main__':
    unittest.main()