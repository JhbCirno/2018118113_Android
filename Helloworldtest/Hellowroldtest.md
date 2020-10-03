# 第三次作业的实验报告

本次实验使用的实验环境为android studio，实验题目为四种不同的活动的启动模式
## standard模式
standard模式时活动的默认启动模式

代码：
```java
   protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.d("FirstActivity",this.toString());
        setContentView(R.layout.first_layout);
        Button button1 = (Button) findViewById(R.id.button);
        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View V) {
               Intent intent = new Intent(Firstactivity.this,secondactivity.class);
               startActivity(intent);
            }
        });
```
