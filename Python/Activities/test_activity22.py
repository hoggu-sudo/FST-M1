import pytest

def test_addition():
    assert 10 + 15 == 25

def test_subtraction():
    assert 50 - 35 == 15

@pytest.mark.activity
def test_multiplication():
    assert 5 * 20 == 100

@pytest.mark.activity
def test_division():
    assert 100 / 5 == 20