#!usr/bin/env python3
"""
This module shows the cli for the program.
"""
from tasks import Tasks


def show_menu() -> None:
    """
    Displays the menu and executes the required functions. It will
    continue sharing options until the user quits out of the program
    :return: None
    """
    menu: str = '''
        == TODO LIST ==
        [1] show tasks
        [2] add task
        [3] complete task
        [4] exit
        Your choice: '''
    tks: Tasks = Tasks()
    while True:
        try:
            # select variable matches to what option is selected from the keyboard
            select: str = input(menu)
            match select:
                case '1':
                    print()
                    tks.show_tasks()
                case '2':
                    print()
                    tks.add_task()
                case '3':
                    print()
                    tks.complete_task()
                case '4':
                    return
                case _:
                    # Message is printed if entry is invalid
                    print(f'{select} was an invalid entry. Please try again.')

        # Catches any internal exceptions raised inside the program to avoid an exit condition
        except Exception as e:
            print(e)
