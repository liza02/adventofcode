import functools

with open('./input.txt') as f:
    calories_list = f.readlines()
    current_elf_calories = 0
    max_calories = 0
    index_elf = 0
    records_calories = []
    for calories in calories_list:
        if '\n' != calories:
            current_elf_calories += int(calories.replace("\n", ""))
        else:
            if current_elf_calories >= max_calories:
                max_calories = current_elf_calories
                print("nouveau record elf " + str(index_elf) + " : " + str(max_calories))
                records_calories.append(max_calories)
            current_elf_calories = 0
            index_elf += 1
    print("nombre total d'elfs : " + str(index_elf))
    total_3_max = functools.reduce(lambda a, b: a + b, records_calories[4:])
    print("top three Elves carrying the most Calories : " + str(total_3_max))
