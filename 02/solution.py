SCORE_RULES_OPPOSANT = {
    "A": 1,  # rock
    "B": 2,  # paper
    "C": 3,  # scissors
}

SCORE_RULES = {
    "X": 1,  # rock
    "Y": 2,  # paper
    "Z": 3,  # scissors
}

SCORE_RULES_PART_2 = {
    "X": 0,  # lose
    "Y": 3,  # draw
    "Z": 6,  # win
}


def part_1():
    with open('./input.txt') as f:
        vals = f.readlines()
        score_opposant = 0
        score = 0
        for jeu in vals:
            jeu = jeu.replace("\n", "").split(" ")
            score_tour = 0
            score_tour_opposant = 0
            match jeu:
                case ['A', 'Y'] | ['B', 'Z'] | ['C', 'X']:
                    score_tour += 6
                case ['A', 'Z'] | ['B', 'X'] | ['C', 'Y']:
                    score_tour_opposant += 6
                case ['A', 'X'] | ['B', 'Y'] | ['C', 'Z']:
                    score_tour += 3
                    score_tour_opposant += 3
            score_tour += SCORE_RULES.get(jeu[1])
            score_tour_opposant += SCORE_RULES_OPPOSANT.get(jeu[0])
            print("my score : " + str(score_tour))
            print("opposant score : " + str(score_tour_opposant))
            score += score_tour
            score_opposant += score_tour_opposant
        print("my total score : " + str(score))
        print("opposant total score : " + str(score_opposant))


def part_2():
    with open('./input.txt') as f:
        vals = f.readlines()
        score = 0
        for jeu in vals:
            jeu = jeu.replace("\n", "").split(" ")
            score_tour = 0
            match jeu:
                case ['A', 'Y'] | ['B', 'X'] | ['C', 'Z']:  # rock
                    score_tour += 1
                case ['A', 'Z'] | ['B', 'Y'] | ['C', 'X']:  # paper
                    score_tour += 2
                case ['A', 'X'] | ['B', 'Z'] | ['C', 'Y']:  # scissor
                    score_tour += 3
            score_tour += SCORE_RULES_PART_2.get(jeu[1])
            print("my score : " + str(score_tour))
            score += score_tour
        print("my total score : " + str(score))


part_1()
# part_2()
