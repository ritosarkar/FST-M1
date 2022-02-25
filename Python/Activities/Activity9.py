list1 = [15,21,19,20,10,12,68]

list2  = [19,10,11,20,22,29,18,42]

list3 = list()

for x in list1:
    if (x %2 != 0):
        list3.append(x)

for x in list2:
    if (x %2 == 0):
        list3.append(x)

print (list3)
