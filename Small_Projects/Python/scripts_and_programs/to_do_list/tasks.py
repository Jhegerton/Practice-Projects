#!/usr/bin/env python3
"""
This module is for the methods and values regarding the tasks
This is the source of most of the programs functionality
and is where the user_interface class calls its methods
"""
from typing import Generator, List
from gen_id import Gen_Id
from errors import TaskNotFoundError, TaskLimitError
from util import is_similar


class Tasks[Tasks]:
    """
    This class hold all the tasks that are stored in the program after entry
    It also holds all operations involving the tasks
    """
    class Task[Task]:
        """
        This class holds the definition of a task object and its string
        representation. It is only required in the Tasks class, so it is nested
        """
        def __init__(self: Task, id_val, task_name, deadline) -> None:
            """
            Instantiates a Task object
            :param id_val: The id of the task
            :param task_name: The description of the task
            :param deadline: The deadline of the task
            """
            self.id_val: str = id_val
            self.task_name: str = task_name
            self.deadline: str = deadline

        def __str__(self: Task) -> str:
            """
            This method returns the string formatted representation
            of the task for display
            :return: str
            """
            return f'{self.id_val} | {self.task_name} | {self.deadline}'

    def __init__(self: Tasks) -> None:
        """
        Instantiates a Tasks object with no parameters
        """
        self.task_list: List[Tasks.Task] = []  # The lists of tasks stored in the program
        self.gen_id: Gen_Id = Gen_Id()  # The instantiation of an internal Gen_Id Object

    def show_tasks(self: Tasks) -> None:
        """
        This method displays all current tasks stored in the program.
        If nothing is stored it shows an empty message.
        :return: None
        """
        # Checks to see if the task list is empty
        if self.task_list:
            # Displays the task list to the console
            task_list_string: str = '\n'.join([str(task) for task in self.task_list]) + '\n'
            print('[YOUR TASKS]', task_list_string, sep='\n')
        else:
            # Displays that the list is empty
            print('[YOUR TASKS]', 'No tasks recorded', sep='\n')

    def add_task(self: Tasks) -> None:
        """
        This message adds a tasks to the program collection for manipulation
        :return: None
        """
        # Prints the header for the add task method
        print('[ADD TASK]')
        print('Enter "back" as the first value to return to the menu')
        # Initializes the id generator and checks if it can be returned
        id_gen: Generator[str, None, None] | None = self.gen_id.create_unique_ids()
        if id_gen:
            id_val: str = next(id_gen)  # Gets a unique id from the generator
            task_name: str = input('What is the task? ')  # Gets the task description

            # returns to the parent main menu function
            if task_name == 'back':
                return

            deadline: str = input('What is the deadline? ')  # Gets the task deadline

            # Adds the newly instantiated task object to the task list
            task: Tasks.Task = self.Task(id_val, task_name, deadline)
            self.task_list.append(task)
        else:
            # Create Task Limit Exception because there can be no more unique ids
            # Notify User
            raise TaskLimitError("You have reached your limit on task count")

    def complete_task(self: Tasks) -> None:
        """
        This method will delete a task by matching an inputted id to one in the collection
        If none exists it catches an exception and displays it can't be found.
        This method also will recognize what id is trying to be typed if misspelled and
        display it agin with a string marking the difference.
        :return: None
        """
        print('[COMPLETE TASK]', end='\n\n')
        end: bool = False  # Initializes the exit condition for the while loop
        # Checks to see if there are any tasks stored
        if self.task_list:
            # Displays stored tasks
            self.show_tasks()
            while not end:
                try:
                    # Gets the id to delete from the user
                    id_val_input: str = input('Enter "back" to return to the menu,'
                                              ' otherwise enter id to complete: \n')

                    # Returns to the main menu if desired
                    if id_val_input == 'back':
                        return

                    # Initializes variables for calculating the
                    # most similar existing string to recommend
                    most_similarity: float = 0.0
                    closest_task: Tasks.Task = None
                    closest_diff: str = ''

                    # Iterates through every stored string and checks for the most similar
                    for i, task in enumerate(self.task_list):
                        sim_id, similarity, diff = is_similar(id_val_input, task.id_val)
                        # Checks for an exact match and deletes the
                        # task and notifies the user
                        if task.id_val == id_val_input:
                            end = True
                            del self.task_list[i]
                            print(f'{task.task_name} completed')
                            break

                        # Finds the most similar at each iteration step
                        if similarity > most_similarity:
                            closest_task = task
                            closest_diff = diff
                            most_similarity = similarity

                    else:
                        # Checks for strings with a similarity of more than fifteen percent
                        # If it matches it sends a custom error message that the task was not found
                        # but the user might be trying a specific string. Otherwise, it just shows a
                        # standard error message
                        if most_similarity > .15:
                            err_msg = (f'The id given does not match any task. '
                                       f'Did you mean this?\n{closest_task}\n'
                                       f'{closest_diff}\n')
                        else:
                            err_msg = 'The id given does not match any task.\n'
                        raise TaskNotFoundError(err_msg)
                # Catches the task not found error and displays it so
                # the user can try again
                except TaskNotFoundError as e:
                    print(e)
        else:
            # Shows that there are no tasks to complete
            self.show_tasks()


def main() -> None:
    """
    This is the main method for the tasks module for testing its methods
    :return: None
    """
    tasks: Tasks = Tasks()  # Initializes Tasks object

    # Initializes generator method and checks to see if it is None
    gen: Generator[str, None, None] | None = tasks.gen_id.create_unique_ids()
    if gen:
        # Initializes the test task and stores them in a list
        t1: Tasks.Task = tasks.Task(next(gen), 'Wash the dishes', 'Today')
        t2: Tasks.Task = tasks.Task(next(gen), 'Take out the trash', 'Tomorrow')
        t3: Tasks.Task = tasks.Task(next(gen), 'Do Jury Duty', 'Saturday')
        tasks.task_list = [t1, t2, t3]

    # Tests the complete task method by execution then displaying the outcome
    tasks.complete_task()
    tasks.show_tasks()


if __name__ == '__main__':
    main()
