import java.util.*;

public class AnswerToQ3C {
    private static Scanner s = new Scanner(System.in);

    private static int getOp(String exp, int cur) {
        Scanner s = new Scanner(exp.substring(cur));
        s.useDelimiter("[^0-9]");
        return s.nextInt();
    }

    private static int doOp(int op1, int op2, char operator) throws Exception {
        switch (operator) {
            case '+':
                return op1 + op2;
            case '-':
                return op1 - op2;
            case '*':
                return op1 * op2;
            case '/':
                return op1 / op2;
            case '^':
                return (int) Math.pow(op1, op2);
            default:
                throw new Exception("Invalid operator: " + operator);
        }
    }

    private static int comparePrecedence(char op1, char op2) {
        if (op1 == '^') return 1;
        if (op2 == '^') return -1;
        if (op1 == '+' || op1 == '-') return (op2 == '+' || op2 == '-') ? 0 : -1;
        return (op2 == '+' || op2 == '-') ? 1 : 0;
    }

    public static void main(String args[]) throws Exception {
        Stack<Character> operators = new Stack<Character>();
        Stack<Integer> operands = new Stack<Integer>();
        while (true) {
            System.out.println("Please enter a new expression: ");
            String exp = s.nextLine();
            if (exp.equals("DONE"))
                break;

            char prev = 0;
            for (int cur = 0; cur < exp.length(); cur++) {
                char ch = exp.charAt(cur);

                switch (ch) {
                    case '(':
                        operators.push(ch);
                        break;
                    case '+':
                    case '-':
                        if (prev == 0 || prev == '(')
                            operands.push(0);
                    case '*':
                    case '/':
                    case '^':
                        while (!operators.isEmpty() && operators.peek() != '(') {
                            if (comparePrecedence(operators.peek(), ch) >= 0) {
                                int op2 = operands.pop();
                                operands.push(doOp(operands.pop(), op2, operators.pop()));
                            } else {
                                break;
                            }
                        }
                        operators.push(ch);
                        break;
                    case ')':
                        while (!operators.isEmpty() && operators.peek() != '(') {
                            int op2 = operands.pop();
                            operands.push(doOp(operands.pop(), op2, operators.pop()));
                        }
                        if (operators.isEmpty())
                            throw new Exception("Unbalanced parentheses: An open parenthesis has been closed multiple times!");
                        operators.pop();
                        break;
                    case ' ':
                    case '\t':
                        break;
                    default:
                        if (Character.isDigit(ch)) {
                            int temp = getOp(exp, cur);
                            while (cur < exp.length() && Character.isDigit(exp.charAt(cur)))
                                cur++;
                            cur--;
                            operands.push(temp);
                        } else {
                            throw new Exception("Error: bad input");
                        }
                }

                if (!Character.isWhitespace(ch)) {
                    prev = ch;
                }
            }

            while (!operators.isEmpty()) {
                int op2 = operands.pop();
                operands.push(doOp(operands.pop(), op2, operators.pop()));
            }
            System.out.println("The result is " + operands.pop());
        }
    }
}
