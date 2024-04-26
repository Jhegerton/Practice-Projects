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
