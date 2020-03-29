import pytest
from chapter1.gcd import gcd


def test_gcd():
    assert 1 == gcd(7, 5)
    assert 6 == gcd(18, 6)
    assert 57 == gcd(2166, 6099)
