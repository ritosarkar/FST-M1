import pytest

def test_addition():
    num1=10
    num2=20
    sum=num1+num2
    assert sum==30

def test_substraction():
    num1=30
    num2=40
    diff=num2-num1
    assert diff==10

def test_multilication():
    num1=10
    num2=20
    mul=num1*num2
    assert mul==200

def test_division():
    num1=100
    num2=5
    quot=num1/num2
    assert quot==20
