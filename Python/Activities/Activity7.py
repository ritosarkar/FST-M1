numList=input("Enter the number list for addition; please use coma(,) as a separator: ").split(',')
print(numList)
result = 0
for x in numList:
    result +=  int(x)
print(result)