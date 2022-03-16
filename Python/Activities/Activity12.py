def calSum(number):
    if number:
        return number + calSum(number-1)
    else:
        return 0

result = calSum(10)
print(result)