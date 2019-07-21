import java.lang.reflect.Array;
import java.math.BigInteger;
import java.util.*;

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
}

class ListNode {
    int val;
    ListNode next;
    ListNode(int x) { val = x; }
    
    @Override
    public int hashCode() {
        return 1;
    }
    
    
}

class Solution {
    
    
    public List<String> res = new ArrayList<>();
    
    public List<String> binaryTreePaths(TreeNode root) {
        String path = "";
        pathSum(root, path);
        return res;
    }
    
    
    private void pathSum(TreeNode root, String path) {
        if (root == null)
            return;
        //System.out.println(res);
        int n = path.length();
        
        if (path.length() == 0) {
            path = path + root.val;
        } else {
            path = path + "->" + root.val;
        }
        
        if ((root.left == null) && (root.right == null)) {
            res.add(path);
            //System.out.println("*");
            //System.out.println(res);
        }
        
        pathSum(root.left, path);
        pathSum(root.right, path);
        //path = path.substring(0, n);
    }
    /*ublic int minDepth(TreeNode root) {
        levelOrder(root);
        return 0;
    }*/
    
   /* public List<List<Integer>> levelOrder(TreeNode root) {
        recursion(root, 0);
        //System.out.println(res);
        return res;
    }*/
    
    
    /*
    public void recursion(TreeNode root, int level) {
        if (res.size() <= level && root != null) {
            res.add(new ArrayList<>());
        }
        if (root == null) {
            //empty
        } else {
            if (root.left == null && root.right == null) {
                minDepth = Math.min(minDepth, level + 1);
            }
            res.get(level).add(root.val);
            recursion(root.left, level + 1);
            recursion(root.right, level + 1);
        }
        
    }*/
    
    
    public TreeNode sortedArrayToBST(int[] nums) {
        if (nums.length == 0) {
            return null;
        }
        Arrays.sort(nums);
        TreeNode root = new TreeNode(nums[nums.length / 2]);
        TreeNode origin = root;
        for (int i = nums.length / 2 - 1; i >= 0; i--) {
            root.left = new TreeNode(nums[i]);
            root = root.left;
        }
        
        root = origin;
        
        for (int i = nums.length / 2 + 1; i < nums.length; i++) {
            root.right = new TreeNode(nums[i]);
            root = root.right;
        }
        
        return origin;
    }
    
    public TreeNode recursion(int[] nums, int start, int end) {
        if (start > end) {
            return null;
        }
    
        if (start == end) {
            return new TreeNode(nums[start]);
        }
    
        TreeNode root = new TreeNode(nums[(start + end) / 2]);
        root.left = recursion(nums, start, (start + end) / 2 - 1);
        root.right = recursion(nums, (start + end) / 2 + 1, end);
        return root;
    }
    
    /*
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        levelOrder(root);
        for (int i = 0; i < res.size(); i++) {
            result.add(res.get(res.size() - 1- i));
        }
        return result;
    }
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        levelOrder(root);
        for (int i = 0; i < res.size(); i++) {
            ArrayList temp = new ArrayList();
            if (i % 2 != 0) {
                for (int j = 0; j < res.get(i).size(); j++) {
                    temp.add(res.get(i).get(res.get(i).size() - 1 - i));
                }
                res.remove(i);
                res.add(i, temp);
            }
        }
        return res;
    }
    
    private boolean isSymmetricArray(List<Integer> array) {
        if (array.size() == 1) {
            return true;
        }
        if (array.size() % 2 != 0) {
            return false;
        }
        for (int i = 0; i < array.size() / 2; i++) {
            if (array.get(i) != array.get(array.size() - i - 1)) {
                return false;
            }
        }
        return true;
    }
    
    public boolean isSymmetric(TreeNode root) {
        levelOrder(root);
        //System.out.println(res);
        for (int i = 0; i < res.size(); i++) {
            if (!isSymmetricArray(res.get(i))) {
                System.out.println(i);
                return false;
            }
        }
        return true;
    }
    
    public List<List<Integer>> levelOrder(TreeNode root) {
        recursion(root, 0);
        //System.out.println(res);
        return res;
    }
    
    int maxDepth = 0;
    List<List<Integer>> res = new ArrayList<>();
    
    public void recursion(TreeNode root, int level) {
        if (res.size() <= level && root != null) {
            res.add(new ArrayList<>());
        }
        if (root == null) {
            //empty
        } else {
            maxDepth = Math.max(maxDepth, level);
            if (level % 2 == 0) {
                res.get(level).add(root.val);
            } else {
                res.get(level).add(0, root.val);
            }
            recursion(root.left, level + 1);
            recursion(root.right, level + 1);
        }
        
    }*/
    
    /*
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> lever = new ArrayList<>();
        if (root == null) {
            return lever;
        }
        ArrayList<TreeNode> allLevel = new ArrayList<>();
        ArrayList<TreeNode> nowLevel = new ArrayList<>();
        ArrayList<Integer> nowLevelVal = new ArrayList<>();
        nowLevelVal.add(root.val);
        lever.add(nowLevelVal);
        nowLevelVal = new ArrayList<>();
        if (root.left != null) {
            nowLevel.add(root.left);
            nowLevelVal.add(root.left.val);
        }
        if (root.right != null) {
            nowLevel.add(root.right);
            nowLevelVal.add(root.right.val);
        }
        allLevel.addAll(nowLevel);
        lever.add(nowLevelVal);
        nowLevel = new ArrayList<>();
        
        nowLevelVal = new ArrayList<>();
        System.out.println(allLevel);
        System.out.println(nowLevelVal);
        while (nowLevel.size() != 0 || allLevel.size() != 0) {
            System.out.println(111111);
            TreeNode temp = allLevel.get(0);
            allLevel.remove(0);
            if (temp.left != null) {
                nowLevel.add(temp.left);
                nowLevelVal.add(temp.left.val);
            }
            
            if (temp.right != null) {
                nowLevel.add(temp.right);
                nowLevelVal.add(temp.right.val);
            }
            System.out.println(nowLevelVal);
            if (allLevel.size() == 0 && nowLevel.size() != 0) {
                System.out.println(nowLevelVal);
                allLevel.addAll(nowLevel);
                System.out.println(allLevel);
                lever.add(nowLevelVal);
                nowLevel = new ArrayList<>();
                nowLevelVal = new ArrayList<>();
            }
        }
        System.out.println(lever);
        return lever;
     }*/
    
    public boolean isSameTree(TreeNode p, TreeNode q) {
        ArrayList<TreeNode> level = new ArrayList<>();
        if (p == null && q == null) {
            return false;
        }
        
        if (p != null && q != null && p.val == q.val) {
            level.add(p);
            level.add(q);
        } else {
            return false;
        }
        while (level.size() != 0) {
            TreeNode first = level.get(0);
            level.remove(0);
            TreeNode second = level.get(0);
            level.remove(0);
            if ((first.left != null && second.left != null) && (first.left.val == second.left.val)) {
                level.add(first.left);
                level.add(second.left);
            } else if (first.left == null && second.left == null) {
            } else {
                return false;
            }
    
            if ((first.right != null && second.right != null) && (first.right.val == second.right.val)) {
                level.add(first.right);
                level.add(second.right);
            } else if (first.right == null && second.right == null) {
            } else {
                return false;
            }
        }
        return true;
    }
    
    TreeNode pre = null;
    TreeNode firstWrong = null;
    TreeNode secondWrong = null;
    
    public void recoverTree(TreeNode root) {
        inorderTraversal(root);
        int temp = firstWrong.val;
        firstWrong.val = secondWrong.val;
        secondWrong.val = temp;
    }
    
    private void inOrderTraversal(TreeNode root) {
        if (root == null) {
            return;
        }
        inorderTraversal(root.left);
        if (pre != null && root.val < pre.val) {
            if (firstWrong == null) {
                firstWrong = pre;
                secondWrong = root;
            } else {
                secondWrong = root;
            }
        }
        pre = root;
        inorderTraversal(root.right);
    }
    /*
    boolean judge = true;
    public boolean isValidBST(TreeNode root) {
        return isValid(root, null, null);
    }
    
    public boolean isValid(TreeNode root, Integer min ,Integer max) {
        if (root == null) {
            return true;
        }
        
        if (min != null && root.val <= min) {
            //System.out.println();
            //System.out.println(1);
            return false;
        }
    
        if (max != null && root.val >= max) {
            //System.out.println();
            //System.out.println(1);
            return false;
        }
    
        if (root.left != null) {
            judge = judge & isValid(root.left, min, Math.min(max,root.val)) ;
        }
        
        if (root.right != null) {
            judge = judge & isValid(root.right, Math.max(min, root.val), max);
        }
        return judge;
    }
    */
    public int numTrees(int n) {
        int[] G = new int[n + 1];
        G[0] = 1;
        G[1] = 1;
        for (int i = 2; i <=n ;i++) {
            for (int j = 1; j <=i; j++) {
                G[i] = G[i] + G[j - 1] * G[i - j];
            }
        }
        return G[n];
    
    }
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        reinorderTraversal(root, result);
        System.out.println(result);
        return result;
    }
    
    public void reinorderTraversal(TreeNode root, List<Integer> result) {
        if (root == null) {
            return;
        }
        reinorderTraversal(root.left, result);
        result.add(root.val);
        reinorderTraversal(root.right, result);
    }
    
    int cur = 0;
    String str = "";
    
    public double cal(String s) {
        this.str = s;
        return expression();
    }
    
    double expression() {
        double num1 = term();
        double num2;
        while (cur < str.length() && (str.charAt(cur) == '+' || str.charAt(cur) == '-')) {
            char op = str.charAt(cur);
            cur++;
            num2 = term();
            if (op == '+') {
                num1 += num2;
            } else {
                num1 -= num2;
            }
        }
        if (cur < str.length() && str.charAt(cur) == ')') {
            cur++;
        }
        return num1;
    }
    
    double term() {
        double num1 = factor();
        double num2;
        while (cur < str.length() && (str.charAt(cur) == '*' || str.charAt(cur) == '/')) {
            char op = str.charAt(cur);
            cur++;
            num2 = factor();
            if (op == '*') {
                num1 *= num2;
            } else {
                num1 /= num2;
            }
        }
        return num1;
    }
    
    double factor() {
        double result;
        if (str.charAt(cur) == '(') {
            cur++;
            return expression();
        } else {
            String string = "";
            while (cur < str.length() && isNumber(str.charAt(cur)) ) {
                string = string + str.charAt(cur);
                cur++;
            }
            result = toNumber(string);
        }
        return result;
    }
    
    public void getVlaue(String string) {
        System.out.println(suffixToResult(infixToSuffix(string)));
    }
    
    private boolean isNumber(char character) {
        return character >= '0' && character <= '9';
    }
    
    private boolean isOperator(char character) {
        return !isNumber(character) && character != '(' && character != ')';
    }
    
    private int priority(char character) {
        if (character == '+' || character == '-') {
            return 1;
        } else {
            return 2;
        }
    }
    
    private Integer toNumber(String expr) {
        int flag = 0;
        //["10","6","9","3","+","-11","*","/","*","17","+","5","+"]
        if (expr.charAt(0) == '-') {
            expr = expr.substring(1);
            flag = 1;
        }
        int number = 0;
        int bit = 1;
        for (int i = expr.length() - 1; i >= 0; i--) {
            number = number + (expr.charAt(i) - '0') * bit;
            bit *= 10;
        }
        if (flag == 0) {
            return number;
        } else {
            return -1 * number;
        }
    }
    
    public List<String> infixToSuffix(String expr) {
        Stack<Character> stack = new Stack<>();
        ArrayList<String> list = new ArrayList<>();
        for (int i = 0; i < expr.length(); i++) {
            if (expr.charAt(i) >= '0' && expr.charAt(i) <= '9') {
                String numExpr = "";
                while (i < expr.length() && isNumber(expr.charAt(i))) {
                    numExpr = numExpr + expr.charAt(i);
                    i++;
                }
                i--;
                list.add(numExpr);
            } else if (expr.charAt(i) == '(') {
                stack.push(expr.charAt(i));
            } else if (expr.charAt(i) == ')') {
                while (!stack.isEmpty() && stack.peek() != '(') {
                    list.add("" + stack.pop());
                }
                if (!stack.isEmpty()) {
                    stack.pop();
                }
            } else {
                
                while (!stack.isEmpty() && isOperator(stack.peek())
                        && priority(stack.peek()) >= priority(expr.charAt(i))) {
                    //System.out.println(priority(stack.peek()));
                    //System.out.println(priority(expr.charAt(i)));
                    list.add(stack.pop() + "");
                }
                stack.push(expr.charAt(i));
            }
            //System.out.println(stack);
            //System.out.println(list);
            //System.out.println("-----");
        }
        while (!stack.isEmpty()) {
            list.add(stack.pop() + "");
        }
        return list;
    }
    
    public int suffixToResult(List<String> list) {
        //System.out.println(list);
        Stack<Integer> stack = new Stack<>();
        
        for (String element : list) {
            if (isNumber(element.charAt(0)) || (element.length() > 1 && isNumber(element.charAt(1)))) {
                //System.out.println(toNumber(element));
                stack.push(toNumber(element));
            } else {
                //System.out.println(stack);
                Integer num1 = stack.pop();
                Integer num2 = stack.pop();
                Integer value = 0;
                if (element.charAt(0) == '+') {
                    value = num2 + num1;
                } else if (element.charAt(0) == '-') {
                    value = num2 - num1;
                } else if (element.charAt(0) == '*') {
                    value = num2 * num1;
                } else if (element.charAt(0) == '/') {
                    value = num2 / num1;
                }
                System.out.println(num2);
                System.out.println(num1);
                System.out.println("***" + value);
                stack.push(value);
            }
        }
        return stack.pop();
    }
    
    public List<String> judgePoint24(int[] nums) {
        ArrayList A = new ArrayList<Double>();
        
        List<String> result = new ArrayList<>();
        List<String> nowRes = new ArrayList<>();
        for (int v: nums) {
            A.add((double) v);
            nowRes.add(String.valueOf(v));
        }
        partition(A, nowRes, result);
        return result;
    }
    
    public void partition(ArrayList<Double> nums, List<String> nowRes, List<String> result) {
        if (nums.size() == 0) {
            return;
        }
        if (nums.size() == 1) {
            if (Math.abs(nums.get(0) - 24) < 1e-6) {
                result.add(nowRes.get(0));
            }
        }
        
        for (int i = 0; i < nums.size(); i++) {
            for (int j = 0; j < nums.size(); j++) {
                // 选择其中任意两个进行运算
                //保证这两个不相等
                if (i != j) {
                    ArrayList<Double> nums2 = new ArrayList<>();
                    ArrayList<String> nowRes2 = new ArrayList<>();
                    //对非被选中的，直接加入
                    for (int k = 0; k < nums.size(); k++) {
                        if (k != i && k!=j) {
                            nums2.add(nums.get(k));
                            nowRes2.add(nowRes.get(k));
                        }
                    }
                    //对被选中的运算
                    for (int k = 0; k < 4; k++) {
                        if (k < 2 && j > i) {
                            continue;
                        } else if (k == 0) {
                            nums2.add(nums.get(i) + nums.get(j));
                            nowRes2.add('(' + nowRes.get(i) + '+' + nowRes.get(j) + ')');
                            partition(nums2, nowRes2, result);
                            nums2.remove(nums2.size() - 1);
                            nowRes2.remove(nowRes2.size() - 1);
                        } else if (k == 1) {
                            nums2.add(nums.get(i) * nums.get(j));
                            nowRes2.add("" + nowRes.get(i) + '*' + nowRes.get(j) + "");
                            partition(nums2, nowRes2, result);
                            nums2.remove(nums2.size() - 1);
                            nowRes2.remove(nowRes2.size() - 1);
                        } else if (k == 2) {
                            nums2.add(nums.get(i) - nums.get(j));
                            nowRes2.add('(' + nowRes.get(i) + '-' + nowRes.get(j) + ')');
                            partition(nums2, nowRes2, result);
                            nums2.remove(nums2.size() - 1);
                            nowRes2.remove(nowRes2.size() - 1);
                        } else if (k == 3 && nums.get(j) != 0) {
                            nums2.add(nums.get(i) / nums.get(j));
                            nowRes2.add("" + nowRes.get(i) + '/' + nowRes.get(j) + "");
                            partition(nums2, nowRes2, result);
                            nums2.remove(nums2.size() - 1);
                            nowRes2.remove(nowRes2.size() - 1);
                        } else {
                            continue;
                        }
                    }
                }
            }
        }
        return;
    }
    /*
    ArrayList<Character> op = new ArrayList<>();
    String[] nums;
    
    public List<String> addOperators(String num, int target) {
        List<String> result = new ArrayList<>();
        partition(num, target, "", "", "", result);
        if (num.length() == 0) {
            return new ArrayList<>();
        }
        System.out.println(result);
        return result;
    }
    
    public void partition(String num, int target,
                          long lastOperaNum,
                          long curNum,
                          String tempRes,
                          List<String> result) {
        if (num.length() == 0 && curNum == target) {
            result.add(tempRes);
            return;
        }
        
        for (int i = 1; i <= num.length(); i++) {
            String cur = num.substring(0, i);
            if (cur.length() > 1 && cur.charAt(0) == '0') {
                return;
            }
            String next = num.substring(i);
            if (tempRes.length() == 0) {
                partition(next, target, cur, cur, cur, result);
            } else {
                partition(next, target, cur,
                        String.valueOf(new BigInteger(curNum).add(new BigInteger(cur))),
                        tempRes + "+" + cur, result);
                
                partition(next, target, '-' + cur,
                        String.valueOf(new BigInteger(curNum).subtract(new BigInteger(cur))),
                        tempRes + "-" + cur, result);
                partition(next, target,
                        String.valueOf(new BigInteger(lastOperaNum).multiply(new BigInteger(cur))),
                        String.valueOf(new BigInteger(curNum).subtract(new BigInteger(lastOperaNum)).add(new BigInteger(lastOperaNum).multiply(new BigInteger(cur)))),
                        tempRes + "*" + cur, result);
            }
        }
    }
    /*
    public void partition(String num, int target,
                          String lastOperaNum,
                          String curNum,
                          String tempRes,
                          List<String> result) {
        if (num.length() == 0 && curNum.length() != 0 && new BigInteger(curNum).equals(new BigInteger(String.valueOf(target)))) {
            result.add(tempRes);
            return;
        }
        
        for (int i = 1; i <= num.length(); i++) {
            String cur = num.substring(0, i);
            if (cur.length() > 1 && cur.charAt(0) == '0') {
                return;
            }
            String next = num.substring(i);
            if (tempRes.length() == 0) {
                partition(next, target, cur, cur, cur, result);
            } else {
                partition(next, target, cur,
                        String.valueOf(new BigInteger(curNum).add(new BigInteger(cur))),
                        tempRes + "+" + cur, result);
    
                partition(next, target, '-' + cur,
                        String.valueOf(new BigInteger(curNum).subtract(new BigInteger(cur))),
                        tempRes + "-" + cur, result);
                partition(next, target,
                        String.valueOf(new BigInteger(lastOperaNum).multiply(new BigInteger(cur))),
                        String.valueOf(new BigInteger(curNum).subtract(new BigInteger(lastOperaNum)).add(new BigInteger(lastOperaNum).multiply(new BigInteger(cur)))),
                        tempRes + "*" + cur, result);
            }
        }
    }*/
    
    /*
    public void split(String input) {
        
        for (int i = 0; i < input.length(); i++) {
            if (input.charAt(i) == '+' || input.charAt(i) == '-' || input.charAt(i) == '*') {
                op.add(input.charAt(i));
            }
        }
        nums = input.split("[\\+\\-\\*]");
        //System.out.println(nums.length);
        //System.out.println(op.size());
    }
    
    public List<Integer> diffWaysToCompute(String input) {
        split(input);
        return paitition(0, nums.length - 1);
    }
    
    public List<Integer> paitition(int start, int end) {
        List<Integer> result = new ArrayList<>();
        if (start == end) {
            result.add(Integer.valueOf(nums[start]));
            return result;
        }
        
        for (int i = start; i < end; i++) {
            for (Integer left : paitition(start, i)) {
                for (Integer right : paitition(i + 1, end)) {
                    //System.out.println(left);
                    //System.out.println(right);
                    if (op.get(i) == '+') {
                        result.add(left + right);
                    } else if (op.get(i) == '-') {
                        result.add(left - right);
                    } else if (op.get(i) == '*') {
                        result.add(left * right);
                    }
                }
            }
        }
       // System.out.println("退出递归");
        return result;
    }*/
    /*
    
    public List<Integer> partition(String input) {
        List<Integer> result = new ArrayList<>();
        if (!input.contains("+") && !input.contains("-") && !input.contains("*")) {
            result.add(Integer.valueOf(input));
            return result;
        }
        for(int i = 0; i < input.length(); i++) {
            if (input.charAt(i) == '+' || input.charAt(i) == '-' || input.charAt(i) == '*') {
                for(Integer left : partition(input.substring(0, i + 1))) {
                    for (Integer right : partition(input.substring(i + 1))) {
                        if (input.charAt(i) == '+') {
                            result.add(left + right);
                        } else if (input.charAt(i) == '-') {
                            result.add(left - right);
                        } else if (input.charAt(i) == '*') {
                            result.add(left * right);
                        }
                    }
                }
            }
        }
        return result;
    }*/
    
    public boolean searchMatrix(int[][] matrix, int target) {
        if (matrix == null || matrix.length == 0) {
            return false;
        }
        int left = 0;
        int right = matrix[0].length - 1;
        int up = 0;
        int down = matrix.length - 1;
        int i = left;
        int j = down;
        while (i <= right || j >= up) {
            System.out.println(i);
            System.out.println(j);
            if (matrix[j][i] < target) {
                if (i != right) {
                    i++;
                }
            } else if (matrix[j][i] > target) {
                if (j != up) {
                    j--;
                }
            } else {
                return true;
            }
            if (i == right && j == up) {
                if (matrix[j][i] == target) {
                    return true;
                }
                break;
            }
        }
        return false;
    }
    /*
    public boolean searchMatrix(int[][] matrix, int target) {
        if (matrix == null || matrix.length == 0) {
            return false;
        }
        return partition(matrix, 0, matrix[0].length - 1, 0, matrix.length, target);
    }
    
    public boolean partition(int[][] matrix, int left, int right, int up, int down, int target) {
        if (left > right || up > down) {
            return false;
        } else if (target < matrix[up][left] || target > matrix[down][right]) {
            return false;
        }
        int mid = left + (right - left) / 2;
        int j = up;
        while (j <= down && matrix[j][mid] <= target) {
            if (matrix[j][mid] == target) {
                return true;
            }
            j++;
        }
        return partition(matrix, mid + 1, right, up, j - 1, target)
                || partition(matrix, left, mid - 1, j, down, target);
        
    }*/
    /*
    int[] nums;
    
    private void swap(int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
    
    public int findKthLargest(int[] nums ,int k) {
        this.nums = nums;
        //System.out.println(quickSelect(0, nums.length - 1, nums.length - k));
        return quickSelect(0, nums.length - 1, nums.length - k);
    }
    
    public int quickSelect(int start, int end, int k) {
        if (start == end) {
            return nums[start];
        }
        int storeIndex = partition(start, end);
        if (k == storeIndex) {
            return nums[storeIndex];
        } else if (k < storeIndex) {
            return quickSelect(start, storeIndex - 1, k);
        } else {
            return quickSelect(storeIndex + 1, end, k);
        }
    }
    
    public int partition(int start, int end) {
        //System.out.println(start);
        //System.out.println(end);
        int pivotIndex = start + new Random().nextInt(end - start);
        int pivot = nums[pivotIndex];
        swap(pivotIndex, start);
        //System.out.println(pivot);
        int i = start;
        int j = end;
        while (i < j) {
            while (i < j && nums[j] >= pivot) {
                j--;
            }
            if (i < j) {
                nums[i++] = nums[j];
            }
            System.out.println(Arrays.toString(nums));
            while (i < j && nums[i] < pivot) {
                i++;
            }
            if (i < j) {
                //swap(i, j);
                //j--;
                nums[j --] = nums[i];
            }
            System.out.println(Arrays.toString(nums));
        }
        System.out.println(Arrays.toString(nums));
        nums[i] = pivot;
        System.out.println(Arrays.toString(nums));
        System.out.println(i);
        return i;
    }
    
    public int findKthLargest2(int[] nums, int k) {
        Arrays.sort(nums);
        return nums[nums.length - k - 1];
    }
    
    public int findKthLargest3(int[] nums, int k) {
        PriorityQueue<Integer> heap = new PriorityQueue<>();
        for (int i = 0; i < k; i++) {
            heap.add(nums[i]);
        }
        System.out.println(heap.peek());
        for (int i = k; i < nums.length; i++) {
            if (nums[i] > heap.peek()) {
                heap.remove();
                heap.add(nums[i]);
            }
        }
        return heap.peek();
    }
    
    public ListNode mergeKLists(ListNode[] lists) {
        if (lists.length == 0) {
            return null;
        }
        return divide(lists, 0 , lists.length - 1);
    }
    
    public ListNode divide(ListNode[] lists, int start, int end) {
        if (start == end) {
            return lists[start];
        }
        int mid = start + (end - start) / 2;
        ListNode left = divide(lists, start, mid);
        ListNode right = divide(lists, mid, end);
        return mergeTwoLists(left, right);
    }
    
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if (l1 == null) {
            return l2;
        }
        if (l2 == null) {
            return l1;
        }
        if (l1.val > l2.val) {
            l1.next = mergeTwoLists(l1.next, l2);
            return l1;
        } else {
            l2.next = mergeTwoLists(l2.next, l1);
            return l2;
        }
    }
    
    public ListNode mergeKLists2(ListNode[] lists) {
        System.out.println(lists[0].val);
        System.out.println(lists[0].next.val);
        PriorityQueue<ListNode> listNodes = new PriorityQueue<>(lists.length, Comparator.comparingInt(a -> a.val));
        for (ListNode list : lists) {
            if (list != null) {
                listNodes.add(list);
            }
        }
        
        ListNode result = new ListNode(-1);
        ListNode headResult = result;
        if (listNodes.size() == 0) {
            return null;
        }
        while (!listNodes.isEmpty()) {
            ListNode head = listNodes.poll();
            result.next = head;
            result = result.next;
            if (head.next != null) {
                listNodes.add(head.next);
            }
        }
        
        return headResult.next;
    }
    
    public int majorityElement(int[] nums) {
        int countMax = 0;
        int maxKey = 0;
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int count = 1;
            if (map.containsKey(nums[i])) {
                count = map.get(nums[i]) + 1;
            }
            map.put(nums[i], count);
            if (count > countMax) {
                countMax = count;
                maxKey = nums[i];
            }
        }
        return maxKey;
    }
    public int majorityElement2(int[] nums) {
        if (nums.length == 0) {
            return -1;
        }
        return divide(nums, 0, nums.length - 1);
    }
    
    public int count(int[] nums, int num, int start, int end) {
        int count = 0;
        for (int i = start; i <= end; i++) {
            if (nums[i] == num) {
                count++;
            }
        }
        return count;
    }
    
    public int divide(int[] nums, int start, int end) {
        if (start == end) {
            return nums[start];
        }
        int mid = start + (end - start) / 2;
        int d1 = divide(nums, start, mid);
        int d2 = divide(nums, mid + 1, start);
        if (d1 == d2) {
            return d1;
        }
        if (count(nums, d1, start, end) > count(nums, d2, start, end)) {
            return d1;
        } else {
            return d2;
        }
        
    }*/
    public static void main(String[] args) {
        /*ListNode bit1 = new ListNode(1);
        ListNode bit2 = new ListNode(3);
        ListNode bit3 = new ListNode(4);
        ListNode bit4 = new ListNode(9);
        ListNode bit11 = new ListNode(9);
        ListNode bit12 = new ListNode(2);
        ListNode bit13 = new ListNode(9);
        bit3.next = bit4;
        bit2.next = bit3;
        bit1.next = bit2;
        bit12.next = bit13;
        bit11.next = bit12;
        Solution solution = new Solution();
        solution.addTwoNumbers(bit1, bit11);
        String string = "L12eqafasfasfa";
        solution.convert(string, 3);
        */
        Solution solution = new Solution();
        /*ListNode l1 = new ListNode(1);
        l1.next = new ListNode(2);
        ListNode l2 = new ListNode(3);
        l2.next = new ListNode(5);
        ListNode[] list = new ListNode[2];
        list[0] = l1;
        list[1] = l2;
        solution.mergeKLists(list);
        //solution.uniquePaths(m, n);
        */
        int[][] matrix = new int[2][2];
        matrix[0][0] = 1;
        matrix[0][1] = 3;
        matrix[1][0] = 2;
        matrix[1][1] = 4;
        TreeNode tree = new TreeNode(5);
        tree.left = new TreeNode(3);
        tree.right = new TreeNode(2);
        tree.left.left = new TreeNode(4);
        tree.left.right = new TreeNode(3);
        tree.right.left = new TreeNode(2);
        tree.right.right = new TreeNode(1);
        System.out.println(solution.binaryTreePaths(tree));
    }
}
