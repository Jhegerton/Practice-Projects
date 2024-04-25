import random


class GameException(Exception):
    pass


class User:

    def __init__(self, win_count=0):
        self._win_count = win_count
        self._entry = None

    def win_count(self, add_num=None):
        if add_num:
            self._win_count += add_num

        else:
            return self._win_count

    def entry(self):
        return self._entry

    def add_win(self):
        self._win_count += 1

    def get_entry(self):
        while True:
            entry = input('Rock, paper or scissors [r/p/s]? ')
            if entry not in 'rps':
                print('I am sorry that is not one of the accepted inputs. Please try again.')
                continue
            else:
                self._entry = entry
                break


class Computer:

    def __init__(self, win_count=0):
        self._win_count = win_count
        self._entry = None

    def win_count(self, add_num=None):
        if add_num:
            self._win_count += add_num

        else:
            return self._win_count

    def entry(self):
        return self._entry

    def add_win(self):
        self._win_count += 1

    def get_entry(self):
        options = ('r', 'p', 's')
        self._entry = random.choice(options)


class Play:
    _menu = (
        '''
        --- Rock Paper Scissors Game ---
        How many rounds would you like to play? ''')

    def __init__(self):
        self.user = User()
        self.computer = Computer()

    def show_menu(self):
        count = ''
        while not count.isdigit():
            count = input(self._menu)
            if count.isdigit() and int(count) >= 0:
                return int(count)
            else:
                print('Input is invalid. Please try again.')

    def play_game(self):
        round_count = self.show_menu()
        if round_count:
            for _ in range(round_count):

                self.user.get_entry()
                self.computer.get_entry()
                u = self.user.entry()
                c = self.computer.entry()
                print(f'You: {u} | Computer: {c}')
                user_win = ((u == 's' and c == 'p') or
                            (u == 'p' and c == 'r') or
                            (u == 'r' and c == 's'))

                computer_win = ((c == 's' and u == 'p') or
                                (c == 'p' and u == 'r') or
                                (c == 'r' and u == 's'))

                tie = ((c == 's' and u == 's') or
                       (c == 'p' and u == 'p') or
                       (c == 'r' and u == 'r'))

                if user_win:
                    print('You won this round.')
                    self.user.add_win()

                elif computer_win:
                    print('You lost this round.')
                    self.computer.add_win()

                elif tie:
                    print('It was a tie.')

                else:
                    raise GameException('Something went wrong')

            else:
                if self.user.win_count() > self.computer.win_count():
                    print(f'[Game summary] Your points: {self.user.win_count()} | '
                          f'Computer points: {self.computer.win_count()}\nYou won.')

                elif self.user.win_count() < self.computer.win_count():
                    print(f'[Game summary] Your points: {self.user.win_count()} | '
                          f'Computer points: {self.computer.win_count()}\nComputer won.')

                else:
                    print(f'[Game summary] Your points: {self.user.win_count()} | '
                          f'Computer points: {self.computer.win_count()}\nIt was a tie..')
        else:
            print('OK. We don\'t have to play. Goodbye!')


def main():
    game = Play()
    game.play_game()


if __name__ == '__main__':
    main()






