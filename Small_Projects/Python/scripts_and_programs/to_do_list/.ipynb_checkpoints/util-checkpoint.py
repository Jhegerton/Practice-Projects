#! /usr/bin/env python3
import re
def is_similar(input_str, match_str):
    same = 0
    input_str = re.sub(r'[^A-Za-z0-9]', '', input_str).lower()
    match_str = re.sub(r'[^A-Za-z0-9]', '', match_str).lower()
    shotest_length = len(input_str) if len(input_str) < len(match_str) else len(match_str)
    for c1, c2 in zip(input_str, match_str):
        if c1 == c2:
            same += 1

    percent_match = same / shotest_length  
    return match_str, percent_match

def main():
    str1 = '32Xu-8FLn-bMxn-7pLn-71H4-I67J-1ed5-R4R1'
    str2 = '32xU-8fln-bMxn-7pLm-71H4167J-led5-R4R1'
    print(is_similar(str1, str2)[1])

if __name__ == '__main__':
    main()