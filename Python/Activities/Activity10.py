numList= tuple(input("Enter the number list for addition; please use coma(,) as a separator: ").split(','))

print('Given list is: ',numList)
print('Numbers divisible by 5 are:')
for x in numList:
    if (int(x)%5 == 0):  
        print(x)
    