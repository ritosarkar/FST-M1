inputNum=int(input('Input the number: '))

if (inputNum%2) == 0:
    txt='{} is even number.'
else:
    txt = '{} is odd number'


print(txt.format(str(inputNum)))