from typing import *
from re import split, sub


class Solution:

    def isMatch(self, s: str, p: str) -> bool:
        past = s[0]
        s_out = []
        for i in range(1, len(s)):
            s_out.append(past)
            if s[i] == past and s[i+1] != '*':
                s_out.append(s[i])
                past = s[i]

            elif s[i] == past and i + 1 < len(s):
                if s[i+1] == '*':
                    s_out.append('|')
                    s_out.append(s[i])
                    s_out.append(s[i+1])
                    past = s[i+1]
                continue

            elif s[i] == '*':
                past = s[i]
                continue

            elif s[i] == '.':
                s_out.append('|')
                s_out.append(s[i])
                past = s[i]

            elif s[i] != past:
                past = s[i]
                s_out.append('|')
                s_out.append(s[i])

        print(s_out)







def main():
    sol = Solution()
    s, p = 'a.bb*.cc.d*.e', 'nn*khk*ff'
    print(s,p)
    sol.isMatch(s, p)


if __name__ == '__main__':
    main()
