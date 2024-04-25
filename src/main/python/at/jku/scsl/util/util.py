import logging
import os
import pandas as pd
import random
import shutil
import time
from datetime import datetime


def get_project_urls(file_name):
    """Reads the project urls from the csv"""
    df = pd.read_csv(concat_path(get_project_root_directory(), 'cleaning', 'out', file_name))
    return df.clean_project_url.tolist(), df.ID.tolist(), df.is_launched.tolist()


def load_integers_from_file(file_path):
    """
    Loads integers from into a list from a given file. One integer per line.
    :param file_path: the path to the file
    :return: a list of integers
    """
    with open(file_path, 'r') as file:
        numbers = [int(line.strip()) for line in file if line.strip().isdigit()]
    return numbers


def save_string_to_file(file_path, string):
    with open(file_path, "w", encoding="utf-8") as text_file:
        text_file.write(string)
    logging.info(f'Saved string to file >> {file_path}')


def get_time_string():
    return str(datetime.now()).replace(' ', '_').replace(':', '-')


def save_ks_html_file(html_doc, url_id, timeout_flag):
    """Saves the files in a html doc"""
    if timeout_flag:
        file_str = f'{get_time_string()}_ID-{url_id}_TIMEDOUT_kickstarter.html'
    else:
        file_str = f'{get_time_string()}_ID-{url_id}_kickstarter.html'
    file_name = os.path.join(get_project_root_directory(), 'main', 'out', 'kickstarter_html_crawled', file_str)
    with open(file_name, "w", encoding="utf-8") as text_file:
        text_file.write(html_doc)
    logging.info(f'Saved new HTML file: {file_name}')


def is_project_already_crawled(url):
    url = url.replace('https://www.kickstarter.com/', '')

    directory = concat_path('out', 'ks_html')
    # List all HTML files in the directory
    html_files = [f for f in os.listdir(directory) if f.endswith('.html')]

    # Iterate over each file and search for the substring
    for file in html_files:
        with open(os.path.join(directory, file), 'r', encoding='utf-8') as f:
            content = f.read()
            if url in content:
                return True
    return False


def get_random_number(low, high):
    """Returns a random number within the range, low and high are included"""
    return random.randint(low, high)


def get_current_time():
    return time.time()


def flatten_dict(d, parent_key='', sep='#'):
    """
    Flattens a nested dictionary.

    Parameters:
    :param d: (dict): The dictionary to flatten.
    :param parent_key: (str, optional): The prefix for the keys in the flattened dictionary.
    :param sep: (str, optional): The separator to use between keys.

    Returns:
    dict: A new dictionary with flattened keys or if d is none, an empty dictionary.
    """
    if not d:
        return {}

    items = []
    for k, v in d.items():
        new_key = f"{parent_key}{sep}{k}" if parent_key else k
        if isinstance(v, dict):
            items.extend(flatten_dict(v, new_key, sep=sep).items())
        else:
            items.append((new_key, v))
    return dict(items)


class URLTimeoutException(Exception):
    """
    Helper Exception to be raised when a URL can't be loaded within specific time
    """
    pass


def get_project_root_directory():
    """
    For instance C:/Users/directory/kickface_analytics
    :return: The projects root directory
    """
    current_dir = os.path.dirname(os.path.abspath(__file__))

    # Navigate to the root directory of the project
    # Assuming this script is within a subdirectory of the root
    root_dir = os.path.dirname(current_dir)

    return root_dir


def concat_path(*path_elements: str) -> str:
    """
    Concatenates strings to a path os independent
    :param path_elements: the path elements as strings
    :return: a concatenated os independent path
    """
    result = ''
    for element in path_elements:
        result = os.path.join(result, element)
    return result


def get_free_disk_space():
    """

    :return: the free disk space on volume E in GiB
    """
    total, used, free = shutil.disk_usage("E:\\")
    return free // (2 ** 30)


def add_project_to_recrawl_list(project_id):
    """
    Adds the given project_id to the recrawl textfile
    :param project_id: the ID to be added to the recrawl textfile
    :return: void
    """
    with open(concat_path(get_project_root_directory(), 'util', "recrawl.txt"), "r+") as file:
        # Read all lines in the file
        lines = file.readlines()
        # Check if the ID is already in the file
        if f"{project_id}\n" not in lines:
            # If not, append the ID to the end of the file
            file.write(f"{project_id}\n")
        else:
            logging.info('Project is already in re-crawl list!')


def add_project_to_not_launched_list(project_id):
    """
     Adds the given project_id to the not_launched textfile
     :param project_id: the ID to be added to the not_launched textfile
     :return: void
     """
    with open(concat_path(get_project_root_directory(), 'util', "not_launched.txt"), "r+") as file:
        # Read all lines in the file
        lines = file.readlines()
        # Check if the ID is already in the file
        if f"{project_id}\n" not in lines:
            # If not, append the ID to the end of the file
            file.write(f"{project_id}\n")
        else:
            logging.info('Project is already in not_launched list!')
