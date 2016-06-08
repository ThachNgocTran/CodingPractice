import os.path
import pandas as pd
import numpy as np

DATA_FILE_PATH = "Data/Indian Liver Patient Dataset (ILPD).csv"
CLEAN_DATA_FILE_PATH = "Data/Cleaned_Indian Liver Patient Dataset (ILPD).csv"


def test_data_preprocessing():
    if DATA_FILE_PATH is None or len(DATA_FILE_PATH) == 0:
        raise Exception("Input is invalid")

    if not os.path.isfile(DATA_FILE_PATH):
        raise Exception("File not exists")

    # Read CSV file
    temp_df = pd.read_csv(DATA_FILE_PATH, header=None)

    # Check its numbers of rows and columns
    (num_row, num_col) = temp_df.shape

    # Add meaningful columns' names.
    temp_df.columns = ['age', 'gender', 'total_bilirubin', 'direct_bilirubin', 'alkaline_phosphotase',
                       'alamine_aminotransferase',
                       'aspartate_aminotransferase', 'total_protiens', 'albumin',
                       'ratio_albumin_and_globulin_ratio', 'liver_res']

    # Transform categorical target variable to numberic one. 1 means "positive", 0 means "negative".
    # temp_df['liver_res'] returns a Series. Modify the Series, return another Series. Assign that to the original Series.
    temp_df['liver_res'] = temp_df['liver_res'].apply(lambda x: 0 if (x == 2) else x)

    # Get the index that is null
    findNull = temp_df['ratio_albumin_and_globulin_ratio'].isnull() # Return a Series (TRUE, TRUE, FALSE...)

    # Get the index based on a Series of Boolean type ==> Int64Index
    index_null = temp_df['ratio_albumin_and_globulin_ratio'].index[findNull]

    # Drop rows based on Index
    temp_df = temp_df.drop(index_null)

    # Drop columns based on names
    # temp_df.drop(['direct_bilirubin', 'aspartate_aminotransferase', 'albumin'], axis=1, inplace=True)

    # Add new column
    # temp_df['is_train'] = np.random.uniform(0, 1, len(temp_df)) <= 0.75

    # Split dataset based on values of a specific column
    # train, test = temp_df[temp_df['is_train'] == True], temp_df[temp_df['is_train'] == False]

    # Save to CSV
    temp_df.to_csv(CLEAN_DATA_FILE_PATH, index=False)
