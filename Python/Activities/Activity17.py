import pandas

credentials={
    "userName":["admin","Charles","Deku"],
    "password":["password","Charl13","AllMight"]
}

dataFile=pandas.DataFrame(credentials)
dataFile.to_csv("creds.csv",index=False)
print(dataFile)