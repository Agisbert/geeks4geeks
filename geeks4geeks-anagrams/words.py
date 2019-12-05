# basic method of input output 
# input N 
# Solution for -> https://practice.geeksforgeeks.org/problems/count-occurences-of-anagrams/0

n = int(input()) 

for x in range(n):	
    text = input()
    word = input()
    nAnagrams = 0

    textLen= len(text)
    wordLen= len(word)
    
    for c in range(textLen-wordLen+1):
        charsInWord = list(word)
        for i in range(c, c+wordLen):
            if text[i] in charsInWord:
                charsInWord.remove(text[i])
            else:
                c = i+1
                break
            if not charsInWord:
                nAnagrams+=1 
    print(nAnagrams)