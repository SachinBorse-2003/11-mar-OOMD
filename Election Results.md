# Election Results Processing System

## Classes

### 1. `ElectionResultsProcessor`

This class is responsible for initiating the processing of election results. It contains the `main` method for executing the program and a method for processing individual election results.

#### Behaviors

- `main(String[] args)`: Entry point of the program. Creates an instance of `ElectionResultProcessor` to process each election result.

- `processElectionResult(String result)`: Delegates the processing of an election result to the `ElectionResultProcessor` class.

### 2. `ElectionResultProcessor`

This class is responsible for processing individual election results, calculating the winner, and displaying the results.

#### Behaviors

- `processResult(String result)`: Takes an election result as input, parses the data, determines the winning party, translates the party code, and displays the result.

- `findWinningParty(Map<String, Integer> partyVotes)`: Helper method to find the party with the maximum votes.

### 3. `PartyTranslator`

This class is responsible for translating party codes into full party names.

#### Behaviors

- `translatePartyCode(String partyCode)`: Takes a party code as input and returns the corresponding full party name.

## Collaboration

- `ElectionResultsProcessor` collaborates with `ElectionResultProcessor` to initiate the processing of individual election results.

- `ElectionResultProcessor` collaborates with `PartyTranslator` to translate party codes into full party names.
