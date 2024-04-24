menu = '''
--- Rock Paper Scissors Game ---
How many rounds would you like to play? '''


class User:

    def __init__(self, win_count):
        self._win_count = win_count
        self._entry = None

    def win_count(self, add_num=None):
        if add_num:
            self._win_count += add_num

        else:
            return self._win_count

    def get_entry(self):
        while True:
            entry = input('Rock, paper or scissors [r/p/s]? ')
            if entry not in 'rps':
                continue
            else:
                self._entry = entry
