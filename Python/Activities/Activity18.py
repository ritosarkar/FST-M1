import pandas

dataFrameR = pandas.read_csv("creds.csv")
print("========[print full data]==========")
print(dataFrameR)

print("========[print userName]==========")
print(dataFrameR["userName"])

print("=====[userName and password at position 2]===========")
print("Username: ", dataFrameR["userName"][1] , "| Password: ", dataFrameR["password"][1])

	
print("Data sorted in ascending userNames:")
print(dataFrameR["userName"].sort_values())

print("Data sorted in ascending password:")
print(dataFrameR["password"].sort_values(ascending=False))