import requests


class TrueRandomizer:
    def __init__(self, max_number):
        self.url = f'https://www.random.org/integers/?num=100&min=1&max={max_number}&col=1&base=10&format=plain&rnd=new'

    def get_new_rand_ints(self):
        """Generates 100 true random integers via API call to random.org"""
        gen_finished = False

        random_numbers = list()
        while not gen_finished:
            response = requests.get(self.url)
            random_numbers = response.text.split('\n')
            random_numbers = random_numbers[:-1]
            random_numbers = list(map(int, random_numbers))
            gen_finished = not (len(random_numbers) != len(set(random_numbers)))  # check if numbers have duplicates

        if len(random_numbers) == 100: return random_numbers
        print("ERROR: Could not generate random numbers!")
        return None
