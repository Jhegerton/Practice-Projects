__author__ = ["Harrison Egerton"]
__export__ = ["greet"]

from os import linesep as new_line
# practice data structures
def greet(): # making a menu with dictionaries
    valid_language : bool = False
    name : str = input("What is your name? ")
    greetings : dict[str, (str, str)] = {
        # dictionary of languages and their greetings
         "English"    : ("Hi", "Bye"),
         "French"     : ("Bonjour", "Au revoir"),
         "Spanish"    : ("Hola", "Adios"),
         "German"     : ("Hallo", "Auf Wiedersehen"),
         "Italian"    : ("Ciao", "Arrivederci"),
         "Portuguese" : ("Olá", "Até"),
         "Japanese"   : ("Kon'nichiwa", "Sayōnara"),
         "Chinese"    : ("Ni hao", "Shi ba")
        }
    while valid_language is False:
        language = input(
            f"What language do you speak? {new_line}"
            f"Options: {new_line}{f'{new_line}'.join(greetings.keys())}{new_line}: "
        ).title()
        try:
            print(f"{greetings[language][0]} {name}.")
            hobby = input("What is your favorite hobby? ")
            print(f"I love {hobby.lower()} too!")
            print(f"{greetings[language][1]} {name}.")
            valid_language = True
        except KeyError: # if the user enters an invalid language
            print(f"Sorry. I can't speak {language}. "
                  f"Can you please pick from the list above?{new_line}")