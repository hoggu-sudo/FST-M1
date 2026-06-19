# Get player names
player1 = input("Enter Player 1 name: ")
player2 = input("Enter Player 2 name: ")

# Loop to repeat the game
while True:
    # Get choices
    choice1 = input(player1 + ", choose rock, paper or scissors: ").lower()
    choice2 = input(player2 + ", choose rock, paper or scissors: ").lower()

    # Game logic
    if choice1 == choice2:
        print("It's a tie!")

    elif choice1 == "rock":
        if choice2 == "scissors":
            print(player1 + " wins!")
        else:
            print(player2 + " wins!")

    elif choice1 == "paper":
        if choice2 == "rock":
            print(player1 + " wins!")
        else:
            print(player2 + " wins!")

    elif choice1 == "scissors":
        if choice2 == "paper":
            print(player1 + " wins!")
        else:
            print(player2 + " wins!")

    else:
        print("Invalid input! Try again.")
        continue  # restart loop

    # Ask to play again
    repeat = input("Do you want to play again? (yes/no): ").lower()

    if repeat == "no":
        print("Game ended.")
        break