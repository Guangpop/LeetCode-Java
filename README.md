紀錄使用IDEA IntelliJ加上LeetCode Editor Plugin刷題的心得以及設置

略過Plugin安裝以及大部分設定,作者以及參考的網頁已經說明過了  
有關於Java Project的設置部分:

1. 開啟IntelliJ的Project Structure
2. 點選Modules並把leetcode, editor, en選為Sources; doc選為Resources
![截圖 2023-12-19 下午11 27 44](https://github.com/Guangpop/LeetCode-Java/assets/489388/800661a5-b13e-42c2-966e-62516b2e6fe4)

3. 打開LeetCode Editor的設定並把Template改為如下:  
Code File Name:
```
P$!velocityTool.replaceChars($!{question.frontendQuestionId}," -.","__")_$!velocityTool.camelCaseName(${question.titleSlug})
```
Code Template:  
```
//Java：${question.title}

${question.content}

public class P$!velocityTool.replaceChars($!{question.frontendQuestionId}," -.","__")_$!velocityTool.camelCaseName(${question.titleSlug}){
    public static void main(String[] args) {
        Solution solution = new P$!velocityTool.replaceChars($!{question.frontendQuestionId}," -.","__")_$!velocityTool.camelCaseName(${question.titleSlug})().new Solution();
        // TO TEST
    }
    ${question.code}
}
```

參考  
1. Rayer - 使用GoLang刷題: https://github.com/Rayer/leetcode-go  
2. kevinhwang - 提供客製化設置For Java: https://www.kevinhwang.cn/?p=864  
 我使用的是原版Plugin以及英文版LeetCode所以只是修改了小部分Tmeplate設定  
