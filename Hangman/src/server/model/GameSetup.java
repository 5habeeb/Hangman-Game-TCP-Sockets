package server.model;

public class GameSetup {
    private String gameData = "Game Data Default";
    private Boolean isGameStarted = false;
    private Game game;

    public String getGameData () {
        System.out.println("Server Sending word: " + gameData);
        return gameData;
    }

    public void setGameData (String input) {
        try {
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("Server Received word: " + input);

        if (isGameStarted)
            switch (input) {
                case "Start Game":
                    this.gameData = "Game already in play";
                    break;
                case "Play Again":
                    restart();
                    break;
                default:
                    gameEntry(input);
                    break;
            }

        if (input.equals("Start Game") && !isGameStarted) {
            isGameStarted = true;
            startGame();
        }
    }

    private void startGame() {
        game = new Game();
        this.gameData = game.startGame();
    }

    private void restart() {
        this.gameData = game.restart();
    }

    private void gameEntry(String input) {
        this.gameData = game.gameEntry(input);
    }
}
