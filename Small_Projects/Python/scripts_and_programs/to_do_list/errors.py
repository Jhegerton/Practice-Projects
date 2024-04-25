#!/usr/bin/env python3
"""
This class defines the custom exceptions for this program
"""


class TimeOutError(StopIteration):
    """
    This class is an exception to be called if the generator
    is taking too many iterations to generate unique passwords
    """
    pass


class TaskNotFoundError(IndexError):
    """
    This class is an exception that is to be called when if a
    task is not found in a list of task objects
    """
    pass


class TaskLimitError(MemoryError):
    """
    This class is an exception that is to be called when the program
    has reached its custom defined max amount of tasks
    """
    pass
        