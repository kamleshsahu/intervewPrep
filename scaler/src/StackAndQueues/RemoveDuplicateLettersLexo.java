package StackAndQueues;


public class RemoveDuplicateLettersLexo {
    public String solve(String A) {
        return removeDuplicateLetters(A);
    }

    public String removeDuplicateLetters(String s) {
        int[] counters = new int[26];
        boolean[] visited = new boolean[26];
        Stack<Character> stack = new Stack<>();

        for (char c : s.toCharArray())
            counters[c - 'a']++;

        // use combination of visited and monotonous increasing stack
        for (char c : s.toCharArray()) {
            if (visited[c - 'a']) {
                counters[c - 'a']--;
                continue;
            }

            while (!stack.isEmpty() &&
                    stack.peek() > c &&
                    counters[stack.peek() - 'a'] > 1) {
                counters[stack.peek() - 'a']--;
                visited[stack.peek() - 'a'] = false;
                stack.pop();
            }

            stack.push(c);
            visited[c - 'a'] = true;
        }

        char[] result = new char[stack.size()];
        for (int i = stack.size() - 1; i >= 0; i--)
            result[i] = stack.pop();

        return new String(result);
    }
}

//complexity : medium - easy
//hint : try to think what to do with current letter take or not?
//why to take and why not?
//
//t.c = O(n)