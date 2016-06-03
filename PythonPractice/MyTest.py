import MyUtilities


def test_check_unique_characters():
    str1 = "wefoijhhg38946t239ru02bfewf"
    str2 = "qwertyuiopasdfghjklzxcvbnm1234567890"

    print("str1: %s => %s" % (str1, str(MyUtilities.check_unique_characters(str1))))
    print("str1: %s => %s" % (str2, str(MyUtilities.check_unique_characters(str2))))


def test_reverse_string():
    str1 = "1234567890"
    str2 = "abcdefghijklmnopqrstuvwxyz"

    print("str1: %s => %s" % (str1, MyUtilities.reverse_string(str1)))
    print("str2: %s => %s" % (str2, MyUtilities.reverse_string(str2)))


def test_remove_duplicates():
    str1 = "abcdefghijklmnopqrstuvwxyz"
    str2 = "abcabdghjjkl"

    print("str1: %s => %s" % (str1, MyUtilities.remove_duplicates(str1)))
    print("str2: %s => %s" % (str2, MyUtilities.remove_duplicates(str2)))


def test_two_string_anagram():
    str1 = "abcdefghijklmnopqrstuvwxyz"
    str2 = "qwertyuiopasdfghjklzxcvbnm"

    str3 = "abcdefghijklmnopqrstuvwxyzz"
    str4 = "qwertyuiopasdfghjklzxcvbnmm"

    print("str1: %s; str2: %s => %s" % (str1, str2, MyUtilities.two_string_anagram(str1, str2)))
    print("str3: %s; str4: %s => %s" % (str3, str4, MyUtilities.two_string_anagram(str3, str4)))


def test_replace_all_string():
    str1 = "wefhej ef  wefhwef "
    str2 = " wefh23789349023rh"

    print("str1: [%s] => [%s]" % (str1, MyUtilities.replace_all_spaces(str1)))
    print("str2: [%s] => [%s]" % (str2, MyUtilities.replace_all_spaces(str2)))


def test_rotated_string():
    str1 = "apple"
    str2 = "pleap"
    str3 = "apple"
    str4 = "ppale"

    print("str1: %s\nstr2: %s\n=> %s" % (str1, str2, str(MyUtilities.check_rotated_string(str1, str2))))
    print("str3: %s\nstr4: %s\n=> %s" % (str3, str4, str(MyUtilities.check_rotated_string(str3, str4))))


def test_calculate_fibonacci():
    print("10th => %s" % (str(MyUtilities.calculate_fibonacci(10))))
    print("20th => %s" % (str(MyUtilities.calculate_fibonacci(20))))
    print("Non Rec 10th => %s" % (str(MyUtilities.calculate_fibonacci_norecursive(10))))
    print("Non Rec 20th => %s" % (str(MyUtilities.calculate_fibonacci_norecursive(20))))


def test_permute_strings():
    # FIRST TEST CASE
    str1 = "abc"
    permuted_strings1 = MyUtilities.permute_string(str1)
    if permuted_strings1 is None:
        raise Exception("Wrong Logic")
    print("There are: [%s] permuted strings for [%s]" % (str(len(permuted_strings1)), str1))
    print("Unique elements? ==> %s" % (str(MyUtilities.check_unique_elements_in_list(permuted_strings1))))
    for i in range(0, len(permuted_strings1)):
        print("%s" % (permuted_strings1[i]))

    # SECOND TEST CASE
    str2 = "abcd"
    permuted_strings2 = MyUtilities.permute_string(str2)
    if permuted_strings2 is None:
        raise Exception("Wrong Logic")
    print("There are: [%s] permuted strings for [%s]" % (str(len(permuted_strings2)), str2))
    print("Unique elements? ==> %s" % (str(MyUtilities.check_unique_elements_in_list(permuted_strings2))))
    for i in range(0, len(permuted_strings2)):
        print("%s" % (permuted_strings2[i]))

    # THIRD TEST CASE
    str3 = "abcde"
    permuted_strings3 = MyUtilities.permute_string(str3)
    if permuted_strings3 is None:
        raise Exception("Wrong Logic")
    print("There are: [%s] permuted strings for [%s]" % (str(len(permuted_strings3)), str3))
    print("Unique elements? ==> %s" % (str(MyUtilities.check_unique_elements_in_list(permuted_strings3))))
    for i in range(0, len(permuted_strings3)):
        print("%s" % (permuted_strings3[i]))


def test_merge_sorted_array():
    # TEST CASE 1
    arr1 = [1,3,5,7,9]
    arr2 = [0,2,4,6,8,10]
    res12 = MyUtilities.merge_sorted_arrays(arr1, arr2)
    print("arr1: %s\narr2: %s\n==> %s" % (str(arr1), str(arr2), str(res12)))

    # TEST CASE 2
    arr3 = [1,3,5,7,29,30,35,74]
    arr4 = [0,2,4,6,25,29]
    res34 = MyUtilities.merge_sorted_arrays(arr3, arr4)
    print("arr3: %s\narr4: %s\n==> %s" % (str(arr3), str(arr4), str(res34)))

