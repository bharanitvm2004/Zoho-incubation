import java.util.*;

public class PuzzleGame {

    private int[][] board;
    private int emptyRow, emptyCol;

    private Stack<Integer> undoStack = new Stack<>();
    private Stack<Integer> redoStack = new Stack<>();
    private Stack<Integer> shuffleHistory = new Stack<>();

    private final int SIZE = 4;


    private final int[] dx = {-1, 0, 1, 0};
    private final int[] dy = {0, 1, 0, -1};
    private final String[] dirName = {"UP", "RIGHT", "DOWN", "LEFT"};

    public PuzzleGame() {
        initializeBoard();
        shuffleBoard(50);
    }

   
    private void initializeBoard() {
        board = new int[SIZE][SIZE];
        int value = 1;

        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                board[i][j] = value++;
            }
        }

        emptyRow = SIZE - 1;
        emptyCol = SIZE - 1;
    }

    
    private void displayBoard() {
        System.out.println("\n-------------------------");
        for (int[] row : board) {
            for (int cell : row) {
                System.out.print((cell == 16 ? " " : cell) + "\t");
            }
            System.out.println();
        }
    }

    
    private boolean isValidMove(int direction) {
        int newRow = emptyRow + dx[direction];
        int newCol = emptyCol + dy[direction];

        return newRow >= 0 && newRow < SIZE &&
               newCol >= 0 && newCol < SIZE;
    }

   
    private void move(int direction) {
        if (!isValidMove(direction)) {
            System.out.println("Invalid move!");
            return;
        }

        performMove(direction);
        undoStack.push(direction);
        redoStack.clear();
    }

   
    private void performMove(int direction) {
        int newRow = emptyRow + dx[direction];
        int newCol = emptyCol + dy[direction];

        swap(emptyRow, emptyCol, newRow, newCol);

        emptyRow = newRow;
        emptyCol = newCol;
    }

    private void swap(int r1, int c1, int r2, int c2) {
        int temp = board[r1][c1];
        board[r1][c1] = board[r2][c2];
        board[r2][c2] = temp;
    }

    private void shuffleBoard(int steps) {
        Random random = new Random();
        int previousDirection = -1;

        for (int i = 0; i < steps; i++) {
            int direction;

            do {
                direction = random.nextInt(4);
            }
            while (!isValidMove(direction) ||
                   (previousDirection != -1 &&
                    direction == (previousDirection + 2) % 4));

            performMove(direction);
            shuffleHistory.push(direction);
            previousDirection = direction;
        }
    }

    private void undo() {
        if (undoStack.isEmpty()) {
            System.out.println("Nothing to undo.");
            return;
        }

        int lastMove = undoStack.pop();
        int opposite = (lastMove + 2) % 4;

        performMove(opposite);
        redoStack.push(lastMove);
    }

 
    private void redo() {
        if (redoStack.isEmpty()) {
            System.out.println("Nothing to redo.");
            return;
        }

        int move = redoStack.pop();
        performMove(move);
        undoStack.push(move);
    }

  
    private void hint() {
        if (shuffleHistory.isEmpty()) {
            System.out.println("No more hints available.");
            return;
        }

        int lastShuffleMove = shuffleHistory.pop();
        int reverseMove = (lastShuffleMove + 2) % 4;

        performMove(reverseMove);
    }

  
    private boolean isSolved() {
        int expected = 1;

        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                if (board[i][j] != expected++)
                    return false;
            }
        }
        return true;
    }

    public void startGame() {
        Scanner sc = new Scanner(System.in);

        while (true) {
            displayBoard();

            if (isSolved()) {
                System.out.println("🎉 Puzzle Solved!");
                break;
            }

            System.out.println("\n0-UP | 1-RIGHT | 2-DOWN | 3-LEFT");
            System.out.println("7-HINT | 8-REDO | 9-UNDO");
            System.out.print("Enter your choice: ");

            int choice = sc.nextInt();

            if (choice >= 0 && choice <= 3) move(choice);
            else if (choice == 9) undo();
            else if (choice == 8) redo();
            else if (choice == 7) hint();
            else System.out.println("Invalid input!");
        }

        sc.close();
    }

  
    public static void main(String[] args) {
        new PuzzleGame().startGame();
    }
}