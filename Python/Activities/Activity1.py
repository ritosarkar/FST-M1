name=input('Enter your name: ')
age=int(input('Enter your age: '))
centuryYear=str(2022+(100-age))
message='{} you will be come 100 year by the year {}'
print(message.format(name,centuryYear))