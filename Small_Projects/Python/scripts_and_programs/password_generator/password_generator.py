#!/usr/bin/env python3
import random
menu = '''
-- Password generator --
Choose option:
1: generate password
2: exit the program
Your choice: '''

letters = 'abcdefghijklmnopqrstuvwxyz'
digits = '0123456789'
special_chars = '!@#$%&*^|()_+'
again = True

while again:
    response = input(menu)

    if response == '1':
        length = int(input('Provide password length: '))
        use_upper = input('Use uppercase letters? (y/n): ') == 'y'
        use_digit = input('Use digits? (y/n): ') == 'y'
        use_special_char = input('Use special characters? (y/n): ') == 'y'

        password = ''
        done = False
        is_formatted = False
        i = 0
        while not is_formatted:
            for _ in range(length):
                letter, digit, char = '', '', ''
                    
                if use_upper:
                    
                    if random.randint(0,1) == 1:
                        letter = random.choice(letters).upper()
                    else: 
                        letter = random.choice(letters)
                else:
                    letter = random.choice(letters)
    
                if use_digit:
                    digit = random.choice(digits)
    
                if use_special_char:
                    char = random.choice(special_chars)
    
                next_char = ''
                
                while next_char == '':
                    next_char = random.choice([letter, digit, char])
                    password += next_char
                    
            check = True
            for char in password:

                if use_upper and char in letters.upper():
                    check = True
                    continue
                elif use_upper:
                    check = False

                if use_digit and char in digits:
                    check = True
                    continue
                elif use_digit:
                    check = False

                if use_special_char and char in special_chars:
                    check = True
                    continue
                elif use_special_char:
                    check = False
                    
            is_formatted = check
            if not is_formatted:
                password = ''

        print(f'Generated password: {password}')     

    elif response == '2':
        print('Bye!')
        again = False

    else:
        print('Please enter a correct value')
        