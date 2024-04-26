import unittest
from errors import (
    TimeOutError,
    TaskNotFoundError,
    TaskLimitError
)


class TestErrors(unittest.TestCase):

    def setUp(self):
        pass

    def tearDown(self):
        pass

    def test_time_out_error(self):
        with self.assertRaises(StopIteration):
            raise TimeOutError('The generator timed out')

    def test_task_not_found_error(self):
        with self.assertRaises(IndexError):
            raise TaskNotFoundError('The task isn\'t stored in the program')

    def test_task_limit_error(self):
        with self.assertRaises(MemoryError):
            raise TaskLimitError('You have hit the max limit for tasks')
