__author__ = ["Harrison Egerton"]
__export__ = ["greet"]

from os import linesep as newline
# practice data structures
def greet(): # making a menu with dictionaries
    valid_language : bool = False
    language: str = ""
    name : str = input("What is your name? ")
    greetings : dict[str, (str, str)] = {
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
            f"What language do you speak? {newline}"
            f"Options: {newline}{f'{newline}'.join(greetings.keys())}{newline}: "
        ).title()
        try:
            assert language in greetings.keys()
            valid_language = True
        except AssertionError: # if the user enters an invalid language
            print(f"Sorry. I can't speak {language}. Can you please pick from the list above?{newline}")

    print(f"{greetings[language][0]} {name}.")
    hobby = input("What is your favorite hobby? ")
    print(f"I love {hobby.lower()} too!")
    print(f"{greetings[language][1]} {name}.")
