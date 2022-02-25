import random

winOne='You won the match.'
winTwo='Computer won the match.'
draw='Match Drawn.'

inputEntered=input('Enter rock paper scissors: ').lower()
if (inputEntered != 'rock' and inputEntered != 'paper' and inputEntered != 'scissors'):
    print('Invalid input try again')
    raise SystemExit

inputOptions=['rock','paper','scissors'] 
computerInput=random.choice(inputOptions)

print ('System input is: '+computerInput+', Your input is: '+inputEntered+'.')

if inputEntered == computerInput:
    print(draw)
elif  inputEntered == 'rock':
    if computerInput == 'scissors':
        print(winTwo)
    else:
        print(winOne)
elif inputEntered == 'paper':
    if computerInput == 'scissors':
        print(winOne)
    else:
        print(winTwo)
elif inputEntered == 'scissors':
    if computerInput=='rock':
        print(winTwo)
    else:
        print(winOne)