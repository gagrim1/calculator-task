package calculator.task;

enum Operation {
    ADD('+'),
    SUB('-'),
    MULT('*'),
    DIV('/'),
    UNDEFINED('?');
    private final Character character;

    Operation(Character character) {
        this.character = character;
    }

    public static Operation findByField(Character character) {
        for(Operation operation : Operation.values()) {
            if (character.equals(operation.getCharacter())) {
                return operation;
            }
        }
        return Operation.UNDEFINED;
    }

    public Character getCharacter() {
        return character;
    }
}
