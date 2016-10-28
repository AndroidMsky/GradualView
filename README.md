# GradualView
GradualshowcolorAndResourse
话不多说上个动图解释框架的内容：

![这里写图片描述](http://img.blog.csdn.net/20161028104317219)



**项目使用方：**

方法一：添加依赖（适合组件化的项目）

```
compile project(':graduallibrary')
```
方法二：
考入四个文件即可
![这里写图片描述](http://img.blog.csdn.net/20161028105909000)
方法三：
通过aar添加再（暂不推荐，由于扩展方法较少，可能暂时无法修改你想要的布局，后续笔者会完善）

```
  compile(name:'graduallibrary-1.0.0', ext:'aar')
```



项目地址：
https://github.com/AndroidMsky/GradualView

记得在笔者X菱电梯的时候，有个需求，大概就是电梯开门，让一个白色的文字渐渐的变成蓝色并且展开，大概的意思就电梯到了几楼的意思。当时很苦恼，**蓝色——》白色**中间要经历怎样的沧桑变化呢？后来跟我们当时的美工MM沟通了一下，她说比如白色还有50％就变成蓝色了，她在PS中先用白色遮罩住蓝色，然后让白色的透明度变为50％，这个效果就出来啦。听了MM的解释笔者真是豁然开朗，也提示大家有些效果自己想不通的话不妨和美工MM共同讨论一下。

于是我就拿起键盘啪啪啪写下啦两个TextView然后一个覆盖一个然后用属性动画去控制透明度，然后啪啪啪提交代码。效果实现就实现啦，可是现在的我就再想，这个渐变动画确实好用，也符合未来安卓界面设计方向，于是我就将这些简易的功能封装成了GradualTextView，来实现文字颜色渐变，文字内容颜色共同渐变的效果。以至于后来我觉得imgView在切换图片的时候也可以渐变，就又出现了GradualImageView。对于框架的第一版，笔者之提供简单的方法支持，后续将持续维护该开源框架。也欢迎大家Fork



项目原理及方法解读：

```
public class GradualTextView extends FrameLayout
```
GradualTextView继承自FrameLayout。自带两个TextView它们大大小一致，用于FrameLayout所以位置都在左上角。


设置文字颜色：

```
/*
    * color1 --->color2  please use deep color to color2
    * */
    public void setTextColor(int color1, int color2) {
        TextColor1 = color1;
        TextColor2 = color2;
        reset();
    }
```

设置文字内容：

```
public void setText(String text) {
        this.text = text;
        reset();
    }
```

1－》2颜色渐变：

```
public void startChange(final int TIME) {
        ObjectAnimator mObObjectAnimator = new ObjectAnimator();
        mObObjectAnimator.ofFloat(textView2, "Alpha", 1.0F, 0.0F).setDuration(TIME).start();
        mObObjectAnimator.cancel();


    }
```

2－》1颜色渐变：

```
public void backChange(final int TIME) {

        ObjectAnimator mObObjectAnimator = new ObjectAnimator();
        mObObjectAnimator.ofFloat(textView2, "Alpha", 0.0F, 1.0F).setDuration(TIME).start();
        mObObjectAnimator.cancel();


```

颜色内容同时渐变：

```
public void twoTextChange(String text1, String text2, int color1, int color2, final int TIME) {
        setTextColor(color1, color2);
        setText(text1);

        ObjectAnimator mObObjectAnimator = new ObjectAnimator();
        mObObjectAnimator.ofFloat(textView2, "Alpha", 0.0F, 1.0F).setDuration(TIME).start();
        mObObjectAnimator.cancel();
        textView2.setText(text2);
        ObjectAnimator mObObjectAnimator1 = new ObjectAnimator();
        mObObjectAnimator1.ofFloat(textView1, "Alpha", 1.0F, 0.0F).setDuration(TIME).start();
        mObObjectAnimator1.cancel();


    }
```

GradualImageView同样继承自FrameLayout

```
public class GradualImageView extends FrameLayout
```

设置图片资源：

```
 public void setImgResourse(int ImgResourse1, int ImgResourse2) {
        this.ImgResourse1 = ImgResourse1;
        this.ImgResourse2 = ImgResourse2;
        reset();
    }
```

图片转换：

```
public void startChange(final int TIME){
        ObjectAnimator mObObjectAnimator=new ObjectAnimator();
        mObObjectAnimator.ofFloat(imageView2, "Alpha", 1.0F,0.0F).setDuration(TIME).start();
        mObObjectAnimator.cancel();


    }
    public void backChange(final int TIME){

        ObjectAnimator mObObjectAnimator=new ObjectAnimator();
        mObObjectAnimator.ofFloat(imageView2, "Alpha", 0.0F,1.0F).setDuration(TIME).start();
        mObObjectAnimator.cancel();


    }
```

Deom调用：

```
public class MainActivity extends AppCompatActivity {
    GradualTextView mGradualView;
    GradualImageView mGradualView2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mGradualView2=(GradualImageView)findViewById(R.id.gv2);
        mGradualView=(GradualTextView)findViewById(R.id.gv1);
        mGradualView.setTextColor(Color.YELLOW,Color.RED);
        mGradualView.setText("Good Good");

        mGradualView2.setImgResourse(R.mipmap.q1,R.mipmap.q2);


    }
    public void start(View v){

        mGradualView.startChange(1000);


    }
    public void backstart(View v){

        mGradualView.backChange(1000);


    }
    public void changetext(View v){

        mGradualView.twoTextChange("Good Good","Hello Tom",Color.YELLOW,Color.RED,1000);


    }


    public void startimg(View v){

        mGradualView2.startChange(1000);


    }
    public void backstartimg(View v){

        mGradualView2.backChange(1000);


    }

}
```

第一版本大概就提供这些方法，欢迎大家Star，Fork。

项目地址：
https://github.com/AndroidMsky/GradualView


如果觉得这篇文章对你有帮助 欢迎star我的github。也算对笔者的一种支持。

欢迎加安卓开发交流群：308372687



![这里写图片描述](http://img.blog.csdn.net/20161028111556438)





博主原创未经允许不许转载。
