#! /usr/bin/env python3
"""
This module holds universal utility functions
"""
import re
from itertools import zip_longest
from typing import Tuple


def is_similar(input_str: str, match_str: str) -> Tuple[str, float, str]:
    """
    Checks for the similarity of two strings and returns the
    matching string, the percent they are the same and a
    differing string
    :param input_str: The input string from the console
    :param match_str: The stored string to test against
    :return: (str, float, str)
    """
    diff: str = ''  # Initializes the difference string
    # Uses zip_longest to get the characters from each string even if one string is shorter
    # Iterates through the characters in each string to check if they are the same
    for c1, c2 in zip_longest(input_str, match_str):
        # if they are the same the diff string appends an underscore
        if c1 == c2:
            diff += '_'
        # if they are different the diff string appends the correct letter from
        # the stored string
        else:
            diff += f'{c2}'

    # Replaces the non-alphanumeric characters from the string and turns the strings
    # lowercase to control for typos that cause changes in string length
    # or to find the similarities in the strings in case they have case typos
    input_str = re.sub(r'[^A-Za-z0-9]', '', input_str).lower()
    match_str = re.sub(r'[^A-Za-z0-9]', '', match_str).lower()

    # Initializes same, which is a count of all the characters in the same
    # location in both strings
    same: int = 0
    # finds the length of the shortest string
    shortest_length: int = len(input_str) if len(input_str) < len(match_str) else len(match_str)
    # checks step by step for the same character
    for c1, c2 in zip(input_str, match_str):
        if c1 == c2:
            same += 1

    # Calculates the percentage the strings match
    percent_match = same / shortest_length

    return match_str, percent_match, diff


def main() -> None:
    """
    This is the main method for the util module for testing its methods
    :return: None
    """
    # Initializes two test id strings
    str1: str = '32Xu-8FLn-bMxn-7pLn-71H4-I67J-1ed5-R4R1'
    str2: str = '32xU-8fln-bMxn-7pLm-71H4167J-led5-R4R1'

    # Gets the tuple output and prints it
    match_str, percent_match, diff = is_similar(str1, str2)
    print(match_str, percent_match, diff, sep='\n')


if __name__ == '__main__':
    main()
