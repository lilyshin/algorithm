#!/usr/bin/env node
const fs = require('fs');
const path = require('path');
const readline = require('readline');

const rl = readline.createInterface({
  input: process.stdin,
  output: process.stdout
});

const basePath = path.join(process.cwd(), 'java', 'algorithm', 'src');

function toPascalCase(str) {
  if (!str) return '';
  return str.split(' ').map(word => {
    if (word.match(/^[()[\\]{}]+$/)) {
        return word;
    }
    return word.charAt(0).toUpperCase() + word.slice(1).toLowerCase();
  }).join('');
}

function processProblem() {
  rl.question('\n문제 제목을 입력하세요 (예: 20. Valid Parentheses): ', (titleLine) => {
    if (!titleLine) {
      console.log('오류: 제목이 입력되지 않았습니다.');
      rl.close();
      return;
    }

    const match = titleLine.match(/^(\d+)\.\s*(.*)$/);
    if (!match) {
      console.log('오류: "숫자. 제목" 형식을 찾을 수 없습니다. (예: "20. Valid Parentheses")');
      rl.close();
      return;
    }

    const number = match[1];
    const title = match[2].trim().replace(/[^a-zA-Z0-9\s()[\\]{}]/g, '');
    const pascalCaseTitle = toPascalCase(title);
    const className = `${pascalCaseTitle}_${number}`;

    const problemPath = path.join(currentCategoryPath, className);
    if (fs.existsSync(problemPath)) {
      console.log(`오류: '${problemPath}' 디렉토리가 이미 존재합니다.`);
      rl.close();
      return;
    }
    fs.mkdirSync(problemPath, { recursive: true });
    console.log(`\n'${problemPath}' 폴더를 생성했습니다.`);

    const packageName = path.relative(basePath, problemPath).replace(/\\|\//g, '.');
    const packageDeclaration = `package ${packageName};\n\n`;

    function askForSolutionCode() {
      console.log('\n`class Solution { ... }` 코드를 여기에 붙여넣으세요. 입력이 끝나면 새 줄에 "END"를 입력하세요:');
      const solutionLines = [];
      
      const solutionListener = (line) => {
        if (line.trim().toUpperCase() === 'END') {
          rl.removeListener('line', solutionListener);

          let solutionCode = solutionLines.join('\n');
          if (!solutionCode.trim().endsWith('}')) {
            console.log("\n오류: 코드가 '}'로 끝나야 합니다. 처음부터 다시 입력해주세요.");
            askForSolutionCode();
            return;
          }

          // "class Solution"을 "public class Solution"으로 변경
          if (solutionCode.includes('class Solution') && !solutionCode.includes('public class Solution')) {
            solutionCode = solutionCode.replace('class Solution', 'public class Solution');
          }

          const solutionContent = `${packageDeclaration}${solutionCode}`;

          fs.writeFileSync(path.join(problemPath, 'Solution.java'), solutionContent);
          console.log(`'${path.join(problemPath, 'Solution.java')}' 파일을 생성했습니다.`);

          console.log('\n프로젝트 생성이 완료되었습니다.');
          rl.close();

        } else {
          solutionLines.push(line);
        }
      };
      
      rl.on('line', solutionListener);
    }

    askForSolutionCode();
  });
}

let currentCategoryPath = '';

rl.question(`생성할 문제의 상위 폴더명을 입력하세요 (예: baekjoon, leetcode, programmers): `, (topLevel) => {
  const topLevelPath = path.join(basePath, topLevel);
  if (!fs.existsSync(topLevelPath)) {
    fs.mkdirSync(topLevelPath, { recursive: true });
    console.log(`'${topLevelPath}' 폴더를 생성했습니다.`);
  }

  rl.question(`'${topLevel}' 하위의 카테고리 폴더명을 입력하세요 (예: Stack, Hashing): `, (category) => {
    currentCategoryPath = path.join(topLevelPath, category);
    if (!fs.existsSync(currentCategoryPath)) {
      fs.mkdirSync(currentCategoryPath, { recursive: true });
      console.log(`'${currentCategoryPath}' 폴더를 생성했습니다.`);
    }
    processProblem();
  });
});