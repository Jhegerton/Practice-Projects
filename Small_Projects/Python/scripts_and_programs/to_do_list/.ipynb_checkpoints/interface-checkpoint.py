import tasks


#!usr/bin/env python3
import tasks
import traceback
def show_menu():
    menu = '''
        == TODO LIST ==
        [1] show tasks
        [2] add task
        [3] complete task
        [4] exit
        Your choice: '''
    tks = tasks.Tasks()
    select = ''
    while True:
        try:
            select = input(menu)
            if select == '1':
                print()
                tks.show_tasks()
            elif select == '2':
                print()
                tks.add_task()
            elif select == '3':
                print()
                tks.complete_task()
            elif select == '4':
                return
            else:
                print(f'{select} was an invalid entry. Please try again.')
                
        except Exception as e:
            print(e)
