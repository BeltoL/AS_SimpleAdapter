# 利用SimpleAdapter实现如下界面效果
## 注意列表项的布局  图片使用QQ群附件资源  使用Toast显示选中的列表项信息

![仿真机截图](https://img-blog.csdnimg.cn/20190405232450320.png?x-oss-process=image/watermark,type_ZmFuZ3poZW5naGVpdGk,shadow_10,text_aHR0cHM6Ly9ibG9nLmNzZG4ubmV0L2JlbHRv,size_16,color_FFFFFF,t_70)

item.xml
```
<LinearLayout xmlns:android="http://schemas.android.com/apk/res/android"
    android:layout_width="match_parent"
    android:layout_height="match_parent"
    android:orientation="horizontal">
    //先设置文本
    <TextView
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        android:id="@+id/name"
        android:textSize="30dp"
        android:paddingLeft="10dp"/>

    <LinearLayout
        android:layout_width="match_parent"
        android:layout_height="wrap_content"
        android:gravity="right">
        //后设置图片
        <ImageView
            android:id="@+id/header"
            android:layout_width="80dp"
            android:layout_height="80dp"
            android:layout_marginRight="10dp" />
    </LinearLayout>
</LinearLayout>
```
activity_main.xml
```
<?xml version="1.0" encoding="utf-8"?>
<android.support.constraint.ConstraintLayout xmlns:android="http://schemas.android.com/apk/res/android"
    xmlns:app="http://schemas.android.com/apk/res-auto"
    xmlns:tools="http://schemas.android.com/tools"
    android:layout_width="match_parent"
    android:layout_height="match_parent"
    tools:context=".MainActivity">


    <ListView
        android:layout_width="match_parent"
        android:layout_height="wrap_content"
        android:id="@+id/listView"
        app:layout_constraintStart_toStartOf="parent"
        app:layout_constraintTop_toTopOf="parent" />


</android.support.constraint.ConstraintLayout>
```

MainAcitity.java
```
package com.example.cy5962.simpleadapter_demo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.SimpleTimeZone;

public class MainActivity extends AppCompatActivity {

    String [] animalname=new String[]{"Lion","Tiger","Monkey","Dog","Cat","Elephant"};
    //创建Listname
    int [] images = new int[] {R.drawable.lion,R.drawable.tiger,R.drawable.monkey,R.drawable.dog,R.drawable.cat,R.drawable.elephant};
    //选择Listimage
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //创建List合集，元素是Map
        List<Map<String,Object>> listItems=new ArrayList<Map<String,Object>>();
        for(int i=0;i<animalname.length;i++)
        {
            Map<String,Object> listItem=new HashMap<String,Object>();
            listItem.put("name",animalname[i]);
            listItem.put("image",images[i]);
            listItems.add(listItem);
        }
        //创建SimpleAdapter
        SimpleAdapter sim=new SimpleAdapter(this,listItems,R.layout.item,
                new String[] {"name","image"}, new int[]{R.id.name ,R.id.header});
        ListView l=(ListView)findViewById(R.id.listView);
        l.setAdapter(sim);
        l.setOnItemClickListener(new AdapterView.OnItemClickListener(){
            public void onItemClick(AdapterView parent, View view,int position,long id){
                Toast.makeText(MainActivity.this,animalname[position],Toast.LENGTH_LONG).show();
            }
        });
    }

}
```