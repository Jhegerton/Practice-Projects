#!/usr/bin/env python3
from gen_id import Gen_Id
from errors import TaskNotFoundError
from util import is_similar
class Tasks:    
    class Task:
        def __init__(self, id_val, task_name, deadline):
            self.id_val = id_val
            self.task_name = task_name
            self.deadline = deadline
            
        def __str__(self):
            return f'{self.id_val} | {self.task_name} | {self.deadline}'
            

    def __init__(self):
        self.task_list = []
        self.gen_id = Gen_Id()
        

    def show_tasks(self):
        if self.task_list:
            task_list_string = '\n'.join([str(task) for task in self.task_list]) + '\n'
            print('[YOUR TASKS]', task_list_string, sep='\n')
        else:
            print('[YOUR TASKS]', 'Empty list', sep='\n')
            

    def add_task(self):
        print('[ADD TASK]')
        print('Enter "back" as the first value to return to the menu')
        id_gen = self.gen_id.create_unique_ids()
        id_val = next(id_gen)
        task_name = input('What is the task? ')
        if task_name == 'back':
            return
        deadline = input('What is the deadline? ')
        task = self.Task(id_val, task_name, deadline)
        self.task_list.append(task)

    
    def complete_task(self):
        print('[COMPLETE TASK]', end='\n\n')
        exit = False
        if self.task_list:
            self.show_tasks()
            while not exit:
                try:
                    id_val_input = input('Enter "back" to return to the menu,'
                                    ' otherwise enter id to complete: \n')
                    
                    if id_val_input == 'back':
                        return
                    most_similarity =  0
                    closest_task = None
                    for i, task in enumerate(self.task_list):
                        sim_id, similarity = is_similar(id_val_input, task.id_val)
                        # print(str(task), similarity)
                        if similarity > most_similarity:
                            closest_task = task
                            most_similarity = similarity
                        if task.id_val == id_val_input:
                            exit = True
                            del self.task_list[i]
                            print(f'{task.task_name} comlpeted')
                            break
                        
                        else:
                            err_msg = ''
                            print(similarity)
                            if similarity > .01:
                                # sim_task = [task for task in self.task_list if task.id_val == similar_id][0]
                                # sim_task = str(sim_task)
                                err_msg = (f'The id given does not match any task.'
                                        f'Did you mean this?\n {closest_task}\n')
                            else:
                                err_msg = 'The id given does not match any task.\n'
                            raise TaskNotFoundError(err_msg)
                            
                except TaskNotFoundError as e:
                    print(e)
        else:
            self.show_tasks()
            print('No tasks to complete', end='\n\n')

def main():
    tasks = Tasks()
    gen = tasks.gen_id.create_unique_ids()
    t1 = tasks.Task(next(gen), 'Wash the dishes', 'Today')
    t2 = tasks.Task(next(gen), 'Take out the trash', 'Tomorrow')
    t3 = tasks.Task(next(gen), 'Do Jury Duty', 'Saturday')
    tasks.task_list = [t1, t2, t3]
    tasks.complete_task()
    tasks.show_tasks()

if __name__ == '__main__':
    main()
        

    