# Algorithm Practice Repository

이 저장소는 알고리즘 문제 해결 연습을 위한 프로젝트입니다.

## 프로젝트 구조

```
algorithm/
├── java/algorithm/src/
│   ├── baekjoon/          # 백준 문제
│   ├── leetcode/          # 리트코드 문제
│   │   ├── BFS_Binary_Trees/
│   │   ├── DFS_Binary_Trees/
│   │   ├── Hashing/
│   │   ├── LinkedList/
│   │   ├── Sliding_Window/
│   │   └── Stack/
│   └── programmers/       # 프로그래머스 문제
├── python/                # 파이썬 솔루션
└── create_problem.js      # 문제 생성 자동화 스크립트
```

## 문제 생성 자동화 도구 사용법

`create_problem.js` 스크립트를 사용하여 새로운 알고리즘 문제 폴더와 Java 파일을 자동으로 생성할 수 있습니다.

### 실행 방법

```bash
node create_problem.js
```

### 사용 단계

1. **상위 폴더 선택**
   - `baekjoon`, `leetcode`, `programmers` 중 선택
   - 예: `leetcode`

2. **카테고리 폴더 선택**
   - 해당 플랫폼의 하위 카테고리 입력
   - 예: `Stack`, `Hashing`, `LinkedList` 등

3. **문제 제목 입력**
   - 형식: `숫자. 문제제목`
   - 예: `20. Valid Parentheses`

4. **솔루션 코드 입력**
   - `class Solution { ... }` 형태의 Java 코드 붙여넣기
   - 입력 완료 후 새 줄에 `END` 입력

### 생성되는 파일 구조

스크립트 실행 후 다음과 같은 구조로 파일이 생성됩니다:

```
java/algorithm/src/leetcode/Stack/ValidParentheses_20/
└── Solution.java
```

### 예시 실행 과정

```bash
$ node create_problem.js

생성할 문제의 상위 폴더명을 입력하세요 (예: baekjoon, leetcode, programmers): leetcode
'leetcode' 하위의 카테고리 폴더명을 입력하세요 (예: Stack, Hashing): Stack

문제 제목을 입력하세요 (예: 20. Valid Parentheses): 20. Valid Parentheses

'java/algorithm/src/leetcode/Stack/ValidParentheses_20' 폴더를 생성했습니다.

`class Solution { ... }` 코드를 여기에 붙여넣으세요. 입력이 끝나면 새 줄에 "END"를 입력하세요:
class Solution {
    public boolean isValid(String s) {
    }
}
END

'java/algorithm/src/leetcode/Stack/ValidParentheses_20/Solution.java' 파일을 생성했습니다.

프로젝트 생성이 완료되었습니다.
```

### 자동화 기능

- **폴더 자동 생성**: 필요한 디렉토리 구조를 자동으로 생성
- **패키지 선언 자동 추가**: Java 파일에 적절한 package 선언 추가
- **클래스명 자동 변환**: 문제 제목을 PascalCase로 변환하여 클래스명 생성
- **public 키워드 자동 추가**: `class Solution`을 `public class Solution`으로 자동 변환
- **중복 방지**: 이미 존재하는 폴더가 있으면 오류 메시지 출력

### 주의사항

- 문제 제목은 "숫자. 제목" 형식을 따라야 합니다
- 솔루션 코드는 `class Solution { ... }` 형태여야 합니다
- 코드 입력 완료 후 반드시 `END`를 입력해야 합니다
- 코드는 `}`로 끝나야 합니다