import re
class Solution:
    @staticmethod
    def myAtoi(s: str) -> int:
        upper_limit: int = 2**31-1
        lower_limit: int = -2**31
        s = re.sub(r'\s', '', s)
        s = re.sub(r'.*?(-?0*[1-9]?[0-9]*).*', r'\1', s)
        if s == '':
            return 0

        num: int = int(s)

        if num > upper_limit:
            return upper_limit
        elif num < lower_limit:
            return lower_limit
        return num

def main():
    sol = Solution()
    print(sol.myAtoi('+-12'))


if __name__ == '__main__':
    main()
