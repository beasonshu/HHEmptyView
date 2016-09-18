# HHEmptyView
android 网络加载提示进度封装View。包含加载中、加载失败、点击按钮重新加载，支持自定义加载中的view。
# Preview
 ![image](https://github.com/hcs-xph/HHEmptyView/blob/master/screen/Screenshot_2016-09-18-17-35-39.png)
 ![image](https://github.com/hcs-xph/HHEmptyView/blob/master/screen/Screenshot_2016-09-18-17-35-48.png)
# Usage xml
```java  
<com.mph.hhemptyview.widget.HHEmptyView
        android:id="@+id/hh_empty_view"
        android:layout_width="match_parent"
        android:layout_height="match_parent"/>
```
直接放xml布局文件跟布局中和其他布局不冲突，无需指定位置。
# Java
1.
```java
        emptyView = (HHEmptyView) findViewById(R.id.hh_empty_view);
        textView = (TextView) findViewById(R.id.name);

        //设置需要绑定的view
        emptyView.bindView(textView);
        //指定自定义的loading View
        View view = getLayoutInflater().inflate(R.layout.loading_view, null);
        emptyView.setCustomLoadingView(view);

        emptyView.setOnBtnClickListener(this);
```
2.
```java
    /**
     * 模拟加载网络数据
     */
    private void loadData() {
        //模拟网络加载开始
        emptyView.loading();
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Random r = new Random();
                int i = r.nextInt(5);
                if(i<=3){
                    //网络加载失败
                    emptyView.empty("网络连接失败");
                }else{
                    //网络加载成功
                    emptyView.success();
                }
            }
        },2000);
    }
```
3.目前可以指定一下属性
```java
    <declare-styleable name="HHEmptyView">
        <!-- 默认提示文字 -->
        <attr name="hh_empty_warn_txt" format="string|reference"/>
        <!-- 默认加载中文字 -->
        <attr name="hh_empty_loading_txt" format="string|reference"/>
        <!-- 重新加载按钮文字 -->
        <attr name="hh_empty_button_txt" format="string|reference"/>
    </declare-styleable>
```

