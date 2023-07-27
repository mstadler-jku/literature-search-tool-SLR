import pandas as pd

df_1 = pd.read_csv('IEEE_FOUR_01.csv')
df_2 = pd.read_csv('IEEE_FOUR_02.csv')

print(len(df_1))
print(len(df_2))

concat_df = pd.concat([df_1, df_2])
print(len(concat_df))
concat_df = concat_df.drop_duplicates(subset='Document Title', keep="first")
print(len(concat_df))
