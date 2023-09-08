# import pandas as pd
#
# df_1 = pd.read_csv('IEEE_FOUR_01.csv')
# df_2 = pd.read_csv('IEEE_FOUR_02.csv')
#
# print(len(df_1))
# print(len(df_2))
#
# concat_df = pd.concat([df_1, df_2])
# print(len(concat_df))
# concat_df = concat_df.drop_duplicates(subset='Document Title', keep="first")
# print(len(concat_df))


import csv
import os.path

import pandas as pd

if __name__ == '__main__':
    IEEE_CSV_PATH = os.path.join("../csv_files_v1", "01_ieee.csv")
    ACM_CSV_PATH = os.path.join("../csv_files_v1", "02_acm.csv")
    SCOPUS_CSV_PATH = os.path.join("../csv_files_v1", "03_scopus.csv")
    WOS_CSV_PATH = os.path.join("../csv_files_v1", "04_wos.csv")
    SPRINGER_CSV_PATH = os.path.join("../csv_files_v1", "05_springer.csv")

    df_ieee = pd.DataFrame(
        columns=["Document Title", "Authors", "Author Affiliations", "Publication Title", "Date Added To Xplore",
                 "Publication Year", "Volume", "Issue", "Start Page", "End Page", "Abstract", "ISSN", "ISBNs", "DOI",
                 "Funding Information", "PDF Link", "Author Keywords", "IEEE Terms", "INSPEC Controlled Terms",
                 "INSPEC Non-Controlled Terms", "Mesh_Terms", "Article Citation Count", "Patent Citation Count",
                 "Reference Count", "License", "Online Date", "Issue Date", "Meeting Date", "Publisher",
                 "Document Identifier"])

    with open(IEEE_CSV_PATH, newline='') as csvfile:
        spamreader = csv.reader(csvfile, delimiter=',', quotechar='|')
        for row in spamreader:
            try:
                df_ieee.loc[len(df_ieee)] = row
            except ValueError:
                print("error here")

    # df_ieee = pd.read_csv(IEEE_CSV_PATH, encoding='latin-1')
    # df_acm = pd.read_csv()
    # df_scopus = pd.read_csv()
    # df_wos = pd.read_csv()
    # df_springer = pd.read_csv()

    print(len(df_ieee))
