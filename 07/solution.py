import re


def is_cd_in(line):
    return bool(re.search("\$ cd .*", line))


def is_cd_out(line):
    return bool(re.search("\$ cd \.\.", line))


def is_ls(line):
    return bool(re.search("\$ ls", line))


def is_file(line):
    return bool(re.search("[0-9]+ .*", line))


def is_dir(line):
    return bool(re.search("dir .*", line))


def extract_dir_name(line):
    return line.replace("$ cd ", "")


def extract_size_of_file(file):
    return int(file.split(" ")[0])


def pop_dir():
    dir = stack.pop()
    list_of_dirs.append(dir)
    if dir["size"] <= 100000:
        return dir["size"]
    return 0


sum_size = 0
stack = []
list_of_dirs = []

# PART 1
with open('./input.txt') as f:
    lines = f.readlines()
    for line in lines:
        line = line.replace("\n", "")
        if is_cd_out(line):
            sum_size += pop_dir()
        elif is_cd_in(line):
            stack.append({"name": extract_dir_name(line), "size": 0})
        elif is_file(line):
            def add_file_size(dir):
                dir["size"] += extract_size_of_file(line)
                return dir


            stack = list(map(add_file_size, stack))

    while stack:
        sum_size += pop_dir()
    print("PART 1 :")
    print("sum = " + str(sum_size))

# PART 2
size_of_dir_to_delete = 30000000
min_size_of_dir_to_delete = list_of_dirs.pop()["size"] - 40000000
for dir in list_of_dirs:
    if (dir["size"] >= min_size_of_dir_to_delete) & (dir["size"] < size_of_dir_to_delete):
        size_of_dir_to_delete = dir["size"]
print("PART 2 :")
print("size of directory to delete = " + str(size_of_dir_to_delete))