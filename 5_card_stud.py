faces = ['A', 2, 3, 4, 5, 6, 7, 8, 9, 10, 'J', 'Q', 'K']
suits = ['Spades', 'Clubs', 'Diamonds', 'Hearts']

face_values = {'A': 14, 'K': 13, 'Q': 12, 'J':11}
face_names = {14: 'A', 13: 'K', 12: 'Q', 11: 'J'}
hands = [
    ['Royal Flush', ['A', 'K', 'Q', 'J', 10], 'Same'],
    ['Straight Flush', 'Sequence', 'Same'],
    ['Four of a Kind', 'Match 4', 'Any'],
    ['Full House', 'Match 3,2', 'Any'],
    ['Flush', 'Any', 'Same'],
    ['Straight', 'Sequence', 'Any'],
    ['Three of a Kind', 'Match 3', 'Any'],
    ['Two Pair', 'Match 2,2', 'Any'],
    ['Pair', 'Match 2', 'Any'],
    ['High Card', 'Any', 'Any']
]
def ace_sequence(cards):
    for hand in [cards, [1 if card == 14 else card for card in cards]]:
        if all([True if hand[x] - hand[x + 1] == -1 else False for x in range(len(hand ) - 1)]):
            return True
    return False


            
def find_hand(hand):
    suits = [x[1] for x in hand]
    cards = []
    cards = [card[0] if type(card[0]) == int else face_values[card[0]] for card in hand]
    cards.sort()
    if (len(hand) != 5):
        raise Exception("Invalid hand, need 5 cards.")    
    highest_card = []
    hand_name = ''
    for option in hands:
        if type(option[1]) == list:
            option[1] = [x if type(x) == int else face_values[x] for x in option[1]]
            option[1].sort()
            if all([x in cards for x in option[1]]):
                for card_hand in hand:
                    value_card_hand = card_hand[0] if type(card_hand[0]) == int else face_values[card_hand[0]]
                    if value_card_hand == option[1][-1]:
                        highest_card = card_hand
                        break
        elif option[1] == 'Sequence':
            if 14 in cards:
                highest_card = ace_sequence(cards)
            elif all([True if cards[x] - cards[x + 1] == -1 else False for x in range(len(cards) - 1)]):
                for card_hand in hand:
                    value_card_hand = card_hand[0] if type(card_hand[0]) == int else face_values[card_hand[0]]
                    if value_card_hand == cards[-1]:
                        highest_card = card_hand
                        break
        elif 'Match' in option[1]:
            match_list = option[1][option[1].find('Match ') + 6:].split(',')
            match_list = [int(x) for x in match_list]
            match_counts = []
            match_used = []
            match_values = []
            for card in cards:
                if card in match_used:
                    continue
                match_used.append(card)
                match_counts.append(cards.count(card))
            for match in match_list:
                if match in match_counts:
                    match_counts.remove(match)
                    match_values.append(True)
            highest_card = len(match_values) == len(match_list)
        elif option[1] == 'Any':
            highest_card = True
        if highest_card != []:
            hand_name = option[0]
            break
        #print(option[0], highest_card) 
    return hand_name, highest_card
def make_deck():
    deck = []
    for suit in suits:
        for value in faces:
            deck.append([value, suit])
    return deck
decks = make_deck()

#print(decks)

print(find_hand([['A', 'Spades'], [10, 'Spades'], ['J', 'Spades'], ['Q', 'Spades'], ['K', 'Spades']])) #Royal flush
print(find_hand([[9, 'Spades'], [10, 'Spades'], ['J', 'Spades'], ['Q', 'Spades'], ['K', 'Spades']])) #Straight flush
print(find_hand([[9, 'Spades'], [9, 'Spades'], [9, 'Spades'], [9, 'Spades'], ['K', 'Spades']])) #Four of kind
print(find_hand([[9, 'Spades'], ['J', 'Spades'], ['J', 'Spades'], [9, 'Spades'], [9, 'Spades']])) #Full house
print(find_hand([[9, 'Spades'], [10, 'Spades'], ['J', 'Spades'], ['Q', 'Spades'], [2, 'Spades']])) #Flush
print(find_hand([[9, 'Spades'], [10, 'Hearts'], ['J', 'Spades'], ['Q', 'Spades'], ['K', 'Spades']])) #Straight
print(find_hand([[9, 'Spades'], [10, 'Spades'], [10, 'Spades'], [10, 'Spades'], ['K', 'Spades']])) #Three of a kind
print(find_hand([[9, 'Spades'], [10, 'Spades'], ['J', 'Spades'], ['J', 'Spades'], [9, 'Spades']])) #Two pair
print(find_hand([[9, 'Spades'], [10, 'Spades'], ['J', 'Spades'], ['K', 'Spades'], ['K', 'Spades']])) #Pair
print(find_hand([[9, 'Spades'], [10, 'Spades'], ['J', 'Spades'], [2, 'hearts'], ['K', 'Spades']])) #High Card

