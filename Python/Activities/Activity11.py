fruitInventory = {
    'banana'   : '24',
    'apple'    : '90',
    'jackfruit': '4',
    'papaya'   : '7',
    'blueberry': '130', 
    'guava'    : '30'
}

fruit=input('Enter the fruit you want to buy: ').lower()

if(fruit in fruitInventory):
    print(fruit+' is available')
else:
    print(fruit+' is not available')