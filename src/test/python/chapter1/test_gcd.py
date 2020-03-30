from unittest import TestCase
from chapter1.gcd import gcd

class TestGcd(TestCase):
    def test_gcd(self):
        self.assertEqual(gcd(7, 5), 1)
        self.assertEqual(gcd(18, 6), 6)
        self.assertEqual(gcd(2166, 6099), 57)
