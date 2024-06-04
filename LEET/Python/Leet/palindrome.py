class Solution:

    @staticmethod
    def is_palindrome(x: int) -> bool:

        if 0 <= x <= 2 ** 31 - 1:
            places = []

            while x > 0:
                num = x % 10
                places.append(num)
                x = (x - num) // 10

            if places != places[::-1]:
                return False
            return True
        return False


def main():
    solution = Solution()
    is_palindrome = solution.is_palindrome
    x, y, z = is_palindrome(121), is_palindrome(-121), is_palindrome(10)

    assert x is True
    assert y is False
    assert z is False


if __name__ == '__main__':
    main()
