import unittest
from util import is_similar


class TestUtil(unittest.TestCase):
    def setUp(self):
        self.input_str: str = '32Xu-8FLn-bMxn-7pLn-71H4-I67J-1ed5-R4R1'
        self.store_str: str = '32xU-8fln-bMxn-7pLm-71H4167J-led5'

    def tearDown(self):
        del self.input_str
        del self.store_str

    def test_is_different(self):
        match_str, percent_match, diff = is_similar(self.input_str, self.store_str)
        self.assertEqual(match_str, '32xU-8fln-bMxn-7pLm-71H4167J-led5')
        self.assertEqual(percent_match, 0.8928571428571429)
        self.assertEqual(diff, '__xU__fl__________m_____167J-led5XXXXXX')

    def test_identical_strings(self):
        self.assertEqual(is_similar("hello", "hello"), ("hello", 1.0, "_____"))

    def test_different_strings(self):
        self.assertEqual(is_similar("abc", "def"), ("def", 0.0, "def"))

    def test_partial_similarity(self):
        self.assertEqual(is_similar("abc", "abd"), ("abd", 2 / 3, "_d_"))

    def test_case_sensitivity(self):
        self.assertEqual(is_similar("abc", "AbC"), ("AbC", 1.0, "___"))

    def test_substring(self):
        self.assertEqual(is_similar("abc", "abcdef"), ("abcdef", 1.0, "_____f"))

    def test_empty_string(self):
        self.assertEqual(is_similar("", "abc"), ("abc", 0.0, "abc"))

    def test_non_alphanumeric(self):
        self.assertEqual(is_similar("abc!!", "abc"), ("abc", 1.0, "___"))
