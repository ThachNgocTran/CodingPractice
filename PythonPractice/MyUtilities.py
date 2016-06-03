
_a = 10


def quick_sort(in_arr: list, start: int, end: int):
    if in_arr is None or len(in_arr) == 0:
        raise Exception("Input array is null")

    i = start
    j = end
    pivot = in_arr[int((start + end) / 2)]

    while i <= j:
        while in_arr[i] < pivot:
            i += 1
        while in_arr[j] > pivot:
            j -= 1
        if i <= j:
            temp = in_arr[i]
            in_arr[i] = in_arr[j]
            in_arr[j] = temp
            i += 1
            j -= 1

    if start < j:
        quick_sort(in_arr, start, j)

    if i < end:
        quick_sort(in_arr, i, end)


def check_if_sorted(in_arr: list) -> bool:
    for i in range(0, len(in_arr)-1):
        if in_arr[i] > in_arr[i+1]:
            return False

    return True


def binary_search(in_arr: list, key: int) -> int:
    position = -1

    if not check_if_sorted(in_arr):
        raise Exception("Input array not sorted")

    start = 0
    end = len(in_arr)-1

    while start <= end:
        middle = int((start+end)/2)
        if in_arr[middle] == key:
            position = middle
            break
        elif in_arr[middle] < key:
            start = middle + 1
        elif in_arr[middle] > key:
            end = middle - 1

    return position


def check_unique_characters(in_str: str) -> bool:
    if in_str is None or len(in_str) == 0:
        raise Exception("Input string is invalid")

    map_chars = 256 * [False]

    for i in range(0, len(in_str) - 1):
        ascii_code = ord(in_str[i])
        if map_chars[ascii_code] == True:
            return False
        map_chars[ascii_code] = True

    return True


def reverse_string(in_str: str) -> str:
    str_out = ""

    for i in range(len(in_str)-1, -1, -1):
        str_out += in_str[i]

    return str_out


def remove_duplicates(in_str: str) -> str:
    if in_str is None or len(in_str) == 0:
        raise Exception("Invalid input")

    str_out = ""
    for i in range(0, len(in_str)):
        currChar = in_str[i]
        already = False
        for j in range(0, i):
            if currChar == in_str[j]:
                already = True
                break
        if not already:
            str_out += currChar

    return str_out


def two_string_anagram(in_str1: str, in_str2: str) -> bool:
    if in_str1 is None or len(in_str1) == 0 or in_str2 is None or len(in_str2) == 0:
        raise Exception("Inputs are invalid")

    if len(in_str1) != len(in_str2):
        return False

    dict1 = {}
    dict2 = {}

    for i in range(0, len(in_str1)):
        currChar = in_str1[i]
        if currChar in dict1:
            dict1[currChar] = dict1[currChar] + 1
        else:
            dict1[currChar] = 1

    for i in range(0, len(in_str2)):
        currChar = in_str2[i]
        if currChar in dict2:
            dict2[currChar] = dict2[currChar] + 1
        else:
            dict2[currChar] = 1

    return dict1 == dict2


def replace_all_spaces(in_str: str) -> str:
    if in_str is None or len(in_str) == 0:
        raise Exception("Input is invalid")

    out_str = ""
    for i in range(0, len(in_str)):
        if in_str[i] == " ":
            out_str += "%20"
        else:
            out_str += in_str[i]

    return out_str


def check_rotated_string(in_str1: str, in_str2: str) -> bool:
    if in_str1 is None or len(in_str1) == 0 or in_str2 is None or len(in_str2) == 0:
        raise Exception("Input")

    result = True
    str_temp = in_str1 + in_str1
    if str_temp.find(in_str2) == -1:
        result = False

    return result


def calculate_fibonacci(in_num: int) -> int:
    if in_num <= 0:
        raise Exception("Input is invalid")

    if in_num == 1 or in_num == 2:
        return 1

    return calculate_fibonacci(in_num - 2) + calculate_fibonacci(in_num - 1)


def calculate_fibonacci_norecursive(in_num: int) -> int:
    if in_num <= 0:
        raise Exception("Input is invalid")

    if in_num == 1 or in_num == 2:
        return 1

    preceding_1 = 1
    preceding_2 = 1
    curr = 3

    while curr <= in_num:
        newFibo = preceding_1 + preceding_2
        preceding_1 = preceding_2
        preceding_2 = newFibo
        curr += 1

    return preceding_2


def permute_string(in_str: str) -> list:
    if in_str is None or len(in_str) == 0:
        raise Exception("Input is invalid")

    permuted_strings = []
    if len(in_str) == 2:
        first = in_str
        second = in_str[1] + in_str[0]

        permuted_strings.append(first)
        permuted_strings.append(second)
    elif len(in_str) >= 3:
        first = in_str[0]
        remaining = in_str[1:]

        tempArray = permute_string(remaining)
        for i in range(0, len(tempArray)):
            currStr = tempArray[i]

            for j in range(0, len(currStr)+1):
                permuted = currStr[0:j] + first + currStr[j:]
                permuted_strings.append(permuted)
    else:
        # impossible!
        raise Exception("Wrong logic")

    return permuted_strings


def check_unique_elements_in_list(in_list: list) -> bool:
    result = True
    if in_list is None or len(in_list) == 0:
        raise Exception("Input is invalid")

    hashMap = {}
    for i in range(0, len(in_list)):
        currEle = in_list[i]
        if currEle in hashMap:
            result = False
            break
        else:
            hashMap[currEle] = 1

    return result


def merge_sorted_arrays(in_array1: list, in_array2: list) -> list:
    if in_array1 is None or len(in_array1) == 0 or in_array2 is None or len(in_array2) == 0:
        raise Exception("Inputs are invalid")

    out_array = [None] * (len(in_array2)+len(in_array1)) # pre-allocate for performance
    firstRunner = 0
    secondRunner = 0
    currRunner = 0

    while firstRunner < len(in_array1) and secondRunner < len(in_array2):
        if in_array1[firstRunner] < in_array2[secondRunner]:
            out_array[currRunner] = in_array1[firstRunner]
            firstRunner += 1
        elif in_array1[firstRunner] > in_array2[secondRunner]:
            out_array[currRunner] = in_array2[secondRunner]
            secondRunner += 1
        else:
            out_array[currRunner] = in_array1[firstRunner]
            currRunner += 1
            out_array[currRunner] = in_array2[secondRunner]
            firstRunner += 1
            secondRunner += 1
        currRunner += 1

    # process the rest (if any)
    if firstRunner < len(in_array1):
        while firstRunner < len(in_array1):
            out_array[currRunner] = in_array1[firstRunner]
            currRunner += 1
            firstRunner += 1

    if secondRunner < len(in_array2):
        while secondRunner < len(in_array2):
            out_array[currRunner] = in_array2[secondRunner]
            currRunner += 1
            secondRunner += 1

    # just double check
    if currRunner != len(out_array):
        raise Exception("Wrong logic")

    return out_array
