from typing import *


class Solution:
    @staticmethod
    def get_locations(s: str, val: str) -> List[int]:
        indexes = []
        cut_len = 0
        try:
            while True:
                index = s.index(val)
                indexes.append(index + cut_len)
                cut_len = len(s[:index + 1])
                s = s[index + 1:]
        except ValueError:
            return sorted(indexes)

    @staticmethod
    def get_path(s: List[str], s_match: List[int]) -> Dict[int, List[str]]:
        path = dict()
        num = 0
        i = 0
        char = 0
        while i < len(s):
            print(f'char: {char}', f'{i}: {s[i]}')
            if i == 0:
                print('first')
                char = s[i]

            if i in s_match:
                print('second')
                temp = []
                temp.append(s[i])
                temp.append(s[i + 1])
                char = s[i + 1] if s[i + 2] else None
                num += 1
                path[num] = temp
                i += 1

            elif char == s[i]:
                print('third')
                temp2 = []
                while i < len(s) and char == s[i]:
                    char = s[i]
                    temp2.append(s[i])
                    i += 1
                path[num] = temp2

            else:
                print('fourth')
                temp3 = [s[i]]
                char = s[i]
                num += 1
                path[num] = temp3

            i += 1
        return path

    def isMatch(self, s: str, p: str) -> bool:
        s_stars: List[int] = self.get_locations(s, '*')
        p_stars: List[int] = self.get_locations(p, '*')
        # print(p_stars)
        s, p = [char for char in s], [char for char in p]
        path = dict()

        s_match = [i - 1 for i in s_stars]
        p_match = [i - 1 for i in p_stars]
        # print(p_match)

        if not s_stars and not p_stars:
            if len(s) != len(p):
                return False
            else:
                while s:
                    if s.pop() != p.pop():
                        return False
                return True
        else:
            print(f's:{s}', f'p:{p}')
            s_path = self.get_path(s, s_match)
            p_path = self.get_path(p, p_match)

            print(f's_path = {s_path}')
            print(f'p_path = {p_path}')


def main():
    sol = Solution()
    sol.isMatch('aabbvvd', 'nn*khk*ff')


if __name__ == '__main__':
    main()
