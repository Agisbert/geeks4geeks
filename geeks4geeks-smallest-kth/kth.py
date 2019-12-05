testCases = int(input())

for testNumber in range(0, testCases):
    arrayLength = int(input())
    array = list(map(int, input().split()))
    array.sort()
    kthElement = int(input())
    print(array[kthElement - 1])