public class FrogCommands {
    public static FrogCommand jumpRightCommand(Frog frog, int steps) {
        return new FrogCommand() {
            @Override
            public boolean doit() {
                frog.jump(steps);
                return true;
            }

            @Override
            public boolean undo() {
                frog.jump(-steps);
                return false;
            }
        };
    }

    public static FrogCommand jumpLeftCommand(Frog frog, int steps) {
        return new FrogCommand() {
            @Override
            public boolean doit() {
                frog.jump(steps);
                return true;
            }

            @Override
            public boolean undo() {
                frog.jump(-steps);
                return false;
            }
        };
    }
}