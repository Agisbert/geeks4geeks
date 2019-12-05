# 0123456789abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ
# 4294967295

# We can cover up to 62^6 56800235584

testCases = int(input())

letters = list("0123456789abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ")

for testNumber in range(0, testCases):
    id = int(input())
    url = ""
    while True:
        module = id % 62
        url += str(letters[module])
        id = (id - module) // 62
        if(id == 0):
            break
    print (url)
    url = ''.join(reversed(url))
    urlLenght = len(url)
    value = 0
    for i in range (0, urlLenght):
        value += letters.index(url[i]) * (62 ** (urlLenght - 1 - i))
    print (value)