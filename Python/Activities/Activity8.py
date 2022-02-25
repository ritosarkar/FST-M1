numList= input("Enter the number list for addition; please use coma(,) as a separator: ").split(',')

if (numList[0] == numList[len(numList)-1]):
    print('true')
else:
    print('false')
