import java.util.*;

class Solution {
    public Object solution(int n, int k, String[] commands) {
        var data = new char[n];
        for (var i = 0; i < n; i++) {
            data[i] = 'O';
        }

        int moves = 0;
        Stack<Integer> history = new Stack<Integer>();
        for (var cmd : commands) {
            var op = cmd.charAt(0);
            if (op == 'U') {
                var v = Integer.parseInt(cmd.substring(2));
                moves += -v;
            }
            else if (op == 'D') {
                var v = Integer.parseInt(cmd.substring(2));
                moves += v;
            }
            else {
                k = doMove(data, k, moves);
                moves = 0;
            }

            if (op == 'C') {
                k = clear(data, k, history);
            }
            else if (op == 'Z') {
                k = undo(data, k, history);
            }
        }

        return new String(data) + "";
    }

    public int doMove(char[] data, int k, int moves) {
        if (moves > 0) {
            while(moves > 0) {
                k++;
                if (data[k] == 'O') {
                    moves--;
                }
            }
        }
        else {
            while(moves < 0) {
                k--;
                if (data[k] == 'O') {
                    moves++;
                }
            }
        }
        return k;
    }

    public int clear(char[] data, int k, Stack<Integer> history) {
        data[k] = 'X';
        history.push(k);
        var t = k;
        while (k < data.length && data[k] == 'X') {
            k++;
        }
        if (k < data.length) {
            return k;
        }
        while (data[t] == 'X') {
            t--;
        }
        return t;
    }

    public int undo(char[] data, int k, Stack<Integer> history) {
        data[history.pop()] = 'O';
        return k;
    }
}