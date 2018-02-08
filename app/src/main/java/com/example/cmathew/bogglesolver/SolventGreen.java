package com.example.cmathew.bogglesolver;

import java.util.HashSet;

public class SolventGreen {
    private static final int BOARD_SIZE = 3;

    public HashSet<String> dictionary;

    public SolventGreen(HashSet<String> dictionary) {
        this.dictionary = dictionary;
    }

    public HashSet<String> solveBoardBoyo(char[][] board) {
        boolean[][] visited = new boolean[BOARD_SIZE][BOARD_SIZE];

        HashSet<String> boyos = new HashSet<>();
        for (int row = 0; row < BOARD_SIZE; row++) {
            for (int column = 0; column < BOARD_SIZE; column++) {
                HashSet<String> squareRes = findWordsOriginatingAtSquare(row, column, board, visited, "");
                boyos.addAll(squareRes);
            }
        }

        return boyos;
    }

    public HashSet<String> findWordsOriginatingAtSquare(
            int row,
            int column,
            char[][] board,
            boolean[][] visited,
            String wordSoFar) {

        HashSet<String> results = new HashSet<>();
        if (dictionary.contains(wordSoFar)) {
            results.add(wordSoFar);
        }

        visited[row][column] = true;

        int minRowNeighbor = Math.max(0, row - 1);
        int maxRowNeighbor = Math.min(row + 1, BOARD_SIZE - 1);
        int minColNeighbor = Math.max(0, column - 1);
        int maxColNeighbor = Math.min(column + 1, BOARD_SIZE - 1);

        for (int i = minRowNeighbor; i <= maxRowNeighbor; i++) {
            for (int j = minColNeighbor; j <= maxColNeighbor; j++) {
                if (!visited[i][j]) {
                    String wordCandidate = wordSoFar + String.valueOf(board[i][j]);
                    HashSet<String> moreResults = findWordsOriginatingAtSquare(i, j, board, visited, wordCandidate);
                    results.addAll(moreResults);
                }
            }
        }
        visited[row][column] = false;

        return results;
    }
}
