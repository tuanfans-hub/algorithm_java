左神对于学习算法的入门提醒
1，善于、乐于折腾。勤写代码找到乐趣，只看课没有用。看懂了一定要确保自己手写正确，再继续下个内容
2，算法的学习节奏，不像大学，像高中。区别是一个为了应试，一个在磨练手艺，代码人就是手艺人
3，关于复习，尽量冲击到一定的题量再整体复习，不要频繁复习，会拉长周期，而且很多是无效的复习

关于StreamTokenizer的规则
它的核心规则非常清晰：
1. 先分词，再分类：它首先会根据你定义的“空白符”来分割输入流，得到一个个“词”。
2. 按优先级判断类型：对于分割出的每个“词”，它会根据语法表里的设置，按优先级判断其类型：是数字？是引号内的字符串？还是普通单词？

🧩 一、核心转换规则
BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
StreamTokenizer in = new StreamTokenizer(br);
in.nextToken()：
ASCII 码 0x00～0x20（含空格、换行、制表符）默认视为空白字符，多个连续空白符被合并为单一分隔符。
in.whitespaceChars(low, hi); // 自定义空白字符范围
		
默认将 0-9、.、- 组合识别为浮点数（ttype = TT_NUMBER），值存入 nval。
若数字字符被设为普通字符（ordinaryChar），则作为字符串处理（ttype = TT_WORD）。
in.parseNumbers(); // 启用数字自动解析（默认开启）。
in.ordinaryChar('0'); // 禁用数字解析，强制作为字符串。
		
单词（Word）：由字母、数字、下划线等组成（默认 a-z、A-Z、0-9 为单词要素）。
字符串（String）：引号 " 或 ' 包围的内容（含空格），值存入 sval。
in.wordChars(low, hi);   // 扩展单词要素字符范围。
in.quoteChar('"');       // 指定引号作为字符串定界符。
		
/ 默认为注释起始符（后续内容忽略）。
/* 和 // 默认为注释块（需显式启用）。
in.slashSlashComments(true);  // 启用 // 注释解析
in.slashStarComments(true);   // 启用 /* */ 注释解析
in.ordinaryChar('/');         // 禁用注释，将 '/' 视为普通字符
		
| 方法                               | 作用                       | 适用场景                 |
|------------------------------------|----------------------------|-----------------------|
| resetSyntax()                     | 重置语法表为默认状态           | 重新初始化解析器           |
| ordinaryChar(int ch)              | 指定字符为普通字符（无特殊含义） | 禁用数字/注释解析          |
| wordChars(int low, int hi)        | 指定字符范围作为单词组成部分    | 扩展单词要素（如支持 `$`）  |
| whitespaceChars(int low, int hi)  | 指定空白字符范围（用作分隔符）  | 自定义分隔符（如逗号）       |
| commentChar(int ch)               | 指定注释起始符               | 更换注释符号（如 `#`）      |
语法表配置对实例全局生效，复用时需调用 resetSyntax()。