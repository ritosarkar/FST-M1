
def fibonacci(fibonacciList, count):
    while count!=0:
        listCount=len(fibonacciList)
        nextEle=fibonacciList[listCount-1] + fibonacciList[listCount-2]
        fibonacciList.append(nextEle)
        count-=1


count=int(input("How many Fibonacci number you want to generate: "))
while(count<=1):
    count= int(input("Please enter non-zero, non-negative also value should be > 1: "))

fibonacciList=[0,1]

if count>2 :    
    fibonacci(fibonacciList, count)

print(fibonacciList)
