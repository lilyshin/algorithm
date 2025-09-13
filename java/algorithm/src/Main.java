import leetcode.DFS_Binary_Trees.MaximumDepthOfBinaryTree_104.Solution;
import leetcode.DFS_Binary_Trees.MaximumDepthOfBinaryTree_104.TreeNode;

/**
 * 여러 문제의 Solution 클래스를 테스트하기 위한 공통 Main 클래스입니다.
 * 이 파일을 직접 수정하여 실행하고 싶은 문제의 코드를 테스트하세요.
 */
public class Main {
    public static void main(String[] args) {
        System.out.println("공통 Main 클래스입니다. 실행할 문제의 Solution 클래스를 아래에 직접 작성하여 테스트하세요.");
        System.out.println("======================================================================");

        // 사용 예시:
        // 1. 실행하려는 Solution 클래스가 포함된 패키지를 import 하거나,
        //    (간단한 테스트를 위해) Solution 클래스 코드를 이 파일 하단에 직접 복사하여 사용하세요.

        // 2. 아래의 주석을 풀고, 클래스 이름과 메서드를 실제 문제에 맞게 수정하여 사용하세요.
        Solution solution = new Solution();
        
        // 예시 테스트 케이스 (문제에 맞게 변경)
        TreeNode root = new TreeNode();
        int result = solution.maxDepth(root); // 메서드 이름은 실제 문제에 맞게 변경
        System.out.println("Input: " + root);
        System.out.println("Output: " + result); // 예상 출력: "ca"
    }
}